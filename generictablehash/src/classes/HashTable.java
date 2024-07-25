package classes;

import interfaces.IDataPersister;
import interfaces.IObjectModel;
import interfaces.ITableHash;

public class HashTable<T> implements ITableHash<T> {

    private IDataPersister<IObjectModel<T>>[] vector = new CircularLinkedList[32];

    private int hash(int key){
        return  key % this.vector.length;
    }

    public HashTable(){
        for(int index = 0; index < this.vector.length; index++) vector[index] = new CircularLinkedList<IObjectModel<T>>();
    }
    @Override
    public void add(int key ,T object) {
        IObjectModel<T> objectModel = new ObjectModel<>(key,object);
        int hash = hash(objectModel.getKey());
        vector[hash].add(objectModel);
    }

    @Override
    public int remove(int key) {
        int index = getIndex(key);
        if ( index == -1) {
            return index;
        }
        this.vector[hash(key)].remove(index);
        return 0;
    }

    @Override
    public T get(int key) {
        int index = getIndex(key);

        if ( index == -1) {
            return null;
        }

        IObjectModel<T> result = this.vector[hash(key)].get(index).value;
        return result.getValue();
    }

    private int getIndex(int key){
        Object[] list = this.vector[hash(key)].toArray();

        if(list == null){
            return -1;
        }

        for(int i = 0; i<list.length; i++){
            if(key == (((IObjectModel<T>) list[i]).getKey())){
                return i;
            }
        }
        return -1;
    }

}
