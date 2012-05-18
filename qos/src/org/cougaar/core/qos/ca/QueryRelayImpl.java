/* 
 * <copyright>
 *  
 *  Copyright 2002-2004 BBNT Solutions, LLC
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

import java.io.Serializable;

import org.cougaar.core.mts.MessageAddress;
import org.cougaar.core.relay.Relay;
import org.cougaar.core.util.UID;

final public class QueryRelayImpl
    extends SimplestRelayImpl
{
    /**
    * 
    */
   private static final long serialVersionUID = 1L;


   QueryRelayImpl(UID uid,
		   MessageAddress source, 
		   MessageAddress target,
		   Object query)
    {
	super(uid, source, target, query);
    }


    @Override
   Relay.TargetFactory makeFactory(MessageAddress target)
    {
	return new QueryRelayImplFactory(target);
    }


    private static class QueryRelayImplFactory 
	implements Relay.TargetFactory, Serializable {
	/**
       * 
       */
      private static final long serialVersionUID = 1L;
   public QueryRelayImplFactory(MessageAddress target) {
	}
	public Relay.Target create(
				   UID uid, MessageAddress source, Object content,
				   Relay.Token token) {
	    return new QueryRelayImpl(uid, source, null, content);
	}
    }
}


