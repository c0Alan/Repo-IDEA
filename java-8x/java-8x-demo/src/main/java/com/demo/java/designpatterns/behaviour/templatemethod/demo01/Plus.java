package com.demo.java.designpatterns.behaviour.templatemethod.demo01;

public class Plus extends AbstractCalculator {
  
    @Override  
    public int calculate(int num1,int num2) {  
        return num1 + num2;  
    }  
}  