package com.example.demo.resource.handler;



import com.example.demo.resource.SpringUtil;
import com.example.demo.resource.context.ResourceType;
import com.example.demo.resource.handler.resource.ResourceHandler;
import com.example.demo.resource.handler.resource.ecs.EcsInstanceHandler;
import com.example.demo.resource.handler.resource.eip.EipInstanceHandler;
import com.example.demo.resource.handler.resource.nat.NatInstanceHandler;
import com.example.demo.resource.handler.resource.slb.SlbInstanceHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenming
 * @date 2020/3/22 0022
 *
 *
 */
public enum ResourceFactory {

    /**
     * 单例
     */
    INSTANCE;

    ResourceFactory() {
        resourceHandler = new HashMap<>();
        resourceHandler.put(ResourceType.ECS_INSTANCE, EcsInstanceHandler.class);
        resourceHandler.put(ResourceType.EIP_INSTANCE, EipInstanceHandler.class);
        resourceHandler.put(ResourceType.SLB_INSTANCE, SlbInstanceHandler.class);
        resourceHandler.put(ResourceType.NAT_INSTANCE, NatInstanceHandler.class);
    }

    private Map<ResourceType, Class<? extends ResourceHandler>> resourceHandler;


    public ResourceHandler get(String resourceType) {
        Class<? extends ResourceHandler> clazz = resourceHandler.get(ResourceType.get(resourceType));
        try {
            return SpringUtil.getBean(clazz);
        } catch (Exception e) {
            return null;
        }
    }

}
