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

import java.util.Properties;

import org.cougaar.core.agent.service.alarm.Alarm;
import org.cougaar.core.component.ServiceBroker;
import org.cougaar.core.qos.metrics.ParameterizedPlugin;
import org.cougaar.core.service.BlackboardService;
import org.cougaar.core.service.LoggingService;

/**
 * Simple tester for FrameSets
 */
public class FrameSetTesterPlugin
    extends ParameterizedPlugin
{
    private class MyAlarm implements Alarm {
	long expiresAt;
	boolean expired = false;

	public MyAlarm (long expirationTime) 
	{
	    expiresAt = System.currentTimeMillis()+expirationTime;
	}

	public long getExpirationTime() 
	{
	    return expiresAt; 
	}

	public synchronized void expire() 
	{
	    if (!expired) {
		expired = true;
		{
		    BlackboardService bbs = getBlackboardService();
		    if (bbs != null) bbs.signalClientActivity();
		}
	    }
	}
	public boolean hasExpired()
	{ 
	    return expired; 
	}

	public synchronized boolean cancel() 
	{
	    boolean was = expired;
	    expired = true;
	    return was;
	}
	
    }


    private LoggingService log;
    private FrameSet frameSet;
    private MyAlarm alarm;
    private Frame host1;

    public void load()
    {
	super.load();

	ServiceBroker sb = getServiceBroker();

	log = (LoggingService)
           sb.getService(this, LoggingService.class, null);
    }



    // plugin
    protected void execute()
    {
	if (alarm == null) {
	    initializeBlackboard();
	    newAlarm();
	} else if (alarm.hasExpired()) {
	    // change some stuff and restart the alarm
	    Long now = new Long(System.currentTimeMillis());
	    if (log.isDebugEnabled())
		log.debug("Updated host1 \"time\" slot");
	    frameSet.setFrameValue(host1, "time", now);
	    newAlarm();
	}
    }

    private void newAlarm()
    {
	alarm = new MyAlarm(5000);
	alarmService.addRealTimeAlarm(alarm);
    }
    
    private void initializeBlackboard()
    {
	BlackboardService bbs = getBlackboardService();
	ServiceBroker sb = getServiceBroker();
	frameSet = new SingleInheritanceFrameSet(sb, bbs,
						 "contains",
						 "parent-kind",
						 "parent-slot",
						 "parent-value",
						 "child-kind",
						 "child-slot",
						 "child-value"
						 );
	Properties props = null;

	props = new Properties();
	frameSet.makePrototype("site", props);

	props = new Properties();
	frameSet.makePrototype("host", props);

	props = new Properties();	
	frameSet.makePrototype("process", props);


	props = new Properties();
	props.put("name", "site1");
	frameSet.makeFrame("site", props);
	
	props = new Properties();
	props.setProperty("name", "site2");
	frameSet.makeFrame("site", props);


	props = new Properties();
	props.setProperty("name", "host1");
	props.put("time", new Long(System.currentTimeMillis()));
	// Use this one as a test case for changing properties
	host1 = frameSet.makeFrame("host", props);

	props = new Properties();
	props.setProperty("name", "host2");
	frameSet.makeFrame("host", props);

	props = new Properties();
	props.setProperty("name", "host3");
	frameSet.makeFrame("host", props);

	props = new Properties();
	props.setProperty("parent-kind", "site");
	props.setProperty("parent-slot", "name");
	props.setProperty("parent-value", "site1");	
	props.setProperty("child-kind", "host");
	props.setProperty("child-slot", "name");
	props.setProperty("child-value", "host1");
	frameSet.makeFrame("contains", props);

	props = new Properties();
	props.setProperty("parent-kind", "site");
	props.setProperty("parent-slot", "name");
	props.setProperty("parent-value", "site1");	
	props.setProperty("child-kind", "host");
	props.setProperty("child-slot", "name");
	props.setProperty("child-value", "host2");
	frameSet.makeFrame("contains", props);

	props = new Properties();
	props.setProperty("parent-kind", "site");
	props.setProperty("parent-slot", "name");
	props.setProperty("parent-value", "site2");	
	props.setProperty("child-kind", "host");
	props.setProperty("child-slot", "name");
	props.setProperty("child-value", "host3");
	frameSet.makeFrame("contains", props);


    }

    protected void setupSubscriptions() 
    {
    }



}
