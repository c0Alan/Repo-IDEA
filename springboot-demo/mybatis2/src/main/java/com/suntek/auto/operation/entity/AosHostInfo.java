package com.suntek.auto.operation.entity;

import java.util.Date;

public class AosHostInfo {
    private Integer id;

    private String hostname;

    private String operationSystem;

    private String ipAddress;

    private Integer cpuNum;

    private Integer memory;

    private Integer disk;

    private Byte initState;

    private Byte runningState;

    private String runningInfo;

    private Date updaettime;

    private Date createtime;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname == null ? null : hostname.trim();
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem == null ? null : operationSystem.trim();
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress == null ? null : ipAddress.trim();
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

    public Integer getDisk() {
        return disk;
    }

    public void setDisk(Integer disk) {
        this.disk = disk;
    }

    public Byte getInitState() {
        return initState;
    }

    public void setInitState(Byte initState) {
        this.initState = initState;
    }

    public Byte getRunningState() {
        return runningState;
    }

    public void setRunningState(Byte runningState) {
        this.runningState = runningState;
    }

    public String getRunningInfo() {
        return runningInfo;
    }

    public void setRunningInfo(String runningInfo) {
        this.runningInfo = runningInfo == null ? null : runningInfo.trim();
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