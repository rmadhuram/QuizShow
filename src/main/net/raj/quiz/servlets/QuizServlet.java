/*
 * Created on Apr 23, 2005
 */
 
package net.raj.quiz.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.raj.quiz.QuizGame;
import net.raj.quiz.StateMachine;

/**
 * @author Rajkumar
 */
public class QuizServlet extends HttpServlet 
{
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
    {
		StateMachine machine = QuizGame.getInstance().getStateMachine();
		String cmd = req.getParameter("quiz:command");
		System.out.println("command is "+ cmd);
		if (cmd != null)
		{
			QuizGame.getInstance().getStateMachine().doTransition(cmd, req);
		}
		ServletContext sc = getServletContext();
	    String jspPage = machine.getCurrentJSP(req);
		RequestDispatcher disp = sc.getRequestDispatcher(jspPage);
		disp.forward(req, resp);
	}
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(arg0, arg1);
	}
	
}
