public class Main {
    public static void main(String[] args) throws InvalidIndexException {
        CircularDoublyLinkedList<String> circularDoublyLinkedList = new CircularDoublyLinkedList<>();

        circularDoublyLinkedList.add("Pedro");
        circularDoublyLinkedList.add("Alan");
        circularDoublyLinkedList.add("Isaac");

        System.out.println(circularDoublyLinkedList.get(0).value);
        System.out.println(circularDoublyLinkedList.get(1).value);
        System.out.println(circularDoublyLinkedList.get(2).value);
        System.out.println(circularDoublyLinkedList.getSize());
        circularDoublyLinkedList.remove(2);
//        System.out.println(doublyLinkedList.get(2));
        circularDoublyLinkedList.add("Abraão",2);
        System.out.println(circularDoublyLinkedList.get(2).value);
        circularDoublyLinkedList.add("Rickelme", 0);
        System.out.println(circularDoublyLinkedList.get(0).value);
        System.out.println(circularDoublyLinkedList.getSize());

//        doublyLinkedList.add(5,5);
    }
}