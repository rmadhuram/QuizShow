/*
 * Created on Aug 5, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package net.raj.quiz.sound;

import java.io.File;
import java.util.HashMap;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

/**
 * @author rmadhuram
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class MIDIPlayer 
{
    public static long MICROSEC = 1000000L;
    private static MIDIPlayer _instance = new MIDIPlayer();
    private HashMap sequenceMap;
    private boolean stopped;
    private boolean isPlaying;
    
    public static MIDIPlayer getInstance()
    {
        return _instance;
    }
    
    protected MIDIPlayer()
    {
        sequenceMap = new HashMap();
        isPlaying = false;
    }
    
    public void play(String fileName) throws Exception
    {
        play(fileName, 0L, 0L, 0L, false);
    }
    
    public void play(final String fileName, final long startTime, final long endTime, final long leadTime, final boolean shouldLoop) throws Exception
    {    
        new Thread()
        {
            /* (non-Javadoc)
             * @see java.lang.Thread#run()
             */
            public void run() {
                try {
                    Thread.sleep(leadTime/1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                try {
                    play(fileName, startTime, endTime, shouldLoop);
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }.start();
    }
    
    public void play(String fileName, final long startTime, final long endTime, final boolean shouldLoop) throws Exception
    {
        if (isPlaying)
        {
            return;
        }
        isPlaying = true;
        
        stopped = false;
        Sequence seq = MidiSystem.getSequence(new File(fileName));
            
        final Sequencer sequencer = MidiSystem.getSequencer();
        sequencer.open();
        sequencer.setSequence(seq);
        sequencer.start();
        sequencer.stop();
        
        new Thread() {
            /* (non-Javadoc)
             * @see java.lang.Thread#run()
             */
            public void run() 
            {
                if (sequencer.isRunning())
                    sequencer.stop();  // safety net
                
                sequencer.setMicrosecondPosition(startTime);
                sequencer.start();
                long delta = (endTime-startTime)/1000L;
                long beginTime = System.currentTimeMillis();
                while (!stopped)
                {
                    long currentTime = System.currentTimeMillis();
                    if ( shouldLoop && endTime > 0 && currentTime - beginTime > delta )
                    {
                        sequencer.stop();
                        // pause 2s before playing again
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) 
                        {
                            e.printStackTrace();
                        }                        
                        sequencer.setMicrosecondPosition(startTime);
                        sequencer.start();
                        beginTime = System.currentTimeMillis();
                    }
                    // courtesy sleep
                    try 
                    {
                        Thread.sleep(250);
                    } catch (InterruptedException e) 
                    {
                        e.printStackTrace();
                    }
                    if (!sequencer.isRunning())
                        stopped = true;
                }
                sequencer.stop();
                isPlaying = false;
            }
        }.start();

    }
    
    public void stop()
    {
        stopped = true;
    }
    
    public static void main(String args[])
    {
        try {
            MIDIPlayer.getInstance().play("C:/raj/projects/QuizShow/data/quiz02/sounds/contemp/amazinglove.mid", 40*MICROSEC, 60*MICROSEC, 2*MICROSEC, true );
            //MIDIPlayer.getInstance().play("C:/rajkumar/projects/QuizShow/data/quiz02/sounds/contemp/blessedbeyourname.mid", 115*MICROSEC, 135*MICROSEC, true );
            //MIDIPlayer.getInstance().play("C:/rajkumar/projects/QuizShow/data/quiz02/sounds/contemp/majesty2.mid", 25*MICROSEC, 45*MICROSEC, true );
            //MIDIPlayer.getInstance().play("C:/rajkumar/projects/QuizShow/data/quiz02/sounds/contemp/my_life_is_in_you.mid", 20*MICROSEC, 40*MICROSEC, true );
            //MIDIPlayer.getInstance().play("C:/rajkumar/projects/QuizShow/data/quiz02/sounds/contemp/MAKEMESV.mid", 20*MICROSEC, 40*MICROSEC, true ); 
            //MIDIPlayer.getInstance().play("C:/raj/projects/QuizShow/data/quiz02/sounds/contemp/MAKEMESV.mid", 120*MICROSEC, 0, false ); 
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
