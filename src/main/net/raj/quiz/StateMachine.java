/*
 * Created on Apr 23, 2005
 */
 
package net.raj.quiz;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JPanel;

import net.raj.quiz.model.Qa;
import net.raj.quiz.model.Quiz;
import net.raj.quiz.ui.AnswerPanel;
import net.raj.quiz.ui.GameBoard;
import net.raj.quiz.ui.QuestionPanel;
import net.raj.quiz.ui.SectionsPanel;

/**
 * @author Rajkumar
 */
public class StateMachine 
{
	public String currentState;
	public Hashtable views;
	private GameBoard gameBoard;
    private QuestionPanel questionPanel;
    private AnswerPanel answerPanel;
    private Qa currentQA;
    private int roundNum;
	
	public StateMachine(String initState, int roundNum)
	{
        this.roundNum = roundNum;
		currentState = initState;
		Quiz quiz = QuizGame.getInstance().getQuiz();
		gameBoard = new GameBoard(quiz.getRound(roundNum), 0, 0);
        questionPanel = new QuestionPanel();
        answerPanel = new AnswerPanel();
	}
	
	public JPanel getView(String state)
	{
		return null;
	}
    
    public Qa getCurrentQA()
    {
        return currentQA;
    }
	
	public String getCurrentJSP(HttpServletRequest req)
	{
		System.out.println("request");
		if ( currentState.equals("start"))
			return "/start.jsp";
		
		if ( currentState.equals("sections"))
			return "/sections.jsp";		
		
		if ( currentState.equals("board"))
        {
            if (gameBoard.isFinished())
                req.setAttribute("finished", "done");
            
            req.setAttribute("wagers", gameBoard.getWagers());
            req.setAttribute("quizObject",  QuizGame.getInstance().getQuiz());
            req.setAttribute("round",  QuizGame.getInstance().getQuiz().getRound(roundNum));
			return "/board.jsp";		
        }
		
		if ( currentState.equals("adjustscore"))
			return "/adjustscore.jsp";
            
        if ( currentState.equals("showingQuestion"))
            return "/questionDisplay.jsp";     
		
        if ( currentState.equals("pauseForAnswer"))
            return "/questionDisplay1.jsp";     
            
        if ( currentState.equals("showingAnswer"))
            return "/answerDisplay.jsp";                 
        
		return "/default.jsp";
	}
	
	public void doTransition(String event, HttpServletRequest req)
	{
		Quiz quiz = QuizGame.getInstance().getQuiz();
		if ( currentState.equals("start"))
		{
			if (event.equals("start"))
			{
				SectionsPanel sections = new SectionsPanel(quiz.getRound(roundNum));
				QuizGame.getInstance().getQuizFrame().setPanel(sections);
				currentState = "sections";
			}
		} else if ( currentState.equals("sections"))
		{
			if (event.equals("showboard"))
			{			
				QuizGame.getInstance().getQuizFrame().setPanel(gameBoard);
				currentState = "board";				
			}
		} else if ( currentState.equals("board"))
		{
			if (event.equals("adjustscore"))
			{			
				currentState = "adjustscore";				
			} else if (event.equals("showQuestion"))
            {
                String section = req.getParameter("section");
                String wager = req.getParameter("wager"); 
                
                int sectionId = Integer.parseInt(section);
                int seqNo = Integer.parseInt(wager);
                gameBoard.showQuestion( sectionId, seqNo );
                                        
                currentQA = quiz.getRound(roundNum).getSection(sectionId).getQuestions().getQa(seqNo);                                        
                questionPanel.setQuestion( currentQA, 3, (seqNo+1)*100 );
                
                QuizGame.getInstance().getQuizFrame().setPanel(questionPanel);
                currentState = "showingQuestion";
            } else if (event.equals("roundOver"))
            {

                roundNum++;
                if (quiz.getRoundCount() > roundNum)
                {
                    gameBoard = new GameBoard(quiz.getRound(roundNum), gameBoard.getScoreA(), gameBoard.getScoreB());
                    currentState = "start";
                    event = "start";                
                    doTransition(event, req);
                } else
                {
                    System.out.println("GAME OVER!");
                }
            }
            
		} else if ( currentState.equals("adjustscore"))
		{
			if (event.equals("adjust"))
			{
				String adjA = req.getParameter("scoreA");
				String adjB = req.getParameter("scoreB");
				int delA = 0;
                int delB = 0;
				if (!adjA.equals(""))
				    delA = Integer.parseInt(adjA);
                
				if (!adjB.equals(""))
                    delB = Integer.parseInt(adjB);
                
                gameBoard.adjustScores(delA, delB);
				currentState = "board";
			}
		} else if ( currentState.equals("showingQuestion"))
        {
            if (event.equals("stopAudio"))
            {
                questionPanel.stopAudio();
            } else
            {
                String option = req.getParameter("option");
                int delA = 0;
                int delB = 0;
                
                String nextState = "showingAnswer";
                questionPanel.stop();
                
                if ("A".equals(option))
                    delA = questionPanel.getPoints();
                    
                else if ("B".equals(option))
                    delB = questionPanel.getPoints();
                    
                else
                    nextState = "pauseForAnswer";
                    
                if ( "showingAnswer".equals(nextState) )
                {
                    answerPanel.setAnswer(currentQA);   
                    answerPanel.setScoreStatus("Team " + option + " scored " + (delA + delB) + "  points");
                    QuizGame.getInstance().getQuizFrame().setPanel(answerPanel);   
                }
                    
                gameBoard.adjustScores(delA, delB);      
                
                currentState = nextState;
            }
                  
        } else if ( currentState.equals("showingAnswer"))
        {
            
            if (event.equals("stopAudio"))
            {
                answerPanel.stopAudio();
            } else
            {
                answerPanel.stopAudio();
                QuizGame.getInstance().getQuizFrame().setPanel(gameBoard);
                currentState = "board";
            }
            
        } else if ( currentState.equals("pauseForAnswer"))
        {
            answerPanel.setAnswer(currentQA);  
            answerPanel.setScoreStatus("");
            QuizGame.getInstance().getQuizFrame().setPanel(answerPanel);   
            currentState = "showingAnswer";
        }
        
	}
}

