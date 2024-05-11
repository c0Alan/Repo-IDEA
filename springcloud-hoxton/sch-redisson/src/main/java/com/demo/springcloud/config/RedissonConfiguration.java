package com.demo.springcloud.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.redisson.spring.cache.CacheConfig;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;


@Configuration
public class RedissonConfiguration {

    @Value("${redis.server}")
    String redisServer;

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        //设置redis的地址，这里是单机模式
        config.useSingleServer().setAddress("redis://" + redisServer);
        //设置Redisson存储数据的格式，这里是使用的Json格式
        config.setCodec(new JsonJacksonCodec());
        return Redisson.create(config);
    }

    //这里是一个缓存管理器
    @Bean
    public CacheManager cacheManager(RedissonClient redissonClient) {
        /*
        为Redisson的缓存管理器设置参数：
            1.缓存数据12分钟过期。
            2.最长空闲时间为10分钟。
        */
        CacheConfig conf = new CacheConfig(12 * 60 * 1000, 10 * 60 * 1000);
        HashMap<String, CacheConfig> map = new HashMap<>();
        map.put("userCache", conf);
        RedissonSpringCacheManager manager = new RedissonSpringCacheManager(redissonClient, map);
        return manager;
    }
}