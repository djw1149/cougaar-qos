package org.cougaar.core.qos.frame.visualizer.tree;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import org.cougaar.core.qos.frame.visualizer.Display;
import org.cougaar.core.qos.frame.visualizer.FrameModel;
import org.cougaar.core.qos.frame.visualizer.ShapeContainer;
import org.cougaar.core.qos.frame.visualizer.ShapeGraphic;
import org.cougaar.core.qos.frame.visualizer.icons.IconFactory;

/**
 * Created by IntelliJ IDEA.
 * User: mwalczak
 * Date: Apr 15, 2005
 * Time: 8:57:37 AM
 * To change this template use File | Settings | File Templates.
 */
public class ContainerTreeView extends ExplorerView implements ChangeListener {
    /**
    * 
    */
   private static final long serialVersionUID = 1L;
   FrameModel frameModel;
    FrameTableModel frameTableModel;
    ShapeGraphicTableModel shapeModel;
    ShapeTableCellRenderer cellRenderer;
    FrameTableCellRenderer frameCellRenderer;
    //HashMap containerToNodeMap;
    Display display;
    DefaultTreeModel treeModel;
    JLabel selectedLabel, selectedFrameLabel;
    Box legend;
    boolean initialBuildDone = false;
    ArrayList treePaths;

    boolean showPrototypes = true;


    public ContainerTreeView(FrameModel frameModel, Display display) {
        super();
        //containerToNodeMap = new HashMap();
        this.display = display;
        this.frameModel = frameModel;
        frameTableModel = new FrameTableModel();
        shapeModel = new ShapeGraphicTableModel();
        cellRenderer = new ShapeTableCellRenderer(false, shapeModel);
        frameCellRenderer = new FrameTableCellRenderer(false, true, frameTableModel);
        treePaths = new ArrayList();
        Icon containerIcon = IconFactory.getIcon(IconFactory.CONTAINER_ICON);
        Icon componentIcon = IconFactory.getIcon(IconFactory.COMPONENT_ICON);
        Icon prototypeIcon = IconFactory.getIcon(IconFactory.CONTAINER_PROTOTYPE_ICON);
        Icon frameIcon     = IconFactory.getIcon(IconFactory.FRAME_ICON);
        tree.setCellRenderer(new ContainerRenderer(containerIcon, componentIcon, prototypeIcon, frameIcon));

        //root =  createNode(display.getRootContainer());
        //treeModel = new DefaultTreeModel(root);
        //tree.setModel(treeModel);
        rebuildTree();
        //tree.expandPath(new TreePath(root));

        //frameModel.addGraphicChangeListener(this);
        frameModel.addAddedFramesListener(this);
        //frameModel.addChangedFramesListener(this);
        //frameModel.addRemovedFramesListener(this);
        //frameModel.addTransitionListener(this);
    }

    public TreeNode getRootNode() {
        return root;
    }

    @Override
   public Component createOtherComponent() {
        super.createOtherComponent();
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(editTable, BorderLayout.CENTER);

        selectedLabel = new JLabel("selected:");
        selectedFrameLabel = new JLabel("");
        legend = FrameTreeView.createHorizontalFrameLegend();

        Box labelBox = Box.createHorizontalBox();
        labelBox.add(selectedLabel);
        labelBox.add(Box.createHorizontalStrut(10));
        labelBox.add(selectedFrameLabel);
        labelBox.add(Box.createHorizontalGlue());
        labelBox.add(new JButton(new ShowHidePrototypes()));
        labelBox.add(new JButton(new RefreshAction()));
        labelBox.add(Box.createHorizontalStrut(10));
        labelBox.add(legend);
        rightPanel.add(labelBox, BorderLayout.NORTH);
        return rightPanel;
    }

    public void stateChanged(ChangeEvent e) {
        if (!initialBuildDone) {
            MyEventHelper helper = new MyEventHelper(e);
            if (SwingUtilities.isEventDispatchThread())
                helper.run();
            else SwingUtilities.invokeLater(helper);
           initialBuildDone = true;
        }
    }

    class ShowHidePrototypes extends AbstractAction {
        /**
       * 
       */
      private static final long serialVersionUID = 1L;
      public ShowHidePrototypes() {
            super((showPrototypes ? "Hide Protoypes" : "Show Prototypes"));
        }
        public void actionPerformed(ActionEvent e) {
            showPrototypes = !showPrototypes;
            putValue(Action.NAME, (showPrototypes ? "Hide Protoypes" : "Show Prototypes"));
            rebuildTree();
        }
    }

    class RefreshAction extends AbstractAction {
        /**
       * 
       */
      private static final long serialVersionUID = 1L;
      public RefreshAction() {
            super("Refresh Tree");
        }
        public void actionPerformed(ActionEvent e) {
            rebuildTree();
        }
    }

    class MyEventHelper implements Runnable {
        ChangeEvent e;
        public MyEventHelper(ChangeEvent che) { e = che;}
        public void run() {
            updateTree(display.getRootContainer());

            /*if (e instanceof ContainerChildRemovedEvent) {
                //ContainerChildRemovedEvent ee = (ContainerChildRemovedEvent)e;
                //ShapeContainer c = ee.getContainer();
                //ShapeGraphic gr = ee.getChild();
            } else if (e instanceof ContainerChildAddedEvent) {
                ContainerChildAddedEvent ee = (ContainerChildAddedEvent) e;
                ShapeContainer container = ee.getContainer();
                ShapeGraphic child = ee.getChild();

                DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) containerToNodeMap.get(container);
                DefaultMutableTreeNode childNode  = (DefaultMutableTreeNode) containerToNodeMap.get(child);

                // if the parent is null, backtrack to the parent that we know about an rebuild the tree from there
                if (parentNode == null) {
                    ShapeContainer prev=null, c = container.getParent();
                    // go up untill we find the container that we know
                    while (c != null && containerToNodeMap.get(c) == null)
                       c = c.getParent();
                    if (c == null)
                        throw new NullPointerException();  // this should definitely not happen
                    DefaultMutableTreeNode ancestorNode = (DefaultMutableTreeNode) containerToNodeMap.get(c);
                    buildTree((ShapeGraphicNode) ancestorNode.getParent(), c);
                    parentNode = createNode(container);
                    if (parentNode == null) throw new NullPointerException();
                }

                if (childNode == null) {
                    childNode = createNode(child);
                    if (child.hasFrame())
                        childNode.add(createNode(child.getFrame()));
                }
                treeModel.insertNodeInto(childNode, parentNode, 0);
            }  else if (e instanceof AddedFramesEvent) {
                // process added frames
                //AddedFramesEvent ee = (AddedFramesEvent)e;
               // if (ee.getAddedDataFrames() != null)
                //    updateTree(display.getRootContainer());
            } */
        }

    }

    @Override
   protected void displayShapeGraphicInTable(ShapeGraphic g) {
        shapeModel.clear();
        shapeModel.set(g);
        editTable.setDefaultRenderer(Object.class, cellRenderer);
        editTable.setModel(shapeModel);
        selectedFrameLabel.setText("Container '"+g.getId()+"'");
        legend.setVisible(false);
    }

    @Override
   protected void displayFrameInTable(org.cougaar.core.qos.frame.Frame frame) {
        frameTableModel.clear();
        frameTableModel.set(frame);
        editTable.setDefaultRenderer(Object.class, frameCellRenderer);
        editTable.setModel(frameTableModel);
        selectedFrameLabel.setText("Frame '"+frame.getValue("name")+"'");
        legend.setVisible(true);
    }

    public void rebuildTree() {
        updateTree(display.getRootContainer());
    }
    public void updateTree(ShapeContainer rootContainer) {
        treePaths = new ArrayList();
        root = buildTree(null, rootContainer);
        treeModel = new DefaultTreeModel(root);
        tree.setModel(treeModel);
        // expand all container nodes
        TreePath tp;
        for (Iterator ii=treePaths.iterator(); ii.hasNext();) {
           tp = (TreePath) ii.next();
           tree.expandPath(tp);
            //System.out.println("expanding path "+tp);
        }
    }

    protected DefaultMutableTreeNode createNode(ShapeGraphic graphic) {
        return new ShapeGraphicNode(graphic);
        /*ShapeGraphicNode newNode = (ShapeGraphicNode) containerToNodeMap.get(graphic);
        if (newNode == null) {
         newNode = new ShapeGraphicNode(graphic);
         containerToNodeMap.put(graphic, newNode);
        }
        return newNode;*/
    }

    protected DefaultMutableTreeNode createNode(org.cougaar.core.qos.frame.Frame frame) {
        return new FrameNode(frame);
        /*
        FrameNode newNode = (FrameNode) containerToNodeMap.get(frame);
        if (newNode == null) {
            newNode = new FrameNode(frame);
            containerToNodeMap.put(frame, newNode);
        }
        return newNode; */
    }

    public DefaultMutableTreeNode buildTree(ShapeGraphicNode parent, Object userObject) {
        ShapeGraphicNode newNode = null;

        if (userObject instanceof ShapeGraphic) {
            ShapeGraphic graphic = (ShapeGraphic)userObject;
            newNode = (ShapeGraphicNode) createNode(graphic);
            if (parent != null && !parent.hasChild(newNode))
                parent.add(newNode);
                //treeModel.insertNodeInto(newNode, parent, 0);

            if (graphic.hasFrame()) {
                DefaultMutableTreeNode fnode = createNode(graphic.getFrame());
                if (!newNode.hasChild(fnode))
                    //treeModel.insertNodeInto(fnode, newNode, 0);
                    newNode.add(fnode);

            }
            if (graphic.isContainer()) {
                ShapeContainer sc = (ShapeContainer) graphic;
                ShapeGraphic g;
                if (showPrototypes) {
                    for (Iterator ii=sc.getPrototypes().iterator(); ii.hasNext();) {
                        g = (ShapeGraphic) ii.next();
                        buildTree(newNode, g);
                    }
                }
                if (sc.getChildren().size() > 0) {
                    for (Iterator ii=sc.getChildren().iterator(); ii.hasNext();) {
                        g = (ShapeGraphic) ii.next();
                        buildTree(newNode, g);
                    }
                } else
                    addPath(parent);

            }  else
                addPath(parent);


        }  /*else if (userObject instanceof org.cougaar.core.qos.frame.Frame) {
            org.cougaar.core.qos.frame.Frame frame = (org.cougaar.core.qos.frame.Frame)userObject;
            newNode = createNode(frame);
        } */
        //if (parent != null && newNode != null)
        //    parent.add(newNode);
        return newNode;
    }

   void addPath(ShapeGraphicNode parent) {
       if (parent == null)
           return;
       ShapeGraphic sg = parent.getShapeGraphic();
       if (sg != null && sg.isPrototype())
           return;
       TreePath tp = new TreePath(parent.getPath());
       treePaths.add(tp);
   }

    private class ContainerRenderer extends DefaultTreeCellRenderer {
        /**
       * 
       */
      private static final long serialVersionUID = 1L;
      Icon containerIcon;
        Icon componentIcon;
        Icon prototypeIcon;
        Icon frameIcon;


        public ContainerRenderer(Icon containerIcon, Icon componentIcon, Icon prototypeIcon, Icon frameIcon) {
            super();
            this.containerIcon = containerIcon;
            this.componentIcon = componentIcon;
            this.prototypeIcon = prototypeIcon;
            this.frameIcon = frameIcon;
        }

        @Override
      public Component getTreeCellRendererComponent(
                JTree tree,
                Object value,
                boolean sel,
                boolean expanded,
                boolean leaf,
                int row,
                boolean hasFocus) {

            super.getTreeCellRendererComponent(tree, value, sel,
                    expanded, leaf, row,
                    hasFocus);

            if (value instanceof FrameNode) {
                setIcon(frameIcon);
            } else if (value instanceof ShapeGraphicNode) {
                ShapeGraphicNode node = (ShapeGraphicNode) value;
                ShapeGraphic g = node.getShapeGraphic();
                if (g != null) {
                    if (g.isPrototype())
                        setIcon(prototypeIcon);
                    else setIcon(g.isContainer() ? containerIcon : componentIcon);
                }

            } else setIcon(null);

            return this;
        }
    }


    class ShapeTableCellRenderer extends JLabel implements TableCellRenderer {
        /**
       * 
       */
      private static final long serialVersionUID = 1L;
      Border unselectedBorder = null;
        Border selectedBorder   = null;
        boolean isBordered = true;
        ShapeGraphicTableModel shapeModel;

        public ShapeTableCellRenderer(boolean isBordered, ShapeGraphicTableModel shapeModel) {
            this.isBordered = isBordered;
            this.shapeModel = shapeModel;
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(
                JTable table, Object value,
                boolean isSelected, boolean hasFocus,
                int row, int column) {

            setText(value.toString());
            if (isBordered) {
                if (isSelected) {
                    if (selectedBorder == null) {
                        selectedBorder = BorderFactory.createMatteBorder(2,5,2,5,
                                table.getSelectionBackground());
                    }
                    setBorder(selectedBorder);
                } else {
                    if (unselectedBorder == null) {
                        unselectedBorder = BorderFactory.createMatteBorder(2,5,2,5,
                                table.getBackground());
                    }
                    setBorder(unselectedBorder);
                }
            }
            return this;
        }
    }

}
