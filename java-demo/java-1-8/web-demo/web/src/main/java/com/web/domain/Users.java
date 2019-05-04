package com.web.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author gacl
 * 用户实体类
 */
public class Users implements Serializable {

    private static final long serialVersionUID = -4313782718477229465L;
    
    // 用户ID
    private String id;
    // 用户名
    private String name;
    // 用户密码
    private String password;
    // 用户邮箱
    private String email;
    // 用户生日
    private Date birthday;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}