/*
 * Created on Apr 28, 2005
 */
 
package net.raj.quiz.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

/**
 * @author Rajkumar
 */
public class BaseScreen extends JPanel 
{
	protected Font bigFont;
	
	public BaseScreen()
	{
		setBackground( Color.blue );
		setForeground( Color.white );
		bigFont = new Font("Helvetica", Font.BOLD, 72);
		setFont( bigFont );
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paint(java.awt.Graphics)
	 */
	public void paint(Graphics g) 
	{
        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    
		super.paint(g);
		g.setColor(new Color(200,200,100));

		g.fillRect(0,0,getWidth(),20);
		g.fillRect(0,getHeight()-20,getWidth(),20);
	}
      
	
}
