package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class BFS {
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

        System.out.println(breadthFirstValues(a));
    }


    public static List<String> breadthFirstValues(TNode<String> root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;

        // Queue
        Queue<TNode<String>> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TNode<String> current = queue.remove();
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);

            result.add(current.val);
        }
        return result;
    }
}
