package com.demo.java.jdk.clazz.innerclass;

/**
 * 成员内部类
 * 内部类访问外部类: 内部类可以无条件访问外部类的所有成员属性和成员方法（包括private成员和静态成员）。
 * 外部类访问内部类: 先创建一个成员内部类的对象，再通过指向这个对象的引用来访问
 * 类外访问内部类: 成员内部类是依附外部类而存在的，如果要创建成员内部类的对象，前提是必须存在一个外部类的对象。
 * 外部访问成员内部类受修饰符影响
 * 
 * @author liuxl
 * @date 2018/6/4 13:00
 */
public class MemberOutter {
    private String value = "MemberOutter";

    public MemberInner getInnerInstance(){
        return new MemberInner();
    }

    public class MemberInner {

        public void sayHello(){
            System.out.println("Hello, MemberInner!");
        }

        public void visitOutterClass(){
            System.out.println("Outter class's value: " + value);
        }
    }
}

