/* -*- JAVA -*- */

// ****** Code generated by the QuO codegenerator 3.0.8 ******
// QuO and the QuO codegenerator have been developed by 
// BBN Technologies.

// Information about QuO is available at:
// http://www.dist-systems.bbn.com/tech/QuO


package org.cougaar.lib.quo;

import com.bbn.quo.rmi.*;
import com.bbn.quo.*;

public class RemoteSSL extends com.bbn.quo.rmi.impl.ContractImpl
{
  static ConstantSF constBooleantrue;
  static ConstantSF constInt0;
  static ConstantSF constInt1000000;
  static ConstantSF constInt10000;
  static ConstantSF constInt2;
  static ConstantSF constInt10000000;
  static ConstantSF constInt5;
  static ConstantSF constInt10;

  static {
    constBooleantrue = new ConstantSF(new Boolean(true));
    constInt0 = new ConstantSF(new Integer(0));
    constInt1000000 = new ConstantSF(new Integer(1000000));
    constInt10000 = new ConstantSF(new Integer(10000));
    constInt2 = new ConstantSF(new Integer(2));
    constInt10000000 = new ConstantSF(new Integer(10000000));
    constInt5 = new ConstantSF(new Integer(5));
    constInt10 = new ConstantSF(new Integer(10));
  }


  public void init(SysCond[] scParams, SysCond[][] scSeqParams, Callback[] cbParams, Callback[][] cbSeqParams, Kernel kernel)
  {
  int child_count = 0;

    if (scParams.length != 3 || scSeqParams.length != 0 || cbParams.length != 0 || cbSeqParams.length != 0) {
      throw new RuntimeException("QuO bug: constructor called improperly");
    }

    callback_objs = cbParams;
    callback_seqs = cbSeqParams;
    syscond_objs = new SysCondImpl[3];
    syscond_seqs = new SysCondImpl[0][];


    com.bbn.quo.rmi.impl.SysCond  servant0 = com.bbn.quo.rmi.impl.SysCond.lookup(scParams[0]);
    com.bbn.quo.rmi.impl.SysCond  servant1 = com.bbn.quo.rmi.impl.SysCond.lookup(scParams[1]);
    com.bbn.quo.rmi.impl.SysCond  servant2 = com.bbn.quo.rmi.impl.SysCond.lookup(scParams[2]);

    com.bbn.quo.rmi.ExpectedCapacitySCTie tsc0 = (com.bbn.quo.rmi.ExpectedCapacitySCTie) servant0;
    com.bbn.quo.data.ExpectedCapacitySCImpl BandwidthSC = (com.bbn.quo.data.ExpectedCapacitySCImpl) tsc0._delegate();
    syscond_objs[0] = BandwidthSC;
    PrimitiveSF BandwidthSF =
      new PrimitiveSF(BandwidthSC);

    com.bbn.quo.rmi.ValueSCTie tsc1 = (com.bbn.quo.rmi.ValueSCTie) servant1;
    ValueSCImpl UseSSLSC = (ValueSCImpl) tsc1._delegate();
    syscond_objs[1] = UseSSLSC;
    PrimitiveSF UseSSLSF =
      new PrimitiveSF(UseSSLSC);

    com.bbn.quo.rmi.ValueSCTie tsc2 = (com.bbn.quo.rmi.ValueSCTie) servant2;
    ValueSCImpl trustSC = (ValueSCImpl) tsc2._delegate();
    syscond_objs[2] = trustSC;
    PrimitiveSF trustSF =
      new PrimitiveSF(trustSC);


    primitives = new PrimitiveSF[3];
    primitives[0] = BandwidthSF;
    primitives[0].sysCond.addObserver(this);
    primitives[1] = UseSSLSF;
    primitives[1].sysCond.addObserver(this);
    primitives[2] = trustSF;
    primitives[2].sysCond.addObserver(this);

    sequences = new SysCondSeqSF[0];

    // pre- and post- method initialization
    probes = new ProbeSCImpl[0];

    // top
    region = new Region("root", null);

    // Regions
    region.children = new Region[2];
    region.children[0] = new Region("ForceSSL", region); // ForceSSL
    region.children[0].idlEnum = 0;
    region.children[0].predicate =
      UseSSLSF;

    // subregions of ForceSSL
    region.children[0].children = null;

    region.children[1] = new Region("AdaptiveSSL", region); // AdaptiveSSL
    region.children[1].idlEnum = 1;
    region.children[1].predicate =
      constBooleantrue;

    // subregions of AdaptiveSSL
    child_count = 4;
    region.children[1].children = new Region[child_count];
    region.children[1].children[0] = new Region("Compromised", region.children[1]); // Compromised
    region.children[1].children[0].idlEnum = 0;
    region.children[1].children[0].predicate =
      new EqualSF(trustSF, constInt0);

    // subregions of Compromised
    child_count = 3;
    region.children[1].children[0].children = new Region[child_count];
    region.children[1].children[0].children[0] = new Region("SameHost", region.children[1].children[0]); // SameHost
    region.children[1].children[0].children[0].idlEnum = 0;
    region.children[1].children[0].children[0].predicate =
      new LessThanEqSF(constInt1000000, BandwidthSF);

    // subregions of SameHost
    region.children[1].children[0].children[0].children = null;


    region.children[1].children[0].children[1] = new Region("SameLan", region.children[1].children[0]); // SameLan
    region.children[1].children[0].children[1].idlEnum = 1;
    region.children[1].children[0].children[1].predicate =
      new LessThanEqSF(constInt10000, BandwidthSF);

    // subregions of SameLan
    region.children[1].children[0].children[1].children = null;


    region.children[1].children[0].children[2] = new Region("Wan", region.children[1].children[0]); // Wan
    region.children[1].children[0].children[2].idlEnum = 2;
    region.children[1].children[0].children[2].predicate =
      constBooleantrue;

    // subregions of Wan
    region.children[1].children[0].children[2].children = null;


    // Region transitions
    // between transitions
    region.children[1].children[0].between = new Transition[0];

    // fromAny transitions
    region.children[1].children[0].fromAny = new Transition[0];

    // toAny transitions
    region.children[1].children[0].toAny = new Transition[0];

    // entering transitions
    region.children[1].children[0].entering = new Transition[0];

    // leaving transitions
    region.children[1].children[0].leaving = new Transition[0];


    region.children[1].children[1] = new Region("Suspect", region.children[1]); // Suspect
    region.children[1].children[1].idlEnum = 1;
    region.children[1].children[1].predicate =
      new LessThanEqSF(trustSF, constInt2);

    // subregions of Suspect
    child_count = 3;
    region.children[1].children[1].children = new Region[child_count];
    region.children[1].children[1].children[0] = new Region("SameHost", region.children[1].children[1]); // SameHost
    region.children[1].children[1].children[0].idlEnum = 0;
    region.children[1].children[1].children[0].predicate =
      new LessThanEqSF(constInt10000000, BandwidthSF);

    // subregions of SameHost
    region.children[1].children[1].children[0].children = null;


    region.children[1].children[1].children[1] = new Region("SameLan", region.children[1].children[1]); // SameLan
    region.children[1].children[1].children[1].idlEnum = 1;
    region.children[1].children[1].children[1].predicate =
      new LessThanEqSF(constInt10000, BandwidthSF);

    // subregions of SameLan
    region.children[1].children[1].children[1].children = null;


    region.children[1].children[1].children[2] = new Region("Wan", region.children[1].children[1]); // Wan
    region.children[1].children[1].children[2].idlEnum = 2;
    region.children[1].children[1].children[2].predicate =
      constBooleantrue;

    // subregions of Wan
    region.children[1].children[1].children[2].children = null;


    // Region transitions
    // between transitions
    region.children[1].children[1].between = new Transition[0];

    // fromAny transitions
    region.children[1].children[1].fromAny = new Transition[0];

    // toAny transitions
    region.children[1].children[1].toAny = new Transition[0];

    // entering transitions
    region.children[1].children[1].entering = new Transition[0];

    // leaving transitions
    region.children[1].children[1].leaving = new Transition[0];


    region.children[1].children[2] = new Region("Normal", region.children[1]); // Normal
    region.children[1].children[2].idlEnum = 2;
    region.children[1].children[2].predicate =
      new LessThanEqSF(trustSF, constInt5);

    // subregions of Normal
    child_count = 3;
    region.children[1].children[2].children = new Region[child_count];
    region.children[1].children[2].children[0] = new Region("SameHost", region.children[1].children[2]); // SameHost
    region.children[1].children[2].children[0].idlEnum = 0;
    region.children[1].children[2].children[0].predicate =
      new LessThanEqSF(constInt10000000, BandwidthSF);

    // subregions of SameHost
    region.children[1].children[2].children[0].children = null;


    region.children[1].children[2].children[1] = new Region("SameLan", region.children[1].children[2]); // SameLan
    region.children[1].children[2].children[1].idlEnum = 1;
    region.children[1].children[2].children[1].predicate =
      new LessThanEqSF(constInt10000, BandwidthSF);

    // subregions of SameLan
    region.children[1].children[2].children[1].children = null;


    region.children[1].children[2].children[2] = new Region("Wan", region.children[1].children[2]); // Wan
    region.children[1].children[2].children[2].idlEnum = 2;
    region.children[1].children[2].children[2].predicate =
      constBooleantrue;

    // subregions of Wan
    region.children[1].children[2].children[2].children = null;


    // Region transitions
    // between transitions
    region.children[1].children[2].between = new Transition[0];

    // fromAny transitions
    region.children[1].children[2].fromAny = new Transition[0];

    // toAny transitions
    region.children[1].children[2].toAny = new Transition[0];

    // entering transitions
    region.children[1].children[2].entering = new Transition[0];

    // leaving transitions
    region.children[1].children[2].leaving = new Transition[0];


    region.children[1].children[3] = new Region("CareFree", region.children[1]); // CareFree
    region.children[1].children[3].idlEnum = 3;
    region.children[1].children[3].predicate =
      new LessThanEqSF(trustSF, constInt10);

    // subregions of CareFree
    child_count = 3;
    region.children[1].children[3].children = new Region[child_count];
    region.children[1].children[3].children[0] = new Region("SameHost", region.children[1].children[3]); // SameHost
    region.children[1].children[3].children[0].idlEnum = 0;
    region.children[1].children[3].children[0].predicate =
      new LessThanEqSF(constInt10000000, BandwidthSF);

    // subregions of SameHost
    region.children[1].children[3].children[0].children = null;


    region.children[1].children[3].children[1] = new Region("SameLan", region.children[1].children[3]); // SameLan
    region.children[1].children[3].children[1].idlEnum = 1;
    region.children[1].children[3].children[1].predicate =
      new LessThanEqSF(constInt10000, BandwidthSF);

    // subregions of SameLan
    region.children[1].children[3].children[1].children = null;


    region.children[1].children[3].children[2] = new Region("Wan", region.children[1].children[3]); // Wan
    region.children[1].children[3].children[2].idlEnum = 2;
    region.children[1].children[3].children[2].predicate =
      constBooleantrue;

    // subregions of Wan
    region.children[1].children[3].children[2].children = null;


    // Region transitions
    // between transitions
    region.children[1].children[3].between = new Transition[0];

    // fromAny transitions
    region.children[1].children[3].fromAny = new Transition[0];

    // toAny transitions
    region.children[1].children[3].toAny = new Transition[0];

    // entering transitions
    region.children[1].children[3].entering = new Transition[0];

    // leaving transitions
    region.children[1].children[3].leaving = new Transition[0];


    // Region transitions
    // between transitions
    region.children[1].between = new Transition[0];

    // fromAny transitions
    region.children[1].fromAny = new Transition[0];

    // toAny transitions
    region.children[1].toAny = new Transition[0];

    // entering transitions
    region.children[1].entering = new Transition[0];

    // leaving transitions
    region.children[1].leaving = new Transition[0];

    // Region transitions
    // between transitions
    region.between = new Transition[0];

    // fromAny transitions
    region.fromAny = new Transition[0];

    // toAny transitions
    region.toAny = new Transition[0];

    // entering transitions
    region.entering = new Transition[0];

    // leaving transitions
    region.leaving = new Transition[0];

    kernel.addContract(this);
    waitForEval();
  }
}
