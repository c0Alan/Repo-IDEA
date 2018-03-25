package com.wisely.ch11_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
