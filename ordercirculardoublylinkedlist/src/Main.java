public class Main {
    public static void main(String[] args) {
        CircularDoublyLinkedList<String> circularDoublyLinkedList = new CircularDoublyLinkedList<>();
        circularDoublyLinkedList.adicionar("Pedro");
        circularDoublyLinkedList.adicionar("Alan");
        circularDoublyLinkedList.adicionar("Isaac");

        System.out.println(circularDoublyLinkedList.getNodo(0).value);
        System.out.println(circularDoublyLinkedList.getNodo(1).value);
        System.out.println(circularDoublyLinkedList.getNodo(2).value);
        System.out.println(circularDoublyLinkedList.tamanho());
        circularDoublyLinkedList.remover(2);
        System.out.println(circularDoublyLinkedList.getNodo(2));
        circularDoublyLinkedList.adicionar("Abraão");
        System.out.println(circularDoublyLinkedList.getNodo(2).value);
        circularDoublyLinkedList.adicionar("Rickelme");
        System.out.println(circularDoublyLinkedList.getNodo(0).value);
        System.out.println(circularDoublyLinkedList.tamanho());
    }
}