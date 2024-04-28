package com.demo.java.designpatterns.structure.decorator.demo01;

public class DecoratorTest {
  
    public static void main(String[] args) {  
        Sourceable source = new Source();  
        Sourceable obj = new Decorator(source);  
        obj.method();  
    }  
} 