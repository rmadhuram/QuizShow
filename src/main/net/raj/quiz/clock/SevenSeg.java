/*
 * Created on Nov 18, 2005
 */
 
package net.raj.quiz.clock;

import java.awt.Color;
import java.awt.Graphics;


/**
 * A seven segment LED display.
 * @author Rajkumar
 */
public class SevenSeg 
{
   public static final byte[] codes = {
         0x7e, 0x60, 0x5b, 0x73, 0x65,
         0x37, 0x3f, 0x62, 0x7f, 0x77 
   };
   
   int value;
   int hSize, vSize;
   int xOffset, yOffset;
   Color fg, bg;

   
   public SevenSeg(int xOffset, int yOffset)
   {
      this.xOffset = xOffset;
      this.yOffset = yOffset;
   }
   
   public void paint(Graphics g)
   {
      byte code = codes[value];
      for (int i=0; i<7; i++)
      {
         if (code % 2 == 1)
            g.setColor(fg);
         else
            g.setColor(bg);
         
         switch (i)
         {
            case 0: // g
               g.drawLine(xOffset+1, yOffset+1+vSize,
                     xOffset+hSize, yOffset+1+vSize);
               break;
            
            case 1: // f
               g.drawLine(xOffset+1, yOffset,
                     xOffset+hSize, yOffset);
               break;
               
            case 2: // e
               g.drawLine(xOffset, yOffset+1,
                     xOffset, yOffset+vSize);
               break;
               
            case 3: // d
               g.drawLine(xOffset, yOffset+vSize+2,
                     xOffset, yOffset+vSize+vSize+1 );
               break;
               
            case 4: // c
               g.drawLine(xOffset+1, yOffset+vSize+vSize+2,
                     xOffset+hSize, yOffset+vSize+vSize+2);
               break;
               
            case 5: // b
               g.drawLine(xOffset+hSize+1, yOffset+vSize+2,
                     xOffset+hSize+1, yOffset+vSize+vSize+1 );
               break;
               
            case 6: // e
               g.drawLine(xOffset+hSize+1, yOffset+1,
                     xOffset+hSize+1, yOffset+vSize);
               break;               
         }
         
        code = (byte) (code >> 1);
      }
   }
   
   public int getValue() 
   {
      return value;
   }
   public void setValue(int value) 
   {
      this.value = value;
   }
   public int getHSize() 
   {
      return hSize;
   }
   public void setHSize(int size) 
   {
      hSize = size;
   }
   public int getVSize() 
   {
      return vSize;
   }
   public void setVSize(int size) 
   {
      vSize = size;
   }
   
   public void setColor(Color fg)
   {
      this.fg = fg;
   }
   
   public void setBackground(Color bg)
   {
      this.bg = bg;
   }   
}
