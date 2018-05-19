package com.design.pattern.build.factorymethod.demo01;

public class MailSender implements Sender {
    @Override  
    public void Send() {  
        System.out.println("this is mailsender!");  
    }  
} 