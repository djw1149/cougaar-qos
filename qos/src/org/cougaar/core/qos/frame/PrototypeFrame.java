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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.cougaar.core.util.UID;

public class PrototypeFrame
    extends Frame
{
    private final String prototype_name;
    private transient HashMap paths;

    PrototypeFrame(FrameSet frameSet, String prototype_name,
		   String parent, UID uid, Properties properties)
    {
	super(frameSet, parent, uid, properties);
	this.prototype_name = prototype_name;
    }

    void addPaths(HashMap paths)
    {
	this.paths = paths;
    }

    Object getValue(Frame origin, String slot)
    {
	if (paths != null) {
	    Path path = (Path) paths.get(slot);
	    if (path != null) {
		Object result = path.getValue(origin);
		if (result != null) return result;
	    }
	}
	return super.getValue(origin, slot);
    }

    public String getPrototypeName()
    {
	return prototype_name;
    }


    public String toString()
    {
	return "<Prototype " +prototype_name+ " " +getUID()+ ">";
    }

    void copyToFrameSet(FrameSet frameSet)
    {
	frameSet.makePrototype(prototype_name, getKind(), getLocalSlots(), 
			       getUID());
    }

    void addLocalSlotNames(Set set)
    {
	super.addLocalSlotNames(set);
	if (paths != null) set.addAll(paths.keySet());
    }

}
