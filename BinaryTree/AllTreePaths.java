package BinaryTree;

import java.util.ArrayList;
import java.util.List;

class AllTreePaths {
    public static void main(String[] args) {
        TNode<String> a = new TNode<>("a");
        TNode<String> b = new TNode<>("b");
        TNode<String> c = new TNode<>("c");
        TNode<String> d = new TNode<>("d");
        TNode<String> e = new TNode<>("e");
        TNode<String> f = new TNode<>("f");

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        System.out.println(allTreePathsDFSRecursive(a));
    }

    // addFirst() method is costly for ArrayList, instead use LinkedList
    public static <T> List<List<TNode<T>>> allTreePathsDFSRecursive(TNode<T> root) {
        if (root == null) return List.of();
        if (root.left == null && root.right == null) {
            List<TNode<T>> singlePath = new ArrayList<>(List.of(root));
            return new ArrayList<>(List.of(singlePath));
        }

        List<List<TNode<T>>> paths = new ArrayList<>();

        List<List<TNode<T>>> leftPaths = allTreePathsDFSRecursive(root.left);
        List<List<TNode<T>>> rightPaths = allTreePathsDFSRecursive(root.right);

        for (List<TNode<T>> path : leftPaths) path.addFirst(root);
        for (List<TNode<T>> path : rightPaths) path.addFirst(root);

        paths.addAll(leftPaths);
        paths.addAll(rightPaths);

        return paths;
    }

}
