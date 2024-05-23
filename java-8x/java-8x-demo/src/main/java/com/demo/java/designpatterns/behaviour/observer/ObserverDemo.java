package com.demo.java.designpatterns.behaviour.observer;

/**
 * Observer 观察者模式是指一个对象订阅另一个对象的状态变化，当被订阅对象发生变化时，通知订阅对象。
 * 常用场景为订阅通知场景, 如 Listener 事件监听
 *
 * @author liuxl
 * @date 2024/4/29
 */
public class ObserverDemo {
  
    public static void main(String[] args) {  
        Subject sub = new MySubject();  
        sub.add(new Observer1());  
        sub.add(new Observer2());  
          
        sub.operation();  
    }  
  
}  