package interfaces;

import classes.Node;

import java.util.LinkedList;

public interface IDataPersister<T> {
    void add(T object);
    void remove(int index);
    Node<T> get(int index);
    int getSize();
    boolean isEmpty();
    IDataPersister<T> getInstance();
    T[] toArray();
}
