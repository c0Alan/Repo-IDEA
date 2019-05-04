package com.jdk.clazz.innerclass;

/**
 * 匿名内部类
 * 匿名内部类应该是平时我们编写代码时用得最多的，
 * 常用于各种事件监听器，而且使代码简洁更加容易维护。
 * 匿名内部类不能有访问修饰符和static修饰符的。
 * 匿名内部类是唯一一种没有构造器的类。正因为其没有构造器，所以匿名内部类的使用范围非常有限，
 * 大部分匿名内部类用于接口回调。匿名内部类在编译的时候由系统自动起名为Outter$1.class。
 * 一般来说，匿名内部类用于继承其他类或是实现接口，并不需要增加额外的方法，只是对继承方法的实现或是重写。
 *
 * @author liuxl
 * @date 2018/6/5 13:11
 */
public abstract class AnonymousOutter {
    public abstract void hello();

    public static void listener(AnonymousOutter anonymous) {
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
