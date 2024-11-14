package com.demo.springcloud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * springsession 配置类
 * 参考：https://blog.csdn.net/TreeShu321/article/details/132907948
 *
 * @author liuxl
 * @date 2024/9/23
 */
@EnableRedisHttpSession
@Configuration
public class SessionConfig {
}