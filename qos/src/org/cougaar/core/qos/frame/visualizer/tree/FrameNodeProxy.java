package org.cougaar.core.qos.frame.visualizer.tree;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.*;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.ObjectInputStream;

/**
 * Created by IntelliJ IDEA.
 * User: mwalczak
 * Date: Apr 28, 2005
 * Time: 5:48:11 PM
 * To change this template use File | Settings | File Templates.
 */
// this class a big hack to be able to have multiple instances of the *same* node in the tree
public class FrameNodeProxy extends FrameNode {
        FrameNode node;

        public FrameNodeProxy(FrameNode node) {
            super( node.getFrame());
            this.node = node;
        }

        public boolean isRelationNode() {
            return node.isRelationNode();
        }

        public String getRelationshioName() {
            return node.getRelationshioName();
        }

        public String toString() {
             return node.toString();
        }

        public void addRelationshipNode(FrameNode rnode) {
            node.addRelationshipNode(rnode);
        }

        public FrameNode getRelationshipNode(String relationship) {
            return node.getRelationshipNode(relationship);
        }

        public org.cougaar.core.qos.frame.Frame getFrame() {
            return node.getFrame();
        }

        public void insert(MutableTreeNode newChild, int childIndex) {
            node.insert(newChild, childIndex);
        }

        public void remove(int childIndex) {
            node.remove(childIndex);
        }

        public void setParent(MutableTreeNode newParent) {
           parent = newParent;
        }

         public TreeNode getParent() {
            return parent;
         }

        public TreeNode getChildAt(int index) {
            return node.getChildAt(index);
        }

       public int getChildCount() {
            return node.getChildCount();
       }

       public int getIndex(TreeNode aChild) {
            return node.getIndex(aChild);
       }

       public Enumeration children() {
            return node.children();
       }

       public void setAllowsChildren(boolean allows) {
           node.setAllowsChildren(allows);
       }

       public boolean getAllowsChildren() {
            return node.getAllowsChildren();
       }
        /*
       public void setUserObject(Object userObject) {
            this.userObject = userObject;
       }

       public Object getUserObject() {
            return userObject;
       }

       public void removeFromParent() {
           MutableTreeNode parent = (MutableTreeNode)getParent();
           if (parent != null) {
               parent.remove(this);
           }
       }  */


       public void remove(MutableTreeNode aChild) {
           node.remove(aChild);
       }

       public void removeAllChildren() {
            node.removeAllChildren();
       }

       public void add(MutableTreeNode newChild) {
           node.add(newChild);
       }


   }
