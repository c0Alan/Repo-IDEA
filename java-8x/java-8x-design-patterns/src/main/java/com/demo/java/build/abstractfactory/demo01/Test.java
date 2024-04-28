package com.demo.java.build.abstractfactory.demo01;

public class Test {
  
    public static void main(String[] args) {  
        Provider provider = new SendMailFactory();  
        Sender sender = provider.produce();  
        sender.Send();  
    }  
}  