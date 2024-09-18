package classes;

import interfaces.INode;
import interfaces.IRedBlackTree;

public class RedBlackTree implements IRedBlackTree {
    private INode root;
    private INode TNULL;

    public RedBlackTree() {
        TNULL = new Node(0);
        TNULL.setColor(false);
        TNULL.setLeftChild(null);
        TNULL.setRightChild(null);
        root = TNULL;
    }

    private void leftRotate(INode current) {
        INode rightChild = current.getRightChild();
        current.setRightChild(rightChild.getLeftChild());
        if (rightChild.getLeftChild() != TNULL) {
            rightChild.getLeftChild().setFather(current);
        }
        rightChild.setFather(current.getFather());
        if (current.getFather() == null) {
            this.root = rightChild;
        } else if (current == current.getFather().getLeftChild()) {
            current.getFather().setLeftChild(rightChild);
        } else {
            current.getFather().setRightChild(rightChild);
        }
        rightChild.setLeftChild(current);
        current.setFather(rightChild);
    }

    private void rightRotate(INode current) {
        INode leftChild = current.getLeftChild();
        current.setLeftChild(leftChild.getRightChild());
        if (leftChild.getRightChild() != TNULL) {
            leftChild.getRightChild().setFather(current);
        }
        leftChild.setFather(current.getFather());
        if (current.getFather() == null) {
            this.root = leftChild;
        } else if (current == current.getFather().getRightChild()) {
            current.getFather().setRightChild(leftChild);
        } else {
            current.getFather().setLeftChild(leftChild);
        }
        leftChild.setRightChild(current);
        current.setFather(leftChild);
    }

    private void fixInsert(INode nodeCurrent) {
        INode nodeAux;
        while (nodeCurrent.getFather().isColor() == true) {
            if (nodeCurrent.getFather() == nodeCurrent.getFather().getFather().getLeftChild()) {
                nodeAux = nodeCurrent.getFather().getFather().getRightChild();
                if (nodeAux.isColor()) {
                    nodeCurrent.getFather().setColor(false);
                    nodeAux.setColor(false);
                    nodeCurrent.getFather().getFather().setColor(true);
                    nodeCurrent = nodeCurrent.getFather().getFather();
                } else {
                    if (nodeCurrent == nodeCurrent.getFather().getRightChild()) {
                        nodeCurrent = nodeCurrent.getFather();
                        leftRotate(nodeCurrent);
                    }
                    nodeCurrent.getFather().setColor(false);
                    nodeCurrent.getFather().getFather().setColor(true);
                    rightRotate(nodeCurrent.getFather().getFather());
                }
            } else {
                nodeAux = nodeCurrent.getFather().getFather().getLeftChild();
                if (nodeAux.isColor()) {
                    nodeCurrent.getFather().setColor(false);
                    nodeAux.setColor(false);
                    nodeCurrent.getFather().getFather().setColor(true);
                    nodeCurrent = nodeCurrent.getFather().getFather();
                } else {
                    if (nodeCurrent == nodeCurrent.getFather().getLeftChild()) {
                        nodeCurrent = nodeCurrent.getFather();
                        rightRotate(nodeCurrent);
                    }
                    nodeCurrent.getFather().setColor(false);
                    nodeCurrent.getFather().getFather().setColor(true);
                    leftRotate(nodeCurrent.getFather().getFather());
                }
            }
            if (nodeCurrent == root) {
                break;
            }
        }
        root.setColor(false);
    }

    public void add(int key) {
        INode node = new Node(key);
        node.setLeftChild(TNULL);
        node.setRightChild(TNULL);

        INode y = null;
        INode x = this.root;

        while (x != TNULL) {
            y = x;
            if (node.getValue() < x.getValue()) {
                x = x.getLeftChild();
            } else {
                x = x.getRightChild();
            }
        }

        node.setFather(y);
        if (y == null) {
            root = node;
        } else if (node.getValue() < y.getValue()) {
            y.setLeftChild(node);
        } else {
            y.setRightChild(node);
        }

        if (node.getFather() == null) {
            node.setColor(false);
            return;
        }

        if (node.getFather().getFather() == null) {
            return;
        }

        fixInsert(node);
    }

    @Override
    public void inorderPrint() {
        inorderPrint(root);
    }

    private void inorderPrint(INode node) {
        if (node != TNULL) {
            inorderPrint(node.getLeftChild());
            System.out.print(node.getValue() + " ");
            inorderPrint(node.getRightChild());
        }
    }
}
