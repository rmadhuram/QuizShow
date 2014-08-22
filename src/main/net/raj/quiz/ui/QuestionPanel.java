/*
 * Created on May 5, 2005
 * Rajkumar Madhuram
 */
 
package net.raj.quiz.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.sound.midi.Sequencer;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import net.raj.quiz.QuizGame;
import net.raj.quiz.model.Audioclip;
import net.raj.quiz.model.Qa;
import net.raj.quiz.sound.MIDIPlayer;

/**
 * @author Rajkumar
 */
public class QuestionPanel extends JPanel 
{
    private JLabel imageLabel;
    private JLabel textLabel;
    private JProgressBar progressBar;
    private JLabel pointsAvail;
    private int points;
    private boolean stopped;
    private Sequencer sequencer;
    private int timeRemaining;
    
    
    public QuestionPanel()
    {
        final Font boldFont = new Font("Helvetica", Font.BOLD, 42);
        final Font boldFont1 = new Font("Helvetica", Font.BOLD, 34);
        timeRemaining = 60;
        RoundedBorder border = new RoundedBorder(Color.red, 3);
        //setBorder(BorderFactory.createCompoundBorder(
        //        BorderFactory.createEmptyBorder(3,3,3,3), border)
        //        );
        setBackground( Color.blue );
        setForeground( Color.white );
        setLayout(new BorderLayout());
        
        imageLabel = new JLabel();
        add(imageLabel, BorderLayout.NORTH);
        imageLabel.setBorder(BorderFactory.createEmptyBorder(40,25,5,25));
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        textLabel = new JLabel();
        add(textLabel, BorderLayout.CENTER);
        textLabel.setFont(boldFont);
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);
        textLabel.setBorder(BorderFactory.createEmptyBorder(5,25,5,25));
        textLabel.setForeground( Color.white );
        
        
        Color darkColor = new Color(128,80,255);
        GradientPanel bottomPanel = new GradientPanel(darkColor, Color.white);  
        bottomPanel.setLayout(new BorderLayout());
        //JPanel bottomPanel = new JPanel(new BorderLayout());
        
        //Color bottomColor = new Color(240,240,100);
        //bottomPanel.setBackground(bottomColor);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
        progressBar = new JProgressBar(0,60) {
           /* (non-Javadoc)
          * @see javax.swing.JComponent#paint(java.awt.Graphics)
          */
         public void paint(Graphics g) {
            // TODO Auto-generated method stub
            super.paint(g);
            g.setColor(Color.black);
            g.setFont(boldFont1);
            g.drawString(timeRemaining+"", 120, 40);
         }
        };
        
        progressBar.setBorderPainted(true);
        progressBar.setBorder(
                BorderFactory.createCompoundBorder( 
                        BorderFactory.createEmptyBorder(10,60,10,20),
                        BorderFactory.createLineBorder(Color.black))
                );
        progressBar.setForeground(Color.green);
        progressBar.setOpaque(false);
        //progressBar.setBackground(Color.black);
        progressBar.setPreferredSize(new Dimension(300,25));
        progressBar.setMaximumSize(new Dimension(300,25));
        progressBar.setStringPainted(false);
        
        bottomPanel.add(progressBar, BorderLayout.WEST);
        
        pointsAvail = new JLabel();
        bottomPanel.add(pointsAvail, BorderLayout.EAST);
        pointsAvail.setFont(new Font("Helvetica", Font.BOLD, 42));
        
        add(bottomPanel, BorderLayout.SOUTH);
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
    
    public void setQuestion(final Qa question, int startAfter, final int maxPoints)
    {
        timeRemaining = 60;
        progressBar.setForeground(Color.green);
        
        repaint();
        imageLabel.setIcon(null);
        if ( question.getImage()!= null )
        {
            ImageIcon icon = new ImageIcon(QuizGame.getInstance().getAbsolutePath(question.getImage()));
            imageLabel.setIcon(icon);
        }
        textLabel.setText("<html><center>" + question.getQuestion() + "</center></html>");
        progressBar.setValue(60);
        pointsAvail.setText(maxPoints + "");
        points = maxPoints;
        stopped = false;
        
        final int startTime = startAfter;
        
        Thread timerThread = new Thread() 
        {
            /* (non-Javadoc)
             * @see java.lang.Thread#run()
             */
            public void run() 
            {
                int points = maxPoints;
                try 
                {
                    
                    if (question.getAudioclip() != null)
                    {
                        Audioclip clip = question.getAudioclip();
                        String audioFile = QuizGame.getInstance().getAbsolutePath(clip.getFile());
                        MIDIPlayer.getInstance().play(audioFile, 
                                clip.getStartTime()*MIDIPlayer.MICROSEC, 
                                clip.getEndTime()*MIDIPlayer.MICROSEC, 
                                3*MIDIPlayer.MICROSEC,  true);
                    }
                    
                    Thread.sleep(startTime * 1000);
                    for (int i=0; i<61; i++)
                    {
                        timeRemaining = 60-i;
                        if ( stopped )
                            return;
                        
                        progressBar.setValue(60-i);
                        progressBar.setString("" + (60-i));
                        Thread.sleep(1000);
                        
                        if ( i == 15 )
                            setPointsFraction(maxPoints, 0.8);
                            
                        else if ( i == 30 )
                        {
                            setPointsFraction(maxPoints, 0.6);    
                            progressBar.setForeground(Color.orange);
                        }
                          
                        else if ( i == 45 )
                        {
                            setPointsFraction(maxPoints, 0.4); 
                            progressBar.setForeground(Color.red);
                        }
    
                    }
                    
                    setPointsFraction(maxPoints, 0.0);   
                    progressBar.setValue(0);
                    progressBar.setString("0");
                    
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
    
        };
        
        timerThread.start();
    }
    
    public void stop()
    {
        stopped = true;
        //MIDIPlayer.getInstance().stop();
    }
    
    private void setPointsFraction(int max, double frac)
    {
        points = (int) (frac*max);
        pointsAvail.setText(points +"");
    }
    
    public int getPoints()
    {
        return points;
    }

    /**
     * 
     */
    public void stopAudio() 
    {
        MIDIPlayer.getInstance().stop();
    }
    
}
