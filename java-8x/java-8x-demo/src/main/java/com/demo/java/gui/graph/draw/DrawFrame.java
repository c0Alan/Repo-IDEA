package com.demo.java.gui.graph.draw;

import javax.swing.*;

/**
 * A frame that contains a panel with drawings
 */
class DrawFrame extends JFrame
{
   public DrawFrame()
   {      
      add(new DrawComponent());
      pack();
   }
}