package com.example.demo.resource.context;

import java.util.Arrays;

/**
 * @author chenming
 * @date 2020/3/22 0022
 */
public enum ResourceStatus {

    /**
     *
     */
    CREATING("creating", "创建中"),

    RUNNING("running", "运行中"),

    RELEASE("release", "已释放");

    String code;

    String desc;

    ResourceStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static ResourceStatus get(String code) {
        return Arrays.asList(ResourceStatus.values()).stream().filter(resourceStatus -> resourceStatus.getCode().equals(code)).findFirst().orElse(null);
    }
}
