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
    public void test01()
            throws ExecutionException, InterruptedException {
        //创建一个线程池
        ExecutorService pool = Executors.newSingleThreadExecutor();
        //创建有返回值的任务
        Callable c1 = new MyCallable();
        //执行任务并获取Future对象
        Future f1 = pool.submit(c1);
        // 输出结果
        System.out.println(f1.get());
        //关闭线程池
        pool.shutdown();
    }


    static class MyCallable implements Callable {

        @Override
        public Integer call() throws Exception {
            int sum = 0;
            // 执行任务
            for (int i = 0; i < 100; i++) {
                sum += i;
            }
            //return sum;
            return Integer.valueOf(sum);
        }
    }
}