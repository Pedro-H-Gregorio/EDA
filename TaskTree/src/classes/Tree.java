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
        return 0;
    }

    @Override
    public int removeFirst() {
        return 0;
    }

    @Override
    public Integer getValue() {
        return null;
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
}
