package com.design.pattern.build.factorymethod.demo01;

public class SmsSender implements Sender {
  
    @Override  
    public void Send() {  
        System.out.println("this is sms sender!");  
    }  
} 