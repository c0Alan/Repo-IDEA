package com.demo.java.jvm.gc;

/**
 * 相互引用的对象是否会被GC, 会
 *
 * @author liuxilin
 * @date 2018/5/26 16:19
 */
public class ReferenceCountingGC {

    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    /**
     * 这个成员属性的唯一意义就是占点内存，以便在能在GC日志中看清楚是否有回收过
     */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        try {
            Thread.sleep(160000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        objA = null;
        objB = null; // 到这里再dump出堆信息就已经被gc了

        // 假设在这行发生GC，objA和objB是否能被回收？
        System.out.println("before GC 1min");
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.gc();
        System.out.println("GC begin");
        try {
            System.out.println("after GC wait 2min");
            Thread.sleep(120000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        testGC();
    }
}