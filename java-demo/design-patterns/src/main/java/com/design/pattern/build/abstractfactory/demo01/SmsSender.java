package com.design.pattern.build.abstractfactory.demo01;

public class SmsSender implements Sender {
  
    @Override  
    public void Send() {  
        System.out.println("this is sms sender!");  
    }  
}  