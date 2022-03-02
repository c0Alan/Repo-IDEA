package com.demo.springcloud.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author liuxilin
 * @date 2022/2/26 13:32
 */
@Data
@Slf4j
@ConfigurationProperties(prefix = "redis")
@Configuration
public class RedisConfig extends CachingConfigurerSupport {

    @Autowired
    RedisProperties redisProperties;

    @Value("#{'${redis.nodes}'.split(',')}")
    private List<String> nodes;

    private Integer mode;

    @PostConstruct
    public void init() {
        if (mode.equals(Integer.valueOf(0))){
            String[] host =  nodes.get(0).split(":");
            redisProperties.setHost(host[0]);
            redisProperties.setPort(Integer.parseInt(host[1]));
            redisProperties.setCluster(null);
        }
        if (mode.equals(Integer.valueOf(2))){
            redisProperties.getCluster().setNodes(nodes);
        }
        log.info("{}", redisProperties);
    }



}