package interfaces;

public interface IObjectModel<T> {
    int getKey();
    void setKey(Object key);
    T getValue();
}
