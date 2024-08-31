package com.demo.springcloud.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
@Configuration
public class AsyncConfig implements AsyncConfigurer {

    /**
     * 获取线程池
     *
     * @return
     */
    @Override
    public Executor getAsyncExecutor() {
        return new ThreadPoolExecutor(4,
                5,
                5,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10),
                new CustomizableThreadFactory("async-task-"),
                new ThreadPoolExecutor.CallerRunsPolicy()
//                new ThreadPoolExecutor.AbortPolicy()
        );
    }

    /**
     * 异常处理
     *
     * @return
     */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (throwable, method, objects) -> {
            //可以做一些其他的业务处理，比如：异常记录日志
            log.error("class: {}", method.getDeclaringClass().getName());
            log.error("method：{}", method.getName());
            log.error("type：{}", throwable.getClass().getName());
            log.error("exception：{}", throwable.getMessage());
        };
    }
}