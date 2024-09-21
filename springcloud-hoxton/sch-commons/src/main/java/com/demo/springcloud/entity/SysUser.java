package com.demo.springcloud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Date;

/**
 * 系统用户表
 *
 * @author liuxilin
 * @since 2023-08-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户账号
     */
    @TableField(value = "usercode")
    private String usercode;

    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 密码
     */
    @TableField(value = "role_ids")
    private String roleIds;

    /**
     * 年龄
     */
    @TableField("birthday")
    private Date birthday;


    /**
     * 手机号
     */
    @TableField(value = "telephone")
    private String telephone;

    /**
     * 是否有效
     */
    @TableField(value = "status")
    private Integer status;


    public SysUser() {
    }

    public SysUser(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }


}
