package com.demo.java.designpatterns.build.abstractfactory;

import org.junit.Test;

/**
 * @author liuxl
 * @date 2024/4/29
 * @description AbstractFactory 抽象工厂
 */
public class AbstractFactoryDemo {
  
    public static void main(String[] args) {  

    }

    /**
     * 抽象工厂示例
     */
    @Test
    public void test01() {
        Provider provider = new SendMailFactory();
        Sender sender = provider.produce();
        sender.Send();
    }
}  