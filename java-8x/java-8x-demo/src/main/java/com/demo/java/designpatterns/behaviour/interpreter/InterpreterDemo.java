package com.demo.java.designpatterns.behaviour.interpreter;

/**
 * Interpreter 解释器模式是指定一个表达式接口，该接口定义了抽象的解析方法。
 *
 * @author liuxl
 * @date 2024/4/29
 */
public class InterpreterDemo {
  
    public static void main(String[] args) {  
  
        // 计算9+2-8的值  
        int result = new Minus().interpret((new Context(new Plus().interpret(new Context(9, 2)), 8)));  
        System.out.println(result);  
    }  
} 