package com.example.demo.core.mns;

import java.util.concurrent.TimeUnit;

public class MnsQueueMessageReceiverConfig {

    private String endpoint;

    private String ak;

    private String sk;

    private String queueName;

    private MnsMessageListener mnsMessageListener;

    private int corePoolSize = 20;

    private int maxPoolSize = 50;

    private long keepAliveTime = 60L;

    private TimeUnit timeUnit;

    private int workQueueSize;

    private String threadName;

    private String rejectHandlerClassName;

    private int maxExceptionCountPerMessage;

    private int maxExceptionCounterCount;

    public MnsQueueMessageReceiverConfig() {
        this.timeUnit = TimeUnit.MINUTES;
        this.workQueueSize = 50;
        this.rejectHandlerClassName = "java.util.concurrent.ThreadPoolExecutor$CallerRunsPolicy";
        this.maxExceptionCounterCount = 1000;
        this.maxExceptionCountPerMessage = -1;
    }

    public int getMaxExceptionCountPerMessage() {
        return maxExceptionCountPerMessage;
    }

    public void setMaxExceptionCountPerMessage(int maxExceptionCountPerMessage) {
        this.maxExceptionCountPerMessage = maxExceptionCountPerMessage;
    }

    public int getMaxExceptionCounterCount() {
        return maxExceptionCounterCount;
    }

    public void setMaxExceptionCounterCount(int maxExceptionCounterCount) {
        this.maxExceptionCounterCount = maxExceptionCounterCount;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAk() {
        return ak;
    }

    public void setAk(String ak) {
        this.ak = ak;
    }

    public String getSk() {
        return sk;
    }

    public void setSk(String sk) {
        this.sk = sk;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public MnsMessageListener getMnsMessageListener() {
        return mnsMessageListener;
    }

    public void setMnsMessageListener(MnsMessageListener mnsMessageListener) {
        this.mnsMessageListener = mnsMessageListener;
    }

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public long getKeepAliveTime() {
        return keepAliveTime;
    }

    public void setKeepAliveTime(long keepAliveTime) {
        this.keepAliveTime = keepAliveTime;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    public int getWorkQueueSize() {
        return workQueueSize;
    }

    public void setWorkQueueSize(int workQueueSize) {
        this.workQueueSize = workQueueSize;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public String getRejectHandlerClassName() {
        return rejectHandlerClassName;
    }

    public void setRejectHandlerClassName(String rejectHandlerClassName) {
        this.rejectHandlerClassName = rejectHandlerClassName;
    }
}
