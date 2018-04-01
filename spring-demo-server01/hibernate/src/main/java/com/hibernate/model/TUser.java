package com.hibernate.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "t_user", schema = "springdemo", catalog = "sd")
public class TUser {

    private Integer nId;
    private String cName;
    private Integer nSex;
    private Integer nAge;
    private String cAddress;
    private String cLoginid;
    private String cPassword;
    private String cSalt;
    private Integer nState;

    private List<TSysRole> roleList; // 一个用户具有多个角色

    private List<TSysUserRole> sysUserRoles;

    @Basic
    @Column(name = "c_name")
    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    @Basic
    @Column(name = "n_sex")
    public Integer getnSex() {
        return nSex;
    }

    public void setnSex(Integer nSex) {
        this.nSex = nSex;
    }

    @Basic
    @Column(name = "n_age")
    public Integer getnAge() {
        return nAge;
    }

    public void setnAge(Integer nAge) {
        this.nAge = nAge;
    }

    @Basic
    @Column(name = "c_address")
    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    @Basic
    @Column(name = "c_loginid", unique =true)
    public String getcLoginid() {
        return cLoginid;
    }

    public void setcLoginid(String cLoginid) {
        this.cLoginid = cLoginid;
    }

    @Basic
    @Column(name = "c_password")
    public String getcPassword() {
        return cPassword;
    }

    public void setcPassword(String cPassword) {
        this.cPassword = cPassword;
    }

    @Basic
    @Column(name = "c_salt")
    public String getcSalt() {
        return cSalt;
    }

    public void setcSalt(String cSalt) {
        this.cSalt = cSalt;
    }

    @Basic
    @Column(name = "n_state")
    public Integer getnState() {
        return nState;
    }

    public void setnState(Integer nState) {
        this.nState = nState;
    }

    @Id
    @Column(name = "n_id")
    @GeneratedValue
    public Integer getnId() {
        return nId;
    }

    public void setnId(Integer nId) {
        this.nId = nId;
    }

    @ManyToMany(fetch= FetchType.EAGER)//立即从数据库中进行加载数据;
    @JoinTable(name = "TSysUserRole", joinColumns = { @JoinColumn(name = "nUserId", referencedColumnName="n_id") }, inverseJoinColumns ={@JoinColumn(name = "nRoleId", referencedColumnName="n_id") })
    public List<TSysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<TSysRole> roleList) {
        this.roleList = roleList;
    }

    @ManyToMany(fetch= FetchType.EAGER)//立即从数据库中进行加载数据;
    @JoinTable(name = "TSysUserRole", joinColumns = { @JoinColumn(name = "nUserId", referencedColumnName="n_id",
            foreignKey = @ForeignKey(name="user_id_fk", value = ConstraintMode.CONSTRAINT)) })
//    @JoinColumn(name="nUserId", foreignKey = @ForeignKey(name="user_id_fk", value = ConstraintMode.CONSTRAINT))
    public List<TSysUserRole> getSysUserRoles() {
        return sysUserRoles;
    }

    public void setSysUserRoles(List<TSysUserRole> sysUserRoles) {
        this.sysUserRoles = sysUserRoles;
    }

    /**
     * 密码盐.
     * @return
     */
    public String genCredentialsSalt(){
        return this.cLoginid + this.cSalt;
    }

}
