package classes;

import interfaces.INode;

public class Tree implements interfaces.Tree {
    private INode root;

    @Override
    public void add(Integer value) {
        INode node = new Node(value);
        if(root != null){
            this.root = node;
        } else {
            addInPosition(this.root, node);
        }
    }

    @Override
    public int removeLast() {
        removeRecursive(searchMinValue(this.root));
        return 0;
    }

    @Override
    public int removeFirst() {
        removeRecursive(searchMaxValue(this.root));
        return 0;
    }

    @Override
    public boolean getValue(Integer value) {
        return search(this.root,value);
    }


    private void addInPosition(INode nodeCurrent, INode nodeNew){
        if(nodeCurrent.compareTo(nodeNew) == 0){
            if (nodeCurrent.getRightChild() == null) {
                nodeCurrent.setRightChild(nodeNew);
            } else {
                addInPosition(nodeCurrent.getRightChild(), nodeNew);
            }

        } else {
            if (nodeCurrent.getLeftChild() == null) {
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

    private INode searchMaxValue(INode node){
        Integer value = node.getValue();
        INode nodeCurrent = node;
        while (nodeCurrent != null && value < nodeCurrent.getValue()){
            value = nodeCurrent.getValue();
            nodeCurrent = nodeCurrent.getRightChild();
        }
        return nodeCurrent;
    }

    private INode searchMinValue(INode node){
        Integer value = node.getValue();
        INode nodeCurrent = node;
        while (nodeCurrent != null && value > nodeCurrent.getValue()){
            value = nodeCurrent.getValue();
            nodeCurrent = nodeCurrent.getLeftChild();
        }
        return nodeCurrent;
    }

    private void removeRecursive(INode node) {
        if(node.getLeftChild() == null && node.getRightChild() == null){
            node = null;
        }
        if (node.getRightChild() != null) {
            removeRecursive(node.getRightChild());
        }
        if (node.getRightChild() != null){
            removeRecursive(node.getLeftChild());
        }
    }
}
