package com.example.demo.resource.handler.resource;

import com.example.demo.resource.domain.ResourceConfig;
import com.example.demo.resource.domain.ResourceInfo;
import com.example.demo.resource.manager.ClusterResourceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chenming
 * @date 2020/3/22 0022
 */
@Component
public abstract class AbstractResourceHandler<K extends ResourceConfig, V extends ResourceInfo> implements ResourceHandler<K, V> {

    @Autowired
    private ClusterResourceManager resourceManager;

    @Override
    public V get(Long clusterResourceId) {
        return getInstanceId(String.valueOf(clusterResourceId));
    }

    @Override
    public void produce(K config) {
        // 通用的业务逻辑操作， 获取资源薪资，幂等校验等等
        String instanceId = "xxxxxxxxx";
        produceInstance(config);
    }

    @Override
    public void release(K config) {
        // 通用的业务逻辑操作， 释放资源薪资，幂等校验等等
        String instanceId = "xxxxxxxxx";
        releaseInstance(config);
    }


    /**
     * 真实释放实例的接口
     * @param config
     */
    protected abstract void releaseInstance(K config);

    /**
     * 真实获取实例的接口
     * @param instanceId
     * @return
     */
    protected abstract V getInstanceId(String instanceId);

    /**
     * 真实创建实例的接口
     * @param config
     * @return
     */
    protected abstract void produceInstance(K config);
}
