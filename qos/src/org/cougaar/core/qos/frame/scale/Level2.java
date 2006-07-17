package org.cougaar.core.qos.frame.scale;

import org.cougaar.core.qos.frame.DataFrame;
import org.cougaar.core.qos.frame.FrameSet;
import org.cougaar.core.qos.frame.SlotDescription;
import org.cougaar.core.util.UID;

public class Level2
    extends Thing {
    static {
        org.cougaar.core.qos.frame.FrameMaker __fm = 
            new org.cougaar.core.qos.frame.FrameMaker() {
                public DataFrame makeFrame(FrameSet frameSet, UID uid) {
                     return new Level2(frameSet, uid);
                }
            };
            DataFrame.registerFrameMaker("org.cougaar.core.qos.frame.scale", "level2", __fm);
    }
    private String level2SlotString;
    private float level2SlotFloat;


    public Level2(UID uid) {
        this(null, uid);
    }


    public Level2(FrameSet frameSet,
                  UID uid) {
        super(frameSet, uid);
        initializeLevel2SlotString("Two");
        initializeLevel2SlotFloat(2.0f);
    }


    public String getKind() {
        return "level2";
    }


    protected void collectSlotValues(java.util.Properties __props) {
        super.collectSlotValues(__props);
        Object __value;
        __value = getLevel2SlotString__AsObject();
        __props.put("level2SlotString", __value != null ? __value : NIL);
        __value = getLevel2SlotFloat__AsObject();
        __props.put("level2SlotFloat", __value != null ? __value : NIL);
    }


    protected void collectContainerSlotValues(java.util.Properties __props) {
        super.collectContainerSlotValues(__props);
        Object __value;
        __value = getLevel1SlotString__AsObject();
        __props.put("level1SlotString", __value != null ? __value : NIL);
        __value = getRootSlotFloat__AsObject();
        __props.put("rootSlotFloat", __value != null ? __value : NIL);
        __value = getLevel1SlotFloat__AsObject();
        __props.put("level1SlotFloat", __value != null ? __value : NIL);
        __value = getRootSlotString__AsObject();
        __props.put("rootSlotString", __value != null ? __value : NIL);
    }


    public String getLevel2SlotString() {
        return level2SlotString;
    }


    String getLevel2SlotString__NoWarn() {
        return level2SlotString;
    }


    Object getLevel2SlotString__AsObject() {
        return level2SlotString;
    }


    public void setLevel2SlotString(String __new_value) {
        String __old_value = level2SlotString;
        this.level2SlotString = __new_value;
        slotModified("level2SlotString", __old_value, __new_value, true, true);
    }


    public void setLevel2SlotString__AsObject(Object __new_value) {
        Object __old_value = getLevel2SlotString__AsObject();
        this.level2SlotString = force_String(__new_value);
        slotModified("level2SlotString", __old_value, __new_value, true, true);
    }


    protected void initializeLevel2SlotString(String new_value) {
        this.level2SlotString = new_value;
        slotInitialized("level2SlotString", new_value);
    }


    void initializeLevel2SlotString__AsObject(Object new_value) {
        this.level2SlotString = force_String(new_value);
        slotInitialized("level2SlotString", new_value);
    }


    public float getLevel2SlotFloat() {
        return level2SlotFloat;
    }


    float getLevel2SlotFloat__NoWarn() {
        return level2SlotFloat;
    }


    Object getLevel2SlotFloat__AsObject() {
        return new Float(level2SlotFloat);
    }


    public void setLevel2SlotFloat(float __new_value) {
        float __old_value = level2SlotFloat;
        this.level2SlotFloat = __new_value;
        slotModified("level2SlotFloat", new Float(__old_value), new Float(__new_value), true, true);
    }


    public void setLevel2SlotFloat__AsObject(Object __new_value) {
        Object __old_value = getLevel2SlotFloat__AsObject();
        this.level2SlotFloat = force_float(__new_value);
        slotModified("level2SlotFloat", __old_value, __new_value, true, true);
    }


    protected void initializeLevel2SlotFloat(float new_value) {
        this.level2SlotFloat = new_value;
        slotInitialized("level2SlotFloat", new Float(new_value));
    }


    void initializeLevel2SlotFloat__AsObject(Object new_value) {
        this.level2SlotFloat = force_float(new_value);
        slotInitialized("level2SlotFloat", new_value);
    }


    public String getLevel1SlotString() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null)
            throw new RuntimeException("No container!");
       if (!(__raw_container instanceof Level1))
            throw new RuntimeException("Bogus container!");
       Level1 __container = (Level1) __raw_container;
       return __container.getLevel1SlotString();
    }


    Object getLevel1SlotString__AsObject() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null) return null;
       if (!(__raw_container instanceof Level1)) {
            getLogger().warn("Container of " +this+ " is not a Level1: " + __raw_container);
            return null;
       }
       Level1 __container = (Level1) __raw_container;
       return __container.getLevel1SlotString__AsObject();
    }


    public float getRootSlotFloat() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null)
            throw new RuntimeException("No container!");
       if (!(__raw_container instanceof Level1))
            throw new RuntimeException("Bogus container!");
       Level1 __container = (Level1) __raw_container;
       return __container.getRootSlotFloat();
    }


    Object getRootSlotFloat__AsObject() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null) return null;
       if (!(__raw_container instanceof Level1)) {
            getLogger().warn("Container of " +this+ " is not a Level1: " + __raw_container);
            return null;
       }
       Level1 __container = (Level1) __raw_container;
       return __container.getRootSlotFloat__AsObject();
    }


    public float getLevel1SlotFloat() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null)
            throw new RuntimeException("No container!");
       if (!(__raw_container instanceof Level1))
            throw new RuntimeException("Bogus container!");
       Level1 __container = (Level1) __raw_container;
       return __container.getLevel1SlotFloat();
    }


    Object getLevel1SlotFloat__AsObject() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null) return null;
       if (!(__raw_container instanceof Level1)) {
            getLogger().warn("Container of " +this+ " is not a Level1: " + __raw_container);
            return null;
       }
       Level1 __container = (Level1) __raw_container;
       return __container.getLevel1SlotFloat__AsObject();
    }


    public String getRootSlotString() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null)
            throw new RuntimeException("No container!");
       if (!(__raw_container instanceof Level1))
            throw new RuntimeException("Bogus container!");
       Level1 __container = (Level1) __raw_container;
       return __container.getRootSlotString();
    }


    Object getRootSlotString__AsObject() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null) return null;
       if (!(__raw_container instanceof Level1)) {
            getLogger().warn("Container of " +this+ " is not a Level1: " + __raw_container);
            return null;
       }
       Level1 __container = (Level1) __raw_container;
       return __container.getRootSlotString__AsObject();
    }


    protected void fireContainerChanges(DataFrame __raw_old, DataFrame __raw_new) {
        if (!(__raw_old instanceof Level1)) {
            getLogger().warn("Container of " +this+ " is not a Level1: " + __raw_old);
            return;
        }
        if (!(__raw_new instanceof Level1)) {
            getLogger().warn("Container of " +this+ " is not a Level1: " + __raw_new);
            return;
        }
        Level1 __old_frame = (Level1) __raw_old;
        Level1 __new_frame = (Level1) __raw_new;
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


    protected void fireContainerChanges(DataFrame __raw) {
        if (!(__raw instanceof Level1)) {
            getLogger().warn("Container of " +this+ " is not a Level1: " + __raw);
            return;
        }
        Level1 __new_frame = (Level1) __raw;
        Object __new;
        __new = __new_frame.getLevel1SlotString__AsObject();
        if (__new != null) {
            fireChange("level1SlotString", null, __new);
        }
        __new = __new_frame.getRootSlotFloat__AsObject();
        if (__new != null) {
            fireChange("rootSlotFloat", null, __new);
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
    private static final int rootSlotFloat__HashVar__ = "rootSlotFloat".hashCode();
    private static final int level1SlotString__HashVar__ = "level1SlotString".hashCode();
    private static final int level2SlotString__HashVar__ = "level2SlotString".hashCode();
    private static final int level2SlotFloat__HashVar__ = "level2SlotFloat".hashCode();
    private static final int name__HashVar__ = "name".hashCode();
    private static final int level1SlotFloat__HashVar__ = "level1SlotFloat".hashCode();
    private static final int rootSlotString__HashVar__ = "rootSlotString".hashCode();


    protected Object getLocalValue(String __slot) {
       int __key = __slot.hashCode();
       if (rootSlotFloat__HashVar__ == __key)
            return getRootSlotFloat__AsObject();
       else if (level1SlotString__HashVar__ == __key)
            return getLevel1SlotString__AsObject();
       else if (level2SlotString__HashVar__ == __key)
            return getLevel2SlotString__AsObject();
       else if (level2SlotFloat__HashVar__ == __key)
            return getLevel2SlotFloat__AsObject();
       else if (name__HashVar__ == __key)
            return getName__AsObject();
       else if (level1SlotFloat__HashVar__ == __key)
            return getLevel1SlotFloat__AsObject();
       else if (rootSlotString__HashVar__ == __key)
            return getRootSlotString__AsObject();
       else
           return super.getLocalValue(__slot);
    }


    protected void setLocalValue(String __slot,
                                 Object __value) {
       int __key = __slot.hashCode();
       if (level2SlotString__HashVar__ == __key)
            setLevel2SlotString__AsObject(__value);
       else if (level2SlotFloat__HashVar__ == __key)
            setLevel2SlotFloat__AsObject(__value);
       else
            super.setLocalValue(__slot, __value);
    }


    protected void initializeLocalValue(String __slot,
                                 Object __value) {
       int __key = __slot.hashCode();
       if (level2SlotString__HashVar__ == __key)
            initializeLevel2SlotString__AsObject(__value);
       else if (level2SlotFloat__HashVar__ == __key)
            initializeLevel2SlotFloat__AsObject(__value);
       else
            super.initializeLocalValue(__slot, __value);
    }


    public SlotDescription slotMetaData__Level2SlotString() {
        SlotDescription __desc = new SlotDescription();
        __desc.name = "level2SlotString";
        __desc.prototype = "level2";
        __desc.is_writable = true;
        Object __value;
        __value = level2SlotString;
        if (__value != null) {
            __desc.is_overridden = true;
            __desc.value = __value;
        } else {
            __desc.is_overridden = false;
            __desc.value = "Two";
        }
        return __desc;
    }


    public SlotDescription slotMetaData__Level2SlotFloat() {
        SlotDescription __desc = new SlotDescription();
        __desc.name = "level2SlotFloat";
        __desc.prototype = "level2";
        __desc.is_writable = true;
        Object __value;
        __value = new Float(level2SlotFloat);
        if (__value != null) {
            __desc.is_overridden = true;
            __desc.value = __value;
        } else {
            __desc.is_overridden = false;
            __desc.value = new Float(2.0f);
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


    protected void collectSlotDescriptions(java.util.Map<String,SlotDescription> map) {
        super.collectSlotDescriptions(map);
        map.put("level2SlotString", slotMetaData__Level2SlotString());
        map.put("level2SlotFloat", slotMetaData__Level2SlotFloat());
        map.put("level1SlotString", slotMetaData__Level1SlotString());
        map.put("rootSlotFloat", slotMetaData__RootSlotFloat());
        map.put("level1SlotFloat", slotMetaData__Level1SlotFloat());
        map.put("rootSlotString", slotMetaData__RootSlotString());
    }
}