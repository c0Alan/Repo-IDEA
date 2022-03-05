package com.demo.springcloud.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * redis key 操作
 *
 * @author liuxilin
 * @date 2022/2/26 22:01
 */
@Api(tags = "jedis key 操作")
@Slf4j
@RequestMapping("/redis/key")
@RestController
public class JedisKeyController {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * expire 命令
     *
     * @param key  键
     * @param time 时间(秒)
     * @return
     */
    @ApiOperation("expire 命令")
    @GetMapping("/expire")
    public boolean expire(@RequestParam String key, @RequestParam long time) {
        try {
            if (time > 0) {
                // 单位秒
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            log.error("{}", e);
            return false;
        }
    }

    /**
     * ttl 命令
     *
     * @param key 键 不能为null
     * @return 时间(秒) 返回0代表为永久有效
     */
    @ApiOperation("ttl 命令")
    @GetMapping("/ttl")
    public long ttl(@RequestParam String key) {
        // 单位秒
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * exists 命令
     *
     * @param key 键
     * @return true 存在 false不存在
     */
    @ApiOperation("exists 命令")
    @GetMapping("/exists")
    public boolean exists(@RequestParam String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * del 命令
     * 传参: keys=key1,key2
     *
     * @param keys 可以传一个值 或多个
     */
    @ApiOperation("del 命令")
    @GetMapping("/del")
    public long del(@RequestParam List<String> keys) {
        long n = 0;
        if(!CollectionUtils.isEmpty(keys)) {
            n = redisTemplate.delete(keys);
        }
        return n;
    }

}
