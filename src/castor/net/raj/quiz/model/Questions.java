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
 * Class Questions.
 * 
 * @version $Revision$ $Date$
 */
public class Questions implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _qaList
     */
    private java.util.Vector _qaList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Questions() {
        super();
        _qaList = new Vector();
    } //-- net.raj.quiz.model.Questions()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addQa
     * 
     * @param vQa
     */
    public void addQa(net.raj.quiz.model.Qa vQa)
        throws java.lang.IndexOutOfBoundsException
    {
        _qaList.addElement(vQa);
    } //-- void addQa(net.raj.quiz.model.Qa) 

    /**
     * Method addQa
     * 
     * @param index
     * @param vQa
     */
    public void addQa(int index, net.raj.quiz.model.Qa vQa)
        throws java.lang.IndexOutOfBoundsException
    {
        _qaList.insertElementAt(vQa, index);
    } //-- void addQa(int, net.raj.quiz.model.Qa) 

    /**
     * Method enumerateQa
     */
    public java.util.Enumeration enumerateQa()
    {
        return _qaList.elements();
    } //-- java.util.Enumeration enumerateQa() 

    /**
     * Method getQa
     * 
     * @param index
     */
    public net.raj.quiz.model.Qa getQa(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _qaList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (net.raj.quiz.model.Qa) _qaList.elementAt(index);
    } //-- net.raj.quiz.model.Qa getQa(int) 

    /**
     * Method getQa
     */
    public net.raj.quiz.model.Qa[] getQa()
    {
        int size = _qaList.size();
        net.raj.quiz.model.Qa[] mArray = new net.raj.quiz.model.Qa[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (net.raj.quiz.model.Qa) _qaList.elementAt(index);
        }
        return mArray;
    } //-- net.raj.quiz.model.Qa[] getQa() 

    /**
     * Method getQaCount
     */
    public int getQaCount()
    {
        return _qaList.size();
    } //-- int getQaCount() 

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
     * Method removeAllQa
     */
    public void removeAllQa()
    {
        _qaList.removeAllElements();
    } //-- void removeAllQa() 

    /**
     * Method removeQa
     * 
     * @param index
     */
    public net.raj.quiz.model.Qa removeQa(int index)
    {
        java.lang.Object obj = _qaList.elementAt(index);
        _qaList.removeElementAt(index);
        return (net.raj.quiz.model.Qa) obj;
    } //-- net.raj.quiz.model.Qa removeQa(int) 

    /**
     * Method setQa
     * 
     * @param index
     * @param vQa
     */
    public void setQa(int index, net.raj.quiz.model.Qa vQa)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _qaList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _qaList.setElementAt(vQa, index);
    } //-- void setQa(int, net.raj.quiz.model.Qa) 

    /**
     * Method setQa
     * 
     * @param qaArray
     */
    public void setQa(net.raj.quiz.model.Qa[] qaArray)
    {
        //-- copy array
        _qaList.removeAllElements();
        for (int i = 0; i < qaArray.length; i++) {
            _qaList.addElement(qaArray[i]);
        }
    } //-- void setQa(net.raj.quiz.model.Qa) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static java.lang.Object unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (net.raj.quiz.model.Questions) Unmarshaller.unmarshal(net.raj.quiz.model.Questions.class, reader);
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
