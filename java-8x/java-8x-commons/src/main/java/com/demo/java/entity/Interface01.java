package com.demo.java.entity;

/**
 * @author liuxl
 * @date 2024/6/17
 */
public interface Interface01 {

    // 接口属性全部为常量
    String NAME = "Interface01";

    void method01();

    /**
     * 只能实现default方法
     */
    default void method02(){
        System.out.println("Interface01.method02");
    }
}
