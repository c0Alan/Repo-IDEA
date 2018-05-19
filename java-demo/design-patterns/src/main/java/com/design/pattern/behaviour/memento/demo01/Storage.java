package com.design.pattern.behaviour.memento.demo01;

public class Storage {
      
    private Memento memento;  
      
    public Storage(Memento memento) {  
        this.memento = memento;  
    }  
  
    public Memento getMemento() {  
        return memento;  
    }  
  
    public void setMemento(Memento memento) {  
        this.memento = memento;  
    }  
} 