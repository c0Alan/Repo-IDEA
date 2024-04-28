package com.demo.java.juc.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author liuxl
 * @date 2024/4/26
 * @description Semaphore
 */
public class SemaphoreDemo {
    private static final int SEM_MAX = 10;

    public static void main(String[] args) {
        test01();
    }

    public static void test01() {
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
}