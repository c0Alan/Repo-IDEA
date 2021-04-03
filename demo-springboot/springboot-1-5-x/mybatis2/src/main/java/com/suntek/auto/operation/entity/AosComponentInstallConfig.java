package com.suntek.auto.operation.entity;

import java.util.Date;

public class AosComponentInstallConfig {
    private Integer id;

    private String componentInstallId;

    private String componentConfigId;

    private String value;

    private Date updaettime;

    private Date createtime;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComponentInstallId() {
        return componentInstallId;
    }

    public void setComponentInstallId(String componentInstallId) {
        this.componentInstallId = componentInstallId == null ? null : componentInstallId.trim();
    }

    public String getComponentConfigId() {
        return componentConfigId;
    }

    public void setComponentConfigId(String componentConfigId) {
        this.componentConfigId = componentConfigId == null ? null : componentConfigId.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
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