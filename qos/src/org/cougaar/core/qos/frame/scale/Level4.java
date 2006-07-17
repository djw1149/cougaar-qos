package org.cougaar.core.qos.frame.scale;

import org.cougaar.core.qos.frame.DataFrame;
import org.cougaar.core.qos.frame.FrameSet;
import org.cougaar.core.qos.frame.SlotDescription;
import org.cougaar.core.util.UID;

public class Level4
    extends Thing {
    static {
        org.cougaar.core.qos.frame.FrameMaker __fm = 
            new org.cougaar.core.qos.frame.FrameMaker() {
                public DataFrame makeFrame(FrameSet frameSet, UID uid) {
                     return new Level4(frameSet, uid);
                }
            };
            DataFrame.registerFrameMaker("org.cougaar.core.qos.frame.scale", "level4", __fm);
    }
    private float level4SlotFloat;
    private String level4SlotString;


    public Level4(UID uid) {
        this(null, uid);
    }


    public Level4(FrameSet frameSet,
                  UID uid) {
        super(frameSet, uid);
        initializeLevel4SlotFloat(4.0f);
        initializeLevel4SlotString("Four");
    }


    public String getKind() {
        return "level4";
    }


    protected void collectSlotValues(java.util.Properties __props) {
        super.collectSlotValues(__props);
        Object __value;
        __value = getLevel4SlotFloat__AsObject();
        __props.put("level4SlotFloat", __value != null ? __value : NIL);
        __value = getLevel4SlotString__AsObject();
        __props.put("level4SlotString", __value != null ? __value : NIL);
    }


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
        __value = getLevel3SlotString__AsObject();
        __props.put("level3SlotString", __value != null ? __value : NIL);
        __value = getLevel1SlotFloat__AsObject();
        __props.put("level1SlotFloat", __value != null ? __value : NIL);
        __value = getLevel3SlotFloat__AsObject();
        __props.put("level3SlotFloat", __value != null ? __value : NIL);
        __value = getRootSlotString__AsObject();
        __props.put("rootSlotString", __value != null ? __value : NIL);
    }


    public float getLevel4SlotFloat() {
        return level4SlotFloat;
    }


    float getLevel4SlotFloat__NoWarn() {
        return level4SlotFloat;
    }


    Object getLevel4SlotFloat__AsObject() {
        return new Float(level4SlotFloat);
    }


    public void setLevel4SlotFloat(float __new_value) {
        float __old_value = level4SlotFloat;
        this.level4SlotFloat = __new_value;
        slotModified("level4SlotFloat", new Float(__old_value), new Float(__new_value), true, true);
    }


    public void setLevel4SlotFloat__AsObject(Object __new_value) {
        Object __old_value = getLevel4SlotFloat__AsObject();
        this.level4SlotFloat = force_float(__new_value);
        slotModified("level4SlotFloat", __old_value, __new_value, true, true);
    }


    protected void initializeLevel4SlotFloat(float new_value) {
        this.level4SlotFloat = new_value;
        slotInitialized("level4SlotFloat", new Float(new_value));
    }


    void initializeLevel4SlotFloat__AsObject(Object new_value) {
        this.level4SlotFloat = force_float(new_value);
        slotInitialized("level4SlotFloat", new_value);
    }


    public String getLevel4SlotString() {
        return level4SlotString;
    }


    String getLevel4SlotString__NoWarn() {
        return level4SlotString;
    }


    Object getLevel4SlotString__AsObject() {
        return level4SlotString;
    }


    public void setLevel4SlotString(String __new_value) {
        String __old_value = level4SlotString;
        this.level4SlotString = __new_value;
        slotModified("level4SlotString", __old_value, __new_value, true, true);
    }


    public void setLevel4SlotString__AsObject(Object __new_value) {
        Object __old_value = getLevel4SlotString__AsObject();
        this.level4SlotString = force_String(__new_value);
        slotModified("level4SlotString", __old_value, __new_value, true, true);
    }


    protected void initializeLevel4SlotString(String new_value) {
        this.level4SlotString = new_value;
        slotInitialized("level4SlotString", new_value);
    }


    void initializeLevel4SlotString__AsObject(Object new_value) {
        this.level4SlotString = force_String(new_value);
        slotInitialized("level4SlotString", new_value);
    }


    public String getLevel1SlotString() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null)
            throw new RuntimeException("No container!");
       if (!(__raw_container instanceof Level3))
            throw new RuntimeException("Bogus container!");
       Level3 __container = (Level3) __raw_container;
       return __container.getLevel1SlotString();
    }


    Object getLevel1SlotString__AsObject() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null) return null;
       if (!(__raw_container instanceof Level3)) {
            getLogger().warn("Container of " +this+ " is not a Level3: " + __raw_container);
            return null;
       }
       Level3 __container = (Level3) __raw_container;
       return __container.getLevel1SlotString__AsObject();
    }


    public float getRootSlotFloat() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null)
            throw new RuntimeException("No container!");
       if (!(__raw_container instanceof Level3))
            throw new RuntimeException("Bogus container!");
       Level3 __container = (Level3) __raw_container;
       return __container.getRootSlotFloat();
    }


    Object getRootSlotFloat__AsObject() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null) return null;
       if (!(__raw_container instanceof Level3)) {
            getLogger().warn("Container of " +this+ " is not a Level3: " + __raw_container);
            return null;
       }
       Level3 __container = (Level3) __raw_container;
       return __container.getRootSlotFloat__AsObject();
    }


    public String getLevel2SlotString() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null)
            throw new RuntimeException("No container!");
       if (!(__raw_container instanceof Level3))
            throw new RuntimeException("Bogus container!");
       Level3 __container = (Level3) __raw_container;
       return __container.getLevel2SlotString();
    }


    Object getLevel2SlotString__AsObject() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null) return null;
       if (!(__raw_container instanceof Level3)) {
            getLogger().warn("Container of " +this+ " is not a Level3: " + __raw_container);
            return null;
       }
       Level3 __container = (Level3) __raw_container;
       return __container.getLevel2SlotString__AsObject();
    }


    public float getLevel2SlotFloat() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null)
            throw new RuntimeException("No container!");
       if (!(__raw_container instanceof Level3))
            throw new RuntimeException("Bogus container!");
       Level3 __container = (Level3) __raw_container;
       return __container.getLevel2SlotFloat();
    }


    Object getLevel2SlotFloat__AsObject() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null) return null;
       if (!(__raw_container instanceof Level3)) {
            getLogger().warn("Container of " +this+ " is not a Level3: " + __raw_container);
            return null;
       }
       Level3 __container = (Level3) __raw_container;
       return __container.getLevel2SlotFloat__AsObject();
    }


    public String getLevel3SlotString() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null)
            throw new RuntimeException("No container!");
       if (!(__raw_container instanceof Level3))
            throw new RuntimeException("Bogus container!");
       Level3 __container = (Level3) __raw_container;
       return __container.getLevel3SlotString();
    }


    Object getLevel3SlotString__AsObject() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null) return null;
       if (!(__raw_container instanceof Level3)) {
            getLogger().warn("Container of " +this+ " is not a Level3: " + __raw_container);
            return null;
       }
       Level3 __container = (Level3) __raw_container;
       return __container.getLevel3SlotString__AsObject();
    }


    public float getLevel1SlotFloat() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null)
            throw new RuntimeException("No container!");
       if (!(__raw_container instanceof Level3))
            throw new RuntimeException("Bogus container!");
       Level3 __container = (Level3) __raw_container;
       return __container.getLevel1SlotFloat();
    }


    Object getLevel1SlotFloat__AsObject() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null) return null;
       if (!(__raw_container instanceof Level3)) {
            getLogger().warn("Container of " +this+ " is not a Level3: " + __raw_container);
            return null;
       }
       Level3 __container = (Level3) __raw_container;
       return __container.getLevel1SlotFloat__AsObject();
    }


    public float getLevel3SlotFloat() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null)
            throw new RuntimeException("No container!");
       if (!(__raw_container instanceof Level3))
            throw new RuntimeException("Bogus container!");
       Level3 __container = (Level3) __raw_container;
       return __container.getLevel3SlotFloat();
    }


    Object getLevel3SlotFloat__AsObject() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null) return null;
       if (!(__raw_container instanceof Level3)) {
            getLogger().warn("Container of " +this+ " is not a Level3: " + __raw_container);
            return null;
       }
       Level3 __container = (Level3) __raw_container;
       return __container.getLevel3SlotFloat__AsObject();
    }


    public String getRootSlotString() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null)
            throw new RuntimeException("No container!");
       if (!(__raw_container instanceof Level3))
            throw new RuntimeException("Bogus container!");
       Level3 __container = (Level3) __raw_container;
       return __container.getRootSlotString();
    }


    Object getRootSlotString__AsObject() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null) return null;
       if (!(__raw_container instanceof Level3)) {
            getLogger().warn("Container of " +this+ " is not a Level3: " + __raw_container);
            return null;
       }
       Level3 __container = (Level3) __raw_container;
       return __container.getRootSlotString__AsObject();
    }


    protected void fireContainerChanges(DataFrame __raw_old, DataFrame __raw_new) {
        if (!(__raw_old instanceof Level3)) {
            getLogger().warn("Container of " +this+ " is not a Level3: " + __raw_old);
            return;
        }
        if (!(__raw_new instanceof Level3)) {
            getLogger().warn("Container of " +this+ " is not a Level3: " + __raw_new);
            return;
        }
        Level3 __old_frame = (Level3) __raw_old;
        Level3 __new_frame = (Level3) __raw_new;
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
        __old = __old_frame.getLevel3SlotString__AsObject();
        __new = __new_frame.getLevel3SlotString__AsObject();
        if (__new != null) {
            if (__old == null || !__old.equals(__new)) {
                fireChange("level3SlotString", __old, __new);
            }
        }
        __old = __old_frame.getLevel1SlotFloat__AsObject();
        __new = __new_frame.getLevel1SlotFloat__AsObject();
        if (__new != null) {
            if (__old == null || !__old.equals(__new)) {
                fireChange("level1SlotFloat", __old, __new);
            }
        }
        __old = __old_frame.getLevel3SlotFloat__AsObject();
        __new = __new_frame.getLevel3SlotFloat__AsObject();
        if (__new != null) {
            if (__old == null || !__old.equals(__new)) {
                fireChange("level3SlotFloat", __old, __new);
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
        if (!(__raw instanceof Level3)) {
            getLogger().warn("Container of " +this+ " is not a Level3: " + __raw);
            return;
        }
        Level3 __new_frame = (Level3) __raw;
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
        __new = __new_frame.getLevel3SlotString__AsObject();
        if (__new != null) {
            fireChange("level3SlotString", null, __new);
        }
        __new = __new_frame.getLevel1SlotFloat__AsObject();
        if (__new != null) {
            fireChange("level1SlotFloat", null, __new);
        }
        __new = __new_frame.getLevel3SlotFloat__AsObject();
        if (__new != null) {
            fireChange("level3SlotFloat", null, __new);
        }
        __new = __new_frame.getRootSlotString__AsObject();
        if (__new != null) {
            fireChange("rootSlotString", null, __new);
        }
    }
    private static final int level4SlotFloat__HashVar__ = "level4SlotFloat".hashCode();
    private static final int rootSlotFloat__HashVar__ = "rootSlotFloat".hashCode();
    private static final int level1SlotString__HashVar__ = "level1SlotString".hashCode();
    private static final int level2SlotString__HashVar__ = "level2SlotString".hashCode();
    private static final int level4SlotString__HashVar__ = "level4SlotString".hashCode();
    private static final int level2SlotFloat__HashVar__ = "level2SlotFloat".hashCode();
    private static final int level3SlotString__HashVar__ = "level3SlotString".hashCode();
    private static final int level1SlotFloat__HashVar__ = "level1SlotFloat".hashCode();
    private static final int name__HashVar__ = "name".hashCode();
    private static final int rootSlotString__HashVar__ = "rootSlotString".hashCode();
    private static final int level3SlotFloat__HashVar__ = "level3SlotFloat".hashCode();


    protected Object getLocalValue(String __slot) {
       int __key = __slot.hashCode();
       if (level4SlotFloat__HashVar__ == __key)
            return getLevel4SlotFloat__AsObject();
       else if (rootSlotFloat__HashVar__ == __key)
            return getRootSlotFloat__AsObject();
       else if (level1SlotString__HashVar__ == __key)
            return getLevel1SlotString__AsObject();
       else if (level2SlotString__HashVar__ == __key)
            return getLevel2SlotString__AsObject();
       else if (level4SlotString__HashVar__ == __key)
            return getLevel4SlotString__AsObject();
       else if (level2SlotFloat__HashVar__ == __key)
            return getLevel2SlotFloat__AsObject();
       else if (level3SlotString__HashVar__ == __key)
            return getLevel3SlotString__AsObject();
       else if (level1SlotFloat__HashVar__ == __key)
            return getLevel1SlotFloat__AsObject();
       else if (name__HashVar__ == __key)
            return getName__AsObject();
       else if (rootSlotString__HashVar__ == __key)
            return getRootSlotString__AsObject();
       else if (level3SlotFloat__HashVar__ == __key)
            return getLevel3SlotFloat__AsObject();
       else
           return super.getLocalValue(__slot);
    }


    protected void setLocalValue(String __slot,
                                 Object __value) {
       int __key = __slot.hashCode();
       if (level4SlotFloat__HashVar__ == __key)
            setLevel4SlotFloat__AsObject(__value);
       else if (level4SlotString__HashVar__ == __key)
            setLevel4SlotString__AsObject(__value);
       else
            super.setLocalValue(__slot, __value);
    }


    protected void initializeLocalValue(String __slot,
                                 Object __value) {
       int __key = __slot.hashCode();
       if (level4SlotFloat__HashVar__ == __key)
            initializeLevel4SlotFloat__AsObject(__value);
       else if (level4SlotString__HashVar__ == __key)
            initializeLevel4SlotString__AsObject(__value);
       else
            super.initializeLocalValue(__slot, __value);
    }


    public SlotDescription slotMetaData__Level4SlotFloat() {
        SlotDescription __desc = new SlotDescription();
        __desc.name = "level4SlotFloat";
        __desc.prototype = "level4";
        __desc.is_writable = true;
        Object __value;
        __value = new Float(level4SlotFloat);
        if (__value != null) {
            __desc.is_overridden = true;
            __desc.value = __value;
        } else {
            __desc.is_overridden = false;
            __desc.value = new Float(4.0f);
        }
        return __desc;
    }


    public SlotDescription slotMetaData__Level4SlotString() {
        SlotDescription __desc = new SlotDescription();
        __desc.name = "level4SlotString";
        __desc.prototype = "level4";
        __desc.is_writable = true;
        Object __value;
        __value = level4SlotString;
        if (__value != null) {
            __desc.is_overridden = true;
            __desc.value = __value;
        } else {
            __desc.is_overridden = false;
            __desc.value = "Four";
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


    public SlotDescription slotMetaData__Level3SlotString() {
        SlotDescription __desc = new SlotDescription();
        __desc.name = "level3SlotString";
        __desc.prototype = "level3";
        __desc.value = getLevel3SlotString__AsObject();
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


    public SlotDescription slotMetaData__Level3SlotFloat() {
        SlotDescription __desc = new SlotDescription();
        __desc.name = "level3SlotFloat";
        __desc.prototype = "level3";
        __desc.value = getLevel3SlotFloat__AsObject();
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
        map.put("level4SlotFloat", slotMetaData__Level4SlotFloat());
        map.put("level4SlotString", slotMetaData__Level4SlotString());
        map.put("level1SlotString", slotMetaData__Level1SlotString());
        map.put("rootSlotFloat", slotMetaData__RootSlotFloat());
        map.put("level2SlotString", slotMetaData__Level2SlotString());
        map.put("level2SlotFloat", slotMetaData__Level2SlotFloat());
        map.put("level3SlotString", slotMetaData__Level3SlotString());
        map.put("level1SlotFloat", slotMetaData__Level1SlotFloat());
        map.put("level3SlotFloat", slotMetaData__Level3SlotFloat());
        map.put("rootSlotString", slotMetaData__RootSlotString());
    }
}