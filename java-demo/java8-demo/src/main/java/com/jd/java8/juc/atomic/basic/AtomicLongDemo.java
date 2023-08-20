package com.jd.java8.juc.atomic.basic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongDemo {
    public static void main(String[] args) {
        test();
    }

    public static void test() {

        AtomicInteger aci = new AtomicInteger(0);
        for(int i=0; i<100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
//                    System.out.println(aci.get());
                    if (aci.addAndGet(1) < 10) {

                        System.out.println(Thread.currentThread().getName());
                    }
//                    System.out.println(aci.get());
                }
            }, "thread-" + i).start();
        }
    }

    public static void test2() {
        AtomicLong mAtoLong = new AtomicLong();

        mAtoLong.set(0x0123456789ABCDEFL);
        System.out.printf("%20s : 0x%016X\n", "get()", mAtoLong.get()); // 0x0123456789ABCDEF
        System.out.printf("%20s : 0x%016X\n", "intValue()", mAtoLong.intValue()); // 0x0000000089ABCDEF
        System.out.printf("%20s : 0x%016X\n", "longValue()", mAtoLong.longValue()); // 0x0123456789ABCDEF
        System.out.printf("%20s : %s\n", "doubleValue()", mAtoLong.doubleValue()); // 8.1985529216486896E16
        System.out.printf("%20s : %s\n", "floatValue()", mAtoLong.floatValue()); // 8.1985531E16

        System.out.printf("%20s : 0x%016X\n", "getAndDecrement()", mAtoLong.getAndDecrement()); // 0x0123456789ABCDEF
        System.out.printf("%20s : 0x%016X\n", "decrementAndGet()", mAtoLong.decrementAndGet()); // 0x0123456789ABCDED
        System.out.printf("%20s : 0x%016X\n", "getAndIncrement()", mAtoLong.getAndIncrement()); // 0x0123456789ABCDED
        System.out.printf("%20s : 0x%016X\n", "incrementAndGet()", mAtoLong.incrementAndGet());

        System.out.printf("%20s : 0x%016X\n", "addAndGet(0x10)", mAtoLong.addAndGet(0x10));
        System.out.printf("%20s : 0x%016X\n", "getAndAdd(0x10)", mAtoLong.getAndAdd(0x10));

        System.out.printf("\n%20s : 0x%016X\n", "get()", mAtoLong.get());

        System.out.printf("%20s : %s\n", "compareAndSet()", mAtoLong.compareAndSet(0x12345679L, 0xFEDCBA9876543210L));
        System.out.printf("%20s : 0x%016X\n", "get()", mAtoLong.get());
    }
}
