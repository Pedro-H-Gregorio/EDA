package interfaces;

public interface IProduct extends IObject<IProduct>{
    Integer getQuantity();
    void setQuantity(Integer quantity);
    String getName();
    int compareTo(IProduct product);
}
