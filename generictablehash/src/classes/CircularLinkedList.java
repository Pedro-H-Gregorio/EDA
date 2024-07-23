package classes;

import interfaces.IDataPersister;
import interfaces.IObjectModel;

public class CircularLinkedList<k> implements IDataPersister<k> {
    private Node<IObjectModel<k,?>> header = null;
    private int size = 0;

    @Override
    public IObjectModel<k, ?> get(Object key) {
        Node<IObjectModel<k,?>> node = this.header;
        while (node != null && node.value.getKey() != key){
            node = node.next;
        }
        if (node == null) return null;
        return  node.value;
    }

    public Node<IObjectModel<k,?>> get(int index) {
        if(getSize() -1 < index){
            return null;
        }
        return this.get(this.header, 0 ,index);
    }

    private Node<IObjectModel<k,?>> get(Node<IObjectModel<k,?>> node, int indexNode, int indexRequired){
        if (indexNode == indexRequired){
            return node;
        }
        indexNode++;
        return this.get(node.next, indexNode, indexRequired);
    }

    private int getSize(){
        return this.size;
    }

    @Override
    public void add(IObjectModel<k, ?> object) {
        Node<IObjectModel<k, ?>> node = new Node<>(object);
        if(this.header == null){
            this.header = node;
            this.header.setNext(node);
        }  else {
            Node<IObjectModel<k,?>> previous = this.get(getSize() - 1);
            node.setNext(previous.next);
            previous.setNext(node);
        }
        this.size++;
    }

    @Override
    public void remove(k key) {

    }
}
