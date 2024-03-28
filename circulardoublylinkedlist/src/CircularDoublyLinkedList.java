public class CircularDoublyLinkedList<T>{
    private Node<T> header;
    private int size;

    public CircularDoublyLinkedList(){
        this.header = null;
        this.size = 0;
    }
    public void add(T value){
        Node<T> node = new Node<>(value);
        if(this.header == null){
            this.header = node;
            this.header.setNext(node);
        } else {
            Node<T> last = this.header.previous;
            last.setNext(node);
            node.setPrevious(last);
            node.setNext(this.header);
        }
        this.header.setPrevious(node);
        this.size++;
    }

    public void add(T value, int index) throws InvalidIndexException {
        Node<T> node = new Node<>(value);

        if(index == 0){
            node.setNext(this.header);
            node.setPrevious(this.header.previous);
            this.header.setPrevious(node);
            this.header = node;
        } else if (index == this.size) {
            node.setNext(this.header);
            node.setPrevious(header.previous);
            this.header.previous.setNext(node);
            this.header.setPrevious(node);
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

        if (index == 0){
            Node<T> nodeNext = node.next;
            nodeNext.setPrevious(node.previous);
            node.previous.setNext(nodeNext);
            this.header = nodeNext;
        } else if (index == this.size - 1){
            node.previous.setNext(this.header);
            this.header.setPrevious(node.previous);
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
        if(index > (this.size)/2){
            return get(this.header.previous, this.size - 1 ,index);
        }
        return get(this.header, 0 ,index);
    }

    private Node<T> get(Node<T> node, int indexNode, int indexRequired){
        if (indexNode == indexRequired) {
            return node;
        }
        if(indexRequired > (this.size)/2){
            return get(node.previous, indexNode - 1, indexRequired);
        }
        return get(node.next, indexNode + 1, indexRequired);
    }

    public int getSize() {
        return size;
    }
}
