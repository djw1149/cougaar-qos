package org.cougaar.core.qos.frame.visualizer;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;

import org.cougaar.util.log.Logger;
import org.cougaar.util.log.Logging;



/**
 * Created by IntelliJ IDEA.
 * User: mwalczak
 * Date: Apr 4, 2005
 * Time: 2:10:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class AnimatedCanvas extends AnimatingSurface implements MouseListener, MouseMotionListener {
    /**
    * 
    */
   private static final long serialVersionUID = 1L;
   protected HashMap shapes;
    protected boolean mouseMoveFlag =false;
    protected Point   mousePoint=null, lastPoint=null;
    protected Point   mouseStartDragPoint=null;
    protected ShapeGraphic selectedShape, mouseOverShape;
    protected Dimension oldSize;
    private transient Logger log = Logging.getLogger(getClass().getName());

    //temp
    int count=0;

    public AnimatedCanvas() {
        super();
        shapes = new HashMap();
        selectedShape = null;
        mouseOverShape = null;
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
   public void reset(int w, int h) {
        /*ShapeGraphic shape;
        for (Iterator ii=shapes.values().iterator(); ii.hasNext();) {
        shape = (ShapeGraphic) ii.next();
        shape.reset(w, h);
        }
        */
        oldSize = getSize();
    }

    @Override
   public void step(int w, int h) {
        /*ShapeGraphic shape;
        for (Iterator ii=shapes.values().iterator(); ii.hasNext();) {
        shape = (ShapeGraphic) ii.next();
        shape.step(w, h);
        }
        */
    }

    public ShapeGraphic get(String shapeId) {
        return (ShapeGraphic) shapes.get(shapeId);
    }

    public void register(ShapeGraphic shape) {
        if (shapes.get(shape.getId())== null)
            shapes.put(shape.getId(), shape);
    }

    public void unregister(ShapeGraphic shape) {
        if (shapes.get(shape.getId())!= null)
            shapes.remove(shape.getId());
    }

    @Override
   public void render(int w, int h, Graphics2D g2) {
        //System.out.println("SassiAnimatedSurface.render w="+w+" h="+h);
        Dimension d = getSize();
        if (oldSize.width != d.width || oldSize.height != d.height)
            reset(w,h);
    }

    public ShapeGraphic findShape(double x, double y) {
        //ShapeGraphic shapes[] = findShapes(x,y);
        //return (shapes != null && shapes.length > 0 ? shapes[0] : null);
        return null;
    }


    //////////////////////////////////////////////////////////////////////////////////
    // mouse event handlers
    //////////////////////////////////////////////////////////////////////////////////
    public void mouseEntered(MouseEvent evt) {}
    public void mouseExited(MouseEvent evt) {}
    public void mouseClicked(MouseEvent evt) {}

    public void mousePressed(MouseEvent evt) {
        //System.out.println("AnimatedCanvas.mousePressed");
        if(mouseMoveFlag==false) {
            // start drag
            mouseMoveFlag=true;
            mousePoint=evt.getPoint();
            mouseStartDragPoint = mousePoint;
            if (selectedShape != null)
                selectedShape.setSelected(false);
            selectedShape = findShape(mousePoint.x,  mousePoint.y);
            if (selectedShape != null)  {
                if (log.isDebugEnabled())
                    log.debug("selecting = "+selectedShape);

                /*if (selectedShape instanceof ShapeContainer) {
                    String childString="";
                    ShapeGraphic ch;
                    for (Iterator ii=((ShapeContainer)selectedShape).getChildren().iterator(); ii.hasNext();) {
                        ch = (ShapeGraphic)ii.next();
                        childString=childString+ ", "+ch.getId();
                    }
                    //if (log.isDebugEnabled())
                    // log.debug("------>children:"+childString);
                    childString = "";
                    for (Iterator ii=((ShapeContainer)selectedShape).getPrototypes().iterator(); ii.hasNext();) {
                        ch = (ShapeGraphic) ii.next();
                        childString=childString+ ", "+ch.getId();
                    }
                    if (log.isDebugEnabled())
                        log.debug("------>prototypes:"+childString);
                }
                */
                selectedShape.setSelected(true);
            }
        }
    }

    public void mouseReleased( MouseEvent evt ){
        mouseMoveFlag=false;
        mousePoint = null;
        mouseStartDragPoint = null;
    }

    // MouseMotionListener interface
    public void mouseDragged(MouseEvent e) {
        if(mouseMoveFlag==true)
            mousePoint=e.getPoint();
    }

    public void mouseMoved(MouseEvent e) {
        //System.out.println("mouseMoved");
        Point mp = e.getPoint();
        ShapeGraphic tmp = mouseOverShape;
        mouseOverShape = findShape(mp.x,  mp.y);
        if (tmp == mouseOverShape)
            return;
        if (tmp != null)
            tmp.setMouseOver(false);

        if (mouseOverShape != null)
            mouseOverShape.setMouseOver(true);
    }
}
