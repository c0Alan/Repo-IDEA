package com.demo.springcloud.java8.juc.basic.synchronize;

/**
 * “synchronized方法”是用synchronized修饰方法，而 “synchronized代码块”则是用synchronized修饰代码块。
 * synchronized代码块中的this是指当前对象。也可以将this替换成其他对象
 * synchronized代码块可以更精确的控制冲突限制访问区域，有时候表现更高效率。
 *
 * @author liuxilin
 * @date 2018/5/20 9:40
 */
public class SynchronizeDemo05 {

    public synchronized void synMethod() { // 方法的锁对象为this
        for (int i = 0; i < 1000000; i++)
            ;
    }

    public void synBlock() {
        synchronized (this) { // 代码块必须要指明锁对象
            for (int i = 0; i < 1000000; i++)
                ;
        }
    }

    /**
     * synchronized代码块效率更高
     * @param args
     */
    public static void main(String[] args) {
        SynchronizeDemo05 demo = new SynchronizeDemo05();

        long start, diff;
        start = System.currentTimeMillis();                // 获取当前时间(millis)
        demo.synMethod();                                // 调用“synchronized方法”
        diff = System.currentTimeMillis() - start;        // 获取“时间差值”
        System.out.println("synMethod() : " + diff); // 9ms

        start = System.currentTimeMillis();                // 获取当前时间(millis)
        demo.synBlock();                                // 调用“synchronized方法块”
        diff = System.currentTimeMillis() - start;        // 获取“时间差值”
        System.out.println("synBlock()  : " + diff); // 3ms
    }
}