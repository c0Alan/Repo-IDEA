package com.demo.springcloud.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "myframe.preuser")
@Data
public class Config02 {
    private String name;
    private int age;
    private String address;
    private String phone;
    private String desc;
    private Date date;
    private List<String> hobby;
    private List<Friend> friends;
    private Map<String,Integer> brother;
}

@Data
class Friend {
    private String name;
    private int age;
}