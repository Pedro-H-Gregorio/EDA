package classes;

import interfaces.IObjectModel;
import interfaces.ITableHash;

public class HashTable<T> implements ITableHash<T> {

    private IObjectModel<T>[] vector = new IObjectModel[3];

    private int hash(int key, Integer length){
        return  key % length;
    }

    private int hash(int key){
        return hash(key,this.vector.length);
    }

    private void resizeArray(){
        IObjectModel<T>[] newArray = new IObjectModel[this.vector.length * 2];
        for(int i = 0; i < this.vector.length; i++){
            newArray[hash(this.vector[i].getKey(),newArray.length)] = this.vector[i];
        }
        this.vector = newArray;
    }

    private int searchIndexToAdd(int index){
        if(this.vector.length <= index){
            resizeArray();
        }
        if(vector[index] == null || vector[index].getKey() == -1){
            return index;
        }
        return searchIndexToAdd(index + 1);
    }

    private int searchIndexToGet(IObjectModel<T>[] vector, int index, int key){
        if(index >= vector.length || vector[index] == null){
            return -1;
        }
        if(vector[index].getKey() == key){
            return index;
        }
        return searchIndexToGet(vector, index + 1, key);
    }
    @Override
    public void add(int key ,T object) {
        IObjectModel<T> objectModel = new ObjectModel<>(key,object);
        int hash = hash(objectModel.getKey());
        if(vector[hash] == null){
            vector[hash] = objectModel;
        } else {
            int index = searchIndexToAdd(hash);
            vector[index] = objectModel;
        }
    }

    @Override
    public int remove(int key) {
        int index = getIndex(key);
        if ( index == -1) {
            return index;
        }
        this.vector[index] = new ObjectModel<>(-1, null);
        return 0;
    }

    @Override
    public T get(int key) {
        int index = getIndex(key);

        if ( index == -1) {
            return null;
        }

        IObjectModel<T> result = this.vector[index];
        return result.getValue();
    }

    private int getIndex(int key){
        int index = hash(key);

        if(vector[index] == null || vector[index].getKey() == -1){
            return -1;
        }

        if(vector[index].getKey() == key){
            return index;
        }

        return searchIndexToGet(vector, index, key);
    }

}
