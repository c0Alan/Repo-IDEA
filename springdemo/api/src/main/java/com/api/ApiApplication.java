package com.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.demo.redis.config", "com.demo.redis", "com.dao.config", "com.service", "com.api"}) // redis
//@ComponentScan(basePackages = {"com.mybatis.config", "com.service.mybatis", "com.api.commons", "com.api.mybatis"}) // mybatis
//@ComponentScan(basePackages = {"com.hibernate", "com.shiro", "com.api.shiro"}) // shiro
@ComponentScan(basePackages = {"com.hibernate", "com.api.hibernate", "com.api.commons"}) // hibernate
//@ComponentScan(basePackages = {"com.api.quartz"})
//@ComponentScan(basePackages = {"com.redis", "com.service.redis", "com.api.commons", "com.api.redis"})
//excludeFilters = {@Filter(type= FilterType.REGEX, pattern = {"com\\.*\\.redis\\.*"})})
//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@EnableAutoConfiguration
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
}

