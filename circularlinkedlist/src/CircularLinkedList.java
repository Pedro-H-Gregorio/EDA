public class CircularLinkedList<T> {
    private Node header;

    private int size = 0;

    public CircularLinkedList(){
        this.header = null;
    }
    public void add(T value) throws InvalidIndexException {
        Node<T> node = new Node<>(value);
        if(this.header == null){
            this.header = node;
            this.header.setNext(node);
        } else {
            Node<T> previous = this.get(this.size - 1);
            node.setNext(previous.next);
            previous.setNext(node);
        }
        this.size++;
    }

    public void add(T value, int index) throws InvalidIndexException {
        Node<T> node = new Node(value);

        if(index == 0){
            this.get(this.size - 1).setNext(node);
            node.setNext(this.header);
            this.header = node;
        } else {
            Node<T> previous = this.get(index - 1);
            node.setNext(previous.next);
            previous.setNext(node);
        }

        size++;
    }

    public void remove(int index) throws InvalidIndexException {
        Node<T> node = this.get(index);

        if(this.size == 1 && index == 0){
            this.header = null;
        } else{
            Node<T> nodePrevious = this.get(index - 1 < 0 ? index - 1 + this.size: index - 1);
            nodePrevious.setNext(node.next);
        }

        node.setNext(null);
        this.size--;
    }

    public Node<T> get(int index) throws InvalidIndexException {
        if(this.size-1 < index){
            throw new InvalidIndexException();
        }
        return this.get(this.header, 0 ,index);
    }

    private Node<T> get(Node<T> node, int indexNode, int indexRequired){
        if (indexNode == indexRequired){
            return node;
        }
        indexNode++;
        return this.get(node.next, indexNode, indexRequired);
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public void printList(){
        Node temp = this.header;
        for(int i = 0; i < this.size; i++){
            System.out.print(temp + " ");
            temp = temp.next;
        }
    }
}
