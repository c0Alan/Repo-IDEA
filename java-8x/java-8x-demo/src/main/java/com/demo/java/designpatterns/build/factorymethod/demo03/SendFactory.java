package com.demo.java.designpatterns.build.factorymethod.demo03;

import com.demo.java.designpatterns.build.factorymethod.demo01.MailSender;
import com.demo.java.designpatterns.build.factorymethod.demo01.Sender;
import com.demo.java.designpatterns.build.factorymethod.demo01.SmsSender;

public class SendFactory {
      
    public static Sender produceMail(){
        return new MailSender();
    }  
      
    public static Sender produceSms(){  
        return new SmsSender();
    }  
} 