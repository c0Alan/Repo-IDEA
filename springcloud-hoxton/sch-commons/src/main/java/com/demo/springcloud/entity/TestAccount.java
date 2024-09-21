package com.demo.springcloud.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 账户表
 * @TableName test_account
 */
@TableName(value ="test_account")
@Data
public class TestAccount implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer id;

    /**
     * 用户编码
     */
    private String usercode;

    /**
     * 用户名
     */
    private String username;

    /**
     * 账户余额
     */
    private Integer money;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}