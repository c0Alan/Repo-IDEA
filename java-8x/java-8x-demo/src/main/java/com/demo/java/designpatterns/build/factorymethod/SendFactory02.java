package com.demo.java.designpatterns.build.factorymethod;

public class SendFactory02 {
      
    public static Sender produceMail(){
        return new MailSender();
    }  
      
    public static Sender produceSms(){  
        return new SmsSender();
    }  
} 