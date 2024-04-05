public class Node{
    public Node next;
    public Node previous;
    public Integer value;


    public Node(Integer value){
        this.next = null;
        this.previous = null;
        this.value = value;

    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
    public boolean isBigger( Node nodeCompare){
        return this.value > nodeCompare.value;
    }
}
