package com.mybatis.model;

public class TUser {
    private Integer nId;

    private String cName;

    private Short nSex;

    private Short nAge;

    private String cAddress;

    private String cLoginid;

    private String cPassword;

    private String cSalt;

    private Short nState;

    public Integer getnId() {
        return nId;
    }

    public void setnId(Integer nId) {
        this.nId = nId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public Short getnSex() {
        return nSex;
    }

    public void setnSex(Short nSex) {
        this.nSex = nSex;
    }

    public Short getnAge() {
        return nAge;
    }

    public void setnAge(Short nAge) {
        this.nAge = nAge;
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress == null ? null : cAddress.trim();
    }

    public String getcLoginid() {
        return cLoginid;
    }

    public void setcLoginid(String cLoginid) {
        this.cLoginid = cLoginid == null ? null : cLoginid.trim();
    }

    public String getcPassword() {
        return cPassword;
    }

    public void setcPassword(String cPassword) {
        this.cPassword = cPassword == null ? null : cPassword.trim();
    }

    public String getcSalt() {
        return cSalt;
    }

    public void setcSalt(String cSalt) {
        this.cSalt = cSalt == null ? null : cSalt.trim();
    }

    public Short getnState() {
        return nState;
    }

    public void setnState(Short nState) {
        this.nState = nState;
    }
}