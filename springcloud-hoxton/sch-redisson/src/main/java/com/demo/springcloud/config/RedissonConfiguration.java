package com.demo.springcloud.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


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
}