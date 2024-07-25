import classes.CircularLinkedList;
import classes.HashTable;
import classes.Student;

public class Main {
    public static void main(String[] args) {
        Student studentOne = new Student("Ray",1);
        Student studentTwo = new Student("Renata",2);
        Student studentTree = new Student("Isaac",3);
        Student studentFour = new Student("Pedro",4);

        HashTable<Student> classe = new HashTable<Student>();
        classe.add(studentOne.getRegistration(),studentOne);
        classe.add(studentTwo.getRegistration(), studentTwo);
        classe.add(studentTree.getRegistration(),studentTree);
        classe.add(studentFour.getRegistration(), studentFour);

        System.out.println(classe.get(1).getName());
        System.out.println(classe.get(2).getName());
        System.out.println(classe.get(3).getName());
        System.out.println(classe.get(4).getName());

        classe.remove(3);

        System.out.println(classe.get(3));

    }
}