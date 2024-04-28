package com.demo.java.designpatterns.build.abstractfactory.demo01;

public class MailSender implements Sender {
    @Override  
    public void Send() {  
        System.out.println("this is mailsender!");  
    }  
}  