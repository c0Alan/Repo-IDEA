package com.demo.java.clazz;

import com.demo.java.entity.TalkingClock02;
import com.demo.java.entity.ArrayAlg03;
import com.demo.java.entity.TalkingClock;
import com.demo.java.entity.MemberOutter;
import com.demo.java.entity.StaticOutter;
import org.junit.Test;

import javax.swing.*;

/**
 * 内部类示例
 *
 * @author liuxl
 * @date 2024/5/2
 */
public class InnerClassDemo {


    /**
     * 内部类示例
     */
    @Test
    public void test03() {
        TalkingClock02 clock = new TalkingClock02(1000, true);
        clock.start();

        // keep program running until user selects "Ok"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }


    /**
     * 静态内部类示例
     */
    @Test
    public void test02(){
        double[] d = new double[20];
        for (int i = 0; i < d.length; i++) {
            d[i] = 100 * Math.random();
        }
        ArrayAlg03.Pair p = ArrayAlg03.minmax(d);
        System.out.println("min = " + p.getFirst());
        System.out.println("max = " + p.getSecond());
    }

    /**
     * 匿名内部类示例
     */
    @Test
    public void test01() {
        TalkingClock clock = new TalkingClock();
        clock.start(1000, true);

        // keep program running until user selects "Ok"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }

    /**
     * 成员内部类
     * 内部类访问外部类: 内部类可以无条件访问外部类的所有成员属性和成员方法（包括private成员和静态成员）。
     * 外部类访问内部类: 先创建一个成员内部类的对象，再通过指向这个对象的引用来访问
     * 类外访问内部类: 成员内部类是依附外部类而存在的，如果要创建成员内部类的对象，前提是必须存在一个外部类的对象。
     * 外部访问成员内部类受修饰符影响
     */
    @Test
    public void memberInner(){
        //第一种方式：
        MemberOutter outter = new MemberOutter();
        MemberOutter.MemberInner inner = outter.new MemberInner();  //必须通过Outter对象来创建
        inner.sayHello();

        //第二种方式：
        MemberOutter.MemberInner inner1 = outter.getInnerInstance();
        inner1.visitOutterClass();
    }

    /**
     * 静态内部类
     * 内部类访问外部类: 不能使用外部类的非static成员变量或者方法
     * 因为要访问非静态成员的话必须先实例化外部类, 但是静态内部类的实例化是通过类名实例化的, 不存在实例化外部类
     * 外部类访问内部类: 相当于外部类的静态成员变量
     */
    @Test
    public void staticInner(){
        StaticOutter.StaticInner inner = new StaticOutter.StaticInner();
        inner.hello(); // hello StaticInner
    }
}
