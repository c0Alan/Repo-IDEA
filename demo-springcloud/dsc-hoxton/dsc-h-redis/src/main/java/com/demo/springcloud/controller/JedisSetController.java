package com.demo.springcloud.controller;

import com.demo.springcloud.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * redis set 类型操作
 *
 * @author liuxilin
 * @date 2022/2/26 22:01
 */
@Api(tags = "jedis set 类型操作")
@RequestMapping("/redis/set")
@RestController
public class JedisSetController {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 指定缓存失效时间
     *
     * @param key  键
     * @param time 时间(秒)
     * @return
     */
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * sadd 命令添加对象列表
     *
     * @param key   键
     * @param value 值 可以是多个
     * @return 成功个数
     */
    @ApiOperation("sadd 命令添加对象列表")
    @PostMapping("/saddList")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "value", value = "User 对象列表", required = true, paramType = "body")
    })
    public long saddList(String key, List<User> value) {
        try {
            return redisTemplate.opsForSet().add(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 将set数据放入缓存
     *
     * @param key   键
     * @param time  时间(秒)
     * @param value 值 可以是多个
     * @return 成功个数
     */
    @ApiOperation("sadd 命令添加对象列表并设置过期时间")
    @PostMapping("/saddListExpire")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "value", value = "User 对象列表", required = true, paramType = "body")
    })
    public long saddListExpire(String key, long time, List<User> value) {
        try {
            Long count = redisTemplate.opsForSet().add(key, value);
            if (time > 0) {
                expire(key, time);
            }
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * scard 命令
     *
     * @param key 键
     * @return
     */
    @ApiOperation("scard 命令")
    @GetMapping("/scard")
    public long scard(String key) {
        try {
            return redisTemplate.opsForSet().size(key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * smembers 命令
     *
     * @param key 键
     * @return
     */
    @ApiOperation("smembers 命令")
    @GetMapping("/smembers")
    public Set<Object> smembers(String key) {
        try {
            return redisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * sismember 命令
     *
     * @param key   键
     * @param value 值
     * @return true 存在 false不存在
     */
    @ApiOperation("sismember 命令")
    @PostMapping("/sismember")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "value", value = "User 对象", required = true, paramType = "body")
    })
    public boolean sismember(String key, User value) {
        try {
            return redisTemplate.opsForSet().isMember(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * srem 命令
     *
     * @param key    键
     * @param values 值 可以是多个
     * @return 移除的个数
     */
    @ApiOperation("srem 命令")
    @PostMapping("/srem")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "value", value = "User 对象列表", required = true, paramType = "body")
    })
    public long srem(String key, List<User> values) {
        try {
            Long count = redisTemplate.opsForSet().remove(key, values);
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
