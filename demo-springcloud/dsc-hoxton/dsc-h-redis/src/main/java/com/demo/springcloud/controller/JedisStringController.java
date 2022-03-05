package com.demo.springcloud.controller;

import com.demo.springcloud.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * redis string 类型操作
 *
 * @author liuxilin
 * @date 2022/2/26 22:01
 */
@Api(tags = "jedis string 类型操作")
@RequestMapping("/redis/string")
@RestController
public class JedisStringController {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * get 命令
     *
     * @param key 键
     * @return 值
     */
    @ApiOperation("get 命令")
    @GetMapping("/get")
    public Object get(@RequestParam String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * set 命令
     *
     * @param key   键
     * @param value 值
     * @return true成功 false失败
     */
    @ApiOperation("set 命令")
    @PostMapping("/set")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "value", value = "User对象", required = true, paramType = "body")
    })
    public boolean set(@RequestParam String key, @RequestBody User value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * setex 命令
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒) time要大于0 如果time小于等于0 将设置无限期
     * @return true成功 false 失败
     */
    @ApiOperation("setex 命令")
    @PostMapping("/setex")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "value", value = "User对象", required = true, paramType = "body")
    })
    public boolean setex(@RequestParam String key, @RequestParam long time, @RequestBody User value) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * incrby 命令
     *
     * @param key   键
     * @param delta 要增加几(大于0)
     * @return
     */
    @ApiOperation("incrby 命令")
    @GetMapping("/incrby")
    public long incr(@RequestParam String key, @RequestParam long delta) {
        if (delta < 0) {
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * decr 命令
     *
     * @param key   键
     * @param delta 要减少几(小于0)
     * @return
     */
    @ApiOperation("decr 命令")
    @GetMapping("/decrby")
    public long decr(@RequestParam String key, @RequestParam long delta) {
        if (delta < 0) {
            throw new RuntimeException("递减因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, -delta);
    }

}
