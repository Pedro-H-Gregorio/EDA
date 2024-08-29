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
        calculateHeight(root);
        calculateBalancingFactor(root);
        if(root.getFather() != null) {
            this.root = root.getFather();
        }
    }

    @Override
    public int removeMin() {
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
    public int removeMax() {
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

    private void leftRotation(INode node){
        node.getRightChild().setFather(node.getFather());
        node.setFather(node.getRightChild());
        INode nodeRight = node.getRightChild().getLeftChild();
        node.getRightChild().setLeftChild(node);
        node.setRightChild(nodeRight);
    }

    private void rightRotation(INode node){
        node.getLeftChild().setFather(node.getFather());
        node.setFather(node.getLeftChild());
        INode nodeLeft = node.getLeftChild().getRightChild();
        node.getLeftChild().setRightChild(node);
        node.setLeftChild(nodeLeft);
    }

    private int calculateBalancingFactor(INode node){
        if (node != null) {
            int leftChildHeight = node.getLeftChild() == null ? 0 : node.getLeftChild().getHeight();
            int rightChildHeight = node.getRightChild() == null ? 0 : node.getRightChild().getHeight();
            int balancingFactor = leftChildHeight - rightChildHeight;
            if (balancingFactor > 1){
                int balancingFactorChildLeft = calculateBalancingFactor(node.getLeftChild());
                if (balancingFactorChildLeft < 0){
                    leftRotation(node.getLeftChild());
                }
                rightRotation(node);
            } else if (balancingFactor < -1) {
                int balancingFactorChildRight = calculateBalancingFactor(node.getLeftChild());
                if (balancingFactorChildRight > 0){
                    rightRotation(node.getRightChild());
                }
                leftRotation(node);
            }
            return balancingFactor;
        }
        return 0;
    }

    private void calculateHeight(INode node){
        if (node != null && (node.getRightChild() != null || node.getLeftChild() != null)) {
            node.setHeight(calculateHeightNode(node));
            calculateHeight(node.getLeftChild());
            calculateHeight(node.getRightChild());
        }
    }
    private int calculateHeightNode(INode node){
        if (node == null) {
            return -1;
        } else {
            int leftHeight = calculateHeightNode(node.getLeftChild());
            int rightHeight = calculateHeightNode(node.getRightChild());

            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
