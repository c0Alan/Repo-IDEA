package com.demo.springcloud.java8.juc.basic.synchronize;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author liuxilin
 * @date 2022年03月18日 17:25
 */
class SynchronizeDemoTest {

    /**
     * 启动就闪退, junit 不支持多线程
     */
    @Test
    void cpuObserve() {
        SynchronizeDemo.cpuObserve();
    }
}