package com.demo.java.jvm.clazzloader;

/**
 * 初始化实例
 * init 方法执行顺序
 * 
 * @author liuxilin
 * @date 2018/5/27 16:39
 */
public class InitDemo02 {
    static class Parent {
        public static int A = 1;

        static {
            A = 2;
        }
    }

    static class Sub extends Parent {
        public static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Sub.B); // 2
    }
}
