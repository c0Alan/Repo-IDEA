package com.design.pattern.build.factorymethod.demo02;

import com.design.pattern.build.factorymethod.demo01.MailSender;
import com.design.pattern.build.factorymethod.demo01.Sender;
import com.design.pattern.build.factorymethod.demo01.SmsSender;

public class SendFactory {
   public Sender produceMail(){
        return new MailSender();
    }  
      
    public Sender produceSms(){  
        return new SmsSender();
    }  
}  