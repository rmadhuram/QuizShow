/*
 * Created on Apr 29, 2005
 */
 
package net.raj.quiz.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import net.raj.quiz.model.Round;
import net.raj.quiz.model.Section;

/**
 * @author Rajkumar
 */
public class GameBoard extends JPanel 
{
	int scoreA, scoreB;
	JLabel scoreLabelA, scoreLabelB;
    JLabel wagerLabels[][];
    int wagers[][];
	
	public GameBoard(Round round, int scoreA, int scoreB)
	{
		setLayout(new BorderLayout());
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(round.getSectionCount(),0));
        wagerLabels = new JLabel[round.getSectionCount()][5];
        wagers = new int[round.getSectionCount()][5];
		for (int i=0; i<round.getSectionCount(); i++)
			topPanel.add(buildSection(round.getSection(i), i));
		add(topPanel, BorderLayout.CENTER);
		
        this.scoreA = scoreA;
        this.scoreB = scoreB;
        
		JPanel scorePanel = buildScorePanel();
        setScoreA(scoreA);
        setScoreB(scoreB);
        
		add(scorePanel, BorderLayout.SOUTH);
	}
    
    public void adjustScores(int delA, int delB)
    {
        scoreA += delA;
        scoreB += delB;
        
        scoreLabelA.setText(scoreA + "");
        scoreLabelB.setText(scoreB + "");
    }
	
	public void setScoreA(int score)
	{
		scoreLabelA.setText(score + "");
	}
	
	public void setScoreB(int score)
	{
		scoreLabelB.setText(score + "");
	}
    
    public int getScoreA()
    {
        return scoreA;
    }
    
    public int getScoreB()
    {
        return scoreB;
    }
    
    public void showQuestion(int secNum, int questNum)
    {
        wagerLabels[secNum][questNum].setText("");
        wagers[secNum][questNum] = 0;
    }
    
    public boolean isFinished()
    {
        boolean finished = true;
        for (int i=0; i<wagers.length; i++)
            for (int j=0; j<5; j++)
                if (wagers[i][j] != 0)
                {
                    finished = false;
                    //System.out.println("Not done at : " + i + " , " + j);
                    break;
                }
        return finished;
    }
    
    public int[][] getWagers()
    {
        return wagers;
    }
	
	/**
	 * @return
	 */
	private JPanel buildScorePanel() 
	{
		GradientPanel scorePanel = new GradientPanel(Color.blue, Color.white);
		scorePanel.setLayout(new GridLayout(1,4));
		Font font = new Font("Helvetica", Font.BOLD, 64);
        
        Color darkColor = new Color(128,80,255);
		
		JLabel label = new GradientLabel(darkColor, Color.white);
        label.setText("Team A");
        //label.setText("Ladies");
		label.setFont( font );
		scorePanel.add(label);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		
		scoreLabelA = new GradientLabel(darkColor, Color.white);
        scoreLabelA.setText("000");
		scoreLabelA.setFont( font );
		scorePanel.add(scoreLabelA);
		scoreLabelA.setHorizontalAlignment(SwingConstants.CENTER);
		
		label = new GradientLabel(darkColor, Color.white);
        label.setText("Team B");
        //label.setText("Gentlemen");
		label.setFont( font );
		scorePanel.add(label);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		
		scoreLabelB = new GradientLabel(darkColor, Color.white);
        scoreLabelB.setText("000");
		scoreLabelB.setFont( font );
		scorePanel.add(scoreLabelB);
		scoreLabelB.setHorizontalAlignment(SwingConstants.CENTER);
		
		return scorePanel;
	}

	private JPanel buildSection(Section section, int secCount)
	{
		JPanel sectionPanel = new JPanel();
		sectionPanel.setBackground(Color.blue);
		sectionPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		c.weighty = 1.0;
		
		JLabel sectionLabel = new JLabel();
        
        Border border = BorderFactory.createCompoundBorder(
                    BorderFactory.createEmptyBorder(2,1,1,2),
                    BorderFactory.createLineBorder(Color.white)
                );
		sectionLabel.setBorder( border );
		sectionLabel.setText(section.getName());
		sectionLabel.setForeground(Color.white);
		sectionLabel.setFont(new Font("Helvetica", Font.BOLD, 42));
		sectionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sectionLabel.setMaximumSize(new Dimension(470,125));
		sectionLabel.setPreferredSize(new Dimension(470,125));
		sectionPanel.add(sectionLabel);
		
		for (int i=0; i<5; i++)
		{
			wagerLabels[secCount][i] = new JLabel((i+1)*100 + "");
            wagers[secCount][i] = (i+1)*100;
            JLabel pointLabel = wagerLabels[secCount][i];
			pointLabel.setBorder(border);
			pointLabel.setForeground(Color.white);
			pointLabel.setFont(new Font("Helvetica", Font.BOLD, 36));
			pointLabel.setHorizontalAlignment(SwingConstants.CENTER);
			pointLabel.setPreferredSize(new Dimension(110,125));
			sectionPanel.add(pointLabel);			
		}
		
		return sectionPanel;
	}
    
    /* (non-Javadoc)
     * @see javax.swing.JComponent#paint(java.awt.Graphics)
     */
    public void paint(Graphics g) 
    {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    
        super.paint(g);
    }    
	
}
