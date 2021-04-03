package com.multiple.datasource.dao1.entity;

import java.util.Date;

public class Namespacelock {
    private Integer id;

    private Integer namespaceid;

    private String datachangeCreatedby;

    private Date datachangeCreatedtime;

    private String datachangeLastmodifiedby;

    private Date datachangeLasttime;

    private Boolean isdeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNamespaceid() {
        return namespaceid;
    }

    public void setNamespaceid(Integer namespaceid) {
        this.namespaceid = namespaceid;
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

    public Boolean getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }
}