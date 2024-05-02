package com.demo.java.entity;

/**
 * 静态内部类
 * 内部类访问外部类: 不能使用外部类的非static成员变量或者方法
 * 因为要访问非静态成员的话必须先实例化外部类, 但是静态内部类的实例化是通过类名实例化的, 不存在实例化外部类
 * 外部类访问内部类: 相当于外部类的静态成员变量
 *
 * @author liuxl
 * @date 2018/6/6 12:19
 */
public class StaticOutter {
    public static class StaticInner {
        public StaticInner() {

        }

        public void hello(){
            System.out.println("hello StaticInner");
        }
    }
}
