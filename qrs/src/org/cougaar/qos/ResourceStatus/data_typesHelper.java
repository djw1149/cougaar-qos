package org.cougaar.qos.ResourceStatus;


/**
* org/cougaar/qos/ResourceStatus/data_typesHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from qrs.idl
* Tuesday, August 7, 2007 11:57:30 AM EDT
*/


// a data_value (DataValue).
abstract public class data_typesHelper
{
  private static String  _id = "IDL:org/cougaar/qos/ResourceStatus/data_types:1.0";

  public static void insert (org.omg.CORBA.Any a, org.cougaar.qos.ResourceStatus.data_types that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static org.cougaar.qos.ResourceStatus.data_types extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_enum_tc (org.cougaar.qos.ResourceStatus.data_typesHelper.id (), "data_types", new String[] { "number_data", "string_data", "boolean_data"} );
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static org.cougaar.qos.ResourceStatus.data_types read (org.omg.CORBA.portable.InputStream istream)
  {
    return org.cougaar.qos.ResourceStatus.data_types.from_int (istream.read_long ());
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, org.cougaar.qos.ResourceStatus.data_types value)
  {
    ostream.write_long (value.value ());
  }

}
