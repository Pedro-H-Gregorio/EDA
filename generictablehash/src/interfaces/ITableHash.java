package interfaces;

public interface ITableHash<T> {
    void add(IObjectModel object);
    void remove(Object key);
    T get(Object key);
}
