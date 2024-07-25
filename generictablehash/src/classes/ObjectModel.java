package classes;

import interfaces.IObjectModel;

public class ObjectModel<T> implements IObjectModel<T> {
    private Object key;
    private final T value;

    public ObjectModel(int key,T object){
        this.value = object;
        this.key = key;
    }
    @Override
    public int getKey() {
        return (int) this.key;
    }

    @Override
    public void setKey(Object key) {
        this.key = key;
    }

    @Override
    public T getValue() {
        return this.value;
    }
}
