package org.cougaar.core.qos.frame.visualizer.event;

import org.cougaar.core.qos.frame.visualizer.ShapeContainer;
import org.cougaar.core.qos.frame.visualizer.ShapeGraphic;

import javax.swing.event.ChangeEvent;

/**
 * Created by IntelliJ IDEA.
 * User: mwalczak
 * Date: May 14, 2005
 * Time: 2:39:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class ContainerChildRemovedEvent extends ChangeEvent {
    ShapeContainer container;
    ShapeGraphic remChild;


    public ContainerChildRemovedEvent(Object source, ShapeContainer container, ShapeGraphic removedchild) {
	    super(source);
        this.container = container;
        this.remChild = removedchild;
    }

    public ShapeContainer getContainer() {
        return container;
    }

    public ShapeGraphic getChild() {
        return remChild;
    }
}
