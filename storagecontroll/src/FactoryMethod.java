import interfaces.IDatabase;
import interfaces.IFactoryMethods;
import interfaces.IProduct;
import interfaces.IStorage;

public abstract class FactoryMethod implements IFactoryMethods {
    @Override
    public IProduct createProduct(String name, Integer quantity) {
        return new Product(name, quantity);
    }

    @Override
    public IStorage createStorage(IDatabase database) {
        return new Storage(database);
    }
}
