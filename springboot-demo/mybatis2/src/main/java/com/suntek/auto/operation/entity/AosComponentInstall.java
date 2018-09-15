package com.suntek.auto.operation.entity;

import java.util.Date;

public class AosComponentInstall {
    private Integer id;

    private String planId;

    private String componentId;

    private String hostInfoId;

    private Integer port;

    private Byte nodeAttribute;

    private Integer cpuNum;

    private Integer memory;

    private Byte packageUploadState;

    private Byte installState;

    private Byte checkState;

    private Date updaettime;

    private Date createtime;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId == null ? null : planId.trim();
    }

    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId == null ? null : componentId.trim();
    }

    public String getHostInfoId() {
        return hostInfoId;
    }

    public void setHostInfoId(String hostInfoId) {
        this.hostInfoId = hostInfoId == null ? null : hostInfoId.trim();
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Byte getNodeAttribute() {
        return nodeAttribute;
    }

    public void setNodeAttribute(Byte nodeAttribute) {
        this.nodeAttribute = nodeAttribute;
    }

    public Integer getCpuNum() {
        return cpuNum;
    }

    public void setCpuNum(Integer cpuNum) {
        this.cpuNum = cpuNum;
    }

    public Integer getMemory() {
        return memory;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    public Byte getPackageUploadState() {
        return packageUploadState;
    }

    public void setPackageUploadState(Byte packageUploadState) {
        this.packageUploadState = packageUploadState;
    }

    public Byte getInstallState() {
        return installState;
    }

    public void setInstallState(Byte installState) {
        this.installState = installState;
    }

    public Byte getCheckState() {
        return checkState;
    }

    public void setCheckState(Byte checkState) {
        this.checkState = checkState;
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