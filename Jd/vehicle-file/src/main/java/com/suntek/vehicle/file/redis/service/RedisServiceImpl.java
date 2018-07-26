package com.suntek.vehicle.file.redis.service;

import com.suntek.vehicle.file.entity.RedisModel;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl extends IRedisService<RedisModel> {
    private static final String REDIS_KEY = "foo";

    @Override
    protected String getRedisKey() {
        return this.REDIS_KEY;
    }
}