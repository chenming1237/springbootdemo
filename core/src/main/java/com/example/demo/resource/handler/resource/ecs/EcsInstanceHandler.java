package com.example.demo.resource.handler.resource.ecs;

import com.example.demo.resource.domain.EcsInstanceConfig;
import com.example.demo.resource.domain.ResourceConfig;
import com.example.demo.resource.domain.ResourceInfo;
import com.example.demo.resource.handler.resource.AbstractResourceHandler;
import org.springframework.stereotype.Component;

/**
 * @author chenming
 * @date 2020/3/22 0022
 */
@Component
public class EcsInstanceHandler extends AbstractResourceHandler {


    @Override
    protected void releaseInstance(ResourceConfig config) {
        System.out.println("调用远程接口释放实例");
    }

    @Override
    protected ResourceInfo getInstanceId(String instanceId) {
        System.out.println("调用远程接口获取实例");
        EcsInstanceConfig ecsInstanceConfig = new EcsInstanceConfig();
        ecsInstanceConfig.setName("ecs云服务器AAA");
        ecsInstanceConfig.setInstanceId("ecs-xxxxxxxx");
        return null;
    }

    @Override
    protected void produceInstance(ResourceConfig config) {
        System.out.println("调用远程接口生产实例");
        EcsInstanceConfig ecsInstanceConfig = new EcsInstanceConfig();
        ecsInstanceConfig.setName("ecs云服务器bbb");
        ecsInstanceConfig.setInstanceId("ecs-xbbbbx");
    }
}
