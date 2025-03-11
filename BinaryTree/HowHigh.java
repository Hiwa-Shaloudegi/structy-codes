package BinaryTree;

import java.util.Stack;

class HowHigh {
    public static void main(String[] args) {
        TNode<String> a = new TNode<>("a");
        TNode<String> b = new TNode<>("b");
        TNode<String> c = new TNode<>("c");
        TNode<String> d = new TNode<>("d");
        TNode<String> e = new TNode<>("e");
        TNode<String> f = new TNode<>("f");
        TNode<String> h = new TNode<>("h");

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        e.right = h;

        System.out.println(howHighDFSRecursive(a));
    }

    public static <T> Integer howHighDFSRecursive(TNode<T> root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 0;

        Integer leftHeight = howHighDFSRecursive(root.left);
        Integer rightHeight = howHighDFSRecursive(root.right);

        return Math.max(leftHeight, rightHeight) + 1;

    }

    public static <T> Integer howHighDFS(TNode<T> root) {
        if (root == null) return 0;

        double maxHeight = Double.NEGATIVE_INFINITY;
        int count = -1;

        Stack<TNode<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TNode<T> current = stack.pop();
            if (current.left == null && current.right == null) maxHeight = Math.max(count, maxHeight);
            else count++;

            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);

        }

        return (int) maxHeight;
    }
}
