package com.demo.java.jdk.clazz.loadorder;

/**
 * 类加载顺序实验
 * 
 * @author liuxl
 * @date 2018/6/1 13:15
 */
public class LoadOrderDemo {

    {
        System.out.println("non static block inited");
    }

    public LoadOrderDemo() {
        System.out.println("constructor inited");
    }

    static class SubDemo extends LoadOrderDemo{
        {
            System.out.println("sub non static block inited");
        }

        public SubDemo() {
            System.out.println("sub constructor inited");
        }
    }

    /**
     * 父类非静态代码块 --> 父类构造方法 --> 非静态代码块 --> 构造方法
     * @param args
     */
    public static void main(String[] args) {
        SubDemo demo = new SubDemo();
    }
}
