package com.example.demo.resource.manager;

import com.example.demo.resource.entity.Resource;
import com.example.demo.resource.handler.resource.ResourceHandler;

/**
 * @author chenming
 * @date 2020/3/22 0022
 */
public interface ClusterResourceManager {

    Resource get(String resourceId);

    ResourceHandler getHandler(String resourceType);

}
