package com.multiple.datasource.dao1.entity;

import java.util.Date;

public class Releasehistory {
    private Integer id;

    private String appid;

    private String clustername;

    private String namespacename;

    private String branchname;

    private Integer releaseid;

    private Integer previousreleaseid;

    private Byte operation;

    private Boolean isdeleted;

    private String datachangeCreatedby;

    private Date datachangeCreatedtime;

    private String datachangeLastmodifiedby;

    private Date datachangeLasttime;

    private String operationcontext;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public String getClustername() {
        return clustername;
    }

    public void setClustername(String clustername) {
        this.clustername = clustername == null ? null : clustername.trim();
    }

    public String getNamespacename() {
        return namespacename;
    }

    public void setNamespacename(String namespacename) {
        this.namespacename = namespacename == null ? null : namespacename.trim();
    }

    public String getBranchname() {
        return branchname;
    }

    public void setBranchname(String branchname) {
        this.branchname = branchname == null ? null : branchname.trim();
    }

    public Integer getReleaseid() {
        return releaseid;
    }

    public void setReleaseid(Integer releaseid) {
        this.releaseid = releaseid;
    }

    public Integer getPreviousreleaseid() {
        return previousreleaseid;
    }

    public void setPreviousreleaseid(Integer previousreleaseid) {
        this.previousreleaseid = previousreleaseid;
    }

    public Byte getOperation() {
        return operation;
    }

    public void setOperation(Byte operation) {
        this.operation = operation;
    }

    public Boolean getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

    public String getDatachangeCreatedby() {
        return datachangeCreatedby;
    }

    public void setDatachangeCreatedby(String datachangeCreatedby) {
        this.datachangeCreatedby = datachangeCreatedby == null ? null : datachangeCreatedby.trim();
    }

    public Date getDatachangeCreatedtime() {
        return datachangeCreatedtime;
    }

    public void setDatachangeCreatedtime(Date datachangeCreatedtime) {
        this.datachangeCreatedtime = datachangeCreatedtime;
    }

    public String getDatachangeLastmodifiedby() {
        return datachangeLastmodifiedby;
    }

    public void setDatachangeLastmodifiedby(String datachangeLastmodifiedby) {
        this.datachangeLastmodifiedby = datachangeLastmodifiedby == null ? null : datachangeLastmodifiedby.trim();
    }

    public Date getDatachangeLasttime() {
        return datachangeLasttime;
    }

    public void setDatachangeLasttime(Date datachangeLasttime) {
        this.datachangeLasttime = datachangeLasttime;
    }

    public String getOperationcontext() {
        return operationcontext;
    }

    public void setOperationcontext(String operationcontext) {
        this.operationcontext = operationcontext == null ? null : operationcontext.trim();
    }
}