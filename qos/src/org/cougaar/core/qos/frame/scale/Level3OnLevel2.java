/*
 * Generated by Cougaar QoS FrameGen
 *   from /Volumes/Data/Projects/cougaar/HEAD/qos/src/org/cougaar/core/qos/frame/scale/test-scale-protos.xml
 *   at Aug 3, 2006 10:09:21 AM
 *
 * Copyright BBN Technologies 2006
 *
 */
package org.cougaar.core.qos.frame.scale;

import org.cougaar.core.qos.frame.DataFrame;
import org.cougaar.core.qos.frame.FrameSet;
import org.cougaar.core.util.UID;

public class Level3OnLevel2
    extends Contains {
    /**
    * 
    */
   private static final long serialVersionUID = 1L;


   static {
        org.cougaar.core.qos.frame.FrameMaker __fm = 
            new org.cougaar.core.qos.frame.FrameMaker() {
                public DataFrame makeFrame(FrameSet frameSet, UID uid) {
                     return new Level3OnLevel2(frameSet, uid);
                }
            };
            DataFrame.registerFrameMaker("org.cougaar.core.qos.frame.scale", "level3OnLevel2", __fm);
    }


    public Level3OnLevel2(UID uid) {
        this(null, uid);
    }


    public Level3OnLevel2(FrameSet frameSet,
                          UID uid) {
        super(frameSet, uid);
    }


    @Override
   public String getKind() {
        return "level3OnLevel2";
    }


    @Override
   public String getParentPrototype() {
        return "level2";
    }


    @Override
   public String getChildPrototype() {
        return "level3";
    }


    @Override
   protected void collectSlotNames(java.util.Set<String> slots) {
        super.collectSlotNames(slots);
    }
}
