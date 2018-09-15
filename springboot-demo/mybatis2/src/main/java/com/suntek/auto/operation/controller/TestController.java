package com.suntek.auto.operation.controller;

import com.suntek.auto.operation.config.AuthorSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxilin
 * @since
 * @version 2018/9/7
 * @Copyright (C)2018 , Suntektech
 */
@RestController
public class TestController {
    @Autowired
    private AuthorSettings authorSettings;

    @RequestMapping("/")
    public String index() {
        return "author name is " + authorSettings.getName();
    }
}
