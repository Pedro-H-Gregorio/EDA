package interfaces;

public interface IFactoryMethods<T> {
    IProduct createProduct(String name, Integer quantity);
    IStorage createStorage(IDatabase<T> database);
}
