package com.suntek.auto.operation.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 
 * @author liuxilin
 * @since
 * @version 2018/9/7
 * @Copyright (C)2018 , Suntektech
 */
@Component
@ConfigurationProperties(prefix = "author")
public class AuthorSettings {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}