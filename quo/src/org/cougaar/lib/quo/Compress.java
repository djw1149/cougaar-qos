/* -*- JAVA -*- */

// ****** Code generated by the QuO codegenerator 3.0.8 ******
// QuO and the QuO codegenerator have been developed by 
// BBN Technologies.

// Information about QuO is available at:
// http://www.dist-systems.bbn.com/tech/QuO


package org.cougaar.lib.quo;

import com.bbn.quo.rmi.*;
import com.bbn.quo.*;

public class Compress extends com.bbn.quo.rmi.impl.ContractImpl
{
  static ConstantSF constDouble2_5;
  static ConstantSF constDouble2_0;
  static ConstantSF constBooleantrue;

  static {
    constDouble2_5 = new ConstantSF(new Double(2.5));
    constDouble2_0 = new ConstantSF(new Double(2.0));
    constBooleantrue = new ConstantSF(new Boolean(true));
  }


  public void init(SysCond[] scParams, SysCond[][] scSeqParams, Callback[] cbParams, Callback[][] cbSeqParams, Kernel kernel)
  {
  int child_count = 0;

    if (scParams.length != 4 || scSeqParams.length != 0 || cbParams.length != 0 || cbSeqParams.length != 0) {
      throw new RuntimeException("QuO bug: constructor called improperly");
    }

    callback_objs = cbParams;
    callback_seqs = cbSeqParams;
    syscond_objs = new SysCondImpl[4];
    syscond_seqs = new SysCondImpl[0][];


    com.bbn.quo.rmi.impl.SysCond  servant0 = com.bbn.quo.rmi.impl.SysCond.lookup(scParams[0]);
    com.bbn.quo.rmi.impl.SysCond  servant1 = com.bbn.quo.rmi.impl.SysCond.lookup(scParams[1]);
    com.bbn.quo.rmi.impl.SysCond  servant2 = com.bbn.quo.rmi.impl.SysCond.lookup(scParams[2]);
    com.bbn.quo.rmi.impl.SysCond  servant3 = com.bbn.quo.rmi.impl.SysCond.lookup(scParams[3]);

    com.bbn.quo.rmi.DataSCTie tsc0 = (com.bbn.quo.rmi.DataSCTie) servant0;
    com.bbn.quo.data.DataSCImpl expectedServerEffectiveMJipsSC = (com.bbn.quo.data.DataSCImpl) tsc0._delegate();
    syscond_objs[0] = expectedServerEffectiveMJipsSC;
    PrimitiveSF expectedServerEffectiveMJipsSF =
      new PrimitiveSF(expectedServerEffectiveMJipsSC);

    com.bbn.quo.rmi.DataSCTie tsc1 = (com.bbn.quo.rmi.DataSCTie) servant1;
    com.bbn.quo.data.DataSCImpl expectedClientEffectiveMJipsSC = (com.bbn.quo.data.DataSCImpl) tsc1._delegate();
    syscond_objs[1] = expectedClientEffectiveMJipsSC;
    PrimitiveSF expectedClientEffectiveMJipsSF =
      new PrimitiveSF(expectedClientEffectiveMJipsSC);

    com.bbn.quo.rmi.DataSCTie tsc2 = (com.bbn.quo.rmi.DataSCTie) servant2;
    com.bbn.quo.data.DataSCImpl expectedNetworkCapacitySC = (com.bbn.quo.data.DataSCImpl) tsc2._delegate();
    syscond_objs[2] = expectedNetworkCapacitySC;
    PrimitiveSF expectedNetworkCapacitySF =
      new PrimitiveSF(expectedNetworkCapacitySC);

    com.bbn.quo.rmi.ValueSCTie tsc3 = (com.bbn.quo.rmi.ValueSCTie) servant3;
    ValueSCImpl UseCompressionSC = (ValueSCImpl) tsc3._delegate();
    syscond_objs[3] = UseCompressionSC;
    PrimitiveSF UseCompressionSF =
      new PrimitiveSF(UseCompressionSC);


    primitives = new PrimitiveSF[4];
    primitives[0] = expectedServerEffectiveMJipsSF;
    primitives[0].sysCond.addObserver(this);
    primitives[1] = expectedClientEffectiveMJipsSF;
    primitives[1].sysCond.addObserver(this);
    primitives[2] = expectedNetworkCapacitySF;
    primitives[2].sysCond.addObserver(this);
    primitives[3] = UseCompressionSF;
    primitives[3].sysCond.addObserver(this);

    sequences = new SysCondSeqSF[0];

    // pre- and post- method initialization
    probes = new ProbeSCImpl[0];

    // top
    region = new Region("root", null);

    // Regions
    region.children = new Region[2];
    region.children[0] = new Region("Compress", region); // Compress
    region.children[0].idlEnum = 0;
    region.children[0].predicate =
      new DisjPairSF(
        UseCompressionSF, 
        new LessThanSF(expectedNetworkCapacitySF, new MultiplySF(constDouble2_5, new DivideSF(new AddSF(expectedServerEffectiveMJipsSF, expectedClientEffectiveMJipsSF), constDouble2_0))));

    // subregions of Compress
    region.children[0].children = null;

    region.children[1] = new Region("Normal", region); // Normal
    region.children[1].idlEnum = 1;
    region.children[1].predicate =
      constBooleantrue;

    // subregions of Normal
    region.children[1].children = null;

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
