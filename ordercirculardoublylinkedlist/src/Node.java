public class Node<T extends Comparable<T>> {
    public Node<T> next;
    public Node<T> previous;
    public T value;


    public Node(T value){
        this.next = null;
        this.previous = null;
        this.value = value;

    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }
    public boolean isBigger(Node<T> nodeCompare){
        return compareTo(nodeCompare.value) > 0;
    }
    private int compareTo( T valueCompare){
        return this.value.compareTo(valueCompare);
    }
}
