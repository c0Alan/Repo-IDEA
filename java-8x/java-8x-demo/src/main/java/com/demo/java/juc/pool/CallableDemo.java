package com.demo.java.juc.pool;

import org.junit.Test;

import java.util.concurrent.*;


public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDemo demo = new CallableDemo();

        demo.test01();
    }

    /**
     * 新建线程计算1-99的和
     */
    @Test
    public void test01() throws ExecutionException, InterruptedException {
        //创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(2);
        //创建有返回值的任务
        Callable<Integer> c1 = new MyCallable();
        //执行任务并获取Future对象
        Future<Integer> f1 = pool.submit(c1);
        Future<Integer> f2 = pool.submit(c1);
        // 输出结果
        System.out.println(f1.get() + f2.get());

        System.out.println("main");

        //关闭线程池
        pool.shutdown();
    }


    static class MyCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            int sum = 0;
            // 执行任务
            for (int i = 0; i < 100; i++) {
                sum += i;
            }

            TimeUnit.SECONDS.sleep(5);
            //return sum;
            return Integer.valueOf(sum);
        }
    }
}