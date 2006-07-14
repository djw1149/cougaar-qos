package org.cougaar.core.qos.frame.topology;

import org.cougaar.core.qos.frame.DataFrame;
import org.cougaar.core.qos.frame.FrameSet;
import org.cougaar.core.qos.frame.SlotDescription;
import org.cougaar.core.qos.metrics.Metric;
import org.cougaar.core.util.UID;

public class Indicator
    extends Thing {
    static {
        org.cougaar.core.qos.frame.FrameMaker __fm = 
            new org.cougaar.core.qos.frame.FrameMaker() {
                public DataFrame makeFrame(FrameSet frameSet, UID uid) {
                     return new Indicator(frameSet, uid);
                }
            };
            DataFrame.registerFrameMaker("org.cougaar.core.qos.frame.topology", "indicator", __fm);
    }
    private String status;


    public Indicator(UID uid) {
        this(null, uid);
    }


    public Indicator(FrameSet frameSet,
                     UID uid) {
        super(frameSet, uid);
        initializeStatus("unknown");
    }


    public String getKind() {
        return "indicator";
    }


    protected void collectSlotValues(java.util.Properties __props) {
        super.collectSlotValues(__props);
        Object __value;
        __value = getStatus__AsObject();
        __props.put("status", __value != null ? __value : NIL);
    }


    protected void collectContainerSlotValues(java.util.Properties __props) {
        super.collectContainerSlotValues(__props);
        Object __value;
        __value = getBytesIn__AsObject();
        __props.put("bytesIn", __value != null ? __value : NIL);
        __value = getLoadAverage__AsObject();
        __props.put("loadAverage", __value != null ? __value : NIL);
        __value = getCpuLoadAverage__AsObject();
        __props.put("cpuLoadAverage", __value != null ? __value : NIL);
        __value = getJips__AsObject();
        __props.put("jips", __value != null ? __value : NIL);
        __value = getPersistSizeLast__AsObject();
        __props.put("persistSizeLast", __value != null ? __value : NIL);
        __value = getMsgIn__AsObject();
        __props.put("msgIn", __value != null ? __value : NIL);
        __value = getEffectiveMJips__AsObject();
        __props.put("effectiveMJips", __value != null ? __value : NIL);
        __value = getCpuLoadMJips__AsObject();
        __props.put("cpuLoadMJips", __value != null ? __value : NIL);
        __value = getBytesOut__AsObject();
        __props.put("bytesOut", __value != null ? __value : NIL);
        __value = getCount__AsObject();
        __props.put("count", __value != null ? __value : NIL);
        __value = getVmSize__AsObject();
        __props.put("vmSize", __value != null ? __value : NIL);
        __value = getMsgOut__AsObject();
        __props.put("msgOut", __value != null ? __value : NIL);
    }


    public String getStatus() {
        return status;
    }


    String getStatus__NoWarn() {
        return status;
    }


    Object getStatus__AsObject() {
        return status;
    }


    public void setStatus(String __new_value) {
        String __old_value = status;
        this.status = __new_value;
        slotModified("status", __old_value, __new_value, true, true);
    }


    public void setStatus__AsObject(Object __new_value) {
        Object __old_value = getStatus__AsObject();
        this.status = force_String(__new_value);
        slotModified("status", __old_value, __new_value, true, true);
    }


    protected void initializeStatus(String new_value) {
        this.status = new_value;
        slotInitialized("status", new_value);
    }


    void initializeStatus__AsObject(Object new_value) {
        this.status = force_String(new_value);
        slotInitialized("status", new_value);
    }


    public Metric getBytesIn() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null)
            throw new RuntimeException("No container!");
       if (!(__raw_container instanceof Agent))
            throw new RuntimeException("Bogus container!");
       Agent __container = (Agent) __raw_container;
       return __container.getBytesIn();
    }


    Object getBytesIn__AsObject() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null) return null;
       if (!(__raw_container instanceof Agent)) {
            getLogger().warn("Container of " +this+ " is not a Agent: " + __raw_container);
            return null;
       }
       Agent __container = (Agent) __raw_container;
       return __container.getBytesIn__AsObject();
    }


    public Metric getLoadAverage() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null)
            throw new RuntimeException("No container!");
       if (!(__raw_container instanceof Agent))
            throw new RuntimeException("Bogus container!");
       Agent __container = (Agent) __raw_container;
       return __container.getLoadAverage();
    }


    Object getLoadAverage__AsObject() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null) return null;
       if (!(__raw_container instanceof Agent)) {
            getLogger().warn("Container of " +this+ " is not a Agent: " + __raw_container);
            return null;
       }
       Agent __container = (Agent) __raw_container;
       return __container.getLoadAverage__AsObject();
    }


    public Metric getCpuLoadAverage() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null)
            throw new RuntimeException("No container!");
       if (!(__raw_container instanceof Agent))
            throw new RuntimeException("Bogus container!");
       Agent __container = (Agent) __raw_container;
       return __container.getCpuLoadAverage();
    }


    Object getCpuLoadAverage__AsObject() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null) return null;
       if (!(__raw_container instanceof Agent)) {
            getLogger().warn("Container of " +this+ " is not a Agent: " + __raw_container);
            return null;
       }
       Agent __container = (Agent) __raw_container;
       return __container.getCpuLoadAverage__AsObject();
    }


    public Metric getJips() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null)
            throw new RuntimeException("No container!");
       if (!(__raw_container instanceof Agent))
            throw new RuntimeException("Bogus container!");
       Agent __container = (Agent) __raw_container;
       return __container.getJips();
    }


    Object getJips__AsObject() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null) return null;
       if (!(__raw_container instanceof Agent)) {
            getLogger().warn("Container of " +this+ " is not a Agent: " + __raw_container);
            return null;
       }
       Agent __container = (Agent) __raw_container;
       return __container.getJips__AsObject();
    }


    public Metric getPersistSizeLast() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null)
            throw new RuntimeException("No container!");
       if (!(__raw_container instanceof Agent))
            throw new RuntimeException("Bogus container!");
       Agent __container = (Agent) __raw_container;
       return __container.getPersistSizeLast();
    }


    Object getPersistSizeLast__AsObject() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null) return null;
       if (!(__raw_container instanceof Agent)) {
            getLogger().warn("Container of " +this+ " is not a Agent: " + __raw_container);
            return null;
       }
       Agent __container = (Agent) __raw_container;
       return __container.getPersistSizeLast__AsObject();
    }


    public Metric getMsgIn() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null)
            throw new RuntimeException("No container!");
       if (!(__raw_container instanceof Agent))
            throw new RuntimeException("Bogus container!");
       Agent __container = (Agent) __raw_container;
       return __container.getMsgIn();
    }


    Object getMsgIn__AsObject() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null) return null;
       if (!(__raw_container instanceof Agent)) {
            getLogger().warn("Container of " +this+ " is not a Agent: " + __raw_container);
            return null;
       }
       Agent __container = (Agent) __raw_container;
       return __container.getMsgIn__AsObject();
    }


    public Metric getEffectiveMJips() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null)
            throw new RuntimeException("No container!");
       if (!(__raw_container instanceof Agent))
            throw new RuntimeException("Bogus container!");
       Agent __container = (Agent) __raw_container;
       return __container.getEffectiveMJips();
    }


    Object getEffectiveMJips__AsObject() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null) return null;
       if (!(__raw_container instanceof Agent)) {
            getLogger().warn("Container of " +this+ " is not a Agent: " + __raw_container);
            return null;
       }
       Agent __container = (Agent) __raw_container;
       return __container.getEffectiveMJips__AsObject();
    }


    public Metric getCpuLoadMJips() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null)
            throw new RuntimeException("No container!");
       if (!(__raw_container instanceof Agent))
            throw new RuntimeException("Bogus container!");
       Agent __container = (Agent) __raw_container;
       return __container.getCpuLoadMJips();
    }


    Object getCpuLoadMJips__AsObject() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null) return null;
       if (!(__raw_container instanceof Agent)) {
            getLogger().warn("Container of " +this+ " is not a Agent: " + __raw_container);
            return null;
       }
       Agent __container = (Agent) __raw_container;
       return __container.getCpuLoadMJips__AsObject();
    }


    public Metric getBytesOut() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null)
            throw new RuntimeException("No container!");
       if (!(__raw_container instanceof Agent))
            throw new RuntimeException("Bogus container!");
       Agent __container = (Agent) __raw_container;
       return __container.getBytesOut();
    }


    Object getBytesOut__AsObject() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null) return null;
       if (!(__raw_container instanceof Agent)) {
            getLogger().warn("Container of " +this+ " is not a Agent: " + __raw_container);
            return null;
       }
       Agent __container = (Agent) __raw_container;
       return __container.getBytesOut__AsObject();
    }


    public Metric getCount() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null)
            throw new RuntimeException("No container!");
       if (!(__raw_container instanceof Agent))
            throw new RuntimeException("Bogus container!");
       Agent __container = (Agent) __raw_container;
       return __container.getCount();
    }


    Object getCount__AsObject() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null) return null;
       if (!(__raw_container instanceof Agent)) {
            getLogger().warn("Container of " +this+ " is not a Agent: " + __raw_container);
            return null;
       }
       Agent __container = (Agent) __raw_container;
       return __container.getCount__AsObject();
    }


    public Metric getVmSize() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null)
            throw new RuntimeException("No container!");
       if (!(__raw_container instanceof Agent))
            throw new RuntimeException("Bogus container!");
       Agent __container = (Agent) __raw_container;
       return __container.getVmSize();
    }


    Object getVmSize__AsObject() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null) return null;
       if (!(__raw_container instanceof Agent)) {
            getLogger().warn("Container of " +this+ " is not a Agent: " + __raw_container);
            return null;
       }
       Agent __container = (Agent) __raw_container;
       return __container.getVmSize__AsObject();
    }


    public Metric getMsgOut() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null)
            throw new RuntimeException("No container!");
       if (!(__raw_container instanceof Agent))
            throw new RuntimeException("Bogus container!");
       Agent __container = (Agent) __raw_container;
       return __container.getMsgOut();
    }


    Object getMsgOut__AsObject() {
       Object __raw_container = containerFrame();
       if ( __raw_container == null) return null;
       if (!(__raw_container instanceof Agent)) {
            getLogger().warn("Container of " +this+ " is not a Agent: " + __raw_container);
            return null;
       }
       Agent __container = (Agent) __raw_container;
       return __container.getMsgOut__AsObject();
    }


    protected void fireContainerChanges(DataFrame __raw_old, DataFrame __raw_new) {
        if (!(__raw_old instanceof Agent)) {
            getLogger().warn("Container of " +this+ " is not a Agent: " + __raw_old);
            return;
        }
        if (!(__raw_new instanceof Agent)) {
            getLogger().warn("Container of " +this+ " is not a Agent: " + __raw_new);
            return;
        }
        Agent __old_frame = (Agent) __raw_old;
        Agent __new_frame = (Agent) __raw_new;
        Object __old;
        Object __new;
        __old = __old_frame.getBytesIn__AsObject();
        __new = __new_frame.getBytesIn__AsObject();
        if (__new != null) {
            if (__old == null || !__old.equals(__new)) {
                fireChange("bytesIn", __old, __new);
            }
        }
        __old = __old_frame.getLoadAverage__AsObject();
        __new = __new_frame.getLoadAverage__AsObject();
        if (__new != null) {
            if (__old == null || !__old.equals(__new)) {
                fireChange("loadAverage", __old, __new);
            }
        }
        __old = __old_frame.getCpuLoadAverage__AsObject();
        __new = __new_frame.getCpuLoadAverage__AsObject();
        if (__new != null) {
            if (__old == null || !__old.equals(__new)) {
                fireChange("cpuLoadAverage", __old, __new);
            }
        }
        __old = __old_frame.getJips__AsObject();
        __new = __new_frame.getJips__AsObject();
        if (__new != null) {
            if (__old == null || !__old.equals(__new)) {
                fireChange("jips", __old, __new);
            }
        }
        __old = __old_frame.getPersistSizeLast__AsObject();
        __new = __new_frame.getPersistSizeLast__AsObject();
        if (__new != null) {
            if (__old == null || !__old.equals(__new)) {
                fireChange("persistSizeLast", __old, __new);
            }
        }
        __old = __old_frame.getMsgIn__AsObject();
        __new = __new_frame.getMsgIn__AsObject();
        if (__new != null) {
            if (__old == null || !__old.equals(__new)) {
                fireChange("msgIn", __old, __new);
            }
        }
        __old = __old_frame.getEffectiveMJips__AsObject();
        __new = __new_frame.getEffectiveMJips__AsObject();
        if (__new != null) {
            if (__old == null || !__old.equals(__new)) {
                fireChange("effectiveMJips", __old, __new);
            }
        }
        __old = __old_frame.getCpuLoadMJips__AsObject();
        __new = __new_frame.getCpuLoadMJips__AsObject();
        if (__new != null) {
            if (__old == null || !__old.equals(__new)) {
                fireChange("cpuLoadMJips", __old, __new);
            }
        }
        __old = __old_frame.getBytesOut__AsObject();
        __new = __new_frame.getBytesOut__AsObject();
        if (__new != null) {
            if (__old == null || !__old.equals(__new)) {
                fireChange("bytesOut", __old, __new);
            }
        }
        __old = __old_frame.getCount__AsObject();
        __new = __new_frame.getCount__AsObject();
        if (__new != null) {
            if (__old == null || !__old.equals(__new)) {
                fireChange("count", __old, __new);
            }
        }
        __old = __old_frame.getVmSize__AsObject();
        __new = __new_frame.getVmSize__AsObject();
        if (__new != null) {
            if (__old == null || !__old.equals(__new)) {
                fireChange("vmSize", __old, __new);
            }
        }
        __old = __old_frame.getMsgOut__AsObject();
        __new = __new_frame.getMsgOut__AsObject();
        if (__new != null) {
            if (__old == null || !__old.equals(__new)) {
                fireChange("msgOut", __old, __new);
            }
        }
    }


    protected void fireContainerChanges(DataFrame __raw) {
        if (!(__raw instanceof Agent)) {
            getLogger().warn("Container of " +this+ " is not a Agent: " + __raw);
            return;
        }
        Agent __new_frame = (Agent) __raw;
        Object __new;
        __new = __new_frame.getBytesIn__AsObject();
        if (__new != null) {
            fireChange("bytesIn", null, __new);
        }
        __new = __new_frame.getLoadAverage__AsObject();
        if (__new != null) {
            fireChange("loadAverage", null, __new);
        }
        __new = __new_frame.getCpuLoadAverage__AsObject();
        if (__new != null) {
            fireChange("cpuLoadAverage", null, __new);
        }
        __new = __new_frame.getJips__AsObject();
        if (__new != null) {
            fireChange("jips", null, __new);
        }
        __new = __new_frame.getPersistSizeLast__AsObject();
        if (__new != null) {
            fireChange("persistSizeLast", null, __new);
        }
        __new = __new_frame.getMsgIn__AsObject();
        if (__new != null) {
            fireChange("msgIn", null, __new);
        }
        __new = __new_frame.getEffectiveMJips__AsObject();
        if (__new != null) {
            fireChange("effectiveMJips", null, __new);
        }
        __new = __new_frame.getCpuLoadMJips__AsObject();
        if (__new != null) {
            fireChange("cpuLoadMJips", null, __new);
        }
        __new = __new_frame.getBytesOut__AsObject();
        if (__new != null) {
            fireChange("bytesOut", null, __new);
        }
        __new = __new_frame.getCount__AsObject();
        if (__new != null) {
            fireChange("count", null, __new);
        }
        __new = __new_frame.getVmSize__AsObject();
        if (__new != null) {
            fireChange("vmSize", null, __new);
        }
        __new = __new_frame.getMsgOut__AsObject();
        if (__new != null) {
            fireChange("msgOut", null, __new);
        }
    }
    private static final int bytesIn__HashVar__ = "bytesIn".hashCode();
    private static final int jips__HashVar__ = "jips".hashCode();
    private static final int persistSizeLast__HashVar__ = "persistSizeLast".hashCode();
    private static final int status__HashVar__ = "status".hashCode();
    private static final int cpuLoadMJips__HashVar__ = "cpuLoadMJips".hashCode();
    private static final int loadAverage__HashVar__ = "loadAverage".hashCode();
    private static final int cpuLoadAverage__HashVar__ = "cpuLoadAverage".hashCode();
    private static final int msgIn__HashVar__ = "msgIn".hashCode();
    private static final int effectiveMJips__HashVar__ = "effectiveMJips".hashCode();
    private static final int count__HashVar__ = "count".hashCode();
    private static final int bytesOut__HashVar__ = "bytesOut".hashCode();
    private static final int name__HashVar__ = "name".hashCode();
    private static final int msgOut__HashVar__ = "msgOut".hashCode();
    private static final int vmSize__HashVar__ = "vmSize".hashCode();


    protected Object getLocalValue(String __slot) {
       int __key = __slot.hashCode();
       if (bytesIn__HashVar__ == __key)
            return getBytesIn__AsObject();
       else if (jips__HashVar__ == __key)
            return getJips__AsObject();
       else if (persistSizeLast__HashVar__ == __key)
            return getPersistSizeLast__AsObject();
       else if (status__HashVar__ == __key)
            return getStatus__AsObject();
       else if (cpuLoadMJips__HashVar__ == __key)
            return getCpuLoadMJips__AsObject();
       else if (loadAverage__HashVar__ == __key)
            return getLoadAverage__AsObject();
       else if (cpuLoadAverage__HashVar__ == __key)
            return getCpuLoadAverage__AsObject();
       else if (msgIn__HashVar__ == __key)
            return getMsgIn__AsObject();
       else if (effectiveMJips__HashVar__ == __key)
            return getEffectiveMJips__AsObject();
       else if (count__HashVar__ == __key)
            return getCount__AsObject();
       else if (bytesOut__HashVar__ == __key)
            return getBytesOut__AsObject();
       else if (name__HashVar__ == __key)
            return getName__AsObject();
       else if (msgOut__HashVar__ == __key)
            return getMsgOut__AsObject();
       else if (vmSize__HashVar__ == __key)
            return getVmSize__AsObject();
       else
           return super.getLocalValue(__slot);
    }


    protected void setLocalValue(String __slot,
                                 Object __value) {
       int __key = __slot.hashCode();
       if (status__HashVar__ == __key)
            setStatus__AsObject(__value);
       else
            super.setLocalValue(__slot, __value);
    }


    protected void initializeLocalValue(String __slot,
                                 Object __value) {
       int __key = __slot.hashCode();
       if (status__HashVar__ == __key)
            initializeStatus__AsObject(__value);
       else
            super.initializeLocalValue(__slot, __value);
    }


    public SlotDescription slotMetaData__Status() {
        SlotDescription __desc = new SlotDescription();
        __desc.name = "status";
        __desc.prototype = "indicator";
        __desc.is_writable = true;
        Object __value;
        __value = status;
        if (__value != null) {
            __desc.is_overridden = true;
            __desc.value = __value;
        } else {
            __desc.is_overridden = false;
            __desc.value = "unknown";
        }
        return __desc;
    }


    public SlotDescription slotMetaData__BytesIn() {
        SlotDescription __desc = new SlotDescription();
        __desc.name = "bytesIn";
        __desc.prototype = "agent";
        __desc.value = getBytesIn__AsObject();
        __desc.is_overridden = false;
        __desc.is_writable = false;
        return __desc;
    }


    public SlotDescription slotMetaData__LoadAverage() {
        SlotDescription __desc = new SlotDescription();
        __desc.name = "loadAverage";
        __desc.prototype = "host";
        __desc.value = getLoadAverage__AsObject();
        __desc.is_overridden = false;
        __desc.is_writable = false;
        return __desc;
    }


    public SlotDescription slotMetaData__CpuLoadAverage() {
        SlotDescription __desc = new SlotDescription();
        __desc.name = "cpuLoadAverage";
        __desc.prototype = "agent";
        __desc.value = getCpuLoadAverage__AsObject();
        __desc.is_overridden = false;
        __desc.is_writable = false;
        return __desc;
    }


    public SlotDescription slotMetaData__Jips() {
        SlotDescription __desc = new SlotDescription();
        __desc.name = "jips";
        __desc.prototype = "host";
        __desc.value = getJips__AsObject();
        __desc.is_overridden = false;
        __desc.is_writable = false;
        return __desc;
    }


    public SlotDescription slotMetaData__PersistSizeLast() {
        SlotDescription __desc = new SlotDescription();
        __desc.name = "persistSizeLast";
        __desc.prototype = "agent";
        __desc.value = getPersistSizeLast__AsObject();
        __desc.is_overridden = false;
        __desc.is_writable = false;
        return __desc;
    }


    public SlotDescription slotMetaData__MsgIn() {
        SlotDescription __desc = new SlotDescription();
        __desc.name = "msgIn";
        __desc.prototype = "agent";
        __desc.value = getMsgIn__AsObject();
        __desc.is_overridden = false;
        __desc.is_writable = false;
        return __desc;
    }


    public SlotDescription slotMetaData__EffectiveMJips() {
        SlotDescription __desc = new SlotDescription();
        __desc.name = "effectiveMJips";
        __desc.prototype = "host";
        __desc.value = getEffectiveMJips__AsObject();
        __desc.is_overridden = false;
        __desc.is_writable = false;
        return __desc;
    }


    public SlotDescription slotMetaData__CpuLoadMJips() {
        SlotDescription __desc = new SlotDescription();
        __desc.name = "cpuLoadMJips";
        __desc.prototype = "agent";
        __desc.value = getCpuLoadMJips__AsObject();
        __desc.is_overridden = false;
        __desc.is_writable = false;
        return __desc;
    }


    public SlotDescription slotMetaData__BytesOut() {
        SlotDescription __desc = new SlotDescription();
        __desc.name = "bytesOut";
        __desc.prototype = "agent";
        __desc.value = getBytesOut__AsObject();
        __desc.is_overridden = false;
        __desc.is_writable = false;
        return __desc;
    }


    public SlotDescription slotMetaData__Count() {
        SlotDescription __desc = new SlotDescription();
        __desc.name = "count";
        __desc.prototype = "host";
        __desc.value = getCount__AsObject();
        __desc.is_overridden = false;
        __desc.is_writable = false;
        return __desc;
    }


    public SlotDescription slotMetaData__VmSize() {
        SlotDescription __desc = new SlotDescription();
        __desc.name = "vmSize";
        __desc.prototype = "node";
        __desc.value = getVmSize__AsObject();
        __desc.is_overridden = false;
        __desc.is_writable = false;
        return __desc;
    }


    public SlotDescription slotMetaData__MsgOut() {
        SlotDescription __desc = new SlotDescription();
        __desc.name = "msgOut";
        __desc.prototype = "agent";
        __desc.value = getMsgOut__AsObject();
        __desc.is_overridden = false;
        __desc.is_writable = false;
        return __desc;
    }


    protected void collectSlotDescriptions(java.util.Map<String,SlotDescription> map) {
        super.collectSlotDescriptions(map);
        map.put("status", slotMetaData__Status());
        map.put("bytesIn", slotMetaData__BytesIn());
        map.put("loadAverage", slotMetaData__LoadAverage());
        map.put("cpuLoadAverage", slotMetaData__CpuLoadAverage());
        map.put("jips", slotMetaData__Jips());
        map.put("persistSizeLast", slotMetaData__PersistSizeLast());
        map.put("msgIn", slotMetaData__MsgIn());
        map.put("effectiveMJips", slotMetaData__EffectiveMJips());
        map.put("cpuLoadMJips", slotMetaData__CpuLoadMJips());
        map.put("bytesOut", slotMetaData__BytesOut());
        map.put("count", slotMetaData__Count());
        map.put("vmSize", slotMetaData__VmSize());
        map.put("msgOut", slotMetaData__MsgOut());
    }
}
