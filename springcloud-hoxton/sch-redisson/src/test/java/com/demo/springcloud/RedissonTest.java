package com.demo.springcloud;

import com.demo.springcloud.entity.SysUser;
import com.demo.springcloud.mapper.TUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedissonTest {

    //注入RedissonClient
    @Autowired
    RedissonClient redissonClient;

    @Autowired
    TUserMapper tUserMapper;

    @Test
    public void test() {
        //创建一个User对象
        SysUser user = new SysUser(1, "test", "password");
        //获得一个RBucket实现类，参数是redis数据库中的key值
        RBucket<SysUser> bucket = redissonClient.getBucket("user:" + user.getId());
        //执行set语句，将user对象存入redis中
        bucket.set(user);
    }

    @Test
    public void get() {
        //获得一个RBucket实现类，参数是redis数据库中的key值
        RBucket<SysUser> bucket = redissonClient.getBucket("user:1");
        SysUser user = bucket.get();
        System.out.println(user);
    }

    @Test
    public void update() {
        SysUser user = new SysUser(1, "newName", "newPassword");
        RBucket<SysUser> bucket = redissonClient.getBucket("user:" + user.getId());
        //bucket.set(user); 不管key存在不存在都添加/修改值
        bucket.setIfExists(user);
    }

    @Test
    public void del() {
        RBucket<SysUser> bucket = redissonClient.getBucket("user:1");
        bucket.delete();
    }

    @Test
    public void list() {
        //在redis中创建一个key为testList的list
        RList<String> list = redissonClient.getList("testList");
        /*
        注意：只要执行了add操作，就已经在redis中存入该数据了，并不需要另外的其他操作
         */
        list.add("one");
        list.add("two");
        list.add("three");
    }

    @Test
    public void list1() {
        RList<String> list = redissonClient.getList("testList");
        System.out.println(list);
    }

    @Test
    public void set() {
        RSet<Integer> set = redissonClient.getSet("testSet");
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);//Set不允许重复元素，这个操作不会被执行
        System.out.println("redis中testSet的值是：" + set);
    }

    @Test
    public void lock() {
        //会在redis中添加一个Map数据类型，Map的key是myLock
        RLock lock = redissonClient.getLock("myLock");
        try {
            // 尝试加锁，等待时间为10秒，过期时间为30秒
            boolean isLocked = lock.tryLock(10, 30, TimeUnit.SECONDS);
            if (isLocked) {
                // 成功获取到锁，执行业务逻辑
                System.out.println("获取锁成功，即将执行业务逻辑...");
                Thread.sleep(30 * 1000);
            } else {
                // 加锁失败
                System.out.println("获取锁失败，请稍后再试");
            }
        } catch (InterruptedException e) {
            // 处理异常
        } finally {
            lock.unlock();
            System.out.println("释放锁成功");
        }
    }

    @Test
    public void test1() {
        SysUser user = tUserMapper.selectById(1);
        System.out.println(user);
    }

    @Cacheable(value = "userCache",key = "#id",cacheManager = "cacheManager")
    public void queryById() {
        SysUser user =  tUserMapper.selectById(2);
    }

}