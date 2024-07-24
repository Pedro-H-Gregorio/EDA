package classes;

import interfaces.IObjectModel;

public abstract class ObjectModel implements IObjectModel {
    private Object key;
    @Override
    public int getKey() {
        return (int) this.key;
    }

    @Override
    public void setKey(Object key) {
        this.key = key;
    }
}
