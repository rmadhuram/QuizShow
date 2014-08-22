/*
 * Created on May 5, 2005
 */
 
package net.raj.quiz.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import net.raj.quiz.QuizGame;
import net.raj.quiz.model.Audioclip;
import net.raj.quiz.model.Qa;
import net.raj.quiz.sound.MIDIPlayer;

/**
 * @author Rajkumar
 */
public class AnswerPanel extends JPanel 
{
    private JLabel qLabel;
    private JLabel imageLabel;
    private JLabel textLabel;
    private JLabel scoreLabel;
    
    private Qa qa;
    
    public AnswerPanel()
    {
        RoundedBorder border = new RoundedBorder(Color.red, 3);
        setBorder(border);
        setBackground( Color.blue );
        setForeground( Color.white );
        setLayout(new BorderLayout());
        textLabel = new JLabel();
        add(textLabel, BorderLayout.CENTER);
        
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false);
        add(topPanel, BorderLayout.NORTH);
        
        imageLabel = new JLabel();
        imageLabel.setBorder(BorderFactory.createEmptyBorder(40,25,5,25));
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);        
        topPanel.add(imageLabel, BorderLayout.NORTH);
        
        qLabel = new JLabel();
        topPanel.add(qLabel, BorderLayout.CENTER);
        qLabel.setBorder(BorderFactory.createEmptyBorder(30,5,20,5));
        
        qLabel.setFont(new Font("Helvetica", Font.BOLD, 30));
        qLabel.setHorizontalAlignment(SwingConstants.CENTER);
        qLabel.setForeground( Color.yellow );
        
        textLabel.setFont(new Font("Helvetica", Font.BOLD, 42));
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);
        textLabel.setForeground( Color.white );
        textLabel.setBorder(BorderFactory.createEmptyBorder(5,25,5,25));
        
        scoreLabel = new JLabel();
        add(scoreLabel, BorderLayout.SOUTH);
        scoreLabel.setFont(new Font("Helvetica", Font.BOLD, 30));
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //scoreLabel.setBackground(Color.white);
        scoreLabel.setForeground( Color.yellow );
        scoreLabel.setBorder(BorderFactory.createEmptyBorder(30,5,20,5));
    }
    
    
    public void setAnswer(final Qa qa)
    {
        this.qa = qa;
        qLabel.setText("<html><center>" + qa.getQuestion() + "</center></html>");
        textLabel.setText("<html><center>" + qa.getAnswer() + "</center></html>");
        
        if (qa.getAudioclip() != null)
            textLabel.setFont(new Font("Helvetica", Font.BOLD, 28));
        else
            textLabel.setFont(new Font("Helvetica", Font.BOLD, 42));

        imageLabel.setIcon(null);
        if ( qa.getImage()!= null )
        {
            ImageIcon icon = new ImageIcon(QuizGame.getInstance().getAbsolutePath(qa.getImage()));
            imageLabel.setIcon(icon);
        }        
        /*
        if (qa.getAudioclip() != null)
        {
            Audioclip clip = qa.getAudioclip();
            String audioFile = QuizGame.getInstance().getAbsolutePath(clip.getFile());
            try {
                MIDIPlayer.getInstance().play(audioFile, 0L, 0L, 2*MIDIPlayer.MICROSEC, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } */
   
    }
    
    public void setScoreStatus(String status)
    {
        scoreLabel.setText(status);
    }
    
    public void aboutToSwitch()
    {
        if (qa.getAudioclip() != null)
        {
            MIDIPlayer.getInstance().stop();
        }
    }

    /**
     * 
     */
    public void stopAudio() 
    {
        MIDIPlayer.getInstance().stop();
    }
}
