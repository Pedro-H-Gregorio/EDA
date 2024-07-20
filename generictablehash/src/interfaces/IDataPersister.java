package interfaces;

public interface IDataPersister<T,k> {
    void add(T object);
    void remove(T object);
    T get(k key);
}
