package interfaces;

public interface ITree {
    void add(Integer value);
    int removeLast();
    int removeFirst();
    boolean getValue(Integer value);
    void print_pre_order();
    void print_in_order();
    void print_post_order();

}
