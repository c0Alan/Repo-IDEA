package com.mybatis.controller;

import com.mybatis.model.TUser;
import com.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("getUser")
    public TUser getTUser() {
        TUser TUser = userService.getUserById(2);
        return TUser;
    }
}