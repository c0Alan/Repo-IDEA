package com.demo.java.swing.dialog;

import javax.swing.*;
import java.awt.*;

/**
 * A sample modal dialog that displays a message and waits for the user to click the OK button.
 */
public class AboutDialog extends JDialog {
    public AboutDialog(JFrame owner) {
        super(owner, "About DialogTest", true);

        // add HTML label to center

        add(
                new JLabel(
                        "<html><h1><i>Core Java</i></h1><hr>By Cay Horstmann</html>"),
                BorderLayout.CENTER);

        // OK button closes the dialog

        JButton ok = new JButton("OK");
        ok.addActionListener(event -> setVisible(false));

        // add OK button to southern border

        JPanel panel = new JPanel();
        panel.add(ok);
        add(panel, BorderLayout.SOUTH);

        pack();
    }
}
