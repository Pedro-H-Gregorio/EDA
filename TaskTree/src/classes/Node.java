package classes;

import interfaces.INode;

public class Node implements INode {
    private final Integer value;
    private INode rightChild;
    private INode leftChild;
    private INode father;

    public Node(Integer value){
        this.value = value;
    }
    @Override
    public INode getFather() {
        return this.father;
    }
    @Override
    public void setFather(INode father) {
        this.father = father;
    }

    @Override
    public INode getRightChild() {
        return this.rightChild;
    }

    @Override
    public INode getLeftChild() {
        return this.leftChild;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }
    @Override
    public void setRightChild(INode rightChild) {
        this.rightChild = rightChild;
    }
    @Override
    public void setLeftChild(INode leftChild) {
        this.leftChild = leftChild;
    }

    @Override
    public Integer compareTo(INode node) {
        return this.value <= node.getValue()? 0 : -1;
    }
}
