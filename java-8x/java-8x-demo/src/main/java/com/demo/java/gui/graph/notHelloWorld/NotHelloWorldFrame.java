package com.demo.java.gui.graph.notHelloWorld;

import javax.swing.*;

/**
 * A frame that contains a message panel
 */
class NotHelloWorldFrame extends JFrame
{
   public NotHelloWorldFrame()
   {
      add(new NotHelloWorldComponent());
      pack();
   }
}