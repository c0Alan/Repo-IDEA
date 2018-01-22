package com.model.redfox;

public class User {
    private String cId;

    private String cLoginid;

    private String cName;

    private String cPassword;

    private String cMail;

    private String cIp;

    private String cXmjp;

    private String cCorp;

    private String cDept;

    private Byte nValid;

    private Short nOrder;

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public String getcLoginid() {
        return cLoginid;
    }

    public void setcLoginid(String cLoginid) {
        this.cLoginid = cLoginid == null ? null : cLoginid.trim();
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcPassword() {
        return cPassword;
    }

    public void setcPassword(String cPassword) {
        this.cPassword = cPassword == null ? null : cPassword.trim();
    }

    public String getcMail() {
        return cMail;
    }

    public void setcMail(String cMail) {
        this.cMail = cMail == null ? null : cMail.trim();
    }

    public String getcIp() {
        return cIp;
    }

    public void setcIp(String cIp) {
        this.cIp = cIp == null ? null : cIp.trim();
    }

    public String getcXmjp() {
        return cXmjp;
    }

    public void setcXmjp(String cXmjp) {
        this.cXmjp = cXmjp == null ? null : cXmjp.trim();
    }

    public String getcCorp() {
        return cCorp;
    }

    public void setcCorp(String cCorp) {
        this.cCorp = cCorp == null ? null : cCorp.trim();
    }

    public String getcDept() {
        return cDept;
    }

    public void setcDept(String cDept) {
        this.cDept = cDept == null ? null : cDept.trim();
    }

    public Byte getnValid() {
        return nValid;
    }

    public void setnValid(Byte nValid) {
        this.nValid = nValid;
    }

    public Short getnOrder() {
        return nOrder;
    }

    public void setnOrder(Short nOrder) {
        this.nOrder = nOrder;
    }
}