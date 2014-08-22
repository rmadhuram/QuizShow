/*
 * Created on May 6, 2005
 */
 
package net.raj.quiz.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.border.LineBorder;

/**
 * @author Rajkumar
 */
public class RoundedBorder extends LineBorder {

    /**
     * @param color
     * @param thickness
     */
    public RoundedBorder(Color color, int thickness) {
        super(color, thickness);
        roundedCorners = true;
        // TODO Auto-generated constructor stub
    }
    


}
