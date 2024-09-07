package com.demo.springcloud.service;

import com.demo.springcloud.entity.SysUser;
import com.demo.springcloud.entity.qo.SysUserQo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * service 示例
 * @author liuxl
 * @date 2024/8/29
 */
@Slf4j
@Service
public class DemoService {

    @Async
    public void asyncMethod() {
        try {
            TimeUnit.SECONDS.sleep(5);
            log.info("异步方法执行！");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Cacheable(value = "user", key = "#user.username")
    public SysUser getUserCache(SysUserQo user){
        log.info("get user");
        return null;
    }
    @CachePut(value = "user", key = "#user.username")
    public SysUser saveUserCache(SysUser user){
        log.info("save user");
        return user;
    }
    @CacheEvict(value = "user", key = "#username") // 移除指定key的数据
    public void deleteUserCache(String username){
        log.info("delete user");
    }
    @CacheEvict(value = "user", allEntries = true) // 移除所有数据
    public void deleteAllUserCache() {
        log.info("delete All");
    }
}
