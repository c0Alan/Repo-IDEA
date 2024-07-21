package com.demo.java.juc.pool;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.*;

/**
 * 线程池
 *
 * @author liuxl
 * @date 2024/4/27
 */
@Slf4j
public class ThreadPoolExecutorDemo {

    private static final int THREADS_SIZE = 1;
    private static final int CAPACITY = 1;

    public static void main(String[] args) throws Exception {
        test05();
    }

    /**
     * 设置线程名称前缀
     *
     * @throws Exception
     */
    @Test
    public void test06() {

        // 创建线程池。线程池的"最大池大小"和"核心池大小"都为1(THREADS_SIZE)，"线程池"的阻塞队列容量为1(CAPACITY)。
        ThreadPoolExecutor pool = new ThreadPoolExecutor(THREADS_SIZE, THREADS_SIZE, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(CAPACITY));
        pool.setThreadFactory(new CustomizableThreadFactory("thread-"));
        // 设置线程池的拒绝策略为"CallerRunsPolicy"
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        // 新建10个任务，并将它们添加到线程池中。
        for (int i = 0; i < 10; i++) {
            Runnable myrun = new MyRunnable2("task-" + i);
            pool.execute(myrun);
        }

        // 关闭线程池
        pool.shutdown();
    }

    static class MyRunnable2 implements Runnable {
        private String name;


        public MyRunnable2(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                log.info(this.name + " is running.");
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 设置线程池的拒绝策略为 CallerRunsPolicy
     *
     * @throws Exception
     */
    public static void test05() throws Exception {

        // 创建线程池。线程池的"最大池大小"和"核心池大小"都为1(THREADS_SIZE)，"线程池"的阻塞队列容量为1(CAPACITY)。
        ThreadPoolExecutor pool = new ThreadPoolExecutor(THREADS_SIZE, THREADS_SIZE, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(CAPACITY));
        // 设置线程池的拒绝策略为"CallerRunsPolicy"
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        // 新建10个任务，并将它们添加到线程池中。
        for (int i = 0; i < 10; i++) {
            Runnable myrun = new MyRunnable("task-" + i);
            pool.execute(myrun);
        }

        // 关闭线程池
        pool.shutdown();
    }


    /**
     * 设置线程池的拒绝策略为 AbortPolicy
     *
     * @throws Exception
     */
    public static void test04() throws Exception {

        // 创建线程池。线程池的"最大池大小"和"核心池大小"都为1(THREADS_SIZE)，"线程池"的阻塞队列容量为1(CAPACITY)。
        ThreadPoolExecutor pool = new ThreadPoolExecutor(THREADS_SIZE, THREADS_SIZE, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(CAPACITY));
        // 设置线程池的拒绝策略为"抛出异常"
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());

        try {

            // 新建10个任务，并将它们添加到线程池中。
            for (int i = 0; i < 10; i++) {
                Runnable myrun = new MyRunnable("task-" + i);
                pool.execute(myrun);
            }
        } catch (RejectedExecutionException e) {
            e.printStackTrace();
            // 关闭线程池
            pool.shutdown();
        }
    }


    /**
     * 设置线程池的拒绝策略为DiscardOldestPolicy
     *
     * @throws Exception
     */
    public static void test03() throws Exception {

        // 创建线程池。线程池的"最大池大小"和"核心池大小"都为1(THREADS_SIZE)，"线程池"的阻塞队列容量为1(CAPACITY)。
        ThreadPoolExecutor pool = new ThreadPoolExecutor(THREADS_SIZE, THREADS_SIZE, 0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(CAPACITY));
        // 设置线程池的拒绝策略为"DiscardOldestPolicy"
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());

        // 新建10个任务，并将它们添加到线程池中。
        for (int i = 0; i < 10; i++) {
            Runnable myrun = new MyRunnable("task-" + i);
            pool.execute(myrun);
        }
        // 关闭线程池
        pool.shutdown();
    }


    /**
     * 设置线程池的拒绝策略为"丢弃"
     *
     * @throws Exception
     */
    public static void test02() throws Exception {

        // 创建线程池。线程池的"最大池大小"和"核心池大小"都为1(THREADS_SIZE)，"线程池"的阻塞队列容量为1(CAPACITY)。
        ThreadPoolExecutor pool = new ThreadPoolExecutor(THREADS_SIZE, THREADS_SIZE, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(CAPACITY));
        // 设置线程池的拒绝策略为"丢弃"
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());

        // 新建10个任务，并将它们添加到线程池中。
        for (int i = 0; i < 10; i++) {
            Runnable myrun = new MyRunnable("task-" + i);
            pool.execute(myrun);
        }
        // 关闭线程池
        pool.shutdown();
    }

    static class MyRunnable implements Runnable {
        private String name;

        public MyRunnable() {
        }

        public MyRunnable(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println(this.name + " is running.");
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Executors 创建线程池
     */
    public static void test01() {
        // 创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors.newFixedThreadPool(2);
        // 创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
        Thread ta = new MyThread();
        Thread tb = new MyThread();
        Thread tc = new MyThread();
        Thread td = new MyThread();
        Thread te = new MyThread();
        // 将线程放入池中进行执行
        pool.execute(ta);
        pool.execute(tb);
        pool.execute(tc);
        pool.execute(td);
        pool.execute(te);
        // 关闭线程池
        pool.shutdown();
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is running.");
        }
    }
}

