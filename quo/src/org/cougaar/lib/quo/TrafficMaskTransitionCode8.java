/* -*- JAVA -*- */

// ****** Code generated by the QuO codegenerator 3.0.10 ******
// QuO and the QuO codegenerator have been developed by 
// BBN Technologies.

// Information about QuO is available at:
// http://www.dist-systems.bbn.com/tech/QuO


package org.cougaar.lib.quo;

import com.bbn.quo.rmi.*;
import com.bbn.quo.*;

// Transition code for transition any->Wan
public class TrafficMaskTransitionCode8 extends TransitionCode
{
  public void perform() {
    syncwork();
  }

  public void syncwork() {
    try {
((org.cougaar.lib.mquo.TrafficMaskControl) ((com.bbn.quo.rmi.impl.ContractImpl) contract).callback_objs[0]).turnOn();
}  catch (java.rmi.RemoteException remote_ex) {
      remote_ex.printStackTrace();
}
  }

  public void asyncwork() {
  }
}

