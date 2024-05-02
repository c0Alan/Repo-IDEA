package com.demo.java.gui.swing.calculator;

import javax.swing.*;
import java.awt.*;

/**
 * 计算器
 *
 * @author liuxilin
 * @date 2022/7/3 21:42
 */
public class Calculator {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            CalculatorFrame frame = new CalculatorFrame();
            frame.setTitle("Calculator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
