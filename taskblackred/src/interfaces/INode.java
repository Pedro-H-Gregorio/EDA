package interfaces;

public interface INode {
    INode getFather();
    void setFather(INode father);
    INode getLeftChild();
    void setLeftChild(INode leftChild);
    INode getRightChild();
    void setRightChild(INode rightChild);
    boolean isColor();
    void setColor(boolean color);
    int getValue();
}
