package com.example.demo.resource.handler.resource.slb;

import com.example.demo.resource.domain.ResourceConfig;
import com.example.demo.resource.domain.ResourceInfo;
import com.example.demo.resource.domain.SlbInstanceConfig;
import com.example.demo.resource.handler.resource.AbstractResourceHandler;
import org.springframework.stereotype.Component;

/**
 * @author chenming
 * @date 2020/3/22 0022
 */
@Component
public class SlbInstanceHandler extends AbstractResourceHandler {


    @Override
    protected void releaseInstance(ResourceConfig config) {
        System.out.println("调用远程接口释放实例");
    }

    @Override
    protected ResourceInfo getInstanceId(String instanceId) {
        System.out.println("调用远程接口获取实例");
        SlbInstanceConfig ecsInstanceConfig = new SlbInstanceConfig();
        ecsInstanceConfig.setName("slb AAA");
        ecsInstanceConfig.setInstanceId("slb-xxxxxxxx");
        return null;
    }

    @Override
    protected void produceInstance(ResourceConfig config) {
        System.out.println("调用远程接口生产实例");
        SlbInstanceConfig ecsInstanceConfig = new SlbInstanceConfig();
        ecsInstanceConfig.setName("slb      bbbb");
        ecsInstanceConfig.setInstanceId("slb-xbbbbx");
    }
}
