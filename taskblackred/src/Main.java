import classes.RedBlackTree;
import interfaces.IRedBlackTree;

public class Main {
    public static void main(String[] args) {
        IRedBlackTree tree = new RedBlackTree();
        tree.insert(55);
        tree.insert(40);
        tree.insert(65);
        tree.insert(60);
        tree.insert(75);
        tree.insert(57);

        tree.inorderPrint();
    }
}