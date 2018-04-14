package com.springcloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DcController {

    @Autowired
    ConsumerService consumerService;

    @GetMapping("/consumer")
    public String dc(){
        return consumerService.consumer();
    }

    @Service
    class ConsumerService {
        @Autowired
        RestTemplate restTemplate;

        public String fallback(){
            return "fallback";
        }

        /**
         * 使用@HystrixCommand来为一个依赖资源定义服务降级逻辑
         * 依赖隔离、服务降级在使用时候都是一体化实现的
         * @return
         */
        @HystrixCommand(fallbackMethod = "fallback")
        public String consumer(){
            return restTemplate.getForObject("http://eureka-client/dc", String.class);
        }

    }
}
