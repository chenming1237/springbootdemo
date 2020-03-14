package com.example.demo.core.mns;

import com.aliyun.mns.model.Message;

/**
 * 对外开放的监听接口，实时获取mns消息
 */
public interface MnsMessageListener {

    void onMessage(Message var1);
}
