public class HashTable {
    private LinkedList[] students = new LinkedList[20];

    private int hash(int registration){
        return registration % this.students.length;
    }

    public void insertValue(Student student){
        int hash = hash(student.getRegistration());
        if (students[hash] == null){
            students[hash] = new LinkedList<>();
        }
        students[hash].add(student);
    }

    public Student getValue(int registration){
        LinkedList<Student> list = students[hash(registration)];
        Node<Student> node = list.get(0);
        while (node != null && node.value.getRegistration() != registration){
            node = node.next;
        }
        if(node == null) return null;
        return node.value;
    }

    public void removeValue(int registration){
        students[hash(registration)].remove(getValue(registration));
    }

}
