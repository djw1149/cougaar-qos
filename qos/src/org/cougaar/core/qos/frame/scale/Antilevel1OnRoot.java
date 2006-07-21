package org.cougaar.core.qos.frame.scale;

import org.cougaar.core.qos.frame.DataFrame;
import org.cougaar.core.qos.frame.FrameSet;
import org.cougaar.core.util.UID;

public class Antilevel1OnRoot
    extends Relationship {
    static {
        org.cougaar.core.qos.frame.FrameMaker __fm = 
            new org.cougaar.core.qos.frame.FrameMaker() {
                public DataFrame makeFrame(FrameSet frameSet, UID uid) {
                     return new Antilevel1OnRoot(frameSet, uid);
                }
            };
            DataFrame.registerFrameMaker("org.cougaar.core.qos.frame.scale", "antilevel1OnRoot", __fm);
    }


    public Antilevel1OnRoot(UID uid) {
        this(null, uid);
    }


    public Antilevel1OnRoot(FrameSet frameSet,
                            UID uid) {
        super(frameSet, uid);
    }


    public String getKind() {
        return "antilevel1OnRoot";
    }


    public String getParentPrototype() {
        return "root";
    }


    public String getChildPrototype() {
        return "antilevel1";
    }


    protected void collectSlotNames(java.util.Set<String> slots) {
        super.collectSlotNames(slots);
    }
}