public class Main {
    public static void main(String[] args) {
        Student studentOne = new Student("Ray",1);
        Student studenttwo = new Student("Renata",2);
        Student studentTree = new Student("Isaac",3);
        Student studentFour = new Student("Pedro",4);

        HashTable classe = new HashTable();
        classe.insertValue(studentOne);
        classe.insertValue(studenttwo);
        classe.insertValue(studentTree);
        classe.insertValue(studentFour);

        System.out.println(classe.getValue(1).getName());
        System.out.println(classe.getValue(2).getName());
        System.out.println(classe.getValue(3).getName());
        System.out.println(classe.getValue(4).getName());

        classe.removeValue(3);

        System.out.println(classe.getValue(3));

    }
}