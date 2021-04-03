package com.suntek.auto.operation.entity;

import java.util.Date;

public class AosHostConfig {
    private Integer id;

    private String username;

    private String password;

    private String httpYum;

    private String ntpServer;

    private String ntpMask;

    private Date updaettime;

    private Date createtime;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getHttpYum() {
        return httpYum;
    }

    public void setHttpYum(String httpYum) {
        this.httpYum = httpYum == null ? null : httpYum.trim();
    }

    public String getNtpServer() {
        return ntpServer;
    }

    public void setNtpServer(String ntpServer) {
        this.ntpServer = ntpServer == null ? null : ntpServer.trim();
    }

    public String getNtpMask() {
        return ntpMask;
    }

    public void setNtpMask(String ntpMask) {
        this.ntpMask = ntpMask == null ? null : ntpMask.trim();
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