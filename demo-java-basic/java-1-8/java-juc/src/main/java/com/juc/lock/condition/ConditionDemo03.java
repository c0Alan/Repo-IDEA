package com.juc.lock.condition;

/**
 * (01) BoundedBuffer 是容量为5的缓冲，缓冲中存储的是Object对象，支持多线程的读/写缓冲。
 * 多个线程操作“一个BoundedBuffer对象”时，它们通过互斥锁lock对缓冲区items进行互斥访问；
 * 而且同一个BoundedBuffer对象下的全部线程共用“notFull”和“notEmpty”这两个Condition。
 * notFull用于控制写缓冲，notEmpty用于控制读缓冲。当缓冲已满的时候，
 * 调用put的线程会执行notFull.await()进行等待；当缓冲区不是满的状态时，
 * 就将对象添加到缓冲区并将缓冲区的容量count+1，最后，
 * 调用notEmpty.signal()缓冲notEmpty上的等待线程(调用notEmpty.await的线程)。
 * 简言之，notFull控制“缓冲区的写入”，当往缓冲区写入数据之后会唤醒notEmpty上的等待线程。
 * 同理，notEmpty控制“缓冲区的读取”，当读取了缓冲区数据之后会唤醒notFull上的等待线程。
 * (02) 在ConditionTest2的main函数中，启动10个“写线程”，向BoundedBuffer中不断的写数据(写入0-9)；
 * 同时，也启动10个“读线程”，从BoundedBuffer中不断的读数据。
 *
 * @author liuxl
 * @date 2018/5/22 13:18
 */
public class ConditionDemo03 {
    private static BoundedBuffer bb = new BoundedBuffer();

    public static void main(String[] args) {
        // 启动10个“写线程”，向BoundedBuffer中不断的写数据(写入0-9)；
        // 启动10个“读线程”，从BoundedBuffer中不断的读数据。
        for (int i = 0; i < 10; i++) {
            new PutThread("p" + i, i).start();
            new TakeThread("t" + i).start();
        }
    }

    static class PutThread extends Thread {
        private int num;

        public PutThread(String name, int num) {
            super(name);
            this.num = num;
        }

        public void run() {
            try {
                Thread.sleep(1);    // 线程休眠1ms
                bb.put(num);        // 向BoundedBuffer中写入数据
            } catch (InterruptedException e) {
            }
        }
    }

    static class TakeThread extends Thread {
        public TakeThread(String name) {
            super(name);
        }

        public void run() {
            try {
                Thread.sleep(10);                    // 线程休眠1ms
                Integer num = (Integer) bb.take();    // 从BoundedBuffer中取出数据
            } catch (InterruptedException e) {
            }
        }
    }
}