package orderlinkedlist;

import interfaces.IDatabase;
import interfaces.IObject;

public class OrderLinkedList<T> implements IDatabase<T> {
    private Node header;
    private Node tail;
    private int size = 0;

    @Override
    public void add(IObject<T> object) {
        Node node = new Node(object);
        if(this.header == null){
            this.header = node;
            this.tail = node;
        } else if (node.isBigger(this.tail)) {
            this.tail.setNext(node);
            this.tail = node;
        } else {
            Node temp = this.header;
            Node previus = null;
            this.header = node.isBigger(this.header)? this.header: node;
            while(node.isBigger(temp) && !node.isEqual(this.header)){
                previus = temp;
                temp = temp.next;
            }
            if(previus != null) {
                previus.setNext(node);
            }
            node.setNext(temp);
        }
        this.size++;
    }

    @Override
    public int remove(int index) {
        Node node = get(this.header,0,index);

        if (node == null){
            return 0;
        }

        if (index == 0){
            this.header = node.next;
        } else if (index == this.size - 1){
            return remove();
        } else {
            Node nodePrevious = get(this.header, 0, index - 1);
            nodePrevious.setNext(node.next);
        }

        node.setNext(null);
        this.size--;
        return 1;
    }

    @Override
    public int remove() {
        if(this.header == null){
            return 0;
        }

        if(getSize() != 1){
            Node node = get(this.header,0,getSize()-2);
            this.tail = node;
            this.tail.setNext(null);
            size--;
            return 1;
        }
        this.header = null;
        this.tail = null;
        size--;
        return 1;
    }

    @Override
    public T get(int index) {
        if(this.size-1 < index){
            return null;
        }
        return (T) get(this.header, 0 ,index).value;
    }

    private Node get(Node node, int indexNode, int indexRequired){
        if (indexNode == indexRequired){
            return node;
        }
        indexNode++;
        return get(node.next, indexNode, indexRequired);
    }

    @Override
    public int getSize() {
        return this.size;
    }
}
