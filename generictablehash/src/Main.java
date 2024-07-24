import classes.CircularLinkedList;
import classes.HashTable;
import classes.Student;

public class Main {
    public static void main(String[] args) {
        Student studentOne = new Student("Ray",1);
        Student studenttwo = new Student("Renata",2);
        Student studentTree = new Student("Isaac",3);
        Student studentFour = new Student("Pedro",4);

        HashTable classe = new HashTable(new CircularLinkedList[32]);
        classe.add(studentOne);
        classe.add(studenttwo);
        classe.add(studentTree);
        classe.add(studentFour);

        System.out.println(classe.get(1).getName());
        System.out.println(classe.get(2).getName());
        System.out.println(classe.get(3).getName());
        System.out.println(classe.get(4).getName());

        classe.remove(3);

        System.out.println(classe.get(3));

    }
}