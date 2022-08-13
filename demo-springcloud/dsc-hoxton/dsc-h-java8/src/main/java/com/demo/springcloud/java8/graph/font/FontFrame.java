package com.demo.springcloud.java8.graph.font;

import javax.swing.*;

/**
 * A frame with a text message component
 */
class FontFrame extends JFrame {
    public FontFrame() {
        add(new FontComponent());
        pack();
    }
}