package com.example.demo.resource.handler;

import com.example.demo.resource.context.ResourceStatus;
import com.example.demo.resource.context.ResourceType;
import com.example.demo.resource.domain.ResourceInfo;
import com.example.demo.resource.entity.Resource;
import com.example.demo.resource.handler.resource.ResourceHandler;
import com.example.demo.resource.manager.ClusterResourceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chenming
 * @date 2020/3/22 0022
 */
@Component
public class ClusterResourceHandlerImpl implements ClusterResourceHandler {

    @Autowired
    private ClusterResourceManager clusterResourceManager;

    @Override
    public ResourceInfo get(String clusterResourceId) {
        Resource resource = clusterResourceManager.get(clusterResourceId);
        ResourceType type = ResourceType.get(resource.getType());
        ResourceHandler resourceHandler = clusterResourceManager.getHandler(type.getCode());
        return resourceHandler.get(resource.getId());
    }
}
