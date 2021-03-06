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

package org.cougaar.core.qos.rss;

import org.cougaar.core.component.ServiceBroker;
import org.cougaar.core.service.ThreadService;
import org.cougaar.core.thread.Schedulable;
import org.cougaar.qos.qrs.DataValue;
import org.cougaar.qos.qrs.SimpleQueueingDataFeed;

/**
 * This entity implements a simple RSS DataFeed and is used by the
 * {@link RSSMetricsUpdateServiceImpl} to push data into the RSS.
 */
public class TrivialDataFeed extends SimpleQueueingDataFeed {
    private static final long HOLD_TIME = 500;
    private final Schedulable thread;

    private class Notifier implements Runnable {
        public void run() {
            long endTime = System.currentTimeMillis() + HOLD_TIME;
            // String key = nextKey();
            // DataValue value = null;
            do {
                String key = nextKey();
                if (key == null) {
                    break;
                }
                DataValue value = lookup(key);
                if (value == null) {
                    continue;
                }
                notifyListeners(key, value);
            } while (System.currentTimeMillis() <= endTime);
            // if (key != null) {
            // value = lookup(key);
            // if (value != null) notifyListeners(key, value);
            // }
            if (!isEmpty()) {
                thread.start();
            }
        }
    }

    @Override
   protected Runnable makeNotifier() {
        return new Notifier();
    }

    TrivialDataFeed(ServiceBroker sb) {
        super();
        ThreadService threadService = sb.getService(this, ThreadService.class, null);
        Runnable notifier = getNotifier();
        thread =
                threadService.getThread(this,
                                        notifier,
                                        "TrivialDataFeed",
                                        ThreadService.WELL_BEHAVED_LANE);
        sb.releaseService(this, ThreadService.class, threadService);
    }

    @Override
   protected void dispatch() {
        thread.start();
    }

}
