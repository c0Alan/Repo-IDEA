package com.suntek.auto.operation.entity;

import java.util.Date;

public class AosComponentConfig {
    private Integer id;

    private String componentId;

    private String configProperty;

    private String defaultValue;

    private String configTemplate;

    private Date updaettime;

    private Date createtime;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId == null ? null : componentId.trim();
    }

    public String getConfigProperty() {
        return configProperty;
    }

    public void setConfigProperty(String configProperty) {
        this.configProperty = configProperty == null ? null : configProperty.trim();
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue == null ? null : defaultValue.trim();
    }

    public String getConfigTemplate() {
        return configTemplate;
    }

    public void setConfigTemplate(String configTemplate) {
        this.configTemplate = configTemplate == null ? null : configTemplate.trim();
    }

    public Date getUpdaettime() {
        return updaettime;
    }

    public void setUpdaettime(Date updaettime) {
        this.updaettime = updaettime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}