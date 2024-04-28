package com.design.pattern.build.abstractfactory.demo01;

public class SendMailFactory implements Provider {
      
    @Override  
    public Sender produce(){  
        return new MailSender();  
    }  
}  