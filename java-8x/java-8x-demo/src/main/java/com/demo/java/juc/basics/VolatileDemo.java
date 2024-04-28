package com.demo.java.juc.basics;

import java.util.concurrent.TimeUnit;

/**
 * @author liuxl
 * @date 2024/4/26
 * @description volatile
 */
public class VolatileDemo {
    static boolean flag = true;
//    static volatile boolean flag = true;

    public static void main(String[] args) {
        test02();
    }


    /**
     * volatile只能保证从工作内存直接刷新或读取主内存，不能保证线程安全
     */
    public static void test02() {
        MyNumber myNumber = new MyNumber();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 1000; i1++) {
//                    myNumber.addPlusPlus();
                    myNumber.addPlusPlus2();
                }
            }).start();
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(myNumber.number2);
    }

    /**
     * t1对flag的修改，t2不可见, 如果while里面有业务代码，则可见
     */
    public static void test01() {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t -----come in");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = false;
        }, "t1").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t -----come in");
            while (flag) {
//                System.out.println(Thread.currentThread().getName()+"\t -----running");
            }
            System.out.println(Thread.currentThread().getName() + "\t -----flag被设置为false，程序停止");
        }, "t2").start();
    }
}