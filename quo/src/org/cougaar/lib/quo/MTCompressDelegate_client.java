/* -*- JAVA -*- */

// ****** Code generated by the QuO codegenerator 3.0.9 ******
// QuO and the QuO codegenerator have been developed by 
// BBN Technologies.

// Information about QuO is available at:
// http://www.dist-systems.bbn.com/tech/QuO


package org.cougaar.lib.quo ;

import java.rmi.*;
import com.bbn.quo.rmi.*;
import com.bbn.quo.*;

public class MTCompressDelegate_client implements org.cougaar.core.mts.MT {

  //These are instance variables declared in ASL.
  protected org.cougaar.core.mts.MT remote;
  protected org.cougaar.lib.quo.CompressDelegateQosket qk;

  void set_remote(org.cougaar.core.mts.MT arg1){
    remote = arg1;
  }
  void set_qk(org.cougaar.lib.quo.CompressDelegateQosket arg1){
    qk = arg1;
  }
  void set_remoteObj(org.cougaar.core.mts.MT arg1){
    remote = arg1;
  }
  org.cougaar.core.mts.MT  get_remoteObj(){
    return(remote);
  }
  protected com.bbn.quo.rmi.Contract quo_Compress;
  public void set_contract_Compress(com.bbn.quo.rmi.Contract arg1){
    quo_Compress = arg1;
  }
  public com.bbn.quo.rmi.Contract get_contract_Compress() {
    return quo_Compress;
  }

  void set_qosket(org.cougaar.lib.quo.CompressDelegateQosket qs){
    qk = qs;
  }
  final static int COMPRESS__COMPRESS = 0;
  final static int COMPRESS__NORMAL = 1;

  public void rerouteMessage(org.cougaar.core.mts.Message m) throws RemoteException {
    // Default declarations and setup of quo introduced variables local to method:
    int[] quo_curRegs_Compress = null;
    com.bbn.quo.corba.Association[] signal =
        new com.bbn.quo.corba.Association[0];
    com.bbn.quo.corba.SignalEvent quo_sig1;
    com.bbn.quo.corba.SignalEvent quo_sig2;

    quo_sig1 = 	new com.bbn.quo.corba.SignalEvent("premethod", signal);
    try { 
quo_curRegs_Compress = quo_Compress.signalAndEvalAndGetCurrentRegion(quo_sig1);
     } catch (java.rmi.RemoteException pre_meth_ceval_ex) {} 
      // Adaptive code for inplaceof methodcall
      switch (quo_curRegs_Compress[0]) {
      case COMPRESS__NORMAL:
        remote.rerouteMessage(m);
        break;
      case COMPRESS__COMPRESS:
        qk.runSerializeAndCompress(m);
        break;
      default:
        remote.rerouteMessage(m);
        break;
      };
      // Adaptive code for before postmethodcontracteval
      quo_sig2 = 	new com.bbn.quo.corba.SignalEvent("postmethod", signal);
      try { 
quo_curRegs_Compress = quo_Compress.signalAndEvalAndGetCurrentRegion(quo_sig2);
             } catch( java.rmi.RemoteException post_meth_ceval_ex) {} 
        return;
      }
      public org.cougaar.core.mts.MessageAddress getMessageAddress() throws RemoteException {
        // Default declarations and setup of quo introduced variables local to method:
        int[] quo_curRegs_Compress = null;
        com.bbn.quo.corba.Association[] signal =
            new com.bbn.quo.corba.Association[0];
        org.cougaar.core.mts.MessageAddress quo_retval;
        com.bbn.quo.corba.SignalEvent quo_sig1;
        com.bbn.quo.corba.SignalEvent quo_sig2;

        quo_retval = remote.getMessageAddress();
        return(quo_retval);
      }
};

