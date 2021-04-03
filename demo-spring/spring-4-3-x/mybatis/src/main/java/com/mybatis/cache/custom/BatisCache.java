package com.mybatis.cache.custom;

import org.apache.ibatis.cache.Cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * MyBatis 自定义缓存类
 * 必须实现 org.apache.ibatis.cache.Cache 接口
 *
 * @author liuxilin
 * @date 2018/6/3 13:22
 */
public class BatisCache implements Cache {
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private ConcurrentHashMap<Object, Object> cache = new ConcurrentHashMap<Object, Object>();
    private String id;

    /**
     * MyBatis 会把命名空间传进来作为缓存id
     * 必须要有这个构造方法
     * @param id
     */
    public BatisCache(String id) {
        this.id = id;
    }

    // 获取缓存编号
    @Override
    public String getId() {
        return id;
    }

    //获取缓存对象的大小
    @Override
    public int getSize() {
        return 0;
    }

    // 保存key值缓存对象
    @Override
    public void putObject(Object key, Object value) {
        cache.put(key, value);
    }

    //通过KEY
    @Override
    public Object getObject(Object key) {
        return cache.get(key);
    }

    // 通过key删除缓存对象
    @Override
    public Object removeObject(Object key) {
        Object obj = cache.get(key);
        cache.put(key, null);
        return obj;
    }

    // 清空缓存
    @Override
    public void clear() {
        cache.clear();
    }

    // 获取缓存的读写锁
    @Override
    public ReadWriteLock getReadWriteLock() {
        return lock;
    }
}