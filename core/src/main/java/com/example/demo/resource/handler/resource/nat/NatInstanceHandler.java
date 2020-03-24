package com.example.demo.resource.handler.resource.nat;

import com.example.demo.resource.domain.NatInstanceConfig;
import com.example.demo.resource.domain.ResourceConfig;
import com.example.demo.resource.domain.ResourceInfo;
import com.example.demo.resource.handler.resource.AbstractResourceHandler;
import org.springframework.stereotype.Component;

/**
 * @author chenming
 * @date 2020/3/22 0022
 */
@Component
public class NatInstanceHandler extends AbstractResourceHandler {


    @Override
    protected void releaseInstance(ResourceConfig config) {
        System.out.println("调用远程接口释放实例");
    }

    @Override
    protected ResourceInfo getInstanceId(String instanceId) {
        System.out.println("调用远程接口获取实例");
        NatInstanceConfig ecsInstanceConfig = new NatInstanceConfig();
        ecsInstanceConfig.setName("网关AAA");
        ecsInstanceConfig.setInstanceId("nat-xxxxxxxx");
        return null;
    }

    @Override
    protected void produceInstance(ResourceConfig config) {
        System.out.println("调用远程接口生产实例");
        NatInstanceConfig ecsInstanceConfig = new NatInstanceConfig();
        ecsInstanceConfig.setName("网关bbb");
        ecsInstanceConfig.setInstanceId("nat-xbbbbx");
    }
}
