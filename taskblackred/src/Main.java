import classes.RedBlackTree;
import interfaces.IRedBlackTree;

public class Main {
    public static void main(String[] args) {
        IRedBlackTree tree = new RedBlackTree();
        tree.add(55);
        tree.add(40);
        tree.add(65);
        tree.add(60);
        tree.add(75);
        tree.add(57);

        tree.inorderPrint();
    }
}