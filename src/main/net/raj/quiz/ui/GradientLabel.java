/*
 * $Header: /root/AP/MASCAL/src/main/com/awarepoint/mascal/ui/GradientLabel.java,v 1.2 2005/03/15 11:41:38 raj Exp $
 *
 * $Author: raj $
 * $Revision: 1.2 $
 *
 * Copyright (c) 2003 AwarePoint Corporation. All rights reserved.
 * AWAREPOINT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package net.raj.quiz.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;
import javax.swing.JLabel;


public class GradientLabel extends JLabel
{
   
   private Color darkColor;
   private Color brightColor;
   
   /**
    * @param TableWithHeader
    */
   public GradientLabel( Color darkColor, Color brightColor)
   {
      this.darkColor = darkColor;
      this.brightColor = brightColor;
   }

   /* (non-Javadoc)
    * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
    */
   protected void paintComponent(Graphics g)
   {
      Dimension d = getSize();
      //GradientPaint gradient =
      //   new GradientPaint(0, d.height/2, darkColor, d.width, d.height/2, brightColor, false);

      GradientPaint gradient =
         new GradientPaint(d.width/2, 0, brightColor, d.width/2, d.height, darkColor, false);
      
      Graphics2D g2D = (Graphics2D) g;
      g2D.setPaint(gradient);
      g2D.fillRect(0, 0, d.width, d.height);
      g2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
      super.paintComponent(g);
      g2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
   }
}