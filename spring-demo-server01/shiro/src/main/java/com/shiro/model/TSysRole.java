package com.shiro.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "t_sys_role", schema = "springdemo", catalog = "sd")
public class TSysRole {

    private int nId;
    private BigInteger nValid;
    private String cDescription;
    private String cRole;

    //角色 -- 权限关系：多对多关系;
    private List<TSysPermission> permissions;

    // 用户 - 角色关系定义;
    private List<TUser> users;// 一个角色对应多个用户

    @Id
    @Column(name = "n_id")
    @GeneratedValue
    public int getnId() {
        return nId;
    }

    public void setnId(int nId) {
        this.nId = nId;
    }

    @Basic
    @Column(name = "n_valid")
    public BigInteger getnValid() {
        return nValid;
    }

    public void setnValid(BigInteger nValid) {
        this.nValid = nValid;
    }

    @Basic
    @Column(name = "c_description")
    public String getcDescription() {
        return cDescription;
    }

    public void setcDescription(String cDescription) {
        this.cDescription = cDescription;
    }

    @Basic
    @Column(name = "c_role")
    public String getcRole() {
        return cRole;
    }

    public void setcRole(String cRole) {
        this.cRole = cRole;
    }

    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name="TSysRolePermission",joinColumns={@JoinColumn(name="nRoleId")},inverseJoinColumns={@JoinColumn(name="nPermissionId")})
    public List<TSysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<TSysPermission> permissions) {
        this.permissions = permissions;
    }

    @ManyToMany
    @JoinTable(name="TSysUserRole",joinColumns={@JoinColumn(name="nRoleId")},inverseJoinColumns={@JoinColumn(name="nUserId")})
    public List<TUser> getUsers() {
        return users;
    }

    public void setUsers(List<TUser> users) {
        this.users = users;
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
