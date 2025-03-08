package BinaryTree;

import java.util.Stack;

class TreeSum {
    public static void main(String[] args) {
        TNode<Integer> a = new TNode<>(3);
        TNode<Integer> b = new TNode<>(11);
        TNode<Integer> c = new TNode<>(4);
        TNode<Integer> d = new TNode<>(4);
        TNode<Integer> e = new TNode<>(-2);
        TNode<Integer> f = new TNode<>(1);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        System.out.println(treeSumDFSRecursive(a));
    }

    public static int treeSumDFS(TNode<Integer> root) {
        if (root == null) return 0;

        int sum = 0;
        // DFS
        Stack<TNode<Integer>> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TNode<Integer> current = stack.removeLast();
            sum += current.val;

            if (current.right != null) stack.add(current.right);
            if (current.left != null) stack.add(current.left);
        }

        return sum;
    }
    public static int treeSumDFSRecursive(TNode<Integer> root) {
            if (root == null) return 0;

            int sum = 0;

            int leftSum = treeSumDFSRecursive(root.left);
            int rightSum = treeSumDFSRecursive(root.right);
            sum += root.val + leftSum + rightSum;

            return sum;
    }


    public static int treeSumBFS(TNode<Integer> root) {
        return 0;
    }

    }
