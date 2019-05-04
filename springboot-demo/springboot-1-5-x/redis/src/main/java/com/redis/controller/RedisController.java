package com.redis.controller;

import com.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RedisController {
    @Autowired
    RedisService redisService;

    /**
     * 测试获取锁
     */
    @RequestMapping("/getDistributeLock")
    public void getDistributeLock(HttpServletRequest request){
        String sessionId = request.getSession().getId();
        redisService.getDistributeLock(sessionId);
    }

    /**
     * 测试释放锁
     */
    @RequestMapping("/releaseDistributeLock")
    public void releaseDistributeLock(HttpServletRequest request){
        String sessionId = request.getSession().getId();
        redisService.releaseDistributeLock(sessionId);
    }
}
