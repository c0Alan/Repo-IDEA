package com.demo.springcloud.java8.concurrency.bounce;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * The component that draws the balls.
 *
 * @author Cay Horstmann
 * @version 1.34 2012-01-26
 */
public class BallComponent extends JPanel {
    private static final int DEFAULT_WIDTH = 450;
    private static final int DEFAULT_HEIGHT = 350;

    private java.util.List<Ball> balls = new ArrayList<>();

    /**
     * Add a ball to the component.
     *
     * @param b the ball to add
     */
    public void add(Ball b) {
        balls.add(b);
    }

    @Override
    public void paintComponent(Graphics g) {
        // erase background
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Ball b : balls) {
            g2.fill(b.getShape());
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
