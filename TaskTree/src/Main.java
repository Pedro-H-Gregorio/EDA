import classes.Tree;
import interfaces.ITree;

public class Main {
    public static void main(String[] args) {
        ITree tree = new Tree();
        tree.add(5);
        tree.add(4);
        tree.add(7);
        tree.add(2);
        tree.add(3);
        tree.add(1);
        tree.add(0);
        tree.add(6);
        tree.add(8);
        tree.add(9);

        System.out.println(tree.getValue(3));
        System.out.println(tree.getValue(4));
        System.out.println(tree.getValue(7));
        System.out.println(tree.getValue(2));
        System.out.println(tree.getValue(1));
        System.out.println(tree.getValue(0));
        System.out.println(tree.getValue(8));
        System.out.println(tree.getValue(9));
        System.out.println(tree.getValue(10));

        tree.removeLast();
        tree.removeFirst();

        System.out.println(tree.getValue(9));
        System.out.println(tree.getValue(0));

        tree.print_pre_order();
        tree.print_in_order();
        tree.print_post_order();
    }
}