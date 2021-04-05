package com.demo.springcloud.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Email miles02@163.com
 *
 * @author fangzhipeng
 * create 2018-07-09
 **/
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
    }

    @HystrixCommand(fallbackMethod = "slowHiError")
    public String slowHi(String name, Integer delayTime) {
        String result = restTemplate.getForObject("http://SERVICE-HI/slowHi?name=" + name + "&delayTime=" + delayTime, String.class);
        return result;
    }

    @HystrixCommand(fallbackMethod = "hiError")
    public String notExistHi(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/notExistHi?name=" + name, String.class);
    }

    public String hiError(String name) {
        return "hi," + name + ",sorry,error!";
    }

    public String slowHiError(String name, Integer delayTime) {
        return "hi," + name + ",sorry,error!delayTime:" + delayTime + "s";
    }

}
