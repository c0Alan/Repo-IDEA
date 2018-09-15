package com.suntek.auto.operation.entity;

import java.util.Date;

public class AosFunctionCheck {
    private Integer id;

    private Integer num;

    private Byte step;

    private String componentId;

    private String action;

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

    public Byte getStep() {
        return step;
    }

    public void setStep(Byte step) {
        this.step = step;
    }

    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId == null ? null : componentId.trim();
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
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