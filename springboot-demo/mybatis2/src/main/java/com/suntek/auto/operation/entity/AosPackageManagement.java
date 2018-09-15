package com.suntek.auto.operation.entity;

import java.util.Date;

public class AosPackageManagement {
    private Integer id;

    private Integer num;

    private String name;

    private String description;

    private Byte versionType;

    private Byte releaseState;

    private Byte used;

    private String uploader;

    private Date uploadeTime;

    private String storePath;

    private Date updaettime;

    private Date createtime;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Byte getVersionType() {
        return versionType;
    }

    public void setVersionType(Byte versionType) {
        this.versionType = versionType;
    }

    public Byte getReleaseState() {
        return releaseState;
    }

    public void setReleaseState(Byte releaseState) {
        this.releaseState = releaseState;
    }

    public Byte getUsed() {
        return used;
    }

    public void setUsed(Byte used) {
        this.used = used;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader == null ? null : uploader.trim();
    }

    public Date getUploadeTime() {
        return uploadeTime;
    }

    public void setUploadeTime(Date uploadeTime) {
        this.uploadeTime = uploadeTime;
    }

    public String getStorePath() {
        return storePath;
    }

    public void setStorePath(String storePath) {
        this.storePath = storePath == null ? null : storePath.trim();
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