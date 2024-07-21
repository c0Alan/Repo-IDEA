package com.demo.java.juc.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore Demo
 *
 * @author liuxl
 * @date 2024/4/26
 * @description Semaphore
 */
@Slf4j
public class SemaphoreDemo {
    private static final int SEM_MAX = 10;

    public static void main(String[] args) {
        new SemaphoreDemo().test01();
    }

    public void test01() {
        log.info("SemaphoreDemo.test01()");
        Semaphore sem = new Semaphore(SEM_MAX);
        //创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        //在线程池中执行任务
        threadPool.execute(new SemaphoreThread(sem, 5));
        threadPool.execute(new SemaphoreThread(sem, 4));
        threadPool.execute(new SemaphoreThread(sem, 7));
        //关闭池
        threadPool.shutdown();
    }

    class SemaphoreThread extends Thread {
        private volatile Semaphore sem;    // 信号量
        private int count;        // 申请信号量的大小

        SemaphoreThread(Semaphore sem, int count) {
            this.sem = sem;
            this.count = count;
        }

        public void run() {
            try {
                // 从信号量中获取count个许可
                sem.acquire(count);

                Thread.sleep(2000);
                log.info(Thread.currentThread().getName() + " acquire count=" + count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 释放给定数目的许可，将其返回到信号量。
                sem.release(count);
                log.info(Thread.currentThread().getName() + " release " + count + "");
            }
        }
    }

}

