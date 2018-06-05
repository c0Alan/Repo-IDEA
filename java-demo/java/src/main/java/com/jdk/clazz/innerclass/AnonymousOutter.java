package com.jdk.clazz.innerclass;

/**
 * 匿名内部类
 * 匿名内部类应该是平时我们编写代码时用得最多的，
 * 常用于各种事件监听器，而且使代码更加容易维护。
 * 
 * @author liuxl
 * @date 2018/6/5 13:11
 */
public abstract class AnonymousOutter {
    public abstract void hello();

    public static void listener(AnonymousOutter anonymous){
        anonymous.hello();
    }

    public static void main(String[] args) {
        listener(new AnonymousOutter() {
            @Override
            public void hello() {
                System.out.println("hello");
            }
        });
    }
}
