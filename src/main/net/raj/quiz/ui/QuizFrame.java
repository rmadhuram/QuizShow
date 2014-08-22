/*
 * Created on Apr 28, 2005
 */
 
package net.raj.quiz.ui;

import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author Rajkumar
 */
public class QuizFrame extends JFrame 
{
	public QuizFrame()
	{
		getContentPane().setLayout(new BorderLayout());
		setUndecorated(true);
      
        addKeyListener(new KeyAdapter() {
             /* (non-Javadoc)
             * @see java.awt.event.KeyAdapter#keyReleased(java.awt.event.KeyEvent)
             */
            public void keyReleased(KeyEvent e) {
               if (e.getKeyChar()=='q' || e.getKeyChar()=='Q')
               {
//                default icon, custom title
                  int n = JOptionPane.showConfirmDialog(
                      QuizFrame.this,
                      "Do you really want to quit?",
                      "Really quit?",
                      JOptionPane.YES_NO_OPTION);
                  
                  if (n == 0)
                     System.exit(-1);

               }
            }
        });
	  
	    //setSize(512,384);
        //setSize(1024,768);
	    GraphicsEnvironment.getLocalGraphicsEnvironment().
			getDefaultScreenDevice().setFullScreenWindow(this);
	}
	
	public void setPanel(JPanel panel)
	{
		getContentPane().removeAll();
		getContentPane().add(panel, BorderLayout.CENTER);
		validate();
		
		if (!isVisible())
			setVisible(true);
        
        repaint();
	}
}
