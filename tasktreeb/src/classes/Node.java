package classes;

import interfaces.INode;

import java.util.LinkedList;
import java.util.List;

public class Node implements INode {
    private LinkedList<Integer> values;
    private Integer limit;
    private LinkedList<INode> childrens;
    private Integer size;
    private boolean isSheet;

    public Node(){

    }

    @Override
    public Integer getValue() {
        return null;
    }

    @Override
    public INode getFather() {
        return null;
    }

    @Override
    public void setFather(INode father) {

    }

    @Override
    public void add(Integer value) {

    }

    @Override
    public int remove(Integer value) {
        return 0;
    }

    @Override
    public boolean get(Integer value) {
        return false;
    }

    @Override
    public INode getSheet(Integer value) {
        return null;
    }

    @Override
    public List<INode> getChildren(Integer value) {
        return this.childrens;
    }

    @Override
    public void splitNode(INode father) {

    }

    @Override
    public void setChildren(INode child) {

    }

    private void sort(){

    }

    private Integer searchValue(){
        return 0;
    }
}
