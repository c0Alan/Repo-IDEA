package com.multiple.datasource.controller;

import com.multiple.datasource.dao1.entity.App;
import com.multiple.datasource.dao1.mapper.AppMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxilin
 * @version 2019-04-01
 * @since
 */
@RestController
public class AppController {
    @Autowired
    AppMapper appMapper;

    @GetMapping("getApp")
    public App getApp() {
        return appMapper.selectByPrimaryKey(1);
    }
}
