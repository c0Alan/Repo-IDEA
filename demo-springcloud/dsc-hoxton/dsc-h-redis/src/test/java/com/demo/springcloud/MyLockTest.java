package com.demo.springcloud;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyLockTest {

    @Autowired
    private RedissonClient redissonClient;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private final static String REDIS_KEY = "test_lock_list";

    @Test
    public void addRedisData() {
        for (int i = 0; i < 100; i++) {
            stringRedisTemplate.opsForList().rightPush(REDIS_KEY, i + "");
        }
    }

    @Test
    public void runTest1() {
        System.out.println("_____________________________执行run1");
        testLock();
    }

    @Test
    public void runTest2() {
        System.out.println("_____________________________执行run2");
        testLock();
    }

    public void testLock() {
        if (redissonClient == null) {
            System.out.println("redissonClient 空");
            return;
        }
        RLock testLock = redissonClient.getLock("testLock");
        // 设置锁生命周期60秒
        // testLock.lock(60, TimeUnit.SECONDS);
        System.out.println("正在获取锁：" + System.currentTimeMillis());
        testLock.lock();
        System.out.println("获取锁成功：" + System.currentTimeMillis());
        try {
            List<String> list = stringRedisTemplate.opsForList().range(REDIS_KEY, 0, 50);
            /**
             * 进行一堆逻辑 ， 假设这些逻辑的处理时间非常耗时，需要20S
             */
            Thread.sleep(15000);
            list.forEach(t -> {
                System.out.println(t);
            });
            stringRedisTemplate.opsForList().trim(REDIS_KEY, list.size(), -1);
        } catch (Exception e) {

        } finally {
            System.out.println("释放锁");
            testLock.unlock();
        }
    }


}