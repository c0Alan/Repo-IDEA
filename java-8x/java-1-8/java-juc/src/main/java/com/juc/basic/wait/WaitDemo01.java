package com.juc.basic.wait;

/**
 * 1. wait()和notify()示例
 * wait()的作用是让当前线程进入等待状态，同时，wait()也会让当前线程释放它所持有的锁。
 * 而notify()和notifyAll()的作用，则是唤醒当前对象上的等待线程；
 * notify()是随机唤醒单个线程，而notifyAll()是唤醒所有的线程。
 * 特别强调的一点是 wait, notify, notifyAll 方法都是由锁对象调用
 *
 * @author liuxilin
 * @date 2018/5/20 10:30
 */
public class WaitDemo01 {

    public static void main(String[] args) {

        MyThread01 t1 = new MyThread01("t1");

        synchronized (t1) {
            try {
                // 启动“线程t1”
                System.out.println(Thread.currentThread().getName() + " start t1");
                t1.start();

                // 主线程等待t1通过notify()唤醒。
                System.out.println(Thread.currentThread().getName() + " wait()");
                t1.wait(); // wait()的作用是让“当前线程”等待，而“当前线程”是指正在cpu上运行的线程！

                System.out.println(Thread.currentThread().getName() + " continue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}