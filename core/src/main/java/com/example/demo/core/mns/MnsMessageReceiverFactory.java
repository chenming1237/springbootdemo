package com.example.demo.core.mns;

import com.example.demo.core.mns.impl.MnsQueueMessageReceiverImpl;

/**
 * mns消息接收者工厂，对外提供消息接收者
 */
public final class MnsMessageReceiverFactory {

    public static MnsQueueMessageReceiver createQueueMessageReceiver(MnsQueueMessageReceiverConfig config){
        return new MnsQueueMessageReceiverImpl(config);
    }
}
