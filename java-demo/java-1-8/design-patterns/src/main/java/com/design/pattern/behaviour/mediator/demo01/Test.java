package com.design.pattern.behaviour.mediator.demo01;

public class Test {
  
    public static void main(String[] args) {  
        Mediator mediator = new MyMediator();  
        mediator.createMediator();  
        mediator.workAll();  
    }  
} 