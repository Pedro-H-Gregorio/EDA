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

    public void add(T value, int index) {
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

    public void remove(int index)  {
        Node<T> node = get(index);

        if (getSize() == 1){
            this.header = null;
            this.tail = null;
        } else if (index == 0){
            this.header = node.next;
        } else{
            Node<T> nodePrevious = get(index - 1);
            nodePrevious.setNext(node.next);
            this.tail = this.size - 1 == index ? nodePrevious : this.tail;
        }

        node.setNext(null);
        this.size--;
    }

    public void remove(T value)  {
        remove(getIndex(value));
    }

    private int getIndex(T value) {
        Node<T> node = this.header;
        int count = 0;
        while(node.value != value){
            node = node.next;
            count++;
        }
        return count;
    }

    public Node<T> get(T value){
        return get(getIndex(value));
    }

    public Node<T> get(int index) {
        if(this.size-1 < index){
            return null;
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
