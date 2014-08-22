/*
 * Created on Apr 28, 2005
 */
 
package net.raj.quiz.ui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import net.raj.quiz.QuizGame;
import net.raj.quiz.sound.MIDIPlayer;

/**
 * @author Rajkumar
 */
public class WelcomeScreen extends BaseScreen
{
	public WelcomeScreen()
	{
		super();
		setLayout(new BorderLayout());
		JLabel label = new JLabel("<html><center>Let's play<br><br>Bible Jeopardy!</center></html>");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.white);
		label.setFont(bigFont);
		add(label, BorderLayout.CENTER);
        
        try {
            
            MIDIPlayer.getInstance().play(
                    QuizGame.getInstance().getAbsolutePath("sounds/jeopardy.mid"),
                    0,
                    76*MIDIPlayer.MICROSEC,
                    0,
                    false);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
}
