package com.demo.java.structure.decorator.demo01;

public class DecoratorTest {
  
    public static void main(String[] args) {  
        Sourceable source = new Source();  
        Sourceable obj = new Decorator(source);  
        obj.method();  
    }  
} 