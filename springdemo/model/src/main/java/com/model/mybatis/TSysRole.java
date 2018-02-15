package com.model.mybatis;

public class TSysRole {
    private Integer nId;

    private Short nValid;

    private String cDescription;

    private String cRole;

    public Integer getnId() {
        return nId;
    }

    public void setnId(Integer nId) {
        this.nId = nId;
    }

    public Short getnValid() {
        return nValid;
    }

    public void setnValid(Short nValid) {
        this.nValid = nValid;
    }

    public String getcDescription() {
        return cDescription;
    }

    public void setcDescription(String cDescription) {
        this.cDescription = cDescription == null ? null : cDescription.trim();
    }

    public String getcRole() {
        return cRole;
    }

    public void setcRole(String cRole) {
        this.cRole = cRole == null ? null : cRole.trim();
    }
}