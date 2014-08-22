import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.swing.JPanel;

/*
 * Created on Aug 4, 2005
 */

/**
 * @author Rajkumar
 */
public class TestSound extends JPanel
{

    public static void main(String[] args) 
    {
        Sequencer sequencer = null;
        try {
            Sequence seq = MidiSystem.getSequence(new File("C:/raj/projects/QuizShow/data/quiz02/sounds/contemp/amazinglove.mid"));
            
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.setSequence(seq);
            
            sequencer.start();
            sequencer.stop();
            sequencer.setMicrosecondPosition(20*1000000L);
            sequencer.start();
            
        } catch (MidiUnavailableException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvalidMidiDataException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

    }
}
