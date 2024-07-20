import interfaces.IController;
import interfaces.IDatabase;
import interfaces.IProduct;
import interfaces.IStorage;

public class Controller extends FactoryMethod implements IController {
    private IStorage storage;
    @Override
    public void add(String name, Integer quantity) {
        storage.add(createProduct(name, quantity));
    }

    @Override
    public int remove(String name, Integer quantity) {
        return storage.remove(createProduct(name,quantity));
    }

    @Override
    public IProduct[] list() {
        return storage.list();
    }

    @Override
    public IProduct checkProduct(String name) {
        return storage.checkProduct(name);
    }

    @Override
    public void connectStorage(IDatabase database){
        this.storage = createStorage(database);
    }
}
