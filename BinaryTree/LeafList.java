package BinaryTree;

import java.util.*;

class LeafList {
    public static void main(String[] args) {
        //        TNode<String> a = new TNode<>("A");
        //        TNode<String> b = new TNode<>("B");
        //        TNode<String> c = new TNode<>("C");
        //        TNode<String> d = new TNode<>("D");
        //        TNode<String> e = new TNode<>("E");
        //        TNode<String> f = new TNode<>("F");
        //
        //        a.left = b;
        //        a.right = c;
        //        b.left = d;
        //        b.right = e;
        //        c.right = f;

        TNode<String> q = new TNode<>("Q");
        TNode<String> r = new TNode<>("R");
        TNode<String> s = new TNode<>("S");
        TNode<String> t = new TNode<>("T");
        TNode<String> u = new TNode<>("U");
        TNode<String> v = new TNode<>("V");
        TNode<String> w = new TNode<>("W");
        TNode<String> x = new TNode<>("X");
        TNode<String> y = new TNode<>("Y");
        TNode<String> z = new TNode<>("Z");

        q.left = r;
        q.right = s;
        r.left = t;
        r.right = u;
        s.right = v;
        t.right = w;
        u.left = x;
        u.right = y;
        y.right = z;

        System.out.println(leafListDFSRecursive(q));
    }


    // BFS approach is not valid, cuz the leaves must be in order from left to right.
    // if the leaves would be in different levels, then the leaves order will be incorrect.
    public static <T> List<TNode<T>> leafListBFS(TNode<T> root) {
        if (root == null) return null;

        List<TNode<T>> leafValues = new ArrayList<>();

        Queue<TNode<T>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TNode<T> current = queue.remove();
            if (current.left == null && current.right == null) leafValues.add(current);

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }

        return leafValues;
    }

    public static <T> List<TNode<T>> leafListDFS(TNode<T> root) {
        if (root == null) return null;

        List<TNode<T>> leafValues = new ArrayList<>();

        Stack<TNode<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TNode<T> current = stack.pop();
            if (current.left == null && current.right == null) leafValues.add(current);

            if (current.right != null) stack.add(current.right);
            if (current.left != null) stack.add(current.left);
        }

        return leafValues;
    }

    public static <T> List<TNode<T>> leafListDFSRecursive(TNode<T> root) {
        if (root == null) return new ArrayList<>();
        if (root.left == null && root.right == null) return new ArrayList<>(List.of(root));

        List<TNode<T>> leftLeaves = leafListDFSRecursive(root.left);
        List<TNode<T>> rightLeaves = leafListDFSRecursive(root.right);

        leftLeaves.addAll(rightLeaves);

        return leftLeaves;
    }
}
