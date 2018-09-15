package com.suntek.auto.operation.entity;

import java.util.Date;

public class AosPlanTpSystem {
    private Integer id;

    private String planId;

    private String tpSystemId;

    private Byte state;

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

    public String getTpSystemId() {
        return tpSystemId;
    }

    public void setTpSystemId(String tpSystemId) {
        this.tpSystemId = tpSystemId == null ? null : tpSystemId.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
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