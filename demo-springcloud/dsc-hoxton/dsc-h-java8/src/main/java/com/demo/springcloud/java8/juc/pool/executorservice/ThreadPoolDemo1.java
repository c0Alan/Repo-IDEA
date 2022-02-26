package com.demo.springcloud.java8.juc.pool.executorservice;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ThreadPoolDemo1 {

    public static void main(String[] args) {
        // 创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors.newFixedThreadPool(2);
        // 创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
        Thread ta = new Thread01();
        Thread tb = new Thread01();
        Thread tc = new Thread01();
        Thread td = new Thread01();
        Thread te = new Thread01();
        // 将线程放入池中进行执行
        pool.execute(ta);
        pool.execute(tb);
        pool.execute(tc);
        pool.execute(td);
        pool.execute(te);
        // 关闭线程池
        pool.shutdown();
    }
}
