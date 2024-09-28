package com.demo.springcloud.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * redisson 操作接口
 * 参考：https://blog.csdn.net/weixin_43759352/article/details/135874990
 * 参考：https://blog.csdn.net/qq_20236937/article/details/137561788
 *
 * @author liuxl
 * @date 2024/9/7
 */
@Api(tags = "redisson操作接口")
@RestController
@Slf4j
@RequestMapping("/redisson")
public class RedissonController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedissonClient redissonClient;

    public static final String REDIS_LOCK = "lock";

    /**
     * 线程不安全,并发10个线程200个请求出现数据不一致问题
     */
    @GetMapping("/decrement")
    public String decrement() {
        // Redis中存有goods:001号商品，数量为100
        String result = stringRedisTemplate.opsForValue().get("goods:001");
        // 获取到剩余商品数
        int total = result == null ? 0 : Integer.parseInt(result);
        if (total > 0) {
            // 剩余商品数大于0 ，则进行扣减
            int realTotal = total - 1;
            // 将商品数回写数据库
            stringRedisTemplate.opsForValue().set("goods:001", String.valueOf(realTotal));
            log.info("购买商品成功，库存还剩：" + realTotal + "件， 服务端口为8001");
            return "购买商品成功，库存还剩：" + realTotal + "件， 服务端口为8001";
        } else {
            log.info("购买商品失败，服务端口为8001");
        }
        return "购买商品失败，服务端口为8001";
    }


    /**
     * 线程安全
     */
    @GetMapping("/decrement2")
    public String decrement2() {
        //创建锁“lock”
        RLock lock = redissonClient.getLock(REDIS_LOCK);

        //加锁
        lock.lock();

        try {
            String result = stringRedisTemplate.opsForValue().get("goods:001");
            int total = result == null ? 0 : Integer.parseInt(result);
            if (total > 0) {
                // 如果在此处需要调用其他微服务，处理时间较长。。。
                int realTotal = total - 1;
                stringRedisTemplate.opsForValue().set("goods:001", String.valueOf(realTotal));
                System.out.println("购买商品成功，库存还剩：" + realTotal + "件， 服务端口为8001");
                return "购买商品成功，库存还剩：" + realTotal + "件， 服务端口为8001";
            } else {
                System.out.println("购买商品失败，服务端口为8001");
            }
            return "购买商品失败，服务端口为8001";
        } finally {
            lock.unlock();
        }
    }


}
