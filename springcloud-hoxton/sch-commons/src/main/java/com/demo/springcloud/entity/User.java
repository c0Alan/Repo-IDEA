package com.demo.springcloud.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;

    private Integer deptId;

    private String username;

    private String password;

    private Integer age;

    public User() {
    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(Integer id, Integer deptId, String username, String password, Integer age) {
        this.id = id;
        this.deptId = deptId;
        this.username = username;
        this.password = password;
        this.age = age;
    }

}