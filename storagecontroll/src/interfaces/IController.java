package interfaces;

public interface IController {
    void add(String name, Integer quantity);
    int remove(String name, Integer quantity);
    IProduct[] list();
    IProduct checkProduct(String name);
    void connectStorage(IDatabase database);
}
