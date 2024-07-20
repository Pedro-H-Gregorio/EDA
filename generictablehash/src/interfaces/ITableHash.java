package interfaces;

public interface ITableHash<T> {
    void addValue(IObjectModel object);
    void removeValue(IObjectModel objectModel);
    void getValue(T key);
}
