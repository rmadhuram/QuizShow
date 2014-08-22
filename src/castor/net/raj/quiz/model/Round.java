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
 * Class Round.
 * 
 * @version $Revision$ $Date$
 */
public class Round implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _points
     */
    private net.raj.quiz.model.Points _points;

    /**
     * Field _sectionList
     */
    private java.util.Vector _sectionList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Round() {
        super();
        _sectionList = new Vector();
    } //-- net.raj.quiz.model.Round()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addSection
     * 
     * @param vSection
     */
    public void addSection(net.raj.quiz.model.Section vSection)
        throws java.lang.IndexOutOfBoundsException
    {
        _sectionList.addElement(vSection);
    } //-- void addSection(net.raj.quiz.model.Section) 

    /**
     * Method addSection
     * 
     * @param index
     * @param vSection
     */
    public void addSection(int index, net.raj.quiz.model.Section vSection)
        throws java.lang.IndexOutOfBoundsException
    {
        _sectionList.insertElementAt(vSection, index);
    } //-- void addSection(int, net.raj.quiz.model.Section) 

    /**
     * Method enumerateSection
     */
    public java.util.Enumeration enumerateSection()
    {
        return _sectionList.elements();
    } //-- java.util.Enumeration enumerateSection() 

    /**
     * Returns the value of field 'points'.
     * 
     * @return the value of field 'points'.
     */
    public net.raj.quiz.model.Points getPoints()
    {
        return this._points;
    } //-- net.raj.quiz.model.Points getPoints() 

    /**
     * Method getSection
     * 
     * @param index
     */
    public net.raj.quiz.model.Section getSection(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _sectionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (net.raj.quiz.model.Section) _sectionList.elementAt(index);
    } //-- net.raj.quiz.model.Section getSection(int) 

    /**
     * Method getSection
     */
    public net.raj.quiz.model.Section[] getSection()
    {
        int size = _sectionList.size();
        net.raj.quiz.model.Section[] mArray = new net.raj.quiz.model.Section[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (net.raj.quiz.model.Section) _sectionList.elementAt(index);
        }
        return mArray;
    } //-- net.raj.quiz.model.Section[] getSection() 

    /**
     * Method getSectionCount
     */
    public int getSectionCount()
    {
        return _sectionList.size();
    } //-- int getSectionCount() 

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
     * Method removeAllSection
     */
    public void removeAllSection()
    {
        _sectionList.removeAllElements();
    } //-- void removeAllSection() 

    /**
     * Method removeSection
     * 
     * @param index
     */
    public net.raj.quiz.model.Section removeSection(int index)
    {
        java.lang.Object obj = _sectionList.elementAt(index);
        _sectionList.removeElementAt(index);
        return (net.raj.quiz.model.Section) obj;
    } //-- net.raj.quiz.model.Section removeSection(int) 

    /**
     * Sets the value of field 'points'.
     * 
     * @param points the value of field 'points'.
     */
    public void setPoints(net.raj.quiz.model.Points points)
    {
        this._points = points;
    } //-- void setPoints(net.raj.quiz.model.Points) 

    /**
     * Method setSection
     * 
     * @param index
     * @param vSection
     */
    public void setSection(int index, net.raj.quiz.model.Section vSection)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _sectionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _sectionList.setElementAt(vSection, index);
    } //-- void setSection(int, net.raj.quiz.model.Section) 

    /**
     * Method setSection
     * 
     * @param sectionArray
     */
    public void setSection(net.raj.quiz.model.Section[] sectionArray)
    {
        //-- copy array
        _sectionList.removeAllElements();
        for (int i = 0; i < sectionArray.length; i++) {
            _sectionList.addElement(sectionArray[i]);
        }
    } //-- void setSection(net.raj.quiz.model.Section) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static java.lang.Object unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (net.raj.quiz.model.Round) Unmarshaller.unmarshal(net.raj.quiz.model.Round.class, reader);
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
