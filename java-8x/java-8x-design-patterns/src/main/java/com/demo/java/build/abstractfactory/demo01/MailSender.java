package com.demo.java.build.abstractfactory.demo01;

public class MailSender implements Sender {
    @Override  
    public void Send() {  
        System.out.println("this is mailsender!");  
    }  
}  