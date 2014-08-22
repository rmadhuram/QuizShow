/*
 * Created on Apr 29, 2005
 */
 
package net.raj.quiz.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * @author Rajkumar
 */
public class Score
{
	private int score;
	private PropertyChangeSupport prop;
	
	public Score(String id )
	{
		prop = new PropertyChangeSupport("");
	}
	/**
	 * @return Returns the score.
	 */
	public int getScore() 
	{
		return score;
	}
	/**
	 * @param score The score to set.
	 */
	public void setScore(int score) 
	{
		this.score = score;
		prop.firePropertyChange("score", null, new Integer(score));
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener)
	{
		prop.addPropertyChangeListener( listener );
	}
}
