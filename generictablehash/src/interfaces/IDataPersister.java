package interfaces;

public interface IDataPersister<k> {
    void add(IObjectModel<k,?> object);

    void remove(k key);
    IObjectModel<k,?> get(k key);
}
