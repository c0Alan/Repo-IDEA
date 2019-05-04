package com.jvm.clazzloader;

/**
 * 初始化实例
 * 虚拟机会保证一个类的<cinit>() 方法被正确的加锁, 同步, 如果多个线程同时去初始化一个类,
 * 那么只会有一个线程去执行这个类的<cinit>()方法, 其他线程都需要阻塞等待, 直到活动线程执行完该类的<cinit>()方法
 *
 *
 * @author liuxilin
 * @date 2018/5/27 16:42
 */
public class InitDemo03 {
    static class DeadLoopClass {
        static {
            // 如果不加上这个if语句，编译器将提示“Initializer does not complete normally”并拒绝编译
            if (true) {
                System.out.println(Thread.currentThread() + "init DeadLoopClass");
                while (true) {
                }
            }
        }
    }

    /**
     * thread2 将被阻塞
     * @param args
     */
    public static void main(String[] args) {
        Runnable script = new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread() + "start");
                DeadLoopClass dlc = new DeadLoopClass();
                System.out.println(Thread.currentThread() + " run over");
            }
        };

        Thread thread1 = new Thread(script);
        Thread thread2 = new Thread(script);
        thread1.start();
        thread2.start();
    }
}
