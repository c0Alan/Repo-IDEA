package com.jvm.clazzloader;

/**
 * 字段解析实例
 *
 *
 * @author liuxilin
 * @date 2018/5/27 16:33
 */
public class FieldResolution {

    interface Interface0 {
        int A = 0;
    }

    interface Interface1 extends Interface0 {
        int A = 1;
    }

    interface Interface2 {
        int A = 2;
    }

    static class Parent implements Interface1 {
        public static int A = 3;
    }

    /**
     * 如果注释掉 public static int A = 4;
     * 编译器就会报错: The field Sub.A is ambiguous, 因为不知道用 父类还是接口的
     */
    static class Sub extends Parent implements Interface2 {
        public static int A = 4;
    }

    public static void main(String[] args) {
        System.out.println(Sub.A);
    }
}