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

package org.cougaar.core.qos.frame.scale;

import java.util.Properties;

import org.cougaar.core.component.ServiceBroker;
import org.cougaar.core.qos.frame.FrameSet;
import org.cougaar.core.qos.frame.FrameSetService;
import org.cougaar.core.qos.metrics.ParameterizedPlugin;
import org.cougaar.core.service.LoggingService;

public class HierarchyGeneratorPlugin extends ParameterizedPlugin implements FrameSetService.Callback {
    private FrameSet frameset;
    private LoggingService log;
    private boolean populated;
    private int height;
    private int degree;
    
    public void start() {
	height = (int) getParameter("height", 1)+1; // height is really max depth
	degree = (int) getParameter("degree", 2);
	String frameSetName = getParameter("frame-set");
	ServiceBroker sb = getServiceBroker();
	log = (LoggingService) sb.getService(this, LoggingService.class, null);
	FrameSetService fss = (FrameSetService) sb.getService(this, FrameSetService.class, null);
	if (fss == null) {
	    log.error("Couldn't find FrameSetService");
	} else {
	    frameset = fss.findFrameSet(frameSetName, this);
	}
	super.start();
    }
    
    private void makeNextLevel(Thing frame, int level) {
	if (level == height) {
	    // done recursion
	    return;
	}
	String type = "level" + level;
	String rtype = type + "On" + (level == 1 ? "Root" : "Level"+(level-1));
	String parentName = frame.getName();
	Properties slots = new Properties();
	Properties empty = new Properties();
	for (int i=1; i<=degree; i++) {
	    String childName = parentName + "." + i;
	    slots.put("name", childName);
	    Thing child = (Thing) frameset.makeFrame(type, slots);
	    Relationship r = (Relationship) frameset.makeFrame(rtype, empty);
	    r.setChildValue(childName);
	    r.setParentValue(parentName);
	    makeNextLevel(child, level+1);
	}
    }

    private void populateFrameSet() {
	log.shout("Starting data creation");
	long now = System.currentTimeMillis();
	Properties slots = new Properties();
	slots.put("name", "1");
	Root root = (Root) frameset.makeFrame("root", slots);
	makeNextLevel(root, 1);
	long duration = System.currentTimeMillis()-now;
	log.shout("Completed data creation in " + duration/1000+ " seconds");
	populated = true;
    }
    
    protected void execute() {
	if (frameset != null && !populated) {
	    populateFrameSet();
	}
    }

    protected void setupSubscriptions() {
	if (frameset != null && !populated) {
	    populateFrameSet();
	}
    }

    public void frameSetAvailable(String name, FrameSet set) {
	frameset = set;
	getBlackboardService().signalClientActivity();
    }

}
