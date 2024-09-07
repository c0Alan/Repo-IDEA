package com.demo.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executors;
import java.util.concurrent.Executor;

/**
 * 定时任务异步任务配置
 * 不配置的话所有任务都是串行的
 *
 * @author liuxl
 * @date 2024/9/5
 */
@Configuration
public class ScheduledConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.setScheduler(setTaskExecutors());
    }

    @Bean
    public Executor setTaskExecutors() {
        return Executors.newScheduledThreadPool(3); // 3个线程来处理。
    }

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        return new ThreadPoolTaskScheduler();
    }
}