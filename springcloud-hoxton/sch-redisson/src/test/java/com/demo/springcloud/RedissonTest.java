package com.demo.springcloud;

import com.demo.springcloud.entity.User;
import org.junit.jupiter.api.Test;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RedissonTest {

    //注入RedissonClient
    @Autowired
    RedissonClient redissonClient;

    @Test
    public void test() {
        //创建一个User对象
        User user = new User(1, "test", "password");
        //获得一个RBucket实现类，参数是redis数据库中的key值
        RBucket<User> bucket = redissonClient.getBucket("user:" + user.getId());
        //执行set语句，将user对象存入redis中
        bucket.set(user);
    }
}