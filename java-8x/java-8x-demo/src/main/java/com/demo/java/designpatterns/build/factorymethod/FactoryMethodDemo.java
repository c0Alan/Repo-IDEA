package com.demo.java.designpatterns.build.factorymethod;

import org.junit.Test;

/**
 * @author liuxl
 * @date 2024/4/29
 * @description FactoryMethod 工厂方法
 */
public class FactoryMethodDemo {
  
    public static void main(String[] args) {  

    }


    /**
     * 静态工厂方法
     */
    @Test
    public void test03(){
        Sender sender = SendFactory02.produceMail();
        sender.Send();
    }
    /**
     * 多个工厂方法
     */
    @Test
    public void test02(){
        SendFactory factory = new SendFactory();
        Sender sender = factory.produceMail();
        sender.Send();
    }

    /**
     * 单个工厂方法
     */
    @Test
    public void test01(){
        SendFactory factory = new SendFactory();
        Sender sender = factory.produce("sms");
        sender.Send();
    }
} 