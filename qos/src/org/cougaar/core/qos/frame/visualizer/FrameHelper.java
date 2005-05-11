/*
 * <copyright>
 *  
 *  Copyright 1997-2005 BBNT Solutions, LLC
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

package org.cougaar.core.qos.frame.visualizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import org.cougaar.core.blackboard.IncrementalSubscription;
import org.cougaar.core.component.ServiceBroker;
import org.cougaar.core.qos.frame.*;
import org.cougaar.core.qos.frame.visualizer.test.ContainsPredicate;
import org.cougaar.core.qos.frame.visualizer.test.FramePredicate;
import org.cougaar.core.qos.metrics.ParameterizedPlugin;
import org.cougaar.core.service.BlackboardService;
import org.cougaar.core.service.LoggingService;
import org.cougaar.util.ConfigFinder;
import org.cougaar.util.UnaryPredicate;
import org.cougaar.util.log.Logger;
import org.cougaar.util.log.Logging;





public class FrameHelper {
    protected static int sid=0;
    protected int internalid = sid++;
    protected FrameSet frameSet;
    protected Collection allFrames;
    protected HashSet dataFrames;
    protected Collection relationshipFrames;

    protected HashMap frameMap;
    private Object lock = new Object();

    private transient Logger log = Logging.getLogger(getClass().getName());



    
    public FrameHelper(Collection allFrames, FrameSet frameSet) {
       	this.allFrames = new HashSet(allFrames);
        this.frameSet = frameSet;
        process(allFrames);
        if (log.isDebugEnabled())
                log.debug("FrameHelper("+internalid+"): initialized with "+allFrames.size()+" frames and frameset="+frameSet.getName());
    }

    public String getFrameSetName() {
	    return frameSet.getName();
    }

    public String toString() {
	return "FrameHelper("+internalid+"):  frameset='"+getFrameSetName()+"' has "+allFrames.size()+" frames, "+dataFrames.size()+" data frames";
    }

    public synchronized Collection getAllFrames() {
	return new ArrayList(allFrames);
    }

    public synchronized Collection getRelationshipFrames() {
        return relationshipFrames;
    }

    public org.cougaar.core.qos.frame.Frame findFrame(FramePredicate predicate) {
	    return findFrame(allFrames, predicate);
    }

    public synchronized org.cougaar.core.qos.frame.Frame findFrame(Collection frames, FramePredicate predicate) {
        if (predicate != null)
            predicate.setFrameSetName((frameSet != null ? frameSet.getName() : null));
        if (log.isDebugEnabled())
                log.debug("findFrame(:"+internalid+"  frames["+frames.size()+"], predicate="+predicate+")");
        org.cougaar.core.qos.frame.Frame f;
        for (Iterator ii = frames.iterator(); ii.hasNext(); ) {
            f = (org.cougaar.core.qos.frame.Frame) ii.next();
            if (predicate.execute(f)) {
            if (log.isDebugEnabled())
                log.debug(":"+internalid+" found frame=  "+f);
            return f;
            }
        }
        return null;
    }
    
    public Collection findFrames(FramePredicate predicate) {
	    return findFrames(allFrames, predicate);
    }

    public synchronized Collection findFrames(Collection frames, FramePredicate predicate) {
        if (predicate != null)
            predicate.setFrameSetName((frameSet != null ? frameSet.getName() : null));
        if (log.isDebugEnabled())
                log.debug("findFrames(:"+internalid+" frames["+frames.size()+"], predicate="+predicate+")");

        ArrayList result = new ArrayList();
        org.cougaar.core.qos.frame.Frame f;
        for (Iterator ii = frames.iterator(); ii.hasNext(); ) {
            f = (org.cougaar.core.qos.frame.Frame) ii.next();
            if (predicate.execute(f))
            result.add(f);
        }
        if (log.isDebugEnabled())
            printResult(result);

        return result;
    }


    protected void printResult(Collection result) {
        if (log.isDebugEnabled() && result.size()> 0) {
            StringBuffer sb = new StringBuffer("found: \n");
            for (Iterator jj=result.iterator(); jj.hasNext();) {
                sb.append(jj.next().toString());
                sb.append("\n");
            }
        } else if (log.isDebugEnabled() && result.size()==0)
            log.debug("found no matches");
    }
   /*
    public synchronized org.cougaar.core.qos.frame.Frame[] getParentAndChild(RelationFrame relationshipFrame) {
        org.cougaar.core.qos.frame.Frame f[] = new org.cougaar.core.qos.frame.Frame[2];
        f[0] = relationshipFrame.relationshipParent();
        f[1] = relationshipFrame.relationshipChild();
        return f;
    }*/

    public synchronized Collection getAllChildren(org.cougaar.core.qos.frame.Frame parent, String relationship) {
        if (log.isDebugEnabled())
            log.debug("getAllChildren(:"+internalid+" parent="+parent+" relationship="+relationship+")");
        return  frameSet.findRelations(parent, "child", relationship);
    }

    protected void process(Collection frames) {
        relationshipFrames = new ArrayList();
        dataFrames = new HashSet();
        //frameMap = new HashMap();
        org.cougaar.core.qos.frame.Frame f;
        String name;

        for (Iterator ii=frames.iterator(); ii.hasNext();) {
            f = (org.cougaar.core.qos.frame.Frame) ii.next();
            if (f instanceof RelationFrame) {
                relationshipFrames.add(f);
                continue;
            }
            name = (String) f.getValue("name");
            dataFrames.add(f);
            //if (frameMap.get(name) != null)
              //  continue; //throw new IllegalArgumentException("frame '"+name+"' already exists in the frame map");
            //else
            //frameMap.put(name, f);
        }
    }
    
}
