package com.demo.java.juc.basics;

/**
 * @author liuxl
 * @date 2024/4/25 
 * @description synchronized
 */
class MyThread02 extends Thread {

    public MyThread02(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100); // 休眠100ms
                    System.out.println(Thread.currentThread().getName() + " loop " + i);
                }
            } catch (InterruptedException ie) {
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new MyThread02("t1");  // 新建“线程t1”
        Thread t2 = new MyThread02("t2");  // 新建“线程t2”
        t1.start();                          // 启动“线程t1”
        t2.start();                          // 启动“线程t2”
    }
}