package org.cougaar.qos.ResourceStatus;


/**
* org/cougaar/qos/ResourceStatus/BadAttributeValueException.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from qrs.idl
* Tuesday, August 7, 2007 11:57:30 AM EDT
*/

public final class BadAttributeValueException extends org.omg.CORBA.UserException
{
  /**
    * 
    */
   private static final long serialVersionUID = 1L;
public String attribute_name = null;

  public BadAttributeValueException ()
  {
    super(BadAttributeValueExceptionHelper.id());
  } // ctor

  public BadAttributeValueException (String _attribute_name)
  {
    super(BadAttributeValueExceptionHelper.id());
    attribute_name = _attribute_name;
  } // ctor


  public BadAttributeValueException (String $reason, String _attribute_name)
  {
    super(BadAttributeValueExceptionHelper.id() + "  " + $reason);
    attribute_name = _attribute_name;
  } // ctor

} // class BadAttributeValueException
