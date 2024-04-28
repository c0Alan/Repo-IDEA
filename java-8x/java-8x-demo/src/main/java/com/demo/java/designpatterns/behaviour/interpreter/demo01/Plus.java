package com.demo.java.designpatterns.behaviour.interpreter.demo01;

public class Plus implements Expression {
  
    @Override  
    public int interpret(Context context) {  
        return context.getNum1()+context.getNum2();  
    }  
}  