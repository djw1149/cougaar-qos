package org.cougaar.core.qos.profile;
import java.lang.reflect.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.cougaar.core.agent.*;
import org.cougaar.core.blackboard.*;
import org.cougaar.core.component.*;
import org.cougaar.core.mts.*;
import org.cougaar.core.node.*;
import org.cougaar.core.plugin.*;
import org.cougaar.core.qos.metrics.*;
import org.cougaar.core.service.*;
import org.cougaar.core.service.wp.*;
import org.cougaar.core.thread.*;
import org.cougaar.core.wp.resolver.*;
import org.cougaar.util.*;

/**
 * This component supports the node-level {@link BlackboardSize}
 * profiler.
 */
public final class BlackboardSizeInAgent
extends ComponentPlugin
implements BlackboardSizeService.Client
{

  private String name;
  private BlackboardSizeService bss;

  private static final String[] CLASSNAMES = new String[] {
    "java.lang.Object",
    "org.cougaar.core.util.UniqueObject",
    "org.cougaar.core.relay.Relay",
    "org.cougaar.planning.ldm.asset.Asset",
    "org.cougaar.planning.ldm.plan.Task",
    "org.cougaar.planning.ldm.plan.Expansion",
    "org.cougaar.planning.ldm.plan.Aggregation",
    "org.cougaar.planning.ldm.plan.Allocation",
    "org.cougaar.planning.ldm.plan.Disposition",
  };
  private static final Class[] CLASSES = new Class[CLASSNAMES.length];
  static {
    for (int i = 0; i < CLASSNAMES.length; i++) {
      String s = CLASSNAMES[i];
      Class cl;
      try {
        cl = Class.forName(s);
      } catch (Exception e) {
        throw new RuntimeException("classname: "+s, e);
      }
      CLASSES[i] = cl;
    }
  }

  private static final int CURRENT = 0;
  private static final int ADD = 1;
  private static final int CHANGE = 2;
  private static final int REMOVE = 3;

  private final int[] trans = new int[4];
  private final Map data = new HashMap();
  private final int[][] values = new int[CLASSES.length][4];
  private final IncrementalSubscription[] subs = 
    new IncrementalSubscription[CLASSES.length];

  public void load() {
    super.load();

    for (int i = 0; i < CLASSNAMES.length; i++) {
      String s = CLASSNAMES[i];
      int j = s.lastIndexOf('.');
      String s2 = (j < 0 ? s : s.substring(j+1));
      int[] ia = new int[4];
      data.put(s2, ia);
      values[i] = ia;
    }
    data.put("transactions", trans);

    bss = (BlackboardSizeService)
      getServiceBroker().getService(
          this,
          BlackboardSizeService.class, 
          null);
    if (bss == null) {
      throw new RuntimeException(
          "Unable to obtain bss");
    }
  }

  protected void setupSubscriptions() {
    for (int i = 0; i < CLASSES.length; i++) {
      final Class cl = CLASSES[i];
      UnaryPredicate p = new UnaryPredicate() {
        public boolean execute(Object o) {
          return cl.isAssignableFrom(o.getClass());
        }
      };
      subs[i] = (IncrementalSubscription) blackboard.subscribe(p);
    }
  }
  protected void execute() {
    trans[CURRENT]++;
    trans[ADD]++;
    for (int i = 0; i < CLASSES.length; i++) {
      IncrementalSubscription sub = subs[i];
      if (sub.hasChanged()) {
        int[] ia = values[i];
        ia[CURRENT] = sub.size();
        ia[ADD] += sub.getAddedCollection().size();
        ia[CHANGE] += sub.getChangedCollection().size();
        ia[REMOVE] += sub.getRemovedCollection().size();
      }
    }
  }

  public String getName() {
    return getAgentIdentifier().getAddress();
  }

  // String type => int[] { current, added, changed, removed };
  public Map getData() {
    return data;
  }
}
