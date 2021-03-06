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

import java.util.LinkedList;

import org.cougaar.core.component.ServiceBroker;
import org.cougaar.core.mts.MessageAddress;
import org.cougaar.core.service.AgentIdentificationService;
import org.cougaar.core.service.BlackboardService;
import org.cougaar.core.service.LoggingService;
import org.cougaar.core.service.UIDService;
import org.cougaar.core.util.UID;


/**
 * Default implementation for Facet.
 */
abstract public class FacetImpl
    implements Facet
{
    private RolePlayer player;
    private ConnectionSpec spec;
    private CoordinationArtifact owner;
    private SimpleQueue factQueue;
    private ServiceBroker sb;
    private UIDService uids;
    private MessageAddress agentId;
    private Receptacle receptacle;

    protected LoggingService log;


    private static class SimpleQueue extends LinkedList {
	/**
       * 
       */
      private static final long serialVersionUID = 1L;

   Object next() {
	    return removeFirst();
	}
    }

    protected FacetImpl(CoordinationArtifact owner, 
			ServiceBroker sb,
			ConnectionSpec spec, 
			RolePlayer player)
    {
	this.player = player;
	this.spec = spec;
	this.owner = owner;
	// The factQueue consists of FactRevision instances
	this.factQueue = new SimpleQueue();

	this.sb = sb;
	log = sb.getService(this, LoggingService.class, null);

	uids = sb.getService(this, UIDService.class, null);
	

	// get agent id
	AgentIdentificationService agentIdService = sb.getService(this, 
   	  AgentIdentificationService.class, 
   	  null);
	if (agentIdService == null) {
	    throw new RuntimeException("Unable to obtain agent-id service");
	}

	agentId = agentIdService.getMessageAddress();
	sb.releaseService(this, 
			  AgentIdentificationService.class, 
			  agentIdService);
	if (agentId == null) {
	    throw new RuntimeException("Agent id is null");
	}

    }


    // Component, which this class isn't.  Deal with this later.
    public void unload() 
    {
	if (uids != null) {
	    sb.releaseService(this, UIDService.class, uids);
	    uids = null;
	}
    }



    // Facet.  Other methods of this interface are handled by
    // extensions.
    protected String getArtifactId()
    {
	return owner.getArtifactId();
    }

    protected String getArtifactKind()
    {
	return owner.getArtifactKind();
    }



    // Accessors
    protected CoordinationArtifact getOwner()
    {
	return owner;
    }

    protected RolePlayer getPlayer()
    {
	return player;
    }


    protected MessageAddress getAgentID()
    {
	return agentId;
    }


    protected UID nextUID()
    {
	return uids.nextUID();
    }


    
    // Fact base
    protected boolean factsHaveChanged()
    {
	// TBD
	return true;
    }

    protected FactRevision nextFact()
    {
	synchronized (factQueue) {
	    if (factQueue.isEmpty())
		return null;
	    else
		return (FactRevision) factQueue.next();
	}
    }


    private void addRevision(FactRevision entry)
    {
	synchronized (factQueue) {
	    factQueue.add(entry);
	}
    }




    // Receptacles
    protected Receptacle getReceptacle()
    {
	return receptacle;
    }

    protected Receptacle makeReceptacle()
    {
	return new ReceptacleImpl();
    }

    protected void linkPlayer()
    {
	if (log.isInfoEnabled())
	    log.info("Linking " +player+ " to " +this);
	receptacle = makeReceptacle();
	player.facetAvailable(spec, receptacle);
    }

    public void setupSubscriptions(BlackboardService blackboard)
    {
    }

    public void execute(BlackboardService blackboard)
    {
    }

    public void processFactBase(BlackboardService blackboard)
    {
    }



    protected class ReceptacleImpl implements Receptacle {
	public void assertFact(Object fact)
	{
	    FactRevision entry = new FactAssertion(fact);
	    addRevision(entry);
	}


	public void retractFact(Object fact)
	{
	    FactRevision entry = new FactRetraction(fact);
	    addRevision(entry);
	}

	public String getArtifactId()
	{
	    return FacetImpl.this.getArtifactId();
	}

	public String getArtifactKind()
	{
	    return FacetImpl.this.getArtifactKind();
	}

	public void setupSubscriptions(BlackboardService bbs)
	{
	    FacetImpl.this.setupSubscriptions(bbs);
	}
	
	public void execute(BlackboardService bbs)
	{
	    FacetImpl.this.execute(bbs);
	}

	public void processFactBase(BlackboardService bbs)
	{
	    FacetImpl.this.processFactBase(bbs);
	}

    }

}
