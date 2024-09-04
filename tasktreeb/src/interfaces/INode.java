package interfaces;

import java.util.List;

public interface INode {

    Integer getValue();
    INode getFather();
    void setFather(INode father);
    void add(Integer value);
    int remove(Integer value);
    boolean get(Integer value);
    INode getSheet(Integer value);
    List<INode> getChildren(Integer value);
    void splitNode(INode father);
    void setChildren(INode child);
}
