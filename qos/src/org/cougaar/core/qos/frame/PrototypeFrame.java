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

import java.io.PrintWriter;
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

    public Properties getLocalSlots()
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

    Object getValue(Frame origin, String slot_name)
    {
	// Look for a dynamically set default first.
	Object slot_value = dynamic_values.get(slot_name);
	if (slot_value != null) return slot_value;

	Attributes attrs = (Attributes) slots.get(slot_name);
	if (attrs != null) {
	    // Declared at this level -- either get a real value or
	    // complain and return null.
	    Object result = null;
	    String value = attrs.getValue("value");
	    String path_name = attrs.getValue("path");
	    if (value != null) {
		result = value;
	    } else if (path_name != null) {
		Path path = getFrameSet().findPath(path_name);
		result = path.getValue((DataFrame) origin);
	    } else {
		if (log.isWarnEnabled())
		    log.warn("Slot " +slot_name+ " is required by prototype "
			     +prototype_name+ 
			     " but was never provided in frame "
			     +origin);
	    }
	    return result;
	} else {
	    // Not owned by us, check super
	    return getInheritedValue((DataFrame) origin, slot_name);
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

    public boolean isa(String kind)
    {
	if (frameSet == null) return kind.equals(prototype_name);
	return frameSet.descendsFrom(this, kind);
    }


    void dumpLocalSlots(PrintWriter writer, int indentation, int offset)
    {
	Map slots = getLocalSlots();
	Iterator itr = slots.entrySet().iterator();
	while (itr.hasNext()) {
	    Map.Entry entry = (Map.Entry) itr.next();
	    String slot_name = (String) entry.getKey();
	    Attributes attrs = (Attributes) entry.getValue();
	    String slot_value = attrs.getValue("value");
	    String path = attrs.getValue("path");
	    String staticp = attrs.getValue("static");
	    String memberp = attrs.getValue("member");
	    for (int i=0; i<indentation; i++) writer.print(' ');
	    writer.print("<slot name=\"" +slot_name+ "\"");
	    if (slot_value != null)
		writer.print(" value=\"" +slot_value+ "\"");
	    else if (path != null)
		writer.print(" path=" +path+ "\"");
	    if (staticp != null) writer.print(" static=\"" +staticp+ "\"");
	    if (memberp != null) writer.print(" member=\"" +memberp+ "\"");
	    writer.println("/>");
	}
    }

    void dump(PrintWriter writer, int indentation, int offset)
    {
	for (int i=0; i<indentation; i++) writer.print(' ');
	writer.println("<prototype name=" +prototype_name+
		       " prototype=\"" +getKind()+ "\">");
	dumpLocalSlots(writer, indentation+offset, offset);
	for (int i=0; i<indentation; i++) writer.print(' ');
	writer.println("</frame>");
    }


}
