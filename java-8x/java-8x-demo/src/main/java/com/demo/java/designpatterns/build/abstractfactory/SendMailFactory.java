package com.demo.java.designpatterns.build.abstractfactory;

public class SendMailFactory implements Provider {
      
    @Override  
    public Sender produce(){  
        return new MailSender();  
    }  
}  