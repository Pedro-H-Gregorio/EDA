package classes;

import interfaces.INode;

public class Node implements INode {
    private int value;
    private INode father;
    private INode leftChild;
    private INode rightChild;
    private boolean color;

    public Node(int data) {
        this.value = data;
        this.color = true;
    }

    public INode getFather() {
        return father;
    }

    public void setFather(INode father) {
        this.father = father;
    }

    public INode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(INode leftChild) {
        this.leftChild = leftChild;
    }

    public INode getRightChild() {
        return rightChild;
    }

    public void setRightChild(INode rightChild) {
        this.rightChild = rightChild;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public int getValue() {
        return value;
    }
}
