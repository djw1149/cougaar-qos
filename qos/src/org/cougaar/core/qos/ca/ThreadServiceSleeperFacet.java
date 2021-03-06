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

package org.cougaar.core.qos.ca;

import java.util.HashMap;

import org.cougaar.core.component.ServiceBroker;
import org.cougaar.core.service.ThreadService;
import org.cougaar.core.thread.Schedulable;

/**
 * Does the main work of the Alarm Coordinaton Artifact via
 * ThreadService Schedulables.
 */
abstract public class ThreadServiceSleeperFacet 
    extends SleeperFacet
{


    private ThreadService threadService;
    private HashMap runners, facts;

    protected ThreadServiceSleeperFacet(CoordinationArtifact owner,
					ServiceBroker sb,
					ConnectionSpec spec, 
					RolePlayer player)
    {
	super(owner, sb, spec, player);
	runners = new HashMap();
	facts = new HashMap();
	threadService = sb.getService(this, ThreadService.class, null);

	linkPlayer();
    }

    abstract protected String getId(Object fact);
    abstract protected long getFireTime(Object fact);
    abstract protected void fireAlarm(Object fact);

    private class Runner implements Runnable {
	String key;
	Schedulable schedulable;

	Runner(String key)
	{
	    this.key = key;
	    schedulable = makeSchedulable(key, this);
	}

	public void run() 
	{
	    Object fact = null;
	    synchronized (facts) {
		fact = facts.get(key);
	    }
	    fireAlarm(fact);
	}
    }

    private Schedulable makeSchedulable(String id, Runnable runner)
    {
	return threadService.getThread(this, runner, id);
    }

    @Override
   public void processFactAssertion(Object fact)
    {
	String key = getId(fact);
	long time = getFireTime(fact);
	Runner runner = null;
	synchronized (runners) {
	    runner = (Runner) runners.get(key);
	    if (runner == null) {
		runner = new Runner(key);
		runners.put(key, runner);
	    }
	    facts.put(key, fact);
	}
	runner.schedulable.schedule(time);
    }


}


