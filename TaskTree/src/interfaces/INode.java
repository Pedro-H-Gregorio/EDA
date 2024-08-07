package interfaces;

public interface INode {
    INode getRightChild();
    INode getLeftChild();
    Integer getValue();
    void setRightChild(INode rightChild);
    void setLeftChild(INode leftChild);

    void setRightChild(INode rightChild);

    void setLeftChild(INode leftChild);

    Integer compareTo(INode node);

}
