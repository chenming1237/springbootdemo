package com.example.demo.core.msg;

import com.aliyun.mns.model.Message;
import com.example.demo.core.mns.MnsMessageListener;
import com.example.demo.core.mns.MnsMessageReceiverFactory;
import com.example.demo.core.mns.MnsQueueMessageReceiver;
import com.example.demo.core.mns.MnsQueueMessageReceiverConfig;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DingTalkMnsMessageHandler implements MnsMessageListener {




    @PostConstruct
    public void init() throws IllegalAccessException {
        System.out.println("hello  cmcmcmcm");
        //MnsQueueMessageReceiverConfig config = new MnsQueueMessageReceiverConfig();
        // config set 属性
        //MnsQueueMessageReceiver receiver = MnsMessageReceiverFactory.createQueueMessageReceiver(config);
        //receiver.start();
    }



    @Override
    public void onMessage(Message var1) {
        // 处理handler
    }
}
