package interfaces;

public interface ITableHash<T> {
    void add(int key, T object);
    int remove(int key);
    T get(int key);
}
