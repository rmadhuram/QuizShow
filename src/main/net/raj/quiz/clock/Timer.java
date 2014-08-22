/*
 * Created on Nov 18, 2005
 */
 
package net.raj.quiz.clock;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

/**
 * @author Rajkumar
 */
public class Timer 
{
   int xOffset, yOffset;
   SevenSeg[] seg;
   int tickMin, tickSec;
   JComponent canvas;
   
   public Timer(int x, int y, int width, int height)
   {
      xOffset = x;
      yOffset = y;
      seg = new SevenSeg[4];
      seg[0] = new SevenSeg(x,y);
      seg[1] = new SevenSeg(x+width+4,y);
      seg[2] = new SevenSeg(x+2*width+8,y);
      seg[3] = new SevenSeg(x+3*width+12,y);
      
      for (int i=0; i<4; i++)
      {
         seg[i].setHSize(width);
         seg[i].setVSize(height);
         seg[i].setValue(0);
         seg[i].setBackground(Color.white);
         seg[i].setColor(Color.black);
      }
      
      new TimerThread().start();
   }
   
   
   
   class TimerThread extends Thread
   {
      /* (non-Javadoc)
       * @see java.lang.Thread#run()
       */
      public void run() 
      {
         while (true)
         {
               
            try {
               Thread.sleep(1000);
            } catch (InterruptedException e) 
            {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
            
            tickSec++;
            if (tickSec>=60)
            {
               tickMin++;
               tickSec = 0;
            }
            seg[0].setValue(tickMin/10);
            seg[1].setValue(tickMin%10);
            seg[2].setValue(tickSec/10);
            seg[3].setValue(tickSec%10);
            if (canvas != null)
               canvas.repaint();
         }
      }
   }
   
   public void paint(Graphics g)
   {
      for (int i=0; i<4; i++)
         seg[i].paint(g);
   }
   
   public JComponent getCanvas() 
   {
      return canvas;
   }
   
   public void setCanvas(JComponent canvas) 
   {
      this.canvas = canvas;
   }
}
