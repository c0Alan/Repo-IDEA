package com.multiple.datasource.dao1.entity;

import java.util.Date;

public class Commit {
    private Integer id;

    private String appid;

    private String clustername;

    private String namespacename;

    private String comment;

    private Boolean isdeleted;

    private String datachangeCreatedby;

    private Date datachangeCreatedtime;

    private String datachangeLastmodifiedby;

    private Date datachangeLasttime;

    private String changesets;

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
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

    public String getChangesets() {
        return changesets;
    }

    public void setChangesets(String changesets) {
        this.changesets = changesets == null ? null : changesets.trim();
    }
}