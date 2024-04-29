package com.demo.java.designpatterns.behaviour.command;

/**
 * Command 命令模式是指达到命令的发出者和执行者之间解耦，实现请求和执行分开
 * Struts其实就是一种将请求和呈现分离的技术
 *
 * @author liuxl
 * @date 2024/4/29
 */
public class CommandDemo {
  
    public static void main(String[] args) {  
        Receiver receiver = new Receiver();  
        Command cmd = new MyCommand(receiver);  
        Invoker invoker = new Invoker(cmd);  
        invoker.invoke();
    }  
} 