package com.demo.java.jvm.clazzloader;

/**
 * 通过子类引用父类的静态字段，不会导致子类初始化
 * 非主动使用类字段演示
 **/
public class NotInitialization {

    /**
     * 结果: SuperClass init! \n 123
     * 说明子类没有被初始化
     *
     * @author liuxilin
     * @date 2018/5/27 16:22
     */
    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }

}