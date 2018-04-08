package com.ssh.entity;

import java.math.BigInteger;

public class TSysRole {
    private int nId;
    private BigInteger nValid;
    private String cDescription;
    private String cRole;

    public int getnId() {
        return nId;
    }

    public void setnId(int nId) {
        this.nId = nId;
    }

    public BigInteger getnValid() {
        return nValid;
    }

    public void setnValid(BigInteger nValid) {
        this.nValid = nValid;
    }

    public String getcDescription() {
        return cDescription;
    }

    public void setcDescription(String cDescription) {
        this.cDescription = cDescription;
    }

    public String getcRole() {
        return cRole;
    }

    public void setcRole(String cRole) {
        this.cRole = cRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TSysRole tSysRole = (TSysRole) o;

        if (nId != tSysRole.nId) return false;
        if (nValid != null ? !nValid.equals(tSysRole.nValid) : tSysRole.nValid != null) return false;
        if (cDescription != null ? !cDescription.equals(tSysRole.cDescription) : tSysRole.cDescription != null)
            return false;
        if (cRole != null ? !cRole.equals(tSysRole.cRole) : tSysRole.cRole != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nId;
        result = 31 * result + (nValid != null ? nValid.hashCode() : 0);
        result = 31 * result + (cDescription != null ? cDescription.hashCode() : 0);
        result = 31 * result + (cRole != null ? cRole.hashCode() : 0);
        return result;
    }
}
