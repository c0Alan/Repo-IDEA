package com.demo.java.base.except;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * A panel with radio buttons for running code snippets and studying their exception behavior
 */
class ExceptTestPanel extends Box {
    private ButtonGroup group;
    private JTextField textField;
    private double[] a = new double[10];

    public ExceptTestPanel() {
        super(BoxLayout.Y_AXIS);
        group = new ButtonGroup();

        // add radio buttons for code snippets

        addRadioButton("Integer divide by zero", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                a[1] = 1 / (a.length - a.length);
            }
        });

        addRadioButton("Floating point divide by zero", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                a[1] = a[2] / (a[3] - a[3]);
            }
        });

        addRadioButton("Array bounds", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                a[1] = a[10];
            }
        });

        addRadioButton("Bad cast", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                a = (double[]) event.getSource();
            }
        });

        addRadioButton("Null pointer", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println(textField.getAction().toString());
            }
        });

        addRadioButton("sqrt(-1)", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                a[1] = Math.sqrt(-1);
            }
        });

        addRadioButton("Overflow", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                a[1] = 1000 * 1000 * 1000 * 1000;
                int n = (int) a[1];
                System.out.println(n);
            }
        });

        addRadioButton("No such file", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    System.out.println(
                            new Scanner(Paths.get("woozle.txt"), "UTF-8").next());
                } catch (IOException e) {
                    textField.setText(e.toString());
                }
            }
        });

        addRadioButton("Throw unknown", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                throw new UnknownError();
            }
        });

        // add the text field for exception display
        textField = new JTextField(30);
        add(textField);
    }

    /**
     * Adds a radio button with a given listener to the panel. Traps any exceptions in the
     * actionPerformed method of the listener.
     *
     * @param s        the label of the radio button
     * @param listener the action listener for the radio button
     */
    private void addRadioButton(String s, ActionListener listener) {
        JRadioButton button = new JRadioButton(s, false) {
            // the button calls this method to fire an
            // action event. We override it to trap exceptions
            @Override
            protected void fireActionPerformed(ActionEvent event) {
                try {
                    textField.setText("No exception");
                    super.fireActionPerformed(event);
                } catch (Exception e) {
                    textField.setText(e.toString());
                }
            }
        };

        button.addActionListener(listener);
        add(button);
        group.add(button);
    }
}