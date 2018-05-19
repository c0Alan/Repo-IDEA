package com.design.pattern.build.factorymethod.demo01;

public class FactoryTest {
  
    public static void main(String[] args) {  
        SendFactory factory = new SendFactory();  
        Sender sender = factory.produce("sms");  
        sender.Send();  
    }  
} 