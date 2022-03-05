package com.demo.springcloud.controller;

import com.demo.springcloud.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * redis sortedset 类型操作
 *
 * @author liuxilin
 * @date 2022/2/26 22:01
 */
@Api(tags = "jedis sortedset 类型操作")
@RequestMapping("/redis/sortedset")
@RestController
public class JedisSortedSetController {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * zadd 命令添加对象
     *
     * @param key   键
     * @param value 值 可以是多个
     * @return 成功个数
     */
    @ApiOperation("zadd 命令添加对象")
    @PostMapping("/zadd")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "value", value = "User 对象", required = true, paramType = "body")
    })
    public boolean zadd(@RequestParam String key, @RequestParam double score,
                        @RequestBody User value) {
        try {
            return redisTemplate.opsForZSet().add(key, value, score);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * zadd 命令添加对象列表
     *
     * @param key   键
     * @param value 值 可以是多个
     * @return 成功个数
     */
    @ApiOperation("zadd 命令添加对象列表")
    @PostMapping("/zaddList")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "value", value = "User 对象列表", required = true, paramType = "body")
    })
    public long zaddList(@RequestParam String key, @RequestBody List<User> value) {
        try {
            Set tuples = new HashSet();
            value.forEach(user -> {
                tuples.add(new DefaultTypedTuple(user, Double.valueOf(1)));
            });
            return redisTemplate.opsForZSet().add(key, tuples);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * zcard 命令
     *
     * @param key 键
     * @return
     */
    @ApiOperation("zcard 命令")
    @GetMapping("/zcard")
    public long zcard(@RequestParam String key) {
        try {
            return redisTemplate.opsForZSet().size(key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * zrange 命令
     *
     * @param key 键
     * @return
     */
    @ApiOperation("zrange 命令")
    @GetMapping("/zrange")
    public Set<Object> zrange(@RequestParam String key, @RequestParam long start,
                              @RequestParam long end) {
        try {
            return redisTemplate.opsForZSet().range(key, start, end);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * zrem 命令
     *
     * @param key    键
     * @param values 值 可以是多个
     * @return 移除的个数
     */
    @ApiOperation("zrem 命令")
    @GetMapping("/zrem")
    public long zrem(String key, List<User> values) {
        try {
            Long count = redisTemplate.opsForZSet().remove(key, values);
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * zremrangebyrank 命令, 根据索引范围删除
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    @ApiOperation("zremrangebyrank 命令, 根据索引范围删除")
    @GetMapping("/zremrangebyrank")
    public long zremrangebyrank(String key, long start, long end) {
        try {
            Long count = redisTemplate.opsForZSet().removeRange(key, start, end);
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
