package com.demo.java.jdk.type.string;

import org.junit.Test;

/**
 * StringBuilder, StringBuffer, String 的比较
 * 运行速度快慢为：StringBuilder > StringBuffer > String
 * (实验证明 StringBuffer 更快)
 * 在线程安全上，StringBuilder是线程不安全的，而StringBuffer是线程安全的
 * 
 * @author liuxl
 * @date 2018/6/6 13:07
 */
public class StringDemo03 {

    @Test
    public void compareString(){

        Long time0 = System.currentTimeMillis();
        StringBuilder sbd = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            sbd.append(i);
        }

        Long time1 = System.currentTimeMillis();
        System.out.println(time1 - time0); // 59
        time1 = System.currentTimeMillis();

        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < 1000000; i++) {
            sbf.append(i);
        }

        Long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1); // 58
        time2 = System.currentTimeMillis();

        String str = new String();
        for (int i = 0; i < 10000; i++) {
            str = str + i;
        }

        Long time3 = System.currentTimeMillis();
        System.out.println(time3 - time2); // 357
    }
}
