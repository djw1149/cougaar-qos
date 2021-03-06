/*
 * Generated by Cougaar QoS FrameGen
 *   from c:\marla\mmon\cougaar\HEAD\qos\src\org\cougaar\core\qos\frame\topology\cougaar-topology-protos.xml
 *   at Mar 14, 2007 4:18:10 PM
 *
 * Copyright BBN Technologies 2006
 *
 */
package org.cougaar.core.qos.frame.topology;

import org.cougaar.core.qos.frame.DataFrame;
import org.cougaar.core.qos.frame.FrameSet;
import org.cougaar.core.qos.frame.SlotDescription;
import org.cougaar.core.util.UID;

public class MsgInIndicator
    extends MsgIndicator {
    /**
    * 
    */
   private static final long serialVersionUID = 1L;


   static {
        org.cougaar.core.qos.frame.FrameMaker __fm = 
            new org.cougaar.core.qos.frame.FrameMaker() {
                public DataFrame makeFrame(FrameSet frameSet, UID uid) {
                     return new MsgInIndicator(frameSet, uid);
                }
            };
            DataFrame.registerFrameMaker("org.cougaar.core.qos.frame.topology", "msgInIndicator", __fm);
    }
    private String watchSlot;


    public MsgInIndicator(UID uid) {
        this(null, uid);
    }


    public MsgInIndicator(FrameSet frameSet,
                          UID uid) {
        super(frameSet, uid);
        initializeWatchSlot("msgOut");
    }


    @Override
   public String getKind() {
        return "msgInIndicator";
    }


    @Override
   protected void collectSlotValues(java.util.Properties __props) {
        super.collectSlotValues(__props);
        Object __value;
        __value = getWatchSlot__AsObject();
        __props.put("watchSlot", __value != null ? __value : NIL);
    }


    public String getWatchSlot() {
        return watchSlot;
    }


    String getWatchSlot__NoWarn() {
        return watchSlot;
    }


    Object getWatchSlot__AsObject() {
        return watchSlot;
    }


    public void setWatchSlot(String __new_value) {
        String __old_value = watchSlot;
        this.watchSlot = __new_value;
        slotModified("watchSlot", __old_value, __new_value, true, true);
    }


    public void setWatchSlot__AsObject(Object __new_value) {
        Object __old_value = getWatchSlot__AsObject();
        this.watchSlot = force_String(__new_value);
        slotModified("watchSlot", __old_value, __new_value, true, true);
    }


    protected void initializeWatchSlot(String new_value) {
        this.watchSlot = new_value;
        slotInitialized("watchSlot", new_value);
    }


    void initializeWatchSlot__AsObject(Object new_value) {
        this.watchSlot = force_String(new_value);
        slotInitialized("watchSlot", new_value);
    }


    @Override
   protected Object getLocalValue(String __slot) {
       String __key = __slot.intern();
       if ("watchSlot" == __key)
            return getWatchSlot__AsObject();
       else
           return super.getLocalValue(__slot);
    }


    @Override
   protected void setLocalValue(String __slot,
                                 Object __value) {
       String __key = __slot.intern();
       if ("watchSlot" == __key)
            setWatchSlot__AsObject(__value);
       else
            super.setLocalValue(__slot, __value);
    }


    @Override
   protected void initializeLocalValue(String __slot,
                                 Object __value) {
       String __key = __slot.intern();
       if ("watchSlot" == __key)
            initializeWatchSlot__AsObject(__value);
       else
            super.initializeLocalValue(__slot, __value);
    }


    @Override
   protected void collectSlotNames(java.util.Set<String> slots) {
        super.collectSlotNames(slots);
        slots.add("watchSlot");
    }


    public SlotDescription slotMetaData__WatchSlot() {
        SlotDescription __desc = new SlotDescription();
        __desc.name = "watchSlot";
        __desc.prototype = "msgInIndicator";
        __desc.is_writable = true;
        Object __value;
        __value = watchSlot;
        if (__value != null) {
            __desc.is_overridden = true;
            __desc.value = __value;
        } else {
            __desc.is_overridden = false;
            __desc.value = "msgOut";
        }
        return __desc;
    }


    @Override
   protected void collectSlotDescriptions(java.util.Map<String,SlotDescription> map) {
        super.collectSlotDescriptions(map);
        map.put("watchSlot", slotMetaData__WatchSlot());
    }
}
