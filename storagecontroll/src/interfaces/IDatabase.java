package interfaces;

public interface IDatabase<T> {
    void add(IObject<T> object);
    int remove(int index);
    int remove();
    T get(int index);
    int getSize();
}
