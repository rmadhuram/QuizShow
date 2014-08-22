
package net.raj.quiz;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import net.raj.quiz.model.Quiz;
import net.raj.quiz.ui.QuizFrame;
import net.raj.quiz.ui.WelcomeScreen;

import org.exolab.castor.xml.Unmarshaller;
import org.mortbay.http.handler.ResourceHandler;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.ServletHttpContext;

/**
 * @author Rajkumar
 */
public class QuizGame 
{
	private static QuizGame _instance;
	private StateMachine stateMachine;
	private Quiz quiz;
	private QuizFrame quizFrame;
    private String baseDir;
    private static String QUIZ_FILE = "quiz.xml";
	
	public static QuizGame getInstance()
	{
		if (_instance == null)
			_instance = new QuizGame();
		
		return _instance;
	}
   
    private void selectQuiz()
    {
       File f = new File("data");
      
       if (!f.exists())
       {
          System.out.println("Error: Could not find data/ directory!");
          System.exit(-1);
       }
       
       File dirs[] = f.listFiles(new FileFilter() {
          /* (non-Javadoc)
          * @see java.io.FileFilter#accept(java.io.File)
          */
         public boolean accept(File path) {
            return path.isDirectory();
         }
       });
       
       if (dirs.length == 0)
       {
          System.out.println("Error: Could not find data/ directory!");
          System.exit(-1);
       }       
       
       JFrame frame = new JFrame();
       File selected = (File)JOptionPane.showInputDialog(
             frame,
             "Select quiz to play:\n",
             "Select quiz",
             JOptionPane.PLAIN_MESSAGE,
             null,
             dirs,
             "ham");
       setBaseDir(selected.getAbsolutePath());
      //System.out.println(selected); 

    }
	
	private void initQuestions()
	{
		quiz = null;
	    Unmarshaller reader = new Unmarshaller(Quiz.class);
	    try
	    {
	    	quiz = (Quiz) reader.unmarshal(new FileReader(getAbsolutePath(QUIZ_FILE)));
	    } catch ( Exception ex )
	    {
	       // log here!
	       ex.printStackTrace();
	    }		
	}
	
	private void startServer() throws Exception
	{
        stateMachine = new StateMachine("start", 0);
		//stateMachine = new StateMachine("sections");
		Server server = new Server();
		server.addListener(":8000");
		ServletHttpContext context = (ServletHttpContext)
		    server.getContext("/");
		context.addServlet("Dump","/dump/*",
		                   "org.mortbay.servlet.Dump");		
		context.addServlet("quiz","/quiz/*",
        "net.raj.quiz.servlets.QuizServlet");	
		context.addServlet("JSP","*.jsp",
        "org.apache.jasper.servlet.JspServlet");

        //context.setResourceBase("C:/rajkumar/projects/QuizShow/web");
        File f = new File("web");
        if ( f.exists() && f.isDirectory())
           context.setResourceBase(f.getAbsolutePath());
        else
        {
           System.out.println("Error: Could not find web/ directory!");
           System.exit(-1);
        }
	    context.addHandler(new ResourceHandler());

		server.start();		
	}
	
	public StateMachine getStateMachine()
	{
		return stateMachine;
	}
	
	public Quiz getQuiz()
	{
		return quiz;
	}
	
	public void initUI()
	{
		quizFrame = new QuizFrame();
		//stateMachine.doTransition("showboard", null);
		quizFrame.setPanel(new WelcomeScreen());
		//quizFrame.setPanel(new GameBoard(quiz.getRound(0)));
	}
	
	public QuizFrame getQuizFrame()
	{
		return quizFrame;
	}
	
	public static void main(String[] args) throws Exception 
	{
        URL url = QuizGame.class.getResource("");
		QuizGame game = getInstance();
		game.selectQuiz();
        //game.setBaseDir("C:/raj/projects/QuizShow/data/quiz03");
        //game.setBaseDir("C:/rajkumar/projects/QuizShow/data/quiz02");
		game.initQuestions();
		game.startServer();
		game.initUI();
	}
    /**
     * @return Returns the baseDir.
     */
    public String getBaseDir() 
    {
        return baseDir;
    }
    
    public String getAbsolutePath(String relPath)
    {
        return getBaseDir() + File.separatorChar + relPath;
    }
    
    /**
     * @param baseDir The baseDir to set.
     */
    public void setBaseDir(String baseDir) 
    {
        this.baseDir = baseDir;
    }
}
