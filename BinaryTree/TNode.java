package BinaryTree;

public class TNode<T> {
    T val;
    TNode<T> left;
    TNode<T> right;

    public TNode(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
