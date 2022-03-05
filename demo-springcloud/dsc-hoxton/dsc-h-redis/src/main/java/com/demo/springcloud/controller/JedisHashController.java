package com.demo.springcloud.controller;

import com.demo.springcloud.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * redis hash 类型操作
 *
 * @author liuxilin
 * @date 2022/2/26 22:01
 */
@Api(tags = "jedis hash 类型操作")
@RequestMapping("/redis/hash")
@RestController
public class JedisHashController {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * hset 命令
     *
     * @param key   键
     * @param item  项
     * @param value 值
     * @return true 成功 false失败
     */
    @ApiOperation("hset 命令")
    @PostMapping("/hset")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "value", value = "User 对象", required = true, paramType = "body")
    })
    public boolean hset(@RequestParam String key, @RequestParam String item, @RequestBody User value) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * hset 命令并设置过期时间
     *
     * @param key   键
     * @param item  项
     * @param value 值
     * @param time  时间(秒)  注意:如果已存在的hash表有时间,这里将会替换原有的时间
     * @return true 成功 false失败
     */
    @ApiOperation("hset 命令并设置过期时间")
    @PostMapping("/hsetExpire")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "value", value = "User 对象", required = true, paramType = "body")
    })
    public boolean hsetExpire(@RequestParam String key, @RequestParam String item,
                              @RequestParam long time, @RequestBody Object value) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Hget 命令
     *
     * @param key  键 不能为null
     * @param item 项 不能为null
     * @return 值
     */
    @ApiOperation("hget 命令")
    @GetMapping("/hget")
    public Object hget(@RequestParam String key, @RequestParam String item) {
        return redisTemplate.opsForHash().get(key, item);
    }

    /**
     * hmget 命令
     *
     * @param key 键
     * @return 对应的多个键值
     */
    @ApiOperation("hmget 命令")
    @GetMapping("/hmget")
    public Map<Object, Object> hmget(@RequestParam String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * hmset 命令
     *
     * @param key 键
     * @param map 对应多个键值
     * @return true 成功 false 失败
     */
    @ApiOperation("hmset 命令")
    @PostMapping("/hmset")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "map", value = "map 对象", required = true, paramType = "body")
    })
    public boolean hmset(@RequestParam String key, @RequestBody Map<String, Object> map) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * hmset 命令并设置过期时间
     *
     * @param key  键
     * @param map  对应多个键值
     * @param time 时间(秒)
     * @return true成功 false失败
     */
    @ApiOperation("hmset 命令并设置过期时间")
    @PostMapping("/hmsetExpire")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "map", value = "map 对象", required = true, paramType = "body")
    })
    public boolean hmsetExpire(@RequestParam String key, @RequestParam long time, @RequestBody Map<String, Object> map) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



    /**
     * hdel 命令
     *
     * @param key  键 不能为null
     * @param items 项 可以使多个 不能为null
     */
    @ApiOperation("hdel 命令")
    @GetMapping("/hdel")
    public void hdel(@RequestParam String key, @RequestParam List<String> items) {
        redisTemplate.opsForHash().delete(key, items);
    }

    /**
     * hexists 命令
     *
     * @param key  键 不能为null
     * @param item 项 不能为null
     * @return true 存在 false不存在
     */
    @ApiOperation("hexists 命令")
    @GetMapping("/hexists")
    public boolean hexists(@RequestParam String key, @RequestParam String item) {
        return redisTemplate.opsForHash().hasKey(key, item);
    }

    /**
     * hincrby 命令
     *
     * @param key  键
     * @param item 项
     * @param by   要增加几(大于0)
     * @return
     */
    @ApiOperation("hincrby 命令")
    @GetMapping("/hincrby")
    public double hincrby(@RequestParam String key, @RequestParam String item, @RequestParam double by) {
        return redisTemplate.opsForHash().increment(key, item, by);
    }

    /**
     * hincrby 命令,减法
     *
     * @param key  键
     * @param item 项
     * @param by   要减少记(小于0)
     * @return
     */
    @ApiOperation("hincrby 命令,减法")
    @GetMapping("/hdecr")
    public double hdecr(@RequestParam String key, @RequestParam String item, @RequestParam double by) {
        return redisTemplate.opsForHash().increment(key, item, -by);
    }

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

}
