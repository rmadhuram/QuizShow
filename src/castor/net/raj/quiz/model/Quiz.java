/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.5.3</a>, using an XML
 * Schema.
 * $Id$
 */

package net.raj.quiz.model;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Vector;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * Class Quiz.
 * 
 * @version $Revision$ $Date$
 */
public class Quiz implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _roundList
     */
    private java.util.Vector _roundList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Quiz() {
        super();
        _roundList = new Vector();
    } //-- net.raj.quiz.model.Quiz()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addRound
     * 
     * @param vRound
     */
    public void addRound(net.raj.quiz.model.Round vRound)
        throws java.lang.IndexOutOfBoundsException
    {
        _roundList.addElement(vRound);
    } //-- void addRound(net.raj.quiz.model.Round) 

    /**
     * Method addRound
     * 
     * @param index
     * @param vRound
     */
    public void addRound(int index, net.raj.quiz.model.Round vRound)
        throws java.lang.IndexOutOfBoundsException
    {
        _roundList.insertElementAt(vRound, index);
    } //-- void addRound(int, net.raj.quiz.model.Round) 

    /**
     * Method enumerateRound
     */
    public java.util.Enumeration enumerateRound()
    {
        return _roundList.elements();
    } //-- java.util.Enumeration enumerateRound() 

    /**
     * Method getRound
     * 
     * @param index
     */
    public net.raj.quiz.model.Round getRound(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _roundList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (net.raj.quiz.model.Round) _roundList.elementAt(index);
    } //-- net.raj.quiz.model.Round getRound(int) 

    /**
     * Method getRound
     */
    public net.raj.quiz.model.Round[] getRound()
    {
        int size = _roundList.size();
        net.raj.quiz.model.Round[] mArray = new net.raj.quiz.model.Round[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (net.raj.quiz.model.Round) _roundList.elementAt(index);
        }
        return mArray;
    } //-- net.raj.quiz.model.Round[] getRound() 

    /**
     * Method getRoundCount
     */
    public int getRoundCount()
    {
        return _roundList.size();
    } //-- int getRoundCount() 

    /**
     * Method isValid
     */
    public boolean isValid()
    {
        try {
            validate();
        }
        catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    } //-- boolean isValid() 

    /**
     * Method marshal
     * 
     * @param out
     */
    public void marshal(java.io.Writer out)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, out);
    } //-- void marshal(java.io.Writer) 

    /**
     * Method marshal
     * 
     * @param handler
     */
    public void marshal(org.xml.sax.ContentHandler handler)
        throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, handler);
    } //-- void marshal(org.xml.sax.ContentHandler) 

    /**
     * Method removeAllRound
     */
    public void removeAllRound()
    {
        _roundList.removeAllElements();
    } //-- void removeAllRound() 

    /**
     * Method removeRound
     * 
     * @param index
     */
    public net.raj.quiz.model.Round removeRound(int index)
    {
        java.lang.Object obj = _roundList.elementAt(index);
        _roundList.removeElementAt(index);
        return (net.raj.quiz.model.Round) obj;
    } //-- net.raj.quiz.model.Round removeRound(int) 

    /**
     * Method setRound
     * 
     * @param index
     * @param vRound
     */
    public void setRound(int index, net.raj.quiz.model.Round vRound)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _roundList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _roundList.setElementAt(vRound, index);
    } //-- void setRound(int, net.raj.quiz.model.Round) 

    /**
     * Method setRound
     * 
     * @param roundArray
     */
    public void setRound(net.raj.quiz.model.Round[] roundArray)
    {
        //-- copy array
        _roundList.removeAllElements();
        for (int i = 0; i < roundArray.length; i++) {
            _roundList.addElement(roundArray[i]);
        }
    } //-- void setRound(net.raj.quiz.model.Round) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static java.lang.Object unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (net.raj.quiz.model.Quiz) Unmarshaller.unmarshal(net.raj.quiz.model.Quiz.class, reader);
    } //-- java.lang.Object unmarshal(java.io.Reader) 

    /**
     * Method validate
     */
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
