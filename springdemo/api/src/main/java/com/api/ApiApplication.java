package com.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;


@SpringBootApplication
//@ComponentScan(basePackages = {"com.demo.redis.config", "com.demo.redis", "com.dao.config", "com.service", "com.api"})
@ComponentScan(basePackages = {"com.mybatis.config", "com.service.mybatis", "com.api.commons", "com.api.mybatis"})
//@ComponentScan(basePackages = {"com.api.quartz"})
//@ComponentScan(basePackages = {"com.redis", "com.service.redis", "com.api.commons", "com.api.redis"})
//excludeFilters = {@Filter(type= FilterType.REGEX, pattern = {"com\\.*\\.redis\\.*"})})
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
}
