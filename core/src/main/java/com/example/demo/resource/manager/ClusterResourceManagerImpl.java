package com.example.demo.resource.manager;

import com.example.demo.resource.entity.Resource;
import com.example.demo.resource.handler.ResourceFactory;
import com.example.demo.resource.handler.resource.ResourceHandler;
import org.springframework.stereotype.Service;

/**
 * @author chenming
 * @date 2020/3/22 0022
 */
@Service
public class ClusterResourceManagerImpl implements ClusterResourceManager {


    @Override
    public Resource get(String resourceId) {
        return null;
    }

    @Override
    public ResourceHandler getHandler(String resourceType) {
        return ResourceFactory.INSTANCE.get(resourceType);
    }
}
