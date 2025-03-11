package BinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

class BottomRightValue {
    public static void main(String[] args) {
        TNode<String> q = new TNode<>("q");
        TNode<String> r = new TNode<>("r");
        TNode<String> s = new TNode<>("s");
        TNode<String> t = new TNode<>("t");
        TNode<String> u = new TNode<>("u");
        TNode<String> v = new TNode<>("v");
        TNode<String> w = new TNode<>("w");
        TNode<String> x = new TNode<>("x");

        q.left = r;
        q.right = s;
        r.left = t;
        r.right = u;
        s.right = v;
        t.right = w;
        u.left = x;

        System.out.println(bottomRightValueBFS(q));

    }

    public static <T> T bottomRightValueBFS(TNode<T> root) {
        if (root == null) return null;

        TNode<T> lastRemovedFromQueue = root;

        Queue<TNode<T>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TNode<T> current = queue.remove();
            lastRemovedFromQueue = current;

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }

        return lastRemovedFromQueue.val;
    }

}
