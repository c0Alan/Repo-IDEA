package com.demo.springcloud.java8.juc.basic.interrupt;

public class InterruptDemo02 {

    /**
     * t1在“等待(阻塞)状态”时，被interrupt()中断；
     * 此时，会清除中断标记[即isInterrupted()会返回false]，
     * 而且会抛出InterruptedException异常[该异常在while循环体内被捕获]。
     * 因此，t1理所当然的会进入死循环了。
     * @param args
     */
    public static void main(String[] args) {
        try {
            Thread t1 = new MyThread02("t1");  // 新建“线程t1”
            System.out.println(t1.getName() + " (" + t1.getState() + ") is new.");

            t1.start();                      // 启动“线程t1”
            System.out.println(t1.getName() + " (" + t1.getState() + ") is started.");

            // 主线程休眠300ms，然后主线程给t1发“中断”指令。
            Thread.sleep(300);
            t1.interrupt();
            System.out.println(t1.getName() + " (" + t1.getState() + ") is interrupted."); // TIMED_WAITING

            // 主线程休眠300ms，然后查看t1的状态。
            Thread.sleep(300);
            System.out.println(t1.getName() + " (" + t1.getState() + ") is interrupted now.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}