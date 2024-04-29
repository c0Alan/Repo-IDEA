package com.demo.java.designpatterns.behaviour.templatemethod;

/**
 * TemplateMethod 模板方法指示一个操作中的算法的骨架，而将一些步骤延迟到子类中。TemplateMethod 使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。
 *
 * @author liuxl
 * @date 2024/4/29
 */
public class TemplateMethodDemo {

    public static void main(String[] args) {
        String exp = "8+8";
        AbstractCalculator cal = new Plus();
        int result = cal.calculate(exp, "\\+");
        System.out.println(result);
    }
}