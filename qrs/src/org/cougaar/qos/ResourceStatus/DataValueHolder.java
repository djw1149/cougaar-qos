package org.cougaar.qos.ResourceStatus;

/**
* org/cougaar/qos/ResourceStatus/DataValueHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from qrs.idl
* Tuesday, August 7, 2007 11:57:30 AM EDT
*/

public final class DataValueHolder implements org.omg.CORBA.portable.Streamable
{
  public org.cougaar.qos.ResourceStatus.DataValue value = null;

  public DataValueHolder ()
  {
  }

  public DataValueHolder (org.cougaar.qos.ResourceStatus.DataValue initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = org.cougaar.qos.ResourceStatus.DataValueHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    org.cougaar.qos.ResourceStatus.DataValueHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return org.cougaar.qos.ResourceStatus.DataValueHelper.type ();
  }

}