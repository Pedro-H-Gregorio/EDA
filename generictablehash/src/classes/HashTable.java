package classes;

import interfaces.IDataPersister;
import interfaces.IObjectModel;
import interfaces.ITableHash;

public class HashTable implements ITableHash<IObjectModel> {

    private IDataPersister<IObjectModel>[] vector;

    public HashTable(IDataPersister<IObjectModel>[] storage){
        this.vector = storage;
    }

    private int hash(Object key){
        return (int) key % this.vector.length;
    }
    @Override
    public void add(IObjectModel object) {
        int hash = hash(object.getKey());
        if (vector[hash] == null){
            vector[hash] = vector[hash].getInstance();
        }
        vector[hash].add(object);
    }

    @Override
    public void remove(Object key) {
        int index = getIndex(key);
        this.vector[hash(key)].remove(index);
    }

    @Override
    public IObjectModel get(Object key) {
        int index = getIndex(key);
        return index == -1? null: this.vector[hash(key)].get(index).value;
    }

    private int getIndex(Object key){
        IObjectModel[] list = this.vector[hash(key)].toArray();
        for(int i = 0; i<list.length; i++){
            if(key.equals(list[i].getKey())){
                return i;
            }
        }
        return -1;
    }

}
