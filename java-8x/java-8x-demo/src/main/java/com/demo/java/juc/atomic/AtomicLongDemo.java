package com.demo.java.juc.atomic;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author liuxl
 * @date 2024/4/25
 * @description 基本类型: AtomicLong
 */
public class AtomicLongDemo {

    private static long longValue = 0;
    private static AtomicLong atomicLong = new AtomicLong(0);

    public static void main(String[] args) {

        test02();
    }

    /**
     * 测试并发操作
     */
    public static void test02() {
        for (int i=0; i<5; i++){
            new ThreadA("Ta").start(); // 可能不到5
//            new ThreadB("Tb").start(); // 一定到5
        }
    }

    static class ThreadA extends Thread {
        public ThreadA(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println(getName() + ":" + ++longValue);
        }
    }

    static class ThreadB extends Thread {
        public ThreadB(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println(getName() + ":" + atomicLong.incrementAndGet());
        }
    }


    /**
     * 相关操作方法
     */
    public static void test01() {
        // 新建AtomicLong对象
        AtomicLong mAtoLong = new AtomicLong();

        mAtoLong.set(0x0123456789ABCDEFL);
        System.out.printf("%20s : 0x%016X\n", "get()", mAtoLong.get());
        System.out.printf("%20s : 0x%016X\n", "intValue()", mAtoLong.intValue());
        System.out.printf("%20s : 0x%016X\n", "longValue()", mAtoLong.longValue());
        System.out.printf("%20s : %s\n", "doubleValue()", mAtoLong.doubleValue());
        System.out.printf("%20s : %s\n", "floatValue()", mAtoLong.floatValue());

        System.out.printf("%20s : 0x%016X\n", "getAndDecrement()", mAtoLong.getAndDecrement());
        System.out.printf("%20s : 0x%016X\n", "decrementAndGet()", mAtoLong.decrementAndGet());
        System.out.printf("%20s : 0x%016X\n", "getAndIncrement()", mAtoLong.getAndIncrement());
        System.out.printf("%20s : 0x%016X\n", "incrementAndGet()", mAtoLong.incrementAndGet());

        System.out.printf("%20s : 0x%016X\n", "addAndGet(0x10)", mAtoLong.addAndGet(0x10));
        System.out.printf("%20s : 0x%016X\n", "getAndAdd(0x10)", mAtoLong.getAndAdd(0x10));

        System.out.printf("\n%20s : 0x%016X\n", "get()", mAtoLong.get());

        System.out.printf("%20s : %s\n", "compareAndSet()", mAtoLong.compareAndSet(0x12345679L, 0xFEDCBA9876543210L));
        System.out.printf("%20s : 0x%016X\n", "get()", mAtoLong.get());
    }
}