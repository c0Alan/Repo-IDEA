package com.demo.java.build.abstractfactory.demo01;

public class SendMailFactory implements Provider {
      
    @Override  
    public Sender produce(){  
        return new MailSender();  
    }  
}  