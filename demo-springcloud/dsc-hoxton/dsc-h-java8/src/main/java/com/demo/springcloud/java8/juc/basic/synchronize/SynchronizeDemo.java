package com.demo.springcloud.java8.juc.basic.synchronize;

import lombok.extern.slf4j.Slf4j;

/**
 * Synchronize 实例
 *
 * @author liuxilin
 * @date 2022年03月18日 16:28
 */
@Slf4j
public class SynchronizeDemo {

    /**
     * 观察300条线程阻塞时CPU占用情况
     * 结论: blocked 线程不占cpu 资源
     */
    public static void cpuObserve() {
        Runnable r = new MyRunable02();

        for (int i = 0; i < 300; i++) {
            String threadName = "test thread" + i;
            new Thread(r, threadName).start();
        }
    }

    /**
     * 观察while循环cup占用情况
     * 结论: 300条 while循环线程占 15% cpu
     */
    public static void cpuObserve2() {
        for (int i = 0; i < 300; i++) {
            String threadName = "test thread" + i;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.info("{}", e);
            }
            new MyThread02(threadName).start();
        }
    }

    public static void main(String[] args) {
        cpuObserve2();
    }
}
