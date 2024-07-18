public class Student {
    private String name;
    private int registration;

    Student(String nome, int matricula){
        setRegistration(matricula);
        setName(nome);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRegistration() {
        return registration;
    }

    public void setRegistration(int registration) {
        this.registration = registration;
    }
}
