package com.demo.java.gui.event.mouse;

import javax.swing.*;

/**
 * A frame containing a panel for testing mouse operations
 */
public class MouseFrame extends JFrame {
    public MouseFrame() {
        add(new MouseComponent());
        pack();
    }
}