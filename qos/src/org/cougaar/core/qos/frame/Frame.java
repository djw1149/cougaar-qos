/*
 * <copyright>
 *  
 *  Copyright 1997-2004 BBNT Solutions, LLC
 *  under sponsorship of the Defense Advanced Research Projects
 *  Agency (DARPA).
 * 
 *  You can redistribute this software and/or modify it under the
 *  terms of the Cougaar Open Source License as published on the
 *  Cougaar Open Source Website (www.cougaar.org).
 * 
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 *  "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 *  LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 *  A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 *  OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 *  SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 *  LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 *  DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 *  THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 *  OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *  
 * </copyright>
 */

package org.cougaar.core.qos.frame;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


import org.cougaar.core.blackboard.ChangeReport;
import org.cougaar.core.util.UID;
import org.cougaar.core.util.UniqueObject;
import org.cougaar.util.log.Logger;
import org.cougaar.util.log.Logging;

public class Frame
    implements UniqueObject
{
    private final UID uid;
    private final String kind;
    private VisibleProperties properties;
    private transient FrameSet frameSet;
    private transient Logger log = Logging.getLogger(getClass().getName());

    public Frame(FrameSet frameSet, String kind, UID uid, Properties properties)
    {
	this.frameSet = frameSet;
	this.uid = uid;
	this.kind = kind;
	this.properties = new VisibleProperties(properties);
    }


    public String toString()
    {
	return "<Frame " +kind+ " " +uid+ ">";
    }

    // Basic accessors

    public boolean isa(String kind)
    {
	return frameSet.descendsFrom(this, kind);
    }

    public Frame relationshipParent()
    {
	return frameSet.getRelationshipParent(this);
    }

    public Frame relationshipChild()
    {
	return frameSet.getRelationshipChild(this);
    }

    public String getKind()
    {
	return kind;
    }

    // Only here for the Tasks servlet
    public VisibleProperties getLocalSlots()
    {
	return properties;
    }


    public VisibleProperties getDerivedSlots()
    {
	VisibleProperties props = new VisibleProperties();
	try {
	    Set slot_names = getAllSlotNames();
	    Iterator itr = slot_names.iterator();
	    while (itr.hasNext()) {
		String slot_name = (String) itr.next();
		if (!properties.containsKey(slot_name)) {
		    Object value = getValue(slot_name);
		    if (value != null) {
			props.put(slot_name, value);
		    } else {
			if (log.isInfoEnabled())
			    log.info("Derived slot " +slot_name+
				     " has no value");
		    }
		}
	    }
	} catch (Throwable t) {
	    log.error("Error computing derived slots", t);
	}

	return props;
    }

    public String getParentKind()
    {
	Frame parent = getParent();
	return parent == null ? null : parent.getKind();
    }

    Frame getPrototype()
    {
	Frame result = frameSet.getPrototype(this);
	if (result == null) {
	    if (log.isWarnEnabled()) log.warn(this + " has no prototype!");
	}
	return result;
    }

    Frame getParent()
    {
	Frame result = frameSet.getParent(this);
	if (result == null) {
	    if (log.isDebugEnabled()) log.debug(this + " has no parent!");
	}
	return result;
    }

    FrameSet getFrameSet()
    {
	return frameSet;
    }

    void copyToFrameSet(FrameSet frameSet)
    {
	frameSet.makeFrame(kind, properties, uid);
    }

    boolean matchesSlots(Properties slot_value_pairs)
    {
	Iterator itr = slot_value_pairs.entrySet().iterator();
	while (itr.hasNext()) {
	    Map.Entry entry = (Map.Entry) itr.next();
	    String slot = (String) entry.getKey();
	    Object value = getValue(slot);
	    if (value == null) return false;
	    if (!value.equals(entry.getValue())) return false;
	}
	return true;
    }

    // These should only be called from the FrameSet owning the
    // frame. 

    public void setValue(String slot, Object object)
    {
	properties.put(slot, object);
	frameSet.valueUpdated(this, slot, object);
    }


    public Object getValue(String slot)
    {
	return getValue(this, slot);
    }

    Object getValue(Frame origin, String slot)
    {
	Object result = properties.get(slot);
	if (result != null) return result;
	Frame prototype = frameSet.getPrototype(this);
	if (prototype != null) {
	    result = prototype.getValue(origin, slot);
	    if (result != null) return result;
	}
	Frame parent = frameSet.getParent(this);
	if (parent != null) {
	    return parent.getValue(origin, slot);
	}
	return null;
    }

    public Frame getSource(String slot)
    {
	if (properties.containsKey(slot)) return this;

	Frame result = null;
	Frame prototype = frameSet.getPrototype(this);
	if (prototype != null) {
	    result = prototype.getSource(slot);
	    if (result != null) return result;
	}
	Frame parent = frameSet.getParent(this);
	if (parent != null) {
	    return parent.getSource(slot);
	}
	return null;
    }

    void addLocalSlotNames(Set set)
    {
	if (properties != null) set.addAll(properties.keySet());
    }

    private void addSlotNames(Set set)
    {
	addLocalSlotNames(set);
	Frame prototype = frameSet.getPrototype(this);
	if (prototype != null) prototype.addSlotNames(set);
	Frame parent =  frameSet.getParent(this);
	if (parent != null) parent.addSlotNames(set);
    }

    public Set getAllSlotNames()
    {
	HashSet set = new HashSet();
	addSlotNames(set);
	return set;
    }
    

    public Set findRelations(String role, String relation)
    {
	return frameSet.findRelations(this, role, relation);
    }


    // UniqueObject
    public UID getUID()
    {
	return uid;
    }

    public void setUID(UID uid)
    {
	if (!uid.equals(this.uid))
	    throw new RuntimeException("UID already set");
    }

    // Object
    public boolean equals(Object o) 
    {
	return
	    ((o == this) ||
	     ((o instanceof Frame) &&
	      uid.equals(((Frame) o).uid)));
    }

    public int hashCode() 
    {
	return uid.hashCode();
    }

    // Hack for servlet
    public static class VisibleProperties extends Properties
    {
	VisibleProperties()
	{
	    super();
	}

	VisibleProperties(Properties properties) 
	{
	    super();
	    putAll(properties);
	}

	public String getContents()
	{
	    return this.toString();
	}
    }


    public static class Change implements ChangeReport {
	public final String slot;
	public final Object value;
	public Change(String attr, Object val)
	{
	    this.slot = attr;
	    this.value = val;
	}
	
	public String getSlot() { return slot; }

	public Object getValue() { return value; }

	// Object
	public boolean equals(Object o) 
	{
	    return
		((o == this) ||
		 ((o instanceof Change) &&
		  slot.equals(((Change) o).slot)));
	}

	public int hashCode() 
	{
	    return slot.hashCode();
	}
    }


}
