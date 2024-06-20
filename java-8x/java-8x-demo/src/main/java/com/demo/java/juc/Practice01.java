package com.demo.java.juc;

/**
 * 子线程循环10次，接着主线程循环100，接着又回到子线程循环10次，接着再回到主线程又循环100，如此循环50次
 *
 * @author liuxl
 * @date 2024/6/18
 */
public class Practice01 {


    public static void main(String[] args) throws InterruptedException {
        ThreadA threadA = new ThreadA();
        threadA.start();
        Thread.sleep(20);

        synchronized (threadA) {
            for (int i = 0; i < 50; i++) {
                for (int j = 0; j < 100; j++){
                }
                System.out.println("ThreadMain:" + i);
                threadA.notify();
                try {
                    threadA.wait(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }


    }


    static class ThreadA extends Thread {
        @Override
        public void run() {
            synchronized (this) {
                for (int i = 0; i < 50; i++) {
                    for (int j = 0; j < 10; j++){
                    }
                    System.out.println("ThreadA:" + i);
                    this.notify();
                    try {
                        this.wait(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        }

    }
}
