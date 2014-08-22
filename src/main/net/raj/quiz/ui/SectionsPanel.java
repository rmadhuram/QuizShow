/*
 * Created on Apr 28, 2005
 */
 
package net.raj.quiz.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;

import net.raj.quiz.model.Round;
import net.raj.quiz.model.Section;
import net.raj.quiz.sound.MIDIPlayer;

/**
 * @author Rajkumar
 */
public class SectionsPanel extends BaseScreen 
{
	private Round round;
	private Image offBuffer;
	private Image nextSectionImage;
	private JLabel label;
	
	public SectionsPanel(Round round)
	{
		this.round = round;
		setLayout(new BorderLayout());
		setBackground(Color.blue);
		Font bigFont = new Font("Helvetica", Font.BOLD, 72);
		label = new JLabel();
		label.setFont(bigFont);
		label.setForeground(Color.white);
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label, BorderLayout.CENTER);
        MIDIPlayer.getInstance().stop();
		new TimerThread().start();
	}
	
	class TimerThread extends Thread
	{
		/* (non-Javadoc)
		 * @see java.lang.Thread#run()
		 */
		public void run() 
		{
			for (int i=0; i<round.getSectionCount(); i++)
			{
				Section sec = round.getSection(i);
				System.out.println(sec.getName());
				label.setText(sec.getName());
				try {
					Thread.sleep(2500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
