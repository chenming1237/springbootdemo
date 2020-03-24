package com.example.demo.resource.domain;

import java.util.List;

/**
 * @author chenming
 * @date 2020/3/22 0022
 */
public class SecurityGroupConfig implements ResourceConfig {

    private String name;

    private String instanceId;

    private String ecsInstanceId;

    private List<Rule> list;

    private String decs;

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

    public List<Rule> getList() {
        return list;
    }

    public void setList(List<Rule> list) {
        this.list = list;
    }

    public String getDecs() {
        return decs;
    }

    public void setDecs(String decs) {
        this.decs = decs;
    }

    private static class Rule{

        private String ip;

        private String port;

        private String desc;

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getPort() {
            return port;
        }

        public void setPort(String port) {
            this.port = port;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }


}
