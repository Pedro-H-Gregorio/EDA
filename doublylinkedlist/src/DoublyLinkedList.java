public class DoublyLinkedList<T>{
    private Node<T> header;
    private Node<T> tail;
    private int size;

    public DoublyLinkedList(){
        this.header = null;
        this.tail = null;
        this.size = 0;
    }
    public void add(T value){
        Node<T> node = new Node<>(value);
        if(this.header == null){
            this.header = node;
        } else {
            this.tail.setNext(node);
            node.setPrevious(this.tail);
        }
        this.tail = node;
        this.size++;
    }

    public void add(T value, int index) throws InvalidIndexException {
        Node<T> node = new Node<>(value);

        if(index == 0){
            node.setNext(this.header);
            this.header.setPrevious(node);
            this.header = node;
        } else if (index == this.size) {
            Node<T> previous = get(index - 1);
            node.setNext(previous.next);
            node.setPrevious(previous);
            previous.setNext(node);
            this.tail = node;
        } else {
            Node<T> previous = get(index - 1);
            node.setNext(previous.next);
            node.setPrevious(previous);
            previous.next.setPrevious(node);
            previous.setNext(node);
        }

        size++;
    }

    public void remove(int index) throws InvalidIndexException {
        Node<T> node = get(index);

        if(getSize() == 1){
            this.tail = null;
            this.header = null;
        } else if (index == 0){
            Node<T> nodeNext = node.next;
            nodeNext.setPrevious(node.previous);
            this.header = nodeNext;
        } else if (index == this.size - 1){
            Node<T> nodePrevious = node.previous;
            nodePrevious.setNext(node.next);
            this.tail = nodePrevious;
        } else {
            Node<T> nodePrevious = node.previous;
            nodePrevious.setNext(node.next);
            node.next.setPrevious(nodePrevious);
        }

        node.setNext(null);
        node.setPrevious(null);

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
