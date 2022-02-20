package com.demo.springcloud.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * 扩展对象管理器
 * @author liuxilin
 * @date 2022年02月13日 21:12
 */
@Configuration
public class BeanManager {

    @Autowired
    CacheManager cacheManager;

}
