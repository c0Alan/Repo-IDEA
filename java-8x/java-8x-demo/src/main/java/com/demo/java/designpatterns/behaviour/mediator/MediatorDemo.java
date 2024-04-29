package com.demo.java.designpatterns.behaviour.mediator;

/**
 * Mediator 中介者模式是指，用一个中介对象来封装一系列的对象交互，使各对象不需要显式地相互引用，从而使其耦合松散，而且可以独立地改变它们之间的交互。
 * 类似spring容器
 *
 * @author liuxl
 * @date 2024/4/29
 */
public class MediatorDemo {
  
    public static void main(String[] args) {  
        Mediator mediator = new MyMediator();  
        mediator.createMediator();  
        mediator.workAll();  
    }  
} 