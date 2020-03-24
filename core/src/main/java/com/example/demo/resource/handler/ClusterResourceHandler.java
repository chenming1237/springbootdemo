package com.example.demo.resource.handler;

import com.example.demo.resource.domain.ResourceInfo;

/**
 * @author chenming
 * @date 2020/3/22 0022
 */
public interface ClusterResourceHandler {

    ResourceInfo get(String clusterResourceId);
}
