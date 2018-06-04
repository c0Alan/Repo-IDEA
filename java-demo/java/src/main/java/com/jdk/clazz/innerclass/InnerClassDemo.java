package com.jdk.clazz.innerclass;

import org.junit.Test;

public class InnerClassDemo {

    /**
     * 测试成员内部类
     */
    @Test
    public void member(){
        //第一种方式：
        MemberOutter outter = new MemberOutter();
        MemberOutter.MemberInner inner = outter.new MemberInner();  //必须通过Outter对象来创建
        inner.sayHello();

        //第二种方式：
        MemberOutter.MemberInner inner1 = outter.getInnerInstance();
        inner1.visitOutterClass();
    }
}
