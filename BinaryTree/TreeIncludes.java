package BinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

class TreeIncludes {
    public static void main(String[] args) {
        //        TNode<String> a = new TNode<>("a");
        //        TNode<String> b = new TNode<>("b");
        //        TNode<String> c = new TNode<>("c");
        //        TNode<String> d = new TNode<>("d");
        //        TNode<String> e = new TNode<>("e");
        //        TNode<String> f = new TNode<>("f");
        //
        //        a.left = b;
        //        a.right = c;
        //        b.left = d;
        //        b.right = e;
        //        c.right = f;

        //        TNode<String> a = new TNode<>("a");
        //        TNode<String> b = new TNode<>("b");
        //        TNode<String> c = new TNode<>("c");
        //        TNode<String> d = new TNode<>("d");
        //        TNode<String> e = new TNode<>("e");
        //        TNode<String> f = new TNode<>("f");
        //
        //        a.left = b;
        //        a.right = c;
        //        b.left = d;
        //        b.right = e;
        //        c.right = f;

        //        TNode<String> a = new TNode<>("a");
        //        TNode<String> b = new TNode<>("b");
        //        TNode<String> c = new TNode<>("c");
        //        TNode<String> d = new TNode<>("d");
        //        TNode<String> e = new TNode<>("e");
        //        TNode<String> f = new TNode<>("f");
        //
        //        a.left = b;
        //        a.right = c;
        //        b.left = d;
        //        b.right = e;
        //        c.right = f;

        TNode<String> a = new TNode<>("a");
        TNode<String> b = new TNode<>("b");
        TNode<String> c = new TNode<>("c");
        TNode<String> d = new TNode<>("d");
        TNode<String> e = new TNode<>("e");
        TNode<String> f = new TNode<>("f");
        TNode<String> g = new TNode<>("g");
        TNode<String> h = new TNode<>("h");

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        e.left = g;
        f.right = h;
        System.out.println(treeIncludesBFS(a, "p"));
    }

    public static boolean treeIncludesDFS(TNode<String> root, String target) {
        if (root == null) return false;

        boolean hasTarget = false;

        Stack<TNode<String>> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TNode<String> current = stack.pop();
            if (current.val.equals(target)) {
                hasTarget = true;
                break;
            }
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }

        return hasTarget;
    }

    public static boolean treeIncludesDFSRecursive(TNode<String> root, String target) {
        if (root == null) return false;

        if (root.val.equals(target)) return true;
        boolean isInLeft = treeIncludesDFSRecursive(root.left, target);
        boolean isInRight = treeIncludesDFSRecursive(root.right, target);

        return isInLeft || isInRight;
    }

    public static boolean treeIncludesBFS(TNode<String> root, String target) {
        if (root == null) return false;

        boolean hasTarget = false;

        Queue<TNode<String>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TNode<String> current = queue.remove();
            if (current.val.equals(target)) {
                hasTarget = true;
                break;
            }
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }

        return hasTarget;
    }
}
