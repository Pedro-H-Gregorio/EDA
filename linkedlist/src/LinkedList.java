public class LinkedList<T> {
    private Node header;
    private Node tail;

    private int size = 0;

    public LinkedList(){
        this.header = null;
        this.tail = null;
    }
    public void add(T value){
        Node<T> node = new Node(value);
        if(this.header == null){
            this.header = node;
        } else {
            this.tail.setNext(node);
        }
        this.tail = node;
        this.size++;
    }

    public void add(T value, int index) throws InvalidIndexException {
        Node<T> node = new Node(value);

        if(index == 0){
            node.setNext(this.header);
            this.header = node;
        } else {
            Node<T> previous = get(index - 1);
            node.setNext(previous.next);
            previous.setNext(node);
        }

        if(index == this.size){
            this.tail = node;
        }

        size++;
    }

    public void remove(int index) throws InvalidIndexException {
        Node<T> node = get(index);
        Node<T> nodePrevious = get(index - 1);
        nodePrevious.setNext(node.next);
        node.setNext(null);

        if(index == this.size - 1){
            this.tail = nodePrevious;
        }

        this.size--;
    }

    public Node<T> get(int index) throws InvalidIndexException {
        if(this.size-1 < index){
            throw new InvalidIndexException();
        }
        return get(this.header, 0 ,index);
    }

    private Node<T> get(Node<T> node, int indexNode, int indexRequired){
        if (indexNode == indexRequired){
            return node;
        }
        indexNode++;
        return get(node.next, indexNode, indexRequired);
    }

    public int getSize() {
        return size;
    }
}
