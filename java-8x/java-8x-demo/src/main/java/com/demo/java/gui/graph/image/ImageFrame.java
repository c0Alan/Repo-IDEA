package com.demo.java.gui.graph.image;

import javax.swing.*;

/**
 * A frame with an image component
 */
class ImageFrame extends JFrame {
    public ImageFrame() {
        add(new ImageComponent());
        pack();
    }
}