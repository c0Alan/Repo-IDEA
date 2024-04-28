package com.demo.java.designpatterns.structure.proxy.demo03;

public class Source implements Sourceable {
  
    @Override  
    public void method() {  
        System.out.println("the original method!");  
    }  
} 