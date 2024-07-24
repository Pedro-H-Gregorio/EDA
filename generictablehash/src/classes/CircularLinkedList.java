package classes;

import classes.Node;
import interfaces.IDataPersister;

public class CircularLinkedList<T> implements IDataPersister<T> {

    private IDataPersister<T> instance;
    private Node header;
    private int size = 0;

    public CircularLinkedList(){
        this.header = null;
    }
    public void add(T value)  {
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

    public void add(T value, int index) {
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

    public void remove(int index) {
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

    public Node<T> get(int index) {
        if(this.size-1 < index){
            return null;
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

    @Override
    public IDataPersister<T> getInstance() {
        if (instance == null) {
            instance = new CircularLinkedList<>();
        }
        return instance;
    }

    @Override
    public T[] toArray() {
        Object[] array = new Object[getSize()];
        Node<T> node = this.header;
        for(int i = 0; i<getSize(); i++){
            array[i] = node;
            node = node.next;
        }
        return array.length == 0? null : (T[]) array;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }
}
