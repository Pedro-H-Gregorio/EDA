import interfaces.IProduct;

public class Product implements IProduct {
    private String name;
    private Integer quantity;

    public Product(String name, Integer quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    @Override
    public Integer getQuantity() {
        return this.quantity;
    }
    @Override
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(IProduct product) {
        return this.name.compareTo(product.getName());
    }
}
