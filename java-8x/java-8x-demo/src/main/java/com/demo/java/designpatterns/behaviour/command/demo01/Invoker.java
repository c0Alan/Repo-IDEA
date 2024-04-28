package com.demo.java.designpatterns.behaviour.command.demo01;

public class Invoker {
      
    private Command command;  
      
    public Invoker(Command command) {  
        this.command = command;  
    }  
  
    public void action(){  
        command.exe();  
    }  
}