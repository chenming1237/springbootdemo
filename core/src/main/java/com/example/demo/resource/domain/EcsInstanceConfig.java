package com.example.demo.resource.domain;

/**
 * @author chenming
 * @date 2020/3/22 0022
 */
public class EcsInstanceConfig implements ResourceConfig {

    private String name;

    private String instanceId;

    private String eip;

    private String securityGroup;

    private String imageVersion;

    private String spec;

    private String natId;

    private String slbId;

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

    public String getEip() {
        return eip;
    }

    public void setEip(String eip) {
        this.eip = eip;
    }

    public String getSecurityGroup() {
        return securityGroup;
    }

    public void setSecurityGroup(String securityGroup) {
        this.securityGroup = securityGroup;
    }

    public String getImageVersion() {
        return imageVersion;
    }

    public void setImageVersion(String imageVersion) {
        this.imageVersion = imageVersion;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getNatId() {
        return natId;
    }

    public void setNatId(String natId) {
        this.natId = natId;
    }

    public String getSlbId() {
        return slbId;
    }

    public void setSlbId(String slbId) {
        this.slbId = slbId;
    }
}
