package org.cougaar.qos.ResourceStatus;


/**
* org/cougaar/qos/ResourceStatus/QualifierKind.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from qrs.idl
* Tuesday, August 7, 2007 11:57:30 AM EDT
*/


// Only a few kinds of qualifiers so far
public class QualifierKind implements org.omg.CORBA.portable.IDLEntity
{
  /**
    * 
    */
   private static final long serialVersionUID = 1L;
private        int __value;
  private static int __size = 6;
  private static org.cougaar.qos.ResourceStatus.QualifierKind[] __array = new org.cougaar.qos.ResourceStatus.QualifierKind [__size];

  public static final int _min_delta = 0;
  public static final org.cougaar.qos.ResourceStatus.QualifierKind min_delta = new org.cougaar.qos.ResourceStatus.QualifierKind(_min_delta);
  public static final int _min_credibility = 1;
  public static final org.cougaar.qos.ResourceStatus.QualifierKind min_credibility = new org.cougaar.qos.ResourceStatus.QualifierKind(_min_credibility);
  public static final int _exceeds_threshold = 2;
  public static final org.cougaar.qos.ResourceStatus.QualifierKind exceeds_threshold = new org.cougaar.qos.ResourceStatus.QualifierKind(_exceeds_threshold);
  public static final int _crosses_threshold = 3;
  public static final org.cougaar.qos.ResourceStatus.QualifierKind crosses_threshold = new org.cougaar.qos.ResourceStatus.QualifierKind(_crosses_threshold);
  public static final int _every = 4;
  public static final org.cougaar.qos.ResourceStatus.QualifierKind every = new org.cougaar.qos.ResourceStatus.QualifierKind(_every);
  public static final int _some = 5;
  public static final org.cougaar.qos.ResourceStatus.QualifierKind some = new org.cougaar.qos.ResourceStatus.QualifierKind(_some);

  public int value ()
  {
    return __value;
  }

  public static org.cougaar.qos.ResourceStatus.QualifierKind from_int (int value)
  {
    if (value >= 0 && value < __size)
      return __array[value];
    else
      throw new org.omg.CORBA.BAD_PARAM ();
  }

  protected QualifierKind (int value)
  {
    __value = value;
    __array[__value] = this;
  }
} // class QualifierKind
