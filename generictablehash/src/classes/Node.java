package classes;

public class Node<T> {
    public Node next;
    public T value;

    public Node(T value){
        this.next = null;
        this.value = value;

    }

    public void setNext(Node next) {
        this.next = next;
    }
}
