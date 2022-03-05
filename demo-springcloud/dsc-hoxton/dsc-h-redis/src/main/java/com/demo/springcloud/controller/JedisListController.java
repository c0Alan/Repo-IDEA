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
import java.util.concurrent.TimeUnit;

/**
 * redis list 类型操作
 *
 * @author liuxilin
 * @date 2022/2/26 22:01
 */
@Api(tags = "jedis list 类型操作")
@RequestMapping("/redis/list")
@RestController
public class JedisListController {

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
     * rpush 命令
     *
     * @param key   键
     * @param value 值
     * @return
     */
    @ApiOperation("rpush 命令")
    @PostMapping("/rpush")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "value", value = "User 对象", required = true, paramType = "body")
    })
    public boolean rpush(String key, User value) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * rpush 命令并设置过期时间
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒)
     * @return
     */
    @ApiOperation("rpush 命令并设置过期时间")
    @PostMapping("/rpushExpire")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "value", value = "User 对象", required = true, paramType = "body")
    })
    public boolean rpushExpire(String key, long time, User value) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
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
     * rpush 命令添加对象列表
     *
     * @param key   键
     * @param value 值
     * @return
     */
    @ApiOperation("rpush 命令添加对象列表")
    @PostMapping("/rpushList")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "value", value = "User 对象列表", required = true, paramType = "body")
    })
    public boolean rpushList(String key, List<User> value) {
        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * rpush 命令添加对象列表并设置过期时间
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒)
     * @return
     */
    @ApiOperation("rpush 命令添加对象列表并设置过期时间")
    @PostMapping("/rpushListExpire")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "value", value = "User 对象列表", required = true, paramType = "body")
    })
    public boolean rpushListExpire(String key, long time, List<Object> value) {
        try {
            redisTemplate.opsForList().rightPushAll(key, value);
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
     * lset 命令
     * 更新指定索引值, list不存在会报错
     *
     * @param key   键
     * @param index 索引
     * @param value 值
     * @return
     */
    @ApiOperation("lset 命令")
    @PostMapping("/lset")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "value", value = "User 对象", required = true, paramType = "body")
    })
    public boolean lset(String key, long index, Object value) {
        try {
            redisTemplate.opsForList().set(key, index, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * lrang 命令
     *
     * @param key   键
     * @param start 开始
     * @param end   结束  0 到 -1代表所有值
     * @return
     */
    @ApiOperation("lrang 命令")
    @GetMapping("/lrang")
    public List<Object> lrang(String key, long start, long end) {
        try {
            return redisTemplate.opsForList().range(key, start, end);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * llen 命令
     *
     * @param key 键
     * @return
     */
    @ApiOperation("llen 命令")
    @GetMapping("/llen")
    public long llen(String key) {
        try {
            return redisTemplate.opsForList().size(key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * lindex 命令
     *
     * @param key   键
     * @param index 索引  index>=0时， 0 表头，1 第二个元素，依次类推；index<0时，-1，表尾，-2倒数第二个元素，依次类推
     * @return
     */
    @ApiOperation("lindex 命令")
    @GetMapping("/lindex")
    public Object lindex(String key, long index) {
        try {
            return redisTemplate.opsForList().index(key, index);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    /**
     * lrem 命令
     *
     * @param key   键
     * @param count 移除多少个
     * @param value 值
     * @return 移除的个数
     */
    @ApiOperation("lrem 命令")
    @GetMapping("/lrem")
    public long lrem(String key, long count, Object value) {
        try {
            Long remove = redisTemplate.opsForList().remove(key, count, value);
            return remove;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
