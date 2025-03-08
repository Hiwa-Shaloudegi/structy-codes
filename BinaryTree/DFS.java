package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class DFS {
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

        System.out.println(depthFirstValues(a));
    }


    public static List<String> depthFirstValues(TNode<String> root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;

        // Stack
        Stack<TNode<String>> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TNode<String> current = stack.pop();
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);

            result.add(current.val);
        }
        return result;
    }

    // Recursive
    public static List<String> depthFirstValuesRecursive(TNode<String> root) {
        if (root == null) return List.of();

        List<String> result = new ArrayList<>();

        List<String> leftArray = depthFirstValuesRecursive(root.left);
        List<String> rightArray = depthFirstValuesRecursive(root.right);

        result.add(root.val);
        result.addAll(leftArray);
        result.addAll(rightArray);

        return result;
    }

}
