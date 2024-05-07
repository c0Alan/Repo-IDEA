package com.demo.springcloud.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;

    private Integer deptId;

    private String username;

    private Integer age;

}