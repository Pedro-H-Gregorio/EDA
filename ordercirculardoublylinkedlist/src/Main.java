public class Main {
    public static void main(String[] args) {
        OrderedCircularDoublyLinkedList orderedCircularDoublyLinkedList = new OrderedCircularDoublyLinkedList();
        orderedCircularDoublyLinkedList.adicionar(5);
        orderedCircularDoublyLinkedList.adicionar(6);
        orderedCircularDoublyLinkedList.adicionar(7);

        System.out.println(orderedCircularDoublyLinkedList.getNodo(0).value);
        System.out.println(orderedCircularDoublyLinkedList.getNodo(1).value);
        System.out.println(orderedCircularDoublyLinkedList.getNodo(2).value);
        System.out.println(orderedCircularDoublyLinkedList.tamanho());
        orderedCircularDoublyLinkedList.remover(2);
        System.out.println(orderedCircularDoublyLinkedList.getNodo(2));
        orderedCircularDoublyLinkedList.adicionar(8);
        System.out.println(orderedCircularDoublyLinkedList.getNodo(2).value);
        orderedCircularDoublyLinkedList.adicionar(4);
        System.out.println(orderedCircularDoublyLinkedList.getNodo(0).value);
        orderedCircularDoublyLinkedList.remover();
        System.out.println(orderedCircularDoublyLinkedList.getNodo(0).value);
        System.out.println(orderedCircularDoublyLinkedList.tamanho());
    }
}