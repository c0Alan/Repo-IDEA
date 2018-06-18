package com.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 通过 @ConfigurationProperties 加载properties 文件内的配置，
 *
 * @author liuxl
 * @date 2018/6/12 12:27
 */
@Component
@ConfigurationProperties(prefix = "author")
public class AuthorSettings {
    private String name;
    private Long age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}