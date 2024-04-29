package com.demo.java.designpatterns.build.factorymethod;

public class MailSender implements Sender {
    @Override  
    public void Send() {  
        System.out.println("this is mailsender!");  
    }  
} 