package com.demo.springcloud.java8.base.innerClass.staticInnerClass;

/**
 * 静态内部类示例
 *
 * @author liuxilin
 * @date 2022/6/25 22:29
 */
public class StaticInnerClassTest {

    public static void main(String[] args) {
        double[] d = new double[20];
        for (int i = 0; i < d.length; i++) {
            d[i] = 100 * Math.random();
        }
        ArrayAlg.Pair p = ArrayAlg.minmax(d);
        System.out.println("min = " + p.getFirst());
        System.out.println("max = " + p.getSecond());
    }
}


