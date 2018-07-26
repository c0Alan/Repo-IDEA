package com.suntek.vehicle.file.entity;

import java.util.Date;

public class User {
    private String name;
    private String loginName;
    private Date createdDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreateDate(Date createdDate) {
        this.createdDate = createdDate;
    }

}