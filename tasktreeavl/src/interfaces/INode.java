package interfaces;

public interface INode {
    INode getRightChild();
    INode getLeftChild();
    Integer getValue();
    void setRightChild(INode rightChild);
    void setLeftChild(INode leftChild);
    Integer compareTo(INode node);
    INode getFather();
    void setFather(INode father);
    void setHeight(int height);
    int getHeight();
}
