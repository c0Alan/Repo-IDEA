package com.demo.java.designpatterns.behaviour.observer.demo01;

public class MySubject extends AbstractSubject {
  
    @Override  
    public void operation() {  
        System.out.println("update self!");  
        notifyObservers();  
    }  
  
}