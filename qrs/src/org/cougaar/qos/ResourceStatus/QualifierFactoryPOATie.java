package org.cougaar.qos.ResourceStatus;


/**
* org/cougaar/qos/ResourceStatus/QualifierFactoryPOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from qrs.idl
* Tuesday, August 7, 2007 11:57:30 AM EDT
*/


// simple.
public class QualifierFactoryPOATie extends QualifierFactoryPOA
{

  // Constructors

  public QualifierFactoryPOATie ( org.cougaar.qos.ResourceStatus.QualifierFactoryOperations delegate ) {
      this._impl = delegate;
  }
  public QualifierFactoryPOATie ( org.cougaar.qos.ResourceStatus.QualifierFactoryOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public org.cougaar.qos.ResourceStatus.QualifierFactoryOperations _delegate() {
      return this._impl;
  }
  public void _delegate (org.cougaar.qos.ResourceStatus.QualifierFactoryOperations delegate ) {
      this._impl = delegate;
  }
  @Override
public org.omg.PortableServer.POA _default_POA() {
      if(_poa != null) {
          return _poa;
      }
      else {
          return super._default_POA();
      }
  }
  private org.cougaar.qos.ResourceStatus.QualifierFactoryOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class QualifierFactoryPOATie
