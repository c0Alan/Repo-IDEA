package com.demo.springcloud.controller;

import com.demo.springcloud.entity.SysUser;
import com.demo.springcloud.response.ResponseResult;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * redis 操作接口
 * 参考：https://blog.csdn.net/qq_20236937/article/details/137561788
 *
 * @author liuxl
 * @date 2024/9/7
 */
@Api(tags = "redis操作接口")
@RestController
@Slf4j
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/setValue")
    public ResponseResult setValue(@RequestParam String key, @RequestParam String value) {
        stringRedisTemplate.opsForValue().set(key, value);
        return ResponseResult.success();
    }

    @GetMapping("/setValue2")
    public ResponseResult setValue2(@RequestParam String key, @RequestParam String value) {
        redisTemplate.opsForValue().set(key, value);
        return ResponseResult.success();
    }

    @GetMapping("/getValue2")
    public ResponseResult getValue2(@RequestParam String key) {
        String value = (String) redisTemplate.opsForValue().get(key);
        return ResponseResult.success(value);
    }


    @PostMapping("/setUser")
    public ResponseResult setUser(@RequestBody SysUser sysUser) {
        redisTemplate.opsForValue().set("user:" + sysUser.getUsercode(), sysUser);
        return ResponseResult.success();
    }

    @GetMapping("/getUser")
    public ResponseResult getUser(@RequestParam String key) {
        SysUser sysUser = (SysUser) redisTemplate.opsForValue().get("user:" + key);
        return ResponseResult.success(sysUser);
    }


}
