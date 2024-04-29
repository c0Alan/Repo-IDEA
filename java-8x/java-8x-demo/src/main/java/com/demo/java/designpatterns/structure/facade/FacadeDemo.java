package com.demo.java.designpatterns.structure.facade;

import org.junit.Test;

/**
 * Facade 外观模式
 *
 * @author liuxl
 * @date 2024/4/29
 */
public class FacadeDemo {

    public static void main(String[] args) {

    }

    @Test
    public void test01() {
        Computer computer = new Computer();
        computer.startup();
        computer.shutdown();
    }
} 