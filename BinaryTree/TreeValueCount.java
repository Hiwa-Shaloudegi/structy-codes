package BinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

class TreeValueCount {
    public static void main(String[] args) {
        TNode<Integer> a = new TNode<>(12);
        TNode<Integer> b = new TNode<>(6);
        TNode<Integer> c = new TNode<>(6);
        TNode<Integer> d = new TNode<>(4);
        TNode<Integer> e = new TNode<>(6);
        TNode<Integer> f = new TNode<>(12);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        System.out.println(treeValueCountDFSRecursive(a, 6));
    }

    public static <T> Integer treeValueCountDFSRecursive(TNode<T> root, T target) {
        if (root == null) return 0;

        Integer leftCount = treeValueCountDFSRecursive(root.left, target);
        Integer rightCount = treeValueCountDFSRecursive(root.right, target);
        return leftCount + rightCount + (root.val.equals(target) ? 1 : 0);
    }

    public static <T> Integer treeValueCountDFS(TNode<T> root, T target) {
        if (root == null) return 0;

        int count = 0;

        Stack<TNode<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TNode<T> current = stack.pop();
            if (current.val.equals(target)) count++;

            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);

        }

        return count;
    }

    public static <T> Integer treeValueCountBFS(TNode<T> root, T target) {
        if (root == null) return 0;
        int count = 0;

        Queue<TNode<T>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TNode<T> current = queue.remove();
            if (current.val.equals(target)) count++;

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }

        return count;
    }
}
