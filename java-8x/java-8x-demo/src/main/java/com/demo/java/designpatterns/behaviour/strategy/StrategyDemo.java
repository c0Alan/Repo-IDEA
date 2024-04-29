package com.demo.java.designpatterns.behaviour.strategy;

/**
 * Strategy 策略模式是指定算法族，分别封装起来，让它们之间可以互相替换，此模式让算法的变化不会影响到使用算法的客户。
 *
 * @author liuxl
 * @date 2024/4/29
 */
public class StrategyDemo {

    public static void main(String[] args) {
        String exp = "2+8";
        ICalculator cal = new Plus();
        int result = cal.calculate(exp);
        System.out.println(result);
    }
} 