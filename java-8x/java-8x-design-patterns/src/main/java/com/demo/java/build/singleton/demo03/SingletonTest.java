package com.demo.java.build.singleton.demo03;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * 测试类
 * 
 * @author liuxilin
 * @date 2018/5/19 15:39
 */
public class SingletonTest {
    private static final Logger logger = Logger.getLogger(SingletonTest.class);

    public static void main(String[] args) {
        SingletonTest test = new SingletonTest();
        test.demo01();
    }

    /**
     * 1. 懒汉模式, 线程不安全
     * logger.info 在@Test中无法打印信息的问题:
     * 多线程中, Junit只管自己的运行，就是说当Junit执行完毕后，就会关闭程序，
     * 不会关心是否还有自己启动的后台线程在运行。
     * 当Junit运行完毕后，如果后台线程还没有执行完毕，那么也是不会再执行了
     * 解决方式: CountDownLatch
     */
    @Test
    public void demo01(){
        for (int i=0; i<10; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        logger.info(SingletonDemo01.getInstance()); // 延迟10ms是 logger.info 在@Test中无法打印信息, 在main中能打印
//                        System.out.println(SingletonDemo01.getInstance());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    /**
     * 测试枚举方式
     */
    @Test
    public void demo05(){
        SingletonDemo05.INSTANCE.otherMethods();
    }
}
