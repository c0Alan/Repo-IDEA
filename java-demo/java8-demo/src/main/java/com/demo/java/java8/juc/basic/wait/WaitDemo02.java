package com.demo.java.java8.juc.basic.wait;

/**
 * 2. wait(long timeout)和notify()
 * wait(long timeout)在超时情况下，线程被唤醒的情况。
 * 
 * @author liuxilin
 * @date 2018/5/20 11:01
 */
public class WaitDemo02 {

    public static void main(String[] args) {

        MyThread02 t1 = new MyThread02("t1");

        synchronized (t1) {
            try {
                // 启动“线程t1”
                System.out.println(Thread.currentThread().getName() + " start t1");
                t1.start();
                Long start = System.currentTimeMillis();
                // 主线程等待t1通过notify()唤醒 或 notifyAll()唤醒，或超过3000ms延时；然后才被唤醒。
                System.out.println(Thread.currentThread().getName() + " call wait ");
                t1.wait(3000);

                System.out.println(Thread.currentThread().getName() + " continue");
                Long diff = System.currentTimeMillis() - start;
                // t1 加 synchronize 的情况 5001, 就绪之后等待锁
                // t1 不加 synchronize 的情况 3000, 就绪之后马上运行
                System.out.println(diff);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}