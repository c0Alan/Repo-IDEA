package com.model.hibernate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_sys_role_permission", schema = "springdemo", catalog = "sd")
public class TSysRolePermission {
    private Integer nPermissionId;
    private Integer nRoleId;

    @Basic
    @Column(name = "n_permission_id")
    public Integer getnPermissionId() {
        return nPermissionId;
    }

    public void setnPermissionId(Integer nPermissionId) {
        this.nPermissionId = nPermissionId;
    }

    @Basic
    @Column(name = "n_role_id")
    public Integer getnRoleId() {
        return nRoleId;
    }

    public void setnRoleId(Integer nRoleId) {
        this.nRoleId = nRoleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TSysRolePermission that = (TSysRolePermission) o;

        if (nPermissionId != null ? !nPermissionId.equals(that.nPermissionId) : that.nPermissionId != null)
            return false;
        if (nRoleId != null ? !nRoleId.equals(that.nRoleId) : that.nRoleId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nPermissionId != null ? nPermissionId.hashCode() : 0;
        result = 31 * result + (nRoleId != null ? nRoleId.hashCode() : 0);
        return result;
    }
}
