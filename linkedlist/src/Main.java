public class Main {
    public static void main(String[] args) throws InvalidIndexException {
         LinkedList<String> linkedList = new LinkedList();

         linkedList.add("Pedro");
         linkedList.add("Alan");
         linkedList.add("Isaac");

        System.out.println(linkedList.get(0).value);
        System.out.println(linkedList.get(1).value);
        System.out.println(linkedList.get(2).value);
        System.out.println(linkedList.getSize());
        linkedList.remove(2);
//        System.out.println(linkedList.get(2));
        linkedList.add("Abraão",2);
        System.out.println(linkedList.get(2).value);
        linkedList.add("Rickelme", 0);
        System.out.println(linkedList.get(0).value);
        System.out.println(linkedList.getSize());

//        linkedList.add(5,5);
    }
}