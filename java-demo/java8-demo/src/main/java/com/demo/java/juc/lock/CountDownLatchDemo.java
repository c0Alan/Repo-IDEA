package com.demo.java.juc.lock;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author liuxl
 * @date 2024/4/26
 * @description CountDownLatch
 */
public class CountDownLatchDemo {

    private static int LATCH_SIZE = 5;
    private static CountDownLatch doneSignal;

    public static void main(String[] args) {
        test01();
    }

    public static void test01() {
        try {
            doneSignal = new CountDownLatch(LATCH_SIZE);

            // 新建5个任务
            for (int i = 0; i < LATCH_SIZE; i++)
                new InnerThread().start();

            System.out.println("main await begin.");
            // "主线程"等待线程池中5个任务的完成
            doneSignal.await();

            System.out.println("main await finished.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class InnerThread extends Thread {
        public void run() {
            try {
                int sleepTime = (1 + new Random().nextInt(3) )* 1000;
                Thread.sleep(sleepTime);
                System.out.println(Thread.currentThread().getName() + " sleep " + sleepTime);
                // 将CountDownLatch的数值减1
                doneSignal.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}