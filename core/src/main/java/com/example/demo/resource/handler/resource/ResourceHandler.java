package com.example.demo.resource.handler.resource;

import com.example.demo.resource.domain.ResourceConfig;
import com.example.demo.resource.domain.ResourceInfo;

/**
 * @author chenming
 * @date 2020/3/22 0022
 */
public interface ResourceHandler<K extends ResourceConfig, V extends ResourceInfo> {


    V get(Long resourceId);

    void produce(K config);

    void release(K config);

}
