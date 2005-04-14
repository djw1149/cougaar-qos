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

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.AttributesImpl;

import org.cougaar.core.util.UID;
import org.cougaar.util.log.Logger;
import org.cougaar.util.log.Logging;

/**
 * This extension to {@link Frame} is the runtime representation of a
 * prototype.  It's main job at runtime is to hold non-static default
 * values (static defaults are code-generated into constants) and to
 * process {@link Path} slot values.
 */
public class PrototypeFrame
    extends Frame
{
    private final String prototype_name;
    private transient Logger log = Logging.getLogger(getClass().getName());
    private transient Properties dynamic_values;
    private Properties slots;

    PrototypeFrame(FrameSet frameSet, 
		   String prototype_name,
		   String parent, 
		   UID uid, 
		   Properties slots)
    {
	super(frameSet, parent, uid);
	this.prototype_name = prototype_name;
	this.slots = slots;
	this.dynamic_values = new Properties();
    }

    Properties getLocalSlots()
    {
	Properties result = new Properties();
	Iterator itr = slots.entrySet().iterator();
	while (itr.hasNext()) {
	    Map.Entry entry = (Map.Entry) itr.next();
	    String slot_name = (String) entry.getKey();
	    Attributes attrs = (Attributes) entry.getValue();
	    Object slot_value = dynamic_values.get(slot_name);
	    if (slot_value != null) {
		result.put(slot_name, slot_value);
	    } else {
		slot_value = attrs.getValue("value");
		if (slot_value != null) result.put(slot_name, slot_value);
	    }
	}
	return result;
    }

    public void setValue(String slot, Object value)
    {
	dynamic_values.put(slot, value);
    }

    public Object getValue(String slot)
    {
	return getValue(this, slot);
    }

    Object getValue(Frame origin, String slot_name)
    {
	Object slot_value = dynamic_values.get(slot_name);
	if (slot_value != null) return slot_value;

	Attributes attrs = (Attributes) slots.get(slot_name);
	String value = attrs.getValue("value");
	String path_name = attrs.getValue("path");
	if (value != null) {
	    return value;
	} else if (path_name != null) {
	    Path path = getFrameSet().findPath(path_name);
	    return path.getValue(origin);
	} else {
	    if (log.isWarnEnabled())
		log.warn("Slot " +slot_name+ " is required by prototype "
			 +prototype_name+ 
			 " but was never provided in frame "
			 +origin);
	    return null;
	}
    }

    public String getName()
    {
	return prototype_name;
    }

    public String getPrototypeName()
    {
	return prototype_name;
    }


    public String toString()
    {
	return "<Prototype " +prototype_name+ " " +getUID()+ ">";
    }
}
