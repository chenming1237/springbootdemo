package com.example.demo.resource.context;

import java.util.Arrays;

/**
 * @author chenming
 * @date 2020/3/22 0022
 */
public enum ResourceType {
    /**
     *
     */
    ECS_INSTANCE("ecsInstance", "ecs云服务器"),

    SLB_INSTANCE("slbInstance", "负载均衡"),

    NAT_INSTANCE("natInstance", "网关"),

    EIP_INSTANCE("eipInstance", "弹性公网ip");

    String code;

    String desc;

    ResourceType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static ResourceType get(String code) {
        return Arrays.asList(ResourceType.values()).stream().filter(resourceType -> resourceType.getCode().equals(code)).findFirst().orElse(null);
    }

}
