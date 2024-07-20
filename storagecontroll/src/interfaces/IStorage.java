package interfaces;

public interface IStorage {
    void add(IProduct product);
    int remove(IProduct product);
    IProduct[] list();
    IProduct checkProduct(String name);
}
