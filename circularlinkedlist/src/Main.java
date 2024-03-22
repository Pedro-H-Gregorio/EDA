public class Main {
    public static void main(String[] args) throws InvalidIndexException {
         CircularLinkedList<String> circularLinkedList = new CircularLinkedList<>();

         circularLinkedList.add("Pedro");
         circularLinkedList.add("Alan");
         circularLinkedList.add("Isaac");

        System.out.println(circularLinkedList.get(0).value);
        System.out.println(circularLinkedList.get(1).value);
        System.out.println(circularLinkedList.get(2).value);
        System.out.println(circularLinkedList.getSize());
        circularLinkedList.remove(2);
//        System.out.println(circularLinkedList.get(2));
        circularLinkedList.add("Abraão",2);
        System.out.println(circularLinkedList.get(2).value);
        circularLinkedList.add("Rickelme", 0);
        System.out.println(circularLinkedList.get(0).value);
        System.out.println(circularLinkedList.getSize());
        circularLinkedList.printList();
//        circularLinkedList.add(5,5);
    }
}