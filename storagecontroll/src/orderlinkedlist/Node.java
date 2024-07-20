package orderlinkedlist;

import interfaces.IObject;
import interfaces.IProduct;

import java.util.Objects;

public class Node {
    public Node next;
    public IObject value;


    public Node(IObject value){
        this.next = null;
        this.value = value;

    }

    public void setNext(Node next) {
        this.next = next;
    }
    public boolean isBigger(Node nodeCompare){
        return this.value.compareTo(nodeCompare.value) >= 0;
    }

    public boolean isEqual(Node nodeCompare){
        return Objects.equals(this.value, nodeCompare.value);
    }
}
