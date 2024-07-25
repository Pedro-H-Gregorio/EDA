package classes;

import interfaces.IObjectModel;

public class Student {
    private Integer registration;
    private String name;

    public Student(String name, Integer registration){
        this.name = name;
        this.registration = registration;
    }

    public String getName() {
        return this.name;
    }
    public Integer getRegistration() {
        return this.registration;
    }
}
