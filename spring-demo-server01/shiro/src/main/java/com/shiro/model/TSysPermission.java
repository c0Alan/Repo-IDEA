package com.shiro.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "t_sys_permission", schema = "springdemo", catalog = "sd")
public class TSysPermission {
    private int nId;
    private BigInteger nValid;
    private String cName;

    /** 父编号 */
    private Integer nParentId;

    /** 父编号列表 */
    private String cParentIds;

    /** 权限字符串 */
    /**menu例子：role:*，button例子：role:create,role:update,role:delete,role:view */
    private String cPermission;

    /** 资源类型，[menu|button] */
    @Column(columnDefinition="enum('menu','button')")
    private String cResourceType;

    /** 资源路径 */
    private String cUrl;

    private List<TSysRole> roles;

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
    @Column(name = "c_name")
    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    @Basic
    @Column(name = "n_parent_id")
    public Integer getnParentId() {
        return nParentId;
    }

    public void setnParentId(Integer nParentId) {
        this.nParentId = nParentId;
    }

    @Basic
    @Column(name = "c_parent_ids")
    public String getcParentIds() {
        return cParentIds;
    }

    public void setcParentIds(String cParentIds) {
        this.cParentIds = cParentIds;
    }

    @Basic
    @Column(name = "c_permission")
    public String getcPermission() {
        return cPermission;
    }

    public void setcPermission(String cPermission) {
        this.cPermission = cPermission;
    }

    @Basic
    @Column(name = "c_resource_type")
    public String getcResourceType() {
        return cResourceType;
    }

    public void setcResourceType(String cResourceType) {
        this.cResourceType = cResourceType;
    }

    @Basic
    @Column(name = "c_url")
    public String getcUrl() {
        return cUrl;
    }

    public void setcUrl(String cUrl) {
        this.cUrl = cUrl;
    }

    @ManyToMany
    @JoinTable(name="TSysRolePermission",joinColumns={@JoinColumn(name="nPermissionId")},inverseJoinColumns={@JoinColumn(name="nRoleId")})
    public List<TSysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<TSysRole> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TSysPermission that = (TSysPermission) o;

        if (nId != that.nId) return false;
        if (nValid != null ? !nValid.equals(that.nValid) : that.nValid != null) return false;
        if (cName != null ? !cName.equals(that.cName) : that.cName != null) return false;
        if (nParentId != null ? !nParentId.equals(that.nParentId) : that.nParentId != null) return false;
        if (cParentIds != null ? !cParentIds.equals(that.cParentIds) : that.cParentIds != null) return false;
        if (cPermission != null ? !cPermission.equals(that.cPermission) : that.cPermission != null) return false;
        if (cResourceType != null ? !cResourceType.equals(that.cResourceType) : that.cResourceType != null)
            return false;
        if (cUrl != null ? !cUrl.equals(that.cUrl) : that.cUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nId;
        result = 31 * result + (nValid != null ? nValid.hashCode() : 0);
        result = 31 * result + (cName != null ? cName.hashCode() : 0);
        result = 31 * result + (nParentId != null ? nParentId.hashCode() : 0);
        result = 31 * result + (cParentIds != null ? cParentIds.hashCode() : 0);
        result = 31 * result + (cPermission != null ? cPermission.hashCode() : 0);
        result = 31 * result + (cResourceType != null ? cResourceType.hashCode() : 0);
        result = 31 * result + (cUrl != null ? cUrl.hashCode() : 0);
        return result;
    }
}
