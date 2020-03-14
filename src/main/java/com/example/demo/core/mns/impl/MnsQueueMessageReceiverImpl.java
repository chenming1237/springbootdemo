package com.example.demo.core.mns.impl;

import com.aliyun.mns.client.CloudAccount;
import com.aliyun.mns.client.MNSClient;
import com.example.demo.core.mns.MnsQueueMessageReceiver;
import com.example.demo.core.mns.MnsQueueMessageReceiverConfig;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class MnsQueueMessageReceiverImpl implements MnsQueueMessageReceiver {

    private MNSClient client;

    private MnsQueueMessageReceiverConfig config;

    private ThreadPoolExecutor threadPoolExecutor;

    /**
     * 控制消息接收的开关
     */
    private AtomicBoolean started = new AtomicBoolean(false);

    public MnsQueueMessageReceiverImpl(MnsQueueMessageReceiverConfig config) {
        this.config = config;
        // 检查操作
    }

    @Override
    public void start() throws IllegalAccessException {
        if (!this.started.get()){
            // 初始化mns客户端, 线程池，执行
            this.initMnsClient();
            this.initThreadPoolExecutor();
            this.startPollThread();
            this.started.set(true);
        }
    }

    private void initMnsClient() {
        CloudAccount cloudAccount = new CloudAccount(this.config.getAk(), this.config.getSk(), this.config.getEndpoint());
        this.client = cloudAccount.getMNSClient();
    }

    private void initThreadPoolExecutor() throws IllegalAccessException {
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(this.config.getWorkQueueSize());
        ThreadFactory threadFactory = new ThreadFactory() {
            private AtomicInteger counter = new AtomicInteger(1);

            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                String threadName = StringUtils.isNoneEmpty(MnsQueueMessageReceiverImpl.this.config.getThreadName()) ? MnsQueueMessageReceiverImpl.this.config.getThreadName() : "MnsQueueMessageReceiver";
                thread.setName(threadName + "-" + this.counter.getAndIncrement());
                return null;
            }
        };
        RejectedExecutionHandler rejectedExecutionHandler;
        try {
            Class<?> clz = Class.forName(this.config.getRejectHandlerClassName());
            rejectedExecutionHandler = (RejectedExecutionHandler) clz.newInstance();
        }catch (Exception v){
            throw new IllegalAccessException("xxxxxxxxxxxxxxx");
        }
        this.threadPoolExecutor = new ThreadPoolExecutor(this.config.getCorePoolSize(), this.config.getMaxPoolSize(),
                this.config.getKeepAliveTime(), this.config.getTimeUnit(), workQueue, threadFactory, rejectedExecutionHandler);
    }

    private void startPollThread() {
        this.threadPoolExecutor.submit(new MnsQueueMessagePoller(this.client.getQueueRef(this.config.getQueueName()), this.config, this.threadPoolExecutor));
    }

    @Override
    public void stop() {
        if(this.started.get()){
            this.shutdownThreadPoolExecutor();
            this.shutdownMnsClient();
            this.started.set(false);
            System.out.println("MessageQueueReceiver stopped");
        }
    }

    private void shutdownThreadPoolExecutor() {
        this.threadPoolExecutor.shutdown();

        try {
            if (!this.threadPoolExecutor.awaitTermination(5L, TimeUnit.SECONDS)) {
                this.threadPoolExecutor.shutdownNow();
            }
        } catch (InterruptedException var2) {
            this.threadPoolExecutor.shutdownNow();
        }
        this.threadPoolExecutor = null;
    }

    private void shutdownMnsClient() {
        this.client.close();
        this.client = null;
    }
}
