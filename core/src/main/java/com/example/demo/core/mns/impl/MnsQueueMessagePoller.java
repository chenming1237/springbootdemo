package com.example.demo.core.mns.impl;

import com.aliyun.mns.client.CloudQueue;
import com.aliyun.mns.model.Message;
import com.example.demo.core.mns.MnsQueueMessageReceiverConfig;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * mns消息轮询器
 */

public class MnsQueueMessagePoller implements Runnable {

    /**
     * 单次批量拉取16条数据
     */
    private static final int MESSAGE_COUNT = 16;

    private final CloudQueue cloudQueue;

    private final MnsQueueMessageReceiverConfig config;

    private final ThreadPoolExecutor threadPoolExecutor;

    private final ConcurrentMap<String, AtomicInteger> messageExceptionCountMap = new ConcurrentHashMap<>();

    public MnsQueueMessagePoller(CloudQueue cloudQueue, MnsQueueMessageReceiverConfig config, ThreadPoolExecutor threadPoolExecutor) {
        this.cloudQueue = cloudQueue;
        this.config = config;
        this.threadPoolExecutor = threadPoolExecutor;
    }

    @Override
    public void run() {
        while (true){
            while (true){
                try {
                    List<Message> messages = this.cloudQueue.batchPopMessage(16, 30);
                    if (messages != null){
                        messages.forEach(message -> {
                            this.doProcessMessage(message);
                        });
                    }
                } catch (Throwable throwable){
                    if(this.isInterrupted(throwable)){
                        // messagePollerThread interrupted. Stop
                        return;
                    }

                    try{
                        Thread.sleep(2000L);
                    }catch (InterruptedException i){
                        return;
                    }
                }
            }
        }
    }

    private boolean isInterrupted(Throwable throwable) {
        // .............
        return false;
    }

    private void doProcessMessage(Message message) {
        this.threadPoolExecutor.submit(() -> {
            try {
                MnsQueueMessagePoller.this.config.getMnsMessageListener().onMessage(message);
                MnsQueueMessagePoller.this.doDeleteMessage(message);
            }catch (Exception e){
                if(MnsQueueMessagePoller.this.isInterrupted(e)){
                    return;
                }

                MnsQueueMessagePoller.this.deleteMessageIfExceedsMaxExceptionCount(message);
            }
        });
    }

    private void deleteMessageIfExceedsMaxExceptionCount(Message message) {
        if (this.config.getMaxExceptionCountPerMessage() == -1) {
            this.doDeleteMessage(message);
        } else {
                AtomicInteger counter = this.messageExceptionCountMap.get(message.getMessageId());
            if (counter == null) {
                if (this.messageExceptionCountMap.size() >= this.config.getMaxExceptionCounterCount()) {
                    return;
                }
                this.messageExceptionCountMap.putIfAbsent(message.getMessageId(), new AtomicInteger(0));
                counter = this.messageExceptionCountMap.get(message.getMessageId());
            }

            if (counter.incrementAndGet() >= this.config.getMaxExceptionCountPerMessage()) {
                this.doDeleteMessage(message);
            }
        }
    }

    private void doDeleteMessage(Message message) {
        try {
            this.cloudQueue.deleteMessage(message.getReceiptHandle());
            this.messageExceptionCountMap.remove(message.getMessageId());
        }catch (Exception e){
            //
        }
    }
}
