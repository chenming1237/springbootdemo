package com.example.demo.resource.domain;

/**
 * @author chenming
 * @date 2020/3/22 0022
 */
public class NatInstanceConfig implements ResourceConfig {

    private String name;

    private String instanceId;

    private String ecsInstanceId;

    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getEcsInstanceId() {
        return ecsInstanceId;
    }

    public void setEcsInstanceId(String ecsInstanceId) {
        this.ecsInstanceId = ecsInstanceId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
