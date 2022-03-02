package com.demo.springcloud.controller;

import io.swagger.annotations.Api;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * redis string 类型操作
 * 参考：https://blog.csdn.net/qq_25135655/article/details/80357137
 *
 * @author liuxilin
 * @date 2022/2/26 22:01
 */
@Api(tags = "redis string类型操作")
@RequestMapping("/redis")
@RestController
public class JedisController {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * string get 方法
     * @param key
     * @return
     */
    @GetMapping("/string/get/{key}")
    public String get(@PathVariable String key) {
        String result = stringRedisTemplate.opsForValue().get(key);
        return result;
    }

    /**
     * string set 方法
     * @param key
     * @return
     */
    @GetMapping("/string/set/{key}")
    public void set(@PathVariable String key) {
        stringRedisTemplate.opsForValue().set(key, "hello");
    }

}
