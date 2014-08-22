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
 * Class Audioclip.
 * 
 * @version $Revision$ $Date$
 */
public class Audioclip implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _file
     */
    private java.lang.String _file;

    /**
     * Field _leadtime
     */
    private int _leadtime = 0;

    /**
     * keeps track of state for field: _leadtime
     */
    private boolean _has_leadtime;

    /**
     * Field _startTime
     */
    private int _startTime;

    /**
     * keeps track of state for field: _startTime
     */
    private boolean _has_startTime;

    /**
     * Field _endTime
     */
    private int _endTime;

    /**
     * keeps track of state for field: _endTime
     */
    private boolean _has_endTime;


      //----------------/
     //- Constructors -/
    //----------------/

    public Audioclip() {
        super();
    } //-- net.raj.quiz.model.Audioclip()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method deleteEndTime
     */
    public void deleteEndTime()
    {
        this._has_endTime= false;
    } //-- void deleteEndTime() 

    /**
     * Method deleteLeadtime
     */
    public void deleteLeadtime()
    {
        this._has_leadtime= false;
    } //-- void deleteLeadtime() 

    /**
     * Method deleteStartTime
     */
    public void deleteStartTime()
    {
        this._has_startTime= false;
    } //-- void deleteStartTime() 

    /**
     * Returns the value of field 'endTime'.
     * 
     * @return the value of field 'endTime'.
     */
    public int getEndTime()
    {
        return this._endTime;
    } //-- int getEndTime() 

    /**
     * Returns the value of field 'file'.
     * 
     * @return the value of field 'file'.
     */
    public java.lang.String getFile()
    {
        return this._file;
    } //-- java.lang.String getFile() 

    /**
     * Returns the value of field 'leadtime'.
     * 
     * @return the value of field 'leadtime'.
     */
    public int getLeadtime()
    {
        return this._leadtime;
    } //-- int getLeadtime() 

    /**
     * Returns the value of field 'startTime'.
     * 
     * @return the value of field 'startTime'.
     */
    public int getStartTime()
    {
        return this._startTime;
    } //-- int getStartTime() 

    /**
     * Method hasEndTime
     */
    public boolean hasEndTime()
    {
        return this._has_endTime;
    } //-- boolean hasEndTime() 

    /**
     * Method hasLeadtime
     */
    public boolean hasLeadtime()
    {
        return this._has_leadtime;
    } //-- boolean hasLeadtime() 

    /**
     * Method hasStartTime
     */
    public boolean hasStartTime()
    {
        return this._has_startTime;
    } //-- boolean hasStartTime() 

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
     * Sets the value of field 'endTime'.
     * 
     * @param endTime the value of field 'endTime'.
     */
    public void setEndTime(int endTime)
    {
        this._endTime = endTime;
        this._has_endTime = true;
    } //-- void setEndTime(int) 

    /**
     * Sets the value of field 'file'.
     * 
     * @param file the value of field 'file'.
     */
    public void setFile(java.lang.String file)
    {
        this._file = file;
    } //-- void setFile(java.lang.String) 

    /**
     * Sets the value of field 'leadtime'.
     * 
     * @param leadtime the value of field 'leadtime'.
     */
    public void setLeadtime(int leadtime)
    {
        this._leadtime = leadtime;
        this._has_leadtime = true;
    } //-- void setLeadtime(int) 

    /**
     * Sets the value of field 'startTime'.
     * 
     * @param startTime the value of field 'startTime'.
     */
    public void setStartTime(int startTime)
    {
        this._startTime = startTime;
        this._has_startTime = true;
    } //-- void setStartTime(int) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static java.lang.Object unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (net.raj.quiz.model.Audioclip) Unmarshaller.unmarshal(net.raj.quiz.model.Audioclip.class, reader);
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
