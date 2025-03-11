package BinaryTree;

import java.util.ArrayList;
import java.util.List;

class TreePathFinder {
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

        System.out.println(treePathFinderDFSRecursive(a, "e"));

//        TNode<Integer> root = new TNode<>(0);
//        TNode<Integer> curr = root;
//        for (int i = 1; i < 6000; i++) {
//            TNode<Integer> newNode = new TNode<>(i);
//            curr.right = newNode;
//            curr = curr.right;
//        }
//        System.out.println(treePathFinderDFSRecursive(root, 3451));

    }

    // Using addFirst() method for ArrayList is costly => O(n)
    // Instead using LinkedList OR use addLast() method and then reverse the final result
    public static <T> List<T> treePathFinderDFSRecursive(TNode<T> root, T target) {
        if (root == null) return null;
        if (root.val.equals(target)) return new ArrayList<>(List.of(root.val));

        List<T> leftPath = treePathFinderDFSRecursive(root.left, target);
        if (leftPath != null) {
            leftPath.addFirst(root.val);
            return leftPath;
        }

        List<T> rightPath = treePathFinderDFSRecursive(root.right, target);
        if (rightPath != null) {
            rightPath.addFirst(root.val);
            return rightPath;
        }

        return null;
    }

}
