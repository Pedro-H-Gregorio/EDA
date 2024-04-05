public class OrderedCircularDoublyLinkedList {
    private Node header;
    private int size;

    public OrderedCircularDoublyLinkedList(){
        this.header = null;
        this.size = 0;
    }
    public void adicionar(Integer value){
        Node node = new Node(value);
        if(this.header == null){
            this.header = node;
            this.header.setNext(node);
            this.header.setPrevious(node);
        } else {
            Node temp = this.header;
            while(temp.isBigger(node) && node.isBigger(this.header)){
                temp = temp.next;
            }
            node.setNext(temp);
            node.setPrevious(temp.previous);
            temp.previous.setNext(node);
            temp.setPrevious(node);
        }
        this.size++;
    }

    public int remover(){
        if(this.header == null){
            return 0;
        }

        if(tamanho() != 1){
            this.header.next.setPrevious(this.header.previous);
            this.header.previous.setNext(this.header.next);
        }
        this.header = null;
        return 1;
    }

    public int remover(int index) {
        Node node = getNodo(index);

        if (node == null){
            return 0;
        }

        if (index == 0){
            Node nodeNext = node.next;
            nodeNext.setPrevious(node.previous);
            node.previous.setNext(nodeNext);
            this.header = nodeNext;
        } else if (index == this.size - 1){
            node.previous.setNext(this.header);
            this.header.setPrevious(node.previous);
        } else {
            Node nodePrevious = node.previous;
            nodePrevious.setNext(node.next);
            node.next.setPrevious(nodePrevious);
        }

        node.setNext(null);
        node.setPrevious(null);

        this.size--;
        return 1;
    }

    public Node getNodo(int index) {
        if(this.size-1 < index){
            return null;
        }
        if(index > (this.size)/2){
            return getNodo(this.header.previous, this.size - 1 ,index);
        }
        return getNodo(this.header, 0 ,index);
    }

    private Node getNodo(Node node, int indexNode, int indexRequired){
        if (indexNode == indexRequired) {
            return node;
        }
        if(indexRequired > (this.size)/2){
            return getNodo(node.previous, indexNode - 1, indexRequired);
        }
        return getNodo(node.next, indexNode + 1, indexRequired);
    }

    public int tamanho() {
        return size;
    }
}
