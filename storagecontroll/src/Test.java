import interfaces.IProduct;
import orderlinkedlist.OrderLinkedList;

public class Test {
    public static void main(String[] args) {
        OrderLinkedList<IProduct> orderedCircularDoublyLinkedList = new OrderLinkedList<>();
        Product product1 = new Product("A",1);
        Product product2 = new Product("B", 1);
        Product product3 = new Product("C", 1);
        Product product4 = new Product("D", 1);
        Product product5 = new Product("E", 1);

        orderedCircularDoublyLinkedList.add(product1);
        orderedCircularDoublyLinkedList.add(product3);
        orderedCircularDoublyLinkedList.add(product2);
        System.out.println(orderedCircularDoublyLinkedList.get(0).getName());
        System.out.println(orderedCircularDoublyLinkedList.get(1).getName());
        System.out.println(orderedCircularDoublyLinkedList.get(2).getName());

//        orderedCircularDoublyLinkedList.add(product1);
//        System.out.println(orderedCircularDoublyLinkedList.get(0).getName());
//        orderedCircularDoublyLinkedList.remove();
//        System.out.println(orderedCircularDoublyLinkedList.get(0));
//
//        orderedCircularDoublyLinkedList.add(product1);
//        orderedCircularDoublyLinkedList.add(product2);
//        orderedCircularDoublyLinkedList.add(product3);
//
//        System.out.println(orderedCircularDoublyLinkedList.get(0).getName());
//        System.out.println(orderedCircularDoublyLinkedList.get(1).getName());
//        System.out.println(orderedCircularDoublyLinkedList.get(2).getName());
//        System.out.println(orderedCircularDoublyLinkedList.getSize());
//        orderedCircularDoublyLinkedList.remove(2);
//        System.out.println(orderedCircularDoublyLinkedList.get(2));
//        orderedCircularDoublyLinkedList.add(product4);
//        System.out.println(orderedCircularDoublyLinkedList.get(2).getName());
//        orderedCircularDoublyLinkedList.add(product5);
//        System.out.println(orderedCircularDoublyLinkedList.get(0).getName());
//        orderedCircularDoublyLinkedList.remove();
//        System.out.println(orderedCircularDoublyLinkedList.get(orderedCircularDoublyLinkedList.getSize() - 1).getName());
//        System.out.println(orderedCircularDoublyLinkedList.getSize());
    }
}
