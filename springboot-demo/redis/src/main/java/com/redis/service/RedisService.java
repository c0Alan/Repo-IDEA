package com.redis.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

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
     * 插入字符串
     * @param key
     * @param value
     */
    public void set(String key, String value) {
        Jedis jedis=null;
        try{
            jedis = getResource();
            jedis.set(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeResource(jedis);
        }
    }

    /**
     * 获取字符串
     * @param key
     * @return
     */
    public String get(String key) {
        String result = null;
        Jedis jedis=null;
        try{
            jedis = getResource();
            result = jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeResource(jedis);
        }
        return result;
    }
}
