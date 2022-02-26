package com.demo.springcloud.java8.juc.basic.interrupt;

/**
 * 终止线程的示例
 * <p>
 * interrupted() 和 isInterrupted()都能够用于检测对象的“中断标记”。
 * 区别是，interrupted()除了返回中断标记之外，它还会清除中断标记(即将中断标记设为false)；
 * 而isInterrupted()仅仅返回中断标记。
 *
 * @author liuxilin
 * @date 2018/5/20 15:54
 */
public class InterruptDemo01 {

    /**
     * t1在“等待(阻塞)状态”时，被interrupt()中断；
     * 此时，会清除中断标记[即isInterrupted()会返回false]，
     * 而且会抛出InterruptedException异常
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            // 新建“线程t1”
            Thread t1 = new MyThread01("t1");
            // NEW
            System.out.println(t1.getName() + " (" + t1.getState() + ") is new.");

            // 启动“线程t1”
            t1.start();
            // RUNNABLE
            System.out.println(t1.getName() + " (" + t1.getState() + ") is started.");

            // 主线程休眠300ms，然后主线程给t1发“中断”指令。
            Thread.sleep(300);

            // 中断标记置为true, 但是如果线程出于阻塞状态, 将被重新置为 false, 并抛出 InterruptedException
            t1.interrupt();
            // TIMED_WAITING
            System.out.println(t1.getName() + " (" + t1.getState() + ") is interrupted.");

            // 主线程休眠300ms，然后查看t1的状态。
            Thread.sleep(300);

            // TERMINATED
            System.out.println(t1.getName() + " (" + t1.getState() + ") is interrupted now.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}