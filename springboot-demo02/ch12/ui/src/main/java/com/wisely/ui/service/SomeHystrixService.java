package com.wisely.ui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * 使用ribbon Ì:周用Some Sevice ，并使用断路器:
 *
 * @author liuxl
 * @date 2018/3/26 23:31
 */
@Service
public class SomeHystrixService {

    /**
     * 在Spring Boot 下使用Ribbon ，我们只需注入一个RestTemplate 即可，
     * Spring Boot 已为我们做好了配置。
     */
    @Autowired
    RestTemplate restTemplate; //1

    /**
     * 使用@HystrixCommand 的fallbackMethod 参数指定，
     * 当本方法调用失败时调用后备方法fallbackSome.
     *
     * @param []
     * @return java.lang.String
     * @author liuxl
     * @date 2018/3/26 23:31
     */
    @HystrixCommand(fallbackMethod = "fallbackSome") //2
    public String getSome() {
        return restTemplate.getForObject("http://some/getsome", String.class);
    }

    public String fallbackSome() {
        return "some service模块故障";
    }
}
