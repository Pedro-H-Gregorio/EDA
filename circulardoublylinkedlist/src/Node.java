public class Node<T> {
    public Node<T> next;
    public Node<T> previous;
    public T value;


    public Node(T value){
        this.next = null;
        this.previous = null;
        this.value = value;

    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }
}
