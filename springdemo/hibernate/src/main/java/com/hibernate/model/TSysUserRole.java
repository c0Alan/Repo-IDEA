package com.hibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "t_sys_user_role", schema = "springdemo", catalog = "sd")
public class TSysUserRole {

    @Id
    @GeneratedValue
    private String cId;

    private Integer nRoleId;
    private Integer nUserId;

    @Id
    @Column(name = "c_id")
    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    @Basic
    @Column(name = "n_role_id")
    public Integer getnRoleId() {
        return nRoleId;
    }

    public void setnRoleId(Integer nRoleId) {
        this.nRoleId = nRoleId;
    }

    @Basic
    @Column(name = "n_user_id")
    public Integer getnUserId() {
        return nUserId;
    }

    public void setnUserId(Integer nUserId) {
        this.nUserId = nUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TSysUserRole that = (TSysUserRole) o;

        if (nRoleId != null ? !nRoleId.equals(that.nRoleId) : that.nRoleId != null) return false;
        if (nUserId != null ? !nUserId.equals(that.nUserId) : that.nUserId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nRoleId != null ? nRoleId.hashCode() : 0;
        result = 31 * result + (nUserId != null ? nUserId.hashCode() : 0);
        return result;
    }
}
