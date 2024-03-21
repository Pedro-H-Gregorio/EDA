public class Main {
    public static void main(String[] args) throws InvalidIndexException {
        DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.add("Pedro");
        doublyLinkedList.add("Alan");
        doublyLinkedList.add("Isaac");

        System.out.println(doublyLinkedList.get(0).value);
        System.out.println(doublyLinkedList.get(1).value);
        System.out.println(doublyLinkedList.get(2).value);
        System.out.println(doublyLinkedList.getSize());
        doublyLinkedList.remove(2);
//        System.out.println(doublyLinkedList.get(2));
        doublyLinkedList.add("Abraão",2);
        System.out.println(doublyLinkedList.get(2).value);
        doublyLinkedList.add("Rickelme", 0);
        System.out.println(doublyLinkedList.get(0).value);
        System.out.println(doublyLinkedList.getSize());

//        doublyLinkedList.add(5,5);
    }
}