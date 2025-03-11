package BinaryTree;


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

class TreeMinValue {
    public static void main(String[] args) {
        TNode<Double> a = new TNode<>(-1.);
        TNode<Double> b = new TNode<>(-6.);
        TNode<Double> c = new TNode<>(-5.);
        TNode<Double> d = new TNode<>(-3.);
        TNode<Double> e = new TNode<>(-4.);
        TNode<Double> f = new TNode<>(-13.);
        TNode<Double> g = new TNode<>(-2.);
        TNode<Double> h = new TNode<>(-2.);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        e.left = g;
        f.right = h;

//        TNode<Double> a = new TNode<>(42.);

        System.out.println(treeMinValueDFSRecursive(a));
    }

    public static Double treeMinValueDFSRecursive(TNode<Double> root) {
        if (root == null) return Double.POSITIVE_INFINITY;
//        if (root.left == null && root.right == null) return root.val;
//        if (root.left == null) {
//            Double rightVal = root.right.val;
//            if (root.val < rightVal) return root.val;
//            else return rightVal;
//        }
//        if (root.right == null) {
//            Double leftVal = root.left.val;
//            if (root.val < leftVal) return root.val;
//            else return leftVal;
//        }

        Double min = 0.;

        Double minLeft = treeMinValueDFSRecursive(root.left);
        Double minRight = treeMinValueDFSRecursive(root.right);

        min = minRight < minLeft ? minRight : minLeft;
        min = root.val < min ? root.val : min;

        return min;
    }

    public static Double treeMinValueDFS(TNode<Double> root) {
        Double min = root.val;

        Stack<TNode<Double>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TNode<Double> current = stack.pop();
            if (current.val < min) min = current.val;
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }
        return min;
    }

    public static Double treeMinValueBFS(TNode<Double> root) {
        Double min = root.val;

        Queue<TNode<Double>> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TNode<Double> current = queue.remove();
            if (current.val < min) min = current.val;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return min;
    }
}
