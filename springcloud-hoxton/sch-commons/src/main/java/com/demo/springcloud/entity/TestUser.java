package com.demo.springcloud.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 测试-用户信息表
 * @TableName test_user
 */
@TableName(value ="test_user")
@Data
public class TestUser implements Serializable {
    /**
     * 自增id
     */
    @TableId
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String telephone;

    /**
     * 默认1  1有效 0 无效
     */
    private Integer enabled;

    /**
     * 年龄
     */
    private Integer age;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}