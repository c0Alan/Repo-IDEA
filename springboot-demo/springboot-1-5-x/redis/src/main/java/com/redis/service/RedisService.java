package com.redis.service;

import com.redis.util.RedisTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取 Jedis 实体的工厂类
 * 
 * @author liuxilin
 * @date 2018/4/25 22:55
 */
@Service
public class RedisService {
    private static Logger logger = LoggerFactory.getLogger(RedisService.class);

    @Autowired
    private JedisPool jedisPool;

    public Jedis getResource() {
        return jedisPool.getResource();
    }

    public void closeResource(Jedis jedis) {
        if(jedis != null){
            jedis.close();
        }
    }

    /**
     * 根据 sessionid 加锁
     * @param SessionId
     */
    public void getDistributeLock(String SessionId){
        System.out.println("Session id: " + SessionId);
        Jedis jedis = getResource();
        boolean result = RedisTool.tryGetDistributedLock(jedis, "lockKey", SessionId, 120000);
        if (result){
            System.out.println("you have get the lock!");
        } else {
            System.out.println("you can't get the lock!");
        }
        jedis.close();
    }

    /**
     * 根据 sessionid 解锁
     * @param SessionId
     */
    public void releaseDistributeLock(String SessionId){
        System.out.println("Session id: " + SessionId);
        Jedis jedis = getResource();
        boolean result = RedisTool.releaseDistributedLock(jedis, "lockKey", SessionId);
        if (result){
            System.out.println("you have release the lock!");
        } else {
            System.out.println("you can't release the lock!");
        }
        jedis.close();
    }
}
