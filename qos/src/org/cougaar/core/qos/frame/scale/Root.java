package org.cougaar.core.qos.frame.scale;

import org.cougaar.core.qos.frame.DataFrame;
import org.cougaar.core.qos.frame.FrameSet;
import org.cougaar.core.qos.frame.SlotDescription;
import org.cougaar.core.util.UID;

public class Root
    extends Thing {
    static {
        org.cougaar.core.qos.frame.FrameMaker __fm = 
            new org.cougaar.core.qos.frame.FrameMaker() {
                public DataFrame makeFrame(FrameSet frameSet, UID uid) {
                     return new Root(frameSet, uid);
                }
            };
            DataFrame.registerFrameMaker("org.cougaar.core.qos.frame.scale", "root", __fm);
    }
    private float rootSlotFloat;
    private float avgLevel1;
    private int count;
    private String rootSlotString;


    public Root(UID uid) {
        this(null, uid);
    }


    public Root(FrameSet frameSet,
                UID uid) {
        super(frameSet, uid);
        initializeRootSlotFloat(0.0f);
        initializeCount(0);
        initializeRootSlotString("Zero");
    }


    public String getKind() {
        return "root";
    }


    protected void collectSlotValues(java.util.Properties __props) {
        super.collectSlotValues(__props);
        Object __value;
        __value = getRootSlotFloat__AsObject();
        __props.put("rootSlotFloat", __value != null ? __value : NIL);
        __value = getAvgLevel1__AsObject();
        __props.put("avgLevel1", __value != null ? __value : NIL);
        __value = getCount__AsObject();
        __props.put("count", __value != null ? __value : NIL);
        __value = getRootSlotString__AsObject();
        __props.put("rootSlotString", __value != null ? __value : NIL);
    }


    public float getRootSlotFloat() {
        return rootSlotFloat;
    }


    float getRootSlotFloat__NoWarn() {
        return rootSlotFloat;
    }


    Object getRootSlotFloat__AsObject() {
        return new Float(rootSlotFloat);
    }


    public void setRootSlotFloat(float __new_value) {
        float __old_value = rootSlotFloat;
        this.rootSlotFloat = __new_value;
        slotModified("rootSlotFloat", new Float(__old_value), new Float(__new_value), true, true);
    }


    public void setRootSlotFloat__AsObject(Object __new_value) {
        Object __old_value = getRootSlotFloat__AsObject();
        this.rootSlotFloat = force_float(__new_value);
        slotModified("rootSlotFloat", __old_value, __new_value, true, true);
    }


    protected void initializeRootSlotFloat(float new_value) {
        this.rootSlotFloat = new_value;
        slotInitialized("rootSlotFloat", new Float(new_value));
    }


    void initializeRootSlotFloat__AsObject(Object new_value) {
        this.rootSlotFloat = force_float(new_value);
        slotInitialized("rootSlotFloat", new_value);
    }


    public float getAvgLevel1() {
        return avgLevel1;
    }


    float getAvgLevel1__NoWarn() {
        return avgLevel1;
    }


    Object getAvgLevel1__AsObject() {
        return new Float(avgLevel1);
    }


    public void setAvgLevel1(float __new_value) {
        float __old_value = avgLevel1;
        this.avgLevel1 = __new_value;
        slotModified("avgLevel1", new Float(__old_value), new Float(__new_value), true, true);
    }


    public void setAvgLevel1__AsObject(Object __new_value) {
        Object __old_value = getAvgLevel1__AsObject();
        this.avgLevel1 = force_float(__new_value);
        slotModified("avgLevel1", __old_value, __new_value, true, true);
    }


    protected void initializeAvgLevel1(float new_value) {
        this.avgLevel1 = new_value;
        slotInitialized("avgLevel1", new Float(new_value));
    }


    void initializeAvgLevel1__AsObject(Object new_value) {
        this.avgLevel1 = force_float(new_value);
        slotInitialized("avgLevel1", new_value);
    }


    public int getCount() {
        return count;
    }


    int getCount__NoWarn() {
        return count;
    }


    Object getCount__AsObject() {
        return new Integer(count);
    }


    public void setCount(int __new_value) {
        int __old_value = count;
        this.count = __new_value;
        slotModified("count", new Integer(__old_value), new Integer(__new_value), true, true);
    }


    public void setCount__AsObject(Object __new_value) {
        Object __old_value = getCount__AsObject();
        this.count = force_int(__new_value);
        slotModified("count", __old_value, __new_value, true, true);
    }


    protected void initializeCount(int new_value) {
        this.count = new_value;
        slotInitialized("count", new Integer(new_value));
    }


    void initializeCount__AsObject(Object new_value) {
        this.count = force_int(new_value);
        slotInitialized("count", new_value);
    }


    public String getRootSlotString() {
        return rootSlotString;
    }


    String getRootSlotString__NoWarn() {
        return rootSlotString;
    }


    Object getRootSlotString__AsObject() {
        return rootSlotString;
    }


    public void setRootSlotString(String __new_value) {
        String __old_value = rootSlotString;
        this.rootSlotString = __new_value;
        slotModified("rootSlotString", __old_value, __new_value, true, true);
    }


    public void setRootSlotString__AsObject(Object __new_value) {
        Object __old_value = getRootSlotString__AsObject();
        this.rootSlotString = force_String(__new_value);
        slotModified("rootSlotString", __old_value, __new_value, true, true);
    }


    protected void initializeRootSlotString(String new_value) {
        this.rootSlotString = new_value;
        slotInitialized("rootSlotString", new_value);
    }


    void initializeRootSlotString__AsObject(Object new_value) {
        this.rootSlotString = force_String(new_value);
        slotInitialized("rootSlotString", new_value);
    }
    private static final int rootSlotFloat__HashVar__ = "rootSlotFloat".hashCode();
    private static final int avgLevel1__HashVar__ = "avgLevel1".hashCode();
    private static final int count__HashVar__ = "count".hashCode();
    private static final int rootSlotString__HashVar__ = "rootSlotString".hashCode();


    protected Object getLocalValue(String __slot) {
       int __key = __slot.hashCode();
       if (rootSlotFloat__HashVar__ == __key)
            return getRootSlotFloat__AsObject();
       else if (avgLevel1__HashVar__ == __key)
            return getAvgLevel1__AsObject();
       else if (count__HashVar__ == __key)
            return getCount__AsObject();
       else if (rootSlotString__HashVar__ == __key)
            return getRootSlotString__AsObject();
       else
           return super.getLocalValue(__slot);
    }


    protected void setLocalValue(String __slot,
                                 Object __value) {
       int __key = __slot.hashCode();
       if (rootSlotFloat__HashVar__ == __key)
            setRootSlotFloat__AsObject(__value);
       else if (avgLevel1__HashVar__ == __key)
            setAvgLevel1__AsObject(__value);
       else if (count__HashVar__ == __key)
            setCount__AsObject(__value);
       else if (rootSlotString__HashVar__ == __key)
            setRootSlotString__AsObject(__value);
       else
            super.setLocalValue(__slot, __value);
    }


    protected void initializeLocalValue(String __slot,
                                 Object __value) {
       int __key = __slot.hashCode();
       if (rootSlotFloat__HashVar__ == __key)
            initializeRootSlotFloat__AsObject(__value);
       else if (avgLevel1__HashVar__ == __key)
            initializeAvgLevel1__AsObject(__value);
       else if (count__HashVar__ == __key)
            initializeCount__AsObject(__value);
       else if (rootSlotString__HashVar__ == __key)
            initializeRootSlotString__AsObject(__value);
       else
            super.initializeLocalValue(__slot, __value);
    }


    protected void collectSlotNames(java.util.Set<String> slots) {
        super.collectSlotNames(slots);
        slots.add("rootSlotFloat");
        slots.add("avgLevel1");
        slots.add("count");
        slots.add("rootSlotString");
    }


    public SlotDescription slotMetaData__RootSlotFloat() {
        SlotDescription __desc = new SlotDescription();
        __desc.name = "rootSlotFloat";
        __desc.prototype = "root";
        __desc.is_writable = true;
        Object __value;
        __value = new Float(rootSlotFloat);
        if (__value != null) {
            __desc.is_overridden = true;
            __desc.value = __value;
        } else {
            __desc.is_overridden = false;
            __desc.value = new Float(0.0f);
        }
        return __desc;
    }


    public SlotDescription slotMetaData__AvgLevel1() {
        SlotDescription __desc = new SlotDescription();
        __desc.name = "avgLevel1";
        __desc.prototype = "root";
        __desc.is_writable = true;
        Object __value;
        __value = new Float(avgLevel1);
        if (__value != null) {
            __desc.is_overridden = true;
            __desc.value = __value;
        } else {
            __desc.is_overridden = false;
        }
        return __desc;
    }


    public SlotDescription slotMetaData__Count() {
        SlotDescription __desc = new SlotDescription();
        __desc.name = "count";
        __desc.prototype = "root";
        __desc.is_writable = true;
        Object __value;
        __value = new Integer(count);
        if (__value != null) {
            __desc.is_overridden = true;
            __desc.value = __value;
        } else {
            __desc.is_overridden = false;
            __desc.value = new Integer(0);
        }
        return __desc;
    }


    public SlotDescription slotMetaData__RootSlotString() {
        SlotDescription __desc = new SlotDescription();
        __desc.name = "rootSlotString";
        __desc.prototype = "root";
        __desc.is_writable = true;
        Object __value;
        __value = rootSlotString;
        if (__value != null) {
            __desc.is_overridden = true;
            __desc.value = __value;
        } else {
            __desc.is_overridden = false;
            __desc.value = "Zero";
        }
        return __desc;
    }


    protected void collectSlotDescriptions(java.util.Map<String,SlotDescription> map) {
        super.collectSlotDescriptions(map);
        map.put("rootSlotFloat", slotMetaData__RootSlotFloat());
        map.put("avgLevel1", slotMetaData__AvgLevel1());
        map.put("count", slotMetaData__Count());
        map.put("rootSlotString", slotMetaData__RootSlotString());
    }
}
