package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 以通过http实现对应用的监控和管理
 * Spring Boot 提供了运行时的应用监控和管理的功能。
 * 我们可以通过http、JMX 、SSH 协议来进行操作。审计、健康及指标信息将会自动得到。
 * 
 * @author liuxilin
 * @date 2018/6/15 22:40
 */
@SpringBootApplication
@RestController
public class DemoApplication {
	@Autowired
	StatusService statusService;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    /**
     * 注册端点的Bean .
     * @return
     */
    @Bean
    public Endpoint<String> status() {
    	Endpoint<String> status =  new StatusEndPoint();
    	return status;
    }

    /**
     * 定义控制器方法用来改变status .
     * @param status
     * @return
     */
    @RequestMapping("/change")
    public String changeStatus(String status){
    	statusService.setStatus(status);
    	return "OK";
    }
}
