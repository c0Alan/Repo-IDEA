package com.demo.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.demo.springcloud.mapper")
public class MybatisConfig {

}
