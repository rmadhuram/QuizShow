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
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * Class Qa.
 * 
 * @version $Revision$ $Date$
 */
public class Qa implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _image
     */
    private java.lang.String _image;

    /**
     * Field _question
     */
    private java.lang.String _question;

    /**
     * Field _answer
     */
    private java.lang.String _answer;

    /**
     * Field _audioclip
     */
    private net.raj.quiz.model.Audioclip _audioclip;

    /**
     * Field _masterNotes
     */
    private java.lang.String _masterNotes;


      //----------------/
     //- Constructors -/
    //----------------/

    public Qa() {
        super();
    } //-- net.raj.quiz.model.Qa()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'answer'.
     * 
     * @return the value of field 'answer'.
     */
    public java.lang.String getAnswer()
    {
        return this._answer;
    } //-- java.lang.String getAnswer() 

    /**
     * Returns the value of field 'audioclip'.
     * 
     * @return the value of field 'audioclip'.
     */
    public net.raj.quiz.model.Audioclip getAudioclip()
    {
        return this._audioclip;
    } //-- net.raj.quiz.model.Audioclip getAudioclip() 

    /**
     * Returns the value of field 'image'.
     * 
     * @return the value of field 'image'.
     */
    public java.lang.String getImage()
    {
        return this._image;
    } //-- java.lang.String getImage() 

    /**
     * Returns the value of field 'masterNotes'.
     * 
     * @return the value of field 'masterNotes'.
     */
    public java.lang.String getMasterNotes()
    {
        return this._masterNotes;
    } //-- java.lang.String getMasterNotes() 

    /**
     * Returns the value of field 'question'.
     * 
     * @return the value of field 'question'.
     */
    public java.lang.String getQuestion()
    {
        return this._question;
    } //-- java.lang.String getQuestion() 

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
     * Sets the value of field 'answer'.
     * 
     * @param answer the value of field 'answer'.
     */
    public void setAnswer(java.lang.String answer)
    {
        this._answer = answer;
    } //-- void setAnswer(java.lang.String) 

    /**
     * Sets the value of field 'audioclip'.
     * 
     * @param audioclip the value of field 'audioclip'.
     */
    public void setAudioclip(net.raj.quiz.model.Audioclip audioclip)
    {
        this._audioclip = audioclip;
    } //-- void setAudioclip(net.raj.quiz.model.Audioclip) 

    /**
     * Sets the value of field 'image'.
     * 
     * @param image the value of field 'image'.
     */
    public void setImage(java.lang.String image)
    {
        this._image = image;
    } //-- void setImage(java.lang.String) 

    /**
     * Sets the value of field 'masterNotes'.
     * 
     * @param masterNotes the value of field 'masterNotes'.
     */
    public void setMasterNotes(java.lang.String masterNotes)
    {
        this._masterNotes = masterNotes;
    } //-- void setMasterNotes(java.lang.String) 

    /**
     * Sets the value of field 'question'.
     * 
     * @param question the value of field 'question'.
     */
    public void setQuestion(java.lang.String question)
    {
        this._question = question;
    } //-- void setQuestion(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static java.lang.Object unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (net.raj.quiz.model.Qa) Unmarshaller.unmarshal(net.raj.quiz.model.Qa.class, reader);
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
