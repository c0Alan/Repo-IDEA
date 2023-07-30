package com.jd.jdk.clazz.innerclass;

import org.junit.Test;

public class InnerClassDemo {

    /**
     * 成员内部类
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

    @Test
    public void staticInner(){
        StaticOutter.StaticInner inner = new StaticOutter.StaticInner();
        inner.hello(); // hello StaticInner
    }
}
