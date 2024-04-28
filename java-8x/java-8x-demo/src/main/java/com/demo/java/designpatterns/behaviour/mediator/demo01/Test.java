package com.demo.java.designpatterns.behaviour.mediator.demo01;

public class Test {
  
    public static void main(String[] args) {  
        Mediator mediator = new MyMediator();  
        mediator.createMediator();  
        mediator.workAll();  
    }  
} 