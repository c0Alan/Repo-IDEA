package com.demo.java.designpatterns.behaviour.mediator;

public abstract class User {
      
    private Mediator mediator;  
      
    public Mediator getMediator(){  
        return mediator;  
    }  
      
    public User(Mediator mediator) {  
        this.mediator = mediator;  
    }  
  
    public abstract void work();  
}  