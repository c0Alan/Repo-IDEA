package com.demo.java.designpatterns.build.factorymethod.demo03;

import com.demo.java.designpatterns.build.factorymethod.demo01.Sender;

public class FactoryTest {
  
    public static void main(String[] args) {      
        Sender sender = SendFactory.produceMail();
        sender.Send();  
    }  
} 