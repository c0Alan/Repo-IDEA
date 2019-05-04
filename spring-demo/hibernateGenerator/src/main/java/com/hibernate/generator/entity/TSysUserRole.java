package com.hibernate.generator.entity;

public class TSysUserRole {
    private String cId;

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TSysUserRole that = (TSysUserRole) o;

        if (cId != null ? !cId.equals(that.cId) : that.cId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return cId != null ? cId.hashCode() : 0;
    }
}
