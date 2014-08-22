import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.raj.quiz.model.Quiz;
import net.raj.quiz.model.Round;
import net.raj.quiz.model.Section;

import org.exolab.castor.xml.Unmarshaller;
import org.mortbay.http.SocketListener;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.ServletHttpContext;

/*
 * Created on Apr 21, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author Rajkumar
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TestQuestions extends JFrame
{
	
	public TestQuestions() throws Exception
	{
		  Quiz quiz = null;
	      Unmarshaller reader = new Unmarshaller(Quiz.class);
	      try
	      {
	      	quiz = (Quiz) reader.unmarshal(new FileReader("db/quiz.xml"));
	      } catch ( Exception ex )
	      {
	         // log here!
	         ex.printStackTrace();
	      }
	      		
		getContentPane().add(new SectionsPanel(quiz.getRound(0)));
		
		Server server = new Server();

		SocketListener listener = new SocketListener();
		listener.setHost("192.168.2.2");
		listener.setPort(8080);listener.setMinThreads(5);
		listener.setMaxThreads(250);
		server.addListener(listener);

		
		//server.addListener(":8080");
		ServletHttpContext context = (ServletHttpContext)
		    server.getContext("/");
		context.addServlet("Dump","/dump/*",
		                   "org.mortbay.servlet.Dump");		
		
		server.start();
	}
	
	class SectionsPanel extends JPanel
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
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		/* (non-Javadoc)
		 * @see javax.swing.JComponent#paint(java.awt.Graphics)
		 */
		public void paint(Graphics g) 
		{
			super.paint(g);
			
		}
	}
	
	private JPanel showSections()
	{
		JPanel panel = new JPanel();
		return panel;
	}
	
	public static void main(String[] args) throws Exception
	{


	      TestQuestions fr = new TestQuestions();
	      //fr.setSize(1024,768);
	      fr.setUndecorated(true);
	      fr.setVisible(true);
	      
	      GraphicsEnvironment.getLocalGraphicsEnvironment().
			getDefaultScreenDevice().setFullScreenWindow(fr);
	     
	}
}
