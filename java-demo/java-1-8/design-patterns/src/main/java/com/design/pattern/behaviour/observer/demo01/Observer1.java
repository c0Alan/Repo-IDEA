package com.design.pattern.behaviour.observer.demo01;

public class Observer1 implements Observer {
  
    @Override  
    public void update() {  
        System.out.println("observer1 has received!");  
    }  
}  