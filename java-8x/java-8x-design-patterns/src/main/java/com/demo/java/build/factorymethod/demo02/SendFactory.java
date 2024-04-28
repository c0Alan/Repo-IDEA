package com.demo.java.build.factorymethod.demo02;

import com.demo.java.build.factorymethod.demo01.MailSender;
import com.demo.java.build.factorymethod.demo01.Sender;
import com.demo.java.build.factorymethod.demo01.SmsSender;

public class SendFactory {
   public Sender produceMail(){
        return new MailSender();
    }  
      
    public Sender produceSms(){  
        return new SmsSender();
    }  
}  