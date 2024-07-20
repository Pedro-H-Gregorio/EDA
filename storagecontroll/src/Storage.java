import interfaces.IStorage;
import interfaces.IDatabase;
import interfaces.IProduct;

public class Storage implements IStorage {
    private IDatabase storage;
    public Storage(IDatabase storage){
        this.storage = storage;
    }
    @Override
    public void add(IProduct product) {
        IProduct productVerify = checkProduct(product.getName());
        if(productVerify == null){
            storage.add(product);
        } else {
            productVerify.setQuantity(productVerify.getQuantity() + product.getQuantity());
        }
    }

    @Override
    public int remove(IProduct product) {
        IProduct productVerify = checkProduct(product.getName());
        if(productVerify == null || product.getQuantity() > productVerify.getQuantity()){
            return -1;
        }
        if(product.getQuantity() == productVerify.getQuantity()){
            this.storage.remove(getIndex(productVerify.getName()));
            return 1;
        }
        productVerify.setQuantity(productVerify.getQuantity() - product.getQuantity());
        return 0;
    }

    @Override
    public IProduct[] list() {
        IProduct[] products = new IProduct[this.storage.getSize()];
        for(int i = 0; i < this.storage.getSize(); i++){
            products[i] = (IProduct) this.storage.get(i);
        }
        return products;
    }

    @Override
    public IProduct checkProduct(String name) {
        int index = getIndex(name);
        return index != -1 ? (IProduct) this.storage.get(index) :null;
    }

    private int getIndex(String name){
        IProduct[] list = list();
        for(int i = 0; i < list.length; i++){
            if(name.equals(list[i].getName())){
                return i;
            }
        }
        return -1;
    }
}
