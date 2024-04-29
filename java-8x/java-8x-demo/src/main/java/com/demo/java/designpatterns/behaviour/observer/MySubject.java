package com.demo.java.designpatterns.behaviour.observer;

public class MySubject extends AbstractSubject {
  
    @Override  
    public void operation() {  
        System.out.println("update self!");  
        notifyObservers();  
    }  
  
}