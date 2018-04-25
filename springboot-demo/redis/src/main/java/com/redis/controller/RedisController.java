package com.redis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedisController {
    /**
     * 测试获取锁
     */
    @RequestMapping("/getDistributeLock")
    public void getDistributeLock(){

        System.out.println("Redis locked!");
    }

    /**
     * 测试释放锁
     */
    @RequestMapping("/releaseDistributeLock")
    public void releaseDistributeLock(){

        System.out.println("Redis released lock!");
    }
}
