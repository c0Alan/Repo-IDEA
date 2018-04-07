package com.c0.pac.person;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PersonApplication {
	
	   public static void main(String[] args) {
		   SpringApplication app = new SpringApplication(PersonApplication.class);

		   /** 启动配置 */
		   app.setBannerMode(Banner.Mode.OFF); // 关闭启动标语

		   app.run(args);
	    }

}
