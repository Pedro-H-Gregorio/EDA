package classes;

import interfaces.INode;
import interfaces.ITree;

public class Tree implements ITree {
    private INode root;

    @Override
    public void add(Integer value) {
        INode node = new Node(value);
        if(root == null){
            this.root = node;
        } else {
            addInPosition(this.root, node);
        }
    }

    @Override
    public int removeLast() {
        Integer value = this.root.getValue();
        INode nodeMin = this.root;
        INode nodeCurrent = this.root;
        while (nodeCurrent != null && value >= nodeCurrent.getValue()){
            value = nodeCurrent.getValue();
            nodeMin = nodeCurrent;
            nodeCurrent = nodeCurrent.getLeftChild();

        }

        if(nodeMin == this.root){
            this.root = null;
        } else {
            nodeMin.getFather().setLeftChild(null);
        }

        return 0;
    }

    @Override
    public int removeFirst() {
        Integer value = this.root.getValue();
        INode nodeMax = this.root;
        INode nodeCurrent = this.root;
        while (nodeCurrent != null && value <= nodeCurrent.getValue()){
            value = nodeCurrent.getValue();
            nodeMax = nodeCurrent;
            nodeCurrent = nodeCurrent.getRightChild();

        }

        if(nodeMax == this.root){
            this.root = null;
        } else {
            nodeMax.getFather().setRightChild(null);
        }

        return 0;
    }

    @Override
    public boolean getValue(Integer value) {
        return search(this.root,value);
    }

    @Override
    public void print_pre_order() {
        pre_order(this.root);
        System.out.println();
    }

    @Override
    public void print_in_order() {
        in_order(this.root);
        System.out.println();
    }

    @Override
    public void print_post_order() {
        post_order(this.root);
        System.out.println();
    }

    private void pre_order(INode node){
        System.out.printf("->%d",node.getValue());
        if(node.getLeftChild() != null){
            pre_order(node.getLeftChild());
        }
        if(node.getRightChild() != null){
            pre_order(node.getRightChild());
        }
    }

    private void in_order(INode node){
        if(node.getLeftChild() != null){
            in_order(node.getLeftChild());
        }
        System.out.printf("->%d",node.getValue());
        if(node.getRightChild() != null){
            in_order(node.getRightChild());
        }
    }

    private void post_order(INode node){
        if(node.getLeftChild() != null){
            post_order(node.getLeftChild());
        }
        if(node.getRightChild() != null){
            post_order(node.getRightChild());
        }
        System.out.printf("->%d",node.getValue());
    }


    private void addInPosition(INode nodeCurrent, INode nodeNew){
        if(nodeCurrent.compareTo(nodeNew) == 0){
            if (nodeCurrent.getRightChild() == null) {
                nodeNew.setFather(nodeCurrent);
                nodeCurrent.setRightChild(nodeNew);
            } else {
                addInPosition(nodeCurrent.getRightChild(), nodeNew);
            }

        } else {
            if (nodeCurrent.getLeftChild() == null) {
                nodeNew.setFather(nodeCurrent);
                nodeCurrent.setLeftChild(nodeNew);
            } else {
                addInPosition(nodeCurrent.getLeftChild(), nodeNew);
            }
        }

    }

    private boolean search (INode node, Integer value){

        if(node == null){
            return false;
        }

        if(value > node.getValue()){
            return search(node.getRightChild(), value);
        } else if (value < node.getValue()){
            return search(node.getLeftChild(), value);
        } else {
            return true;
        }
    }
}
