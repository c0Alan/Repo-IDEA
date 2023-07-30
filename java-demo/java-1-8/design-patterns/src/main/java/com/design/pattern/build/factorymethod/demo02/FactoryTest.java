package com.design.pattern.build.factorymethod.demo02;

import com.design.pattern.build.factorymethod.demo01.Sender;

public class FactoryTest {
  
    public static void main(String[] args) {  
        SendFactory factory = new SendFactory();  
        Sender sender = factory.produceMail();
        sender.Send();  
    }  
}  