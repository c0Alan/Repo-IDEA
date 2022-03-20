package com.demo.springcloud.manager;

import com.demo.springcloud.config.PoolConfig;
import com.greenpineyu.fel.FelEngine;
import com.greenpineyu.fel.FelEngineImpl;
import com.greenpineyu.fel.context.FelContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * FelEngine 池
 * @author liuxilin
 * @date 2022年02月13日 22:04
 */
@Slf4j
@Service
public class FelEngineFactory extends BasePooledObjectFactory<FelEngine> {
    @Autowired
    PoolConfig poolConfig;

    @Autowired
    CacheManager cacheManager;

    private volatile GenericObjectPool<FelEngine> pool = null;

    private GenericObjectPool<FelEngine> getInstance() {
        if (pool == null) {
            synchronized (this) {
                if (pool == null) {
                    GenericObjectPoolConfig objectPoolConfig = new GenericObjectPoolConfig();
                    objectPoolConfig.setMaxTotal(poolConfig.getFelEngineMaxTotal());
                    objectPoolConfig.setMaxIdle(poolConfig.getFelEngineMaxIdle());
                    objectPoolConfig.setMinIdle(poolConfig.getFelEngineMinIdle());
                    objectPoolConfig.setLifo(false);
                    pool = new GenericObjectPool<>(this, objectPoolConfig);
                }
            }
        }
        return pool;
    }

    @Override
    public FelEngine create() throws Exception {
        FelEngine obj = new FelEngineImpl();
        resetObject(obj);
        return obj;
    }

    @Override
    public PooledObject<FelEngine> wrap(FelEngine felEngine) {
        resetObject(felEngine);
        return new DefaultPooledObject<>(felEngine);
    }

    public void clear() {
        getInstance().clear();
    }

    public FelEngine borrowObject() throws Exception {
        FelEngine obj = getInstance().borrowObject();
        return obj;
    }

    /**
     * 每个 FelEngine 对象存一份随机数据, 可通过 key.key1 方式获取
     * 如: {"xing":{"xing":"xxx"}}
     * 如: {"address":{"province":"xxx","city":"xxx","district":"xxx"}}
     * @param obj
     */
    public void resetObject(FelEngine obj) {
        FelContext felContext = obj.getContext();
        for(Map.Entry<String, Object> entry : cacheManager.getBaseDataMap().entrySet()) {
            String sheetName = entry.getKey();
            List<Map<String, Object>> sheetData = (List<Map<String, Object>>) entry.getValue();
            Random random = new Random();
            int index = random.nextInt(sheetData.size());
            Map<String, Object> randomData = sheetData.get(index);
            felContext.set(sheetName, randomData);
        }
    }

    public void returnObject(FelEngine obj) throws Exception {
        resetObject(obj);
        getInstance().returnObject(obj);
    }
}
