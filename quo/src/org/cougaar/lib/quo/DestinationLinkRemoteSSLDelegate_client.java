/* -*- JAVA -*- */

// ****** Code generated by the QuO codegenerator 3.0.8 ******
// QuO and the QuO codegenerator have been developed by 
// BBN Technologies.

// Information about QuO is available at:
// http://www.dist-systems.bbn.com/tech/QuO


package org.cougaar.lib.quo ;

import java.rmi.*;
import com.bbn.quo.rmi.*;
import com.bbn.quo.*;

public class DestinationLinkRemoteSSLDelegate_client implements org.cougaar.core.mts.DestinationLink {

  //These are instance variables declared in ASL.
  protected org.cougaar.core.mts.DestinationLink remote;
  protected org.cougaar.lib.quo.RemoteSSLDelegateQosket qk;

  void set_remote(org.cougaar.core.mts.DestinationLink arg1){
    remote = arg1;
  }
  void set_qk(org.cougaar.lib.quo.RemoteSSLDelegateQosket arg1){
    qk = arg1;
  }
  void set_remoteObj(org.cougaar.core.mts.DestinationLink arg1){
    remote = arg1;
  }
  org.cougaar.core.mts.DestinationLink  get_remoteObj(){
    return(remote);
  }
  protected com.bbn.quo.rmi.Contract quo_RemoteSSL;
  void set_contract_RemoteSSL(com.bbn.quo.rmi.Contract arg1){
    quo_RemoteSSL = arg1;
  }
  com.bbn.quo.rmi.Contract get_contract_RemoteSSL() {
    return quo_RemoteSSL;
  }

  void set_qosket(org.cougaar.lib.quo.RemoteSSLDelegateQosket qs){
    qk = qs;
  }
  final static int REMOTESSL__FORCESSL = 0;
  final static int REMOTESSL__ADAPTIVESSL = 1;
  final static int REMOTESSLADAPTIVESSL__COMPROMISED = 0;
  final static int REMOTESSLADAPTIVESSL__SUSPECT = 1;
  final static int REMOTESSLADAPTIVESSL__NORMAL = 2;
  final static int REMOTESSLADAPTIVESSL__CAREFREE = 3;
  final static int REMOTESSLADAPTIVESSLCOMPROMISED__SAMEHOST = 0;
  final static int REMOTESSLADAPTIVESSLCOMPROMISED__SAMELAN = 1;
  final static int REMOTESSLADAPTIVESSLCOMPROMISED__WAN = 2;
  final static int REMOTESSLADAPTIVESSLSUSPECT__SAMEHOST = 0;
  final static int REMOTESSLADAPTIVESSLSUSPECT__SAMELAN = 1;
  final static int REMOTESSLADAPTIVESSLSUSPECT__WAN = 2;
  final static int REMOTESSLADAPTIVESSLNORMAL__SAMEHOST = 0;
  final static int REMOTESSLADAPTIVESSLNORMAL__SAMELAN = 1;
  final static int REMOTESSLADAPTIVESSLNORMAL__WAN = 2;
  final static int REMOTESSLADAPTIVESSLCAREFREE__SAMEHOST = 0;
  final static int REMOTESSLADAPTIVESSLCAREFREE__SAMELAN = 1;
  final static int REMOTESSLADAPTIVESSLCAREFREE__WAN = 2;

  public void forwardMessage(org.cougaar.core.society.Message message)  throws org.cougaar.core.mts.UnregisteredNameException, org.cougaar.core.mts.NameLookupException, org.cougaar.core.mts.CommFailureException, org.cougaar.core.mts.MisdeliveredMessageException {
    remote.forwardMessage(message);
  }
  public int cost(org.cougaar.core.society.Message message) {
    // Default declarations and setup of quo introduced variables local to method:
    int[] quo_curRegs_RemoteSSL = null;
    int cost;
    com.bbn.quo.corba.Association[] signal =
        new com.bbn.quo.corba.Association[0];
    com.bbn.quo.corba.SignalEvent quo_sig1;
    com.bbn.quo.corba.SignalEvent quo_sig2;

    quo_sig1 = 	new com.bbn.quo.corba.SignalEvent("premethod", signal);
    try { 
quo_curRegs_RemoteSSL = quo_RemoteSSL.signalAndEvalAndGetCurrentRegion(quo_sig1);
     } catch (java.rmi.RemoteException pre_meth_ceval_ex) {} 
      // Adaptive code for inplaceof methodcall
      switch (quo_curRegs_RemoteSSL[0]) {
      case REMOTESSL__FORCESSL:
        cost = qk.computeCost(message);
        break;
      case REMOTESSL__ADAPTIVESSL:
        switch (quo_curRegs_RemoteSSL[1]) {
        case REMOTESSLADAPTIVESSL__COMPROMISED:
          switch (quo_curRegs_RemoteSSL[2]) {
          case REMOTESSLADAPTIVESSLCOMPROMISED__SAMEHOST:
            cost = qk.computeCost(message);
            break;
          case REMOTESSLADAPTIVESSLCOMPROMISED__SAMELAN:
            cost = qk.computeCost(message);
            break;
          case REMOTESSLADAPTIVESSLCOMPROMISED__WAN:
            cost = qk.computeCost(message);
            break;
          default:
            cost = remote.cost(message);
            break;
          }
          break;
        case REMOTESSLADAPTIVESSL__SUSPECT:
          switch (quo_curRegs_RemoteSSL[2]) {
          case REMOTESSLADAPTIVESSLSUSPECT__SAMELAN:
            cost = qk.computeCost(message);
            break;
          case REMOTESSLADAPTIVESSLSUSPECT__WAN:
            cost = qk.computeCost(message);
            break;
          default:
            cost = remote.cost(message);
            break;
          }
          break;
        case REMOTESSLADAPTIVESSL__NORMAL:
          switch (quo_curRegs_RemoteSSL[2]) {
          case REMOTESSLADAPTIVESSLNORMAL__WAN:
            cost = qk.computeCost(message);
            break;
          default:
            cost = remote.cost(message);
            break;
          }
          break;
        default:
          cost = remote.cost(message);
          break;
        }
        break;
      default:
      cost =   remote.cost(message);
        break;
      };
      return(cost);
    }
    public java.lang.Class getProtocolClass() {
    return(remote.getProtocolClass());
  }
    public boolean retryFailedMessage(org.cougaar.core.society.Message message, int retryCount) {
    return(remote.retryFailedMessage(message, retryCount));
  }
    public org.cougaar.core.society.MessageAddress getDestination() {
    return(remote.getDestination());
  }
};

