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
import org.cougaar.core.qos.frame.SlotDescription;
import org.cougaar.core.util.UID;

public class Level3
    extends Thing {
    /**
    * 
    */
   private static final long serialVersionUID = 1L;


   static {
        org.cougaar.core.qos.frame.FrameMaker __fm = 
            new org.cougaar.core.qos.frame.FrameMaker() {
                public DataFrame makeFrame(FrameSet frameSet, UID uid) {
                     return new Level3(frameSet, uid);
                }
            };
            DataFrame.registerFrameMaker("org.cougaar.core.qos.frame.scale", "level3", __fm);
    }
    private String level3SlotString;
    private float level3SlotFloat;


    public Level3(UID uid) {
        this(null, uid);
    }


    public Level3(FrameSet frameSet,
                  UID uid) {
        super(frameSet, uid);
        initializeLevel3SlotString("Three");
        initializeLevel3SlotFloat(3.0f);
    }


    @Override
   public String getKind() {
        return "level3";
    }


    @Override
   protected void collectSlotValues(java.util.Properties __props) {
        super.collectSlotValues(__props);
        Object __value;
        __value = getLevel3SlotString__AsObject();
        __props.put("level3SlotString", __value != null ? __value : NIL);
        __value = getLevel3SlotFloat__AsObject();
        __props.put("level3SlotFloat", __value != null ? __value : NIL);
    }


    @Override
   protected void collectContainerSlotValues(java.util.Properties __props) {
        super.collectContainerSlotValues(__props);
        Object __value;
        __value = getLevel1SlotString__AsObject();
        __props.put("level1SlotString", __value != null ? __value : NIL);
        __value = getRootSlotFloat__AsObject();
        __props.put("rootSlotFloat", __value != null ? __value : NIL);
        __value = getLevel2SlotString__AsObject();
        __props.put("level2SlotString", __value != null ? __value : NIL);
        __value = getLevel2SlotFloat__AsObject();
        __props.put("level2SlotFloat", __value != null ? __value : NIL);
        __value = getLevel1SlotFloat__AsObject();
        __props.put("level1SlotFloat", __value != null ? __value : NIL);
        __value = getRootSlotString__AsObject();
        __props.put("rootSlotString", __value != null ? __value : NIL);
    }


    public String getLevel3SlotString() {
        return level3SlotString;
    }


    String getLevel3SlotString__NoWarn() {
        return level3SlotString;
    }


    Object getLevel3SlotString__AsObject() {
        return level3SlotString;
    }


    public void setLevel3SlotString(String __new_value) {
        String __old_value = level3SlotString;
        this.level3SlotString = __new_value;
        slotModified("level3SlotString", __old_value, __new_value, true, true);
    }


    public void setLevel3SlotString__AsObject(Object __new_value) {
        Object __old_value = getLevel3SlotString__AsObject();
        this.level3SlotString = force_String(__new_value);
        slotModified("level3SlotString", __old_value, __new_value, true, true);
    }


    protected void initializeLevel3SlotString(String new_value) {
        this.level3SlotString = new_value;
        slotInitialized("level3SlotString", new_value);
    }


    void initializeLevel3SlotString__AsObject(Object new_value) {
        this.level3SlotString = force_String(new_value);
        slotInitialized("level3SlotString", new_value);
    }


    public float getLevel3SlotFloat() {
        return level3SlotFloat;
    }


    float getLevel3SlotFloat__NoWarn() {
        return level3SlotFloat;
    }


    Object getLevel3SlotFloat__AsObject() {
        return new Float(level3SlotFloat);
    }


    public void setLevel3SlotFloat(float __new_value) {
        float __old_value = level3SlotFloat;
        this.level3SlotFloat = __new_value;
        slotModified("level3SlotFloat", new Float(__old_value), new Float(__new_value), true, true);
    }


    public void setLevel3SlotFloat__AsObject(Object __new_value) {
        Object __old_value = getLevel3SlotFloat__AsObject();
        this.level3SlotFloat = force_float(__new_value);
        slotModified("level3SlotFloat", __old_value, __new_value, true, true);
    }


    protected void initializeLevel3SlotFloat(float new_value) {
        this.level3SlotFloat = new_value;
        slotInitialized("level3SlotFloat", new Float(new_value));
    }


    void initializeLevel3SlotFloat__AsObject(Object new_value) {
        this.level3SlotFloat = force_float(new_value);
        slotInitialized("level3SlotFloat", new_value);
    }


    public String getLevel1SlotString() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null) return "One";
       if (!(__raw_container instanceof Level2))
            throw new RuntimeException("Bogus container!");
       Level2 __container = (Level2) __raw_container;
       return __container.getLevel1SlotString();
    }


    Object getLevel1SlotString__AsObject() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null) return "One";
       if (!(__raw_container instanceof Level2)) {
            getLogger().warn("Container of " +this+ " is not a Level2: " + __raw_container);
            return null;
       }
       Level2 __container = (Level2) __raw_container;
       return __container.getLevel1SlotString__AsObject();
    }


    public float getRootSlotFloat() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null) return 0.0f;
       if (!(__raw_container instanceof Level2))
            throw new RuntimeException("Bogus container!");
       Level2 __container = (Level2) __raw_container;
       return __container.getRootSlotFloat();
    }


    Object getRootSlotFloat__AsObject() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null) return 0.0f;
       if (!(__raw_container instanceof Level2)) {
            getLogger().warn("Container of " +this+ " is not a Level2: " + __raw_container);
            return null;
       }
       Level2 __container = (Level2) __raw_container;
       return __container.getRootSlotFloat__AsObject();
    }


    public String getLevel2SlotString() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null) return "Two";
       if (!(__raw_container instanceof Level2))
            throw new RuntimeException("Bogus container!");
       Level2 __container = (Level2) __raw_container;
       return __container.getLevel2SlotString();
    }


    Object getLevel2SlotString__AsObject() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null) return "Two";
       if (!(__raw_container instanceof Level2)) {
            getLogger().warn("Container of " +this+ " is not a Level2: " + __raw_container);
            return null;
       }
       Level2 __container = (Level2) __raw_container;
       return __container.getLevel2SlotString__AsObject();
    }


    public float getLevel2SlotFloat() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null) return 2.0f;
       if (!(__raw_container instanceof Level2))
            throw new RuntimeException("Bogus container!");
       Level2 __container = (Level2) __raw_container;
       return __container.getLevel2SlotFloat();
    }


    Object getLevel2SlotFloat__AsObject() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null) return 2.0f;
       if (!(__raw_container instanceof Level2)) {
            getLogger().warn("Container of " +this+ " is not a Level2: " + __raw_container);
            return null;
       }
       Level2 __container = (Level2) __raw_container;
       return __container.getLevel2SlotFloat__AsObject();
    }


    public float getLevel1SlotFloat() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null) return 1.0f;
       if (!(__raw_container instanceof Level2))
            throw new RuntimeException("Bogus container!");
       Level2 __container = (Level2) __raw_container;
       return __container.getLevel1SlotFloat();
    }


    Object getLevel1SlotFloat__AsObject() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null) return 1.0f;
       if (!(__raw_container instanceof Level2)) {
            getLogger().warn("Container of " +this+ " is not a Level2: " + __raw_container);
            return null;
       }
       Level2 __container = (Level2) __raw_container;
       return __container.getLevel1SlotFloat__AsObject();
    }


    public String getRootSlotString() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null) return "Zero";
       if (!(__raw_container instanceof Level2))
            throw new RuntimeException("Bogus container!");
       Level2 __container = (Level2) __raw_container;
       return __container.getRootSlotString();
    }


    Object getRootSlotString__AsObject() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null) return "Zero";
       if (!(__raw_container instanceof Level2)) {
            getLogger().warn("Container of " +this+ " is not a Level2: " + __raw_container);
            return null;
       }
       Level2 __container = (Level2) __raw_container;
       return __container.getRootSlotString__AsObject();
    }


    @Override
   protected void fireContainerChanges(DataFrame __raw_old, DataFrame __raw_new) {
        if (!(__raw_old instanceof Level2)) {
            getLogger().warn("Container of " +this+ " is not a Level2: " + __raw_old);
            return;
        }
        if (!(__raw_new instanceof Level2)) {
            getLogger().warn("Container of " +this+ " is not a Level2: " + __raw_new);
            return;
        }
        Level2 __old_frame = (Level2) __raw_old;
        Level2 __new_frame = (Level2) __raw_new;
        Object __old;
        Object __new;
        __old = __old_frame.getLevel1SlotString__AsObject();
        __new = __new_frame.getLevel1SlotString__AsObject();
        if (__new != null) {
            if (__old == null || !__old.equals(__new)) {
                fireChange("level1SlotString", __old, __new);
            }
        }
        __old = __old_frame.getRootSlotFloat__AsObject();
        __new = __new_frame.getRootSlotFloat__AsObject();
        if (__new != null) {
            if (__old == null || !__old.equals(__new)) {
                fireChange("rootSlotFloat", __old, __new);
            }
        }
        __old = __old_frame.getLevel2SlotString__AsObject();
        __new = __new_frame.getLevel2SlotString__AsObject();
        if (__new != null) {
            if (__old == null || !__old.equals(__new)) {
                fireChange("level2SlotString", __old, __new);
            }
        }
        __old = __old_frame.getLevel2SlotFloat__AsObject();
        __new = __new_frame.getLevel2SlotFloat__AsObject();
        if (__new != null) {
            if (__old == null || !__old.equals(__new)) {
                fireChange("level2SlotFloat", __old, __new);
            }
        }
        __old = __old_frame.getLevel1SlotFloat__AsObject();
        __new = __new_frame.getLevel1SlotFloat__AsObject();
        if (__new != null) {
            if (__old == null || !__old.equals(__new)) {
                fireChange("level1SlotFloat", __old, __new);
            }
        }
        __old = __old_frame.getRootSlotString__AsObject();
        __new = __new_frame.getRootSlotString__AsObject();
        if (__new != null) {
            if (__old == null || !__old.equals(__new)) {
                fireChange("rootSlotString", __old, __new);
            }
        }
    }


    @Override
   protected void fireContainerChanges(DataFrame __raw) {
        if (!(__raw instanceof Level2)) {
            getLogger().warn("Container of " +this+ " is not a Level2: " + __raw);
            return;
        }
        Level2 __new_frame = (Level2) __raw;
        Object __new;
        __new = __new_frame.getLevel1SlotString__AsObject();
        if (__new != null) {
            fireChange("level1SlotString", null, __new);
        }
        __new = __new_frame.getRootSlotFloat__AsObject();
        if (__new != null) {
            fireChange("rootSlotFloat", null, __new);
        }
        __new = __new_frame.getLevel2SlotString__AsObject();
        if (__new != null) {
            fireChange("level2SlotString", null, __new);
        }
        __new = __new_frame.getLevel2SlotFloat__AsObject();
        if (__new != null) {
            fireChange("level2SlotFloat", null, __new);
        }
        __new = __new_frame.getLevel1SlotFloat__AsObject();
        if (__new != null) {
            fireChange("level1SlotFloat", null, __new);
        }
        __new = __new_frame.getRootSlotString__AsObject();
        if (__new != null) {
            fireChange("rootSlotString", null, __new);
        }
    }


    @Override
   protected Object getLocalValue(String __slot) {
       String __key = __slot.intern();
       if ("rootSlotFloat" == __key)
            return getRootSlotFloat__AsObject();
       else if ("level1SlotString" == __key)
            return getLevel1SlotString__AsObject();
       else if ("level2SlotString" == __key)
            return getLevel2SlotString__AsObject();
       else if ("level2SlotFloat" == __key)
            return getLevel2SlotFloat__AsObject();
       else if ("level3SlotString" == __key)
            return getLevel3SlotString__AsObject();
       else if ("level1SlotFloat" == __key)
            return getLevel1SlotFloat__AsObject();
       else if ("name" == __key)
            return getName__AsObject();
       else if ("level3SlotFloat" == __key)
            return getLevel3SlotFloat__AsObject();
       else if ("rootSlotString" == __key)
            return getRootSlotString__AsObject();
       else
           return super.getLocalValue(__slot);
    }


    @Override
   protected void setLocalValue(String __slot,
                                 Object __value) {
       String __key = __slot.intern();
       if ("level3SlotString" == __key)
            setLevel3SlotString__AsObject(__value);
       else if ("level3SlotFloat" == __key)
            setLevel3SlotFloat__AsObject(__value);
       else
            super.setLocalValue(__slot, __value);
    }


    @Override
   protected void initializeLocalValue(String __slot,
                                 Object __value) {
       String __key = __slot.intern();
       if ("level3SlotString" == __key)
            initializeLevel3SlotString__AsObject(__value);
       else if ("level3SlotFloat" == __key)
            initializeLevel3SlotFloat__AsObject(__value);
       else
            super.initializeLocalValue(__slot, __value);
    }


    @Override
   protected void collectSlotNames(java.util.Set<String> slots) {
        super.collectSlotNames(slots);
        slots.add("level3SlotString");
        slots.add("level3SlotFloat");
        slots.add("level1SlotString");
        slots.add("rootSlotFloat");
        slots.add("level2SlotString");
        slots.add("level2SlotFloat");
        slots.add("level1SlotFloat");
        slots.add("rootSlotString");
    }


    public SlotDescription slotMetaData__Level3SlotString() {
        SlotDescription __desc = new SlotDescription();
        __desc.name = "level3SlotString";
        __desc.prototype = "level3";
        __desc.is_writable = true;
        Object __value;
        __value = level3SlotString;
        if (__value != null) {
            __desc.is_overridden = true;
            __desc.value = __value;
        } else {
            __desc.is_overridden = false;
            __desc.value = "Three";
        }
        return __desc;
    }


    public SlotDescription slotMetaData__Level3SlotFloat() {
        SlotDescription __desc = new SlotDescription();
        __desc.name = "level3SlotFloat";
        __desc.prototype = "level3";
        __desc.is_writable = true;
        Object __value;
        __value = new Float(level3SlotFloat);
        if (__value != null) {
            __desc.is_overridden = true;
            __desc.value = __value;
        } else {
            __desc.is_overridden = false;
            __desc.value = new Float(3.0f);
        }
        return __desc;
    }


    public SlotDescription slotMetaData__Level1SlotString() {
        SlotDescription __desc = new SlotDescription();
        __desc.name = "level1SlotString";
        __desc.prototype = "level1";
        __desc.value = getLevel1SlotString__AsObject();
        __desc.is_overridden = false;
        __desc.is_writable = false;
        return __desc;
    }


    public SlotDescription slotMetaData__RootSlotFloat() {
        SlotDescription __desc = new SlotDescription();
        __desc.name = "rootSlotFloat";
        __desc.prototype = "root";
        __desc.value = getRootSlotFloat__AsObject();
        __desc.is_overridden = false;
        __desc.is_writable = false;
        return __desc;
    }


    public SlotDescription slotMetaData__Level2SlotString() {
        SlotDescription __desc = new SlotDescription();
        __desc.name = "level2SlotString";
        __desc.prototype = "level2";
        __desc.value = getLevel2SlotString__AsObject();
        __desc.is_overridden = false;
        __desc.is_writable = false;
        return __desc;
    }


    public SlotDescription slotMetaData__Level2SlotFloat() {
        SlotDescription __desc = new SlotDescription();
        __desc.name = "level2SlotFloat";
        __desc.prototype = "level2";
        __desc.value = getLevel2SlotFloat__AsObject();
        __desc.is_overridden = false;
        __desc.is_writable = false;
        return __desc;
    }


    public SlotDescription slotMetaData__Level1SlotFloat() {
        SlotDescription __desc = new SlotDescription();
        __desc.name = "level1SlotFloat";
        __desc.prototype = "level1";
        __desc.value = getLevel1SlotFloat__AsObject();
        __desc.is_overridden = false;
        __desc.is_writable = false;
        return __desc;
    }


    public SlotDescription slotMetaData__RootSlotString() {
        SlotDescription __desc = new SlotDescription();
        __desc.name = "rootSlotString";
        __desc.prototype = "root";
        __desc.value = getRootSlotString__AsObject();
        __desc.is_overridden = false;
        __desc.is_writable = false;
        return __desc;
    }


    @Override
   protected void collectSlotDescriptions(java.util.Map<String,SlotDescription> map) {
        super.collectSlotDescriptions(map);
        map.put("level3SlotString", slotMetaData__Level3SlotString());
        map.put("level3SlotFloat", slotMetaData__Level3SlotFloat());
        map.put("level1SlotString", slotMetaData__Level1SlotString());
        map.put("rootSlotFloat", slotMetaData__RootSlotFloat());
        map.put("level2SlotString", slotMetaData__Level2SlotString());
        map.put("level2SlotFloat", slotMetaData__Level2SlotFloat());
        map.put("level1SlotFloat", slotMetaData__Level1SlotFloat());
        map.put("rootSlotString", slotMetaData__RootSlotString());
    }
}
