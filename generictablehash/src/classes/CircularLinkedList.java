package classes;

import interfaces.IDataPersister;
import interfaces.IObjectModel;

public class CircularLinkedList<T extends IObjectModel<?, ?>,k> implements IDataPersister<T,k> {
    private Node<T> header = null;
    private int size = 0;
    @Override
    public void add(IObjectModel object) {
        Node<IObjectModel> node = new Node<>(object);
        if(this.header == null){
            this.header = node;
            this.header.setNext(node);
        }  else {
        Node<IObjectModel> previous = this.get(getSize() - 1);
        node.setNext(previous.next);
        previous.setNext(node);
        }
        this.size++;
    }

    @Override
    public void remove(IObjectModel object) {

    }

    @Override
    public IObjectModel get(k key) {
        Node<IObjectModel> node = this.header;
        while (node != null && node.value.getKey() != key){
            node = node.next;
        }
        if (node == null) return null;
        return node.value;
    }

    public Node<IObjectModel> get(int index) {
        if(getSize() -1 < index){
            return null;
        }
        return this.get(this.header, 0 ,index);
    }

    private Node<IObjectModel> get(Node<IObjectModel> node, int indexNode, int indexRequired){
        if (indexNode == indexRequired){
            return node;
        }
        indexNode++;
        return this.get(node.next, indexNode, indexRequired);
    }

    private int getSize(){
        return this.size;
    }

}
