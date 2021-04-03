package com.suntek.auto.operation.entity;

import java.util.Date;

public class AosComponent {
    private Integer id;

    private String name;

    private Byte attribute;

    private Byte initNum;

    private Byte type;

    private String version;

    private String usages;

    private Date updaettime;

    private Date createtime;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getAttribute() {
        return attribute;
    }

    public void setAttribute(Byte attribute) {
        this.attribute = attribute;
    }

    public Byte getInitNum() {
        return initNum;
    }

    public void setInitNum(Byte initNum) {
        this.initNum = initNum;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getUsages() {
        return usages;
    }

    public void setUsages(String usages) {
        this.usages = usages == null ? null : usages.trim();
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