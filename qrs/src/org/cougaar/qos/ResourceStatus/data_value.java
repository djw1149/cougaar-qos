package org.cougaar.qos.ResourceStatus;


/**
* org/cougaar/qos/ResourceStatus/data_value.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from qrs.idl
* Tuesday, August 7, 2007 11:57:30 AM EDT
*/

public final class data_value implements org.omg.CORBA.portable.IDLEntity
{
  /**
    * 
    */
   private static final long serialVersionUID = 1L;
private double ___d_value;
  private String ___s_value;
  private boolean ___b_value;
  private org.cougaar.qos.ResourceStatus.data_types __discriminator;
  private boolean __uninitialized = true;

  public data_value ()
  {
  }

  public org.cougaar.qos.ResourceStatus.data_types discriminator ()
  {
    if (__uninitialized)
      throw new org.omg.CORBA.BAD_OPERATION ();
    return __discriminator;
  }

  public double d_value ()
  {
    if (__uninitialized)
      throw new org.omg.CORBA.BAD_OPERATION ();
    verifyd_value (__discriminator);
    return ___d_value;
  }

  public void d_value (double value)
  {
    __discriminator = org.cougaar.qos.ResourceStatus.data_types.number_data;
    ___d_value = value;
    __uninitialized = false;
  }

  public void d_value (org.cougaar.qos.ResourceStatus.data_types discriminator, double value)
  {
    verifyd_value (discriminator);
    __discriminator = discriminator;
    ___d_value = value;
    __uninitialized = false;
  }

  private void verifyd_value (org.cougaar.qos.ResourceStatus.data_types discriminator)
  {
    if (discriminator != org.cougaar.qos.ResourceStatus.data_types.number_data)
      throw new org.omg.CORBA.BAD_OPERATION ();
  }

  public String s_value ()
  {
    if (__uninitialized)
      throw new org.omg.CORBA.BAD_OPERATION ();
    verifys_value (__discriminator);
    return ___s_value;
  }

  public void s_value (String value)
  {
    __discriminator = org.cougaar.qos.ResourceStatus.data_types.string_data;
    ___s_value = value;
    __uninitialized = false;
  }

  public void s_value (org.cougaar.qos.ResourceStatus.data_types discriminator, String value)
  {
    verifys_value (discriminator);
    __discriminator = discriminator;
    ___s_value = value;
    __uninitialized = false;
  }

  private void verifys_value (org.cougaar.qos.ResourceStatus.data_types discriminator)
  {
    if (discriminator != org.cougaar.qos.ResourceStatus.data_types.string_data)
      throw new org.omg.CORBA.BAD_OPERATION ();
  }

  public boolean b_value ()
  {
    if (__uninitialized)
      throw new org.omg.CORBA.BAD_OPERATION ();
    verifyb_value (__discriminator);
    return ___b_value;
  }

  public void b_value (boolean value)
  {
    __discriminator = org.cougaar.qos.ResourceStatus.data_types.boolean_data;
    ___b_value = value;
    __uninitialized = false;
  }

  public void b_value (org.cougaar.qos.ResourceStatus.data_types discriminator, boolean value)
  {
    verifyb_value (discriminator);
    __discriminator = discriminator;
    ___b_value = value;
    __uninitialized = false;
  }

  private void verifyb_value (org.cougaar.qos.ResourceStatus.data_types discriminator)
  {
    if (discriminator != org.cougaar.qos.ResourceStatus.data_types.boolean_data)
      throw new org.omg.CORBA.BAD_OPERATION ();
  }

} // class data_value
