package com.demo.java.gui.swing.calculator;

import javax.swing.*;

/**
 * A frame with a calculator panel.
 */
public class CalculatorFrame extends JFrame {
    public CalculatorFrame() {
        add(new CalculatorPanel());
        pack();
    }
}
