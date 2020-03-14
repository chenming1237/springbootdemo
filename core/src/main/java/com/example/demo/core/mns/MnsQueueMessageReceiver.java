package com.example.demo.core.mns;

/**
 * Mns消息接收管理者，可控制消息的接收开关
 */
public interface MnsQueueMessageReceiver {

    void start() throws IllegalAccessException;

    void stop();
}
