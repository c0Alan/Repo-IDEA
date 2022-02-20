package com.demo.springcloud.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * 对象池配置类
 *
 * @author xuxueli 2017-04-28
 */
@Configuration
@Slf4j
@RefreshScope
@Data
public class PoolConfig {

    @Value("${app.pool.felEngine.maxTotal:20}")
    private Integer felEngineMaxTotal;

    @Value("${app.pool.felEngine.minIdle:0}")
    private Integer felEngineMinIdle;

    @Value("${app.pool.felEngine.maxIdle:8}")
    private Integer felEngineMaxIdle;

}