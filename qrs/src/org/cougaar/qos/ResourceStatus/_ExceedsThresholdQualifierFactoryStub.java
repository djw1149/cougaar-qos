package org.cougaar.qos.ResourceStatus;


/**
* org/cougaar/qos/ResourceStatus/_ExceedsThresholdQualifierFactoryStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from qrs.idl
* Tuesday, August 7, 2007 11:57:30 AM EDT
*/


// greater than the given threshold.
public class _ExceedsThresholdQualifierFactoryStub extends org.omg.CORBA.portable.ObjectImpl implements org.cougaar.qos.ResourceStatus.ExceedsThresholdQualifierFactory
{

  public org.cougaar.qos.ResourceStatus.Qualifier getQualifier (double threshold)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getQualifier", true);
                $out.write_double (threshold);
                $in = _invoke ($out);
                org.cougaar.qos.ResourceStatus.Qualifier $result = org.cougaar.qos.ResourceStatus.QualifierHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getQualifier (threshold        );
            } finally {
                _releaseReply ($in);
            }
  } // getQualifier

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:org/cougaar/qos/ResourceStatus/ExceedsThresholdQualifierFactory:1.0", 
    "IDL:org/cougaar/qos/ResourceStatus/QualifierFactory:1.0"};

  @Override
public String[] _ids ()
  {
    return __ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.Object obj = org.omg.CORBA.ORB.init (args, props).string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     String str = org.omg.CORBA.ORB.init (args, props).object_to_string (this);
     s.writeUTF (str);
  }
} // class _ExceedsThresholdQualifierFactoryStub
