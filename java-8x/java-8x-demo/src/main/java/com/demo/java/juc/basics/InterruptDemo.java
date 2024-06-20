package com.demo.java.juc.basics;

import org.junit.Test;

/**
 * interrupt()的作用是中断本线程。
 *
 * 如果本线程是处于阻塞状态：调用线程的wait(), wait(long)或wait(long, int)会让它进入等待(阻塞)状态，
 * 或者调用线程的join(), join(long), join(long, int), sleep(long), sleep(long, int)也会让它进入阻塞状态。若线程在阻塞状态时，
 * 调用了它的interrupt()方法，那么它的“中断状态”会被清除并且会收到一个InterruptedException异常。
 * 例如，线程通过wait()进入阻塞状态，此时通过interrupt()中断该线程；调用interrupt()会立即将线程的中断标记设为“true”，
 * 但是由于线程处于阻塞状态，所以该“中断标记”会立即被清除为“false”，同时，会产生一个InterruptedException的异常。
 *
 * @author liuxl
 * @date 2024/4/25
 */
public class InterruptDemo {

    public static void main(String[] args) {
    }

    /**
     * 通过“额外添加标记”的方式中断线程
     */
    public void test03() {
        try {
            Thread03 t1 = new Thread03("t1");  // 新建“线程t1”
            System.out.println(t1.getName() + " (" + t1.getState() + ") is new.");

            t1.start();                      // 启动“线程t1”
            System.out.println(t1.getName() + " (" + t1.getState() + ") is started.");

            // 主线程休眠300ms，然后主线程给t1发“中断”指令。
            Thread.sleep(300);
            t1.stopTask();
            System.out.println(t1.getName() + " (" + t1.getState() + ") is interrupted.");

            // 主线程休眠300ms，然后查看t1的状态。
            Thread.sleep(300);
            System.out.println(t1.getName() + " (" + t1.getState() + ") is interrupted now.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class Thread03 extends Thread {

        private volatile boolean flag= true;
        public void stopTask() {
            flag = false;
        }

        public Thread03(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized(this) {
                try {
                    int i=0;
                    while (flag) {
                        Thread.sleep(100); // 休眠100ms
                        i++;
                        System.out.println(Thread.currentThread().getName()+" ("+this.getState()+") loop " + i);
                    }
                } catch (InterruptedException ie) {
                    System.out.println(Thread.currentThread().getName() +" ("+this.getState()+") catch InterruptedException.");
                }
            }
        }
    }


    /**
     * 将run()方法中捕获InterruptedException异常的代码块移到while循环体内。程序进入了死循环！
     * t1在“等待(阻塞)状态”时，被interrupt()中断；此时，会清除中断标记[即isInterrupted()会返回false]，
     * 而且会抛出InterruptedException异常[该异常在while循环体内被捕获]。因此，t1理所当然的会进入死循环了。
     */
    @Test
    public void test02() {
        try {
            Thread t1 = new Thread02("t1");  // 新建“线程t1”
            System.out.println(t1.getName() +" ("+t1.getState()+") is new.");

            t1.start();                      // 启动“线程t1”
            System.out.println(t1.getName() +" ("+t1.getState()+") is started.");

            // 主线程休眠300ms，然后主线程给t1发“中断”指令。
            Thread.sleep(300);
            t1.interrupt();
            System.out.println(t1.getName() +" ("+t1.getState()+") is interrupted.");

            // 主线程休眠300ms，然后查看t1的状态。
            Thread.sleep(300);
            System.out.println(t1.getName() +" ("+t1.getState()+") is interrupted now.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class Thread02 extends Thread {

        public Thread02(String name) {
            super(name);
        }

        @Override
        public void run() {
            int i=0;
            while (!isInterrupted()) {
                try {
                    Thread.sleep(100); // 休眠100ms
                } catch (InterruptedException ie) {
                    System.out.println(Thread.currentThread().getName() +" ("+this.getState()+") catch InterruptedException.");
                }
                i++;
                System.out.println(Thread.currentThread().getName()+" ("+this.getState()+") loop " + i);
            }
        }
    }


    /**
     * (01) 主线程main中通过new MyThread("t1")创建线程t1，之后通过t1.start()启动线程t1。
     * (02) t1启动之后，会不断的检查它的中断标记，如果中断标记为“false”；则休眠100ms。
     * (03) t1休眠之后，会切换到主线程main；主线程再次运行时，会执行t1.interrupt()中断线程t1。t1收到中断指令之后，会将t1的中断标记设置“false”，
     * 而且会抛出InterruptedException异常。在t1的run()方法中，是在循环体while之外捕获的异常；因此循环被终止。
     */
    @Test
    public void test01() {
        try {
            Thread01 t1 = new Thread01("t1");  // 新建“线程t1”
            System.out.println(t1.getName() + " (" + t1.getState() + ") is new.");

            t1.start();                      // 启动“线程t1”
            System.out.println(t1.getName() + " (" + t1.getState() + ") is started.");

            // 主线程休眠300ms，然后主线程给t1发“中断”指令。
            Thread.sleep(300);
            t1.interrupt();
            System.out.println(t1.getName() + " (" + t1.getState() + ") is interrupted.");

            // 主线程休眠300ms，然后查看t1的状态。
            Thread.sleep(300);
            System.out.println(t1.getName() + " (" + t1.getState() + ") is interrupted now.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class Thread01 extends Thread {

        public Thread01(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                int i = 0;
                while (!isInterrupted()) {
                    Thread.sleep(100); // 休眠100ms
                    i++;
                    System.out.println(Thread.currentThread().getName() + " (" + this.getState() + ") loop " + i);
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " (" + this.getState() + ") catch InterruptedException.");
            }
        }
    }
}