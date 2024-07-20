package classes;

import interfaces.IObjectModel;

public class Student implements IObjectModel<Integer, String> {
    private Integer registration;
    private String name;

    @Override
    public Integer getKey() {
        return this.registration;
    }

    @Override
    public String getValue() {
        return this.name;
    }
}
