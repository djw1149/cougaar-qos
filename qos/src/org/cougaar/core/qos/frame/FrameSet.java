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

import java.util.Properties;
import java.util.Set;

import org.cougaar.core.util.UID;

public interface FrameSet
{
    public String getName();

    public String getPackageName();

    public boolean descendsFrom(Frame frame, String prototype);

    public Frame findFrame(String kind, String slot, Object value);

    public Frame findFrame(UID uid);

    public Path findPath(String name);

    public Path findPath(UID uid);

    public Set findFrames(String kind, 
			  Properties slot_value_pairs,
			  boolean includePrototypes);

    public Set findRelations(Frame root, String role, String relation);

    public Frame makeFrame(Frame frame);

    public Frame makeFrame(String kind, Properties slots);

    public Frame makeFrame(String kind, Properties slots, UID uid);

    public PrototypeFrame makePrototype(String kind, String parent, 
					Properties properties);

    public PrototypeFrame makePrototype(String kind, String parent, 
					Properties properties, UID uid);

    public Path  makePath(String name, Path.Fork[] forks, String slot);

    public void removeFrame(Frame frame);

    public Frame getParent(Frame frame);

    public Frame getPrototype(Frame frame);

    public Frame getRelationshipParent(Frame relationship);

    public Frame getRelationshipChild(Frame relationship);

    public void valueUpdated(Frame frame, String slot, Object value);

    public void processQueue();

    public Set getPrototypes();
}
