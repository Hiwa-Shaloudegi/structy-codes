package BinaryTree;

class MaxRootToLeafPathSum {
    public static void main(String[] args) {
        TNode<Double> a = new TNode<>(-1.);
        TNode<Double> b = new TNode<>(-6.);
        TNode<Double> c = new TNode<>(-5.);
        TNode<Double> d = new TNode<>(-3.);
        TNode<Double> e = new TNode<>(0.);
        TNode<Double> f = new TNode<>(-13.);
        TNode<Double> g = new TNode<>(-1.);
        TNode<Double> h = new TNode<>(-2.);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        e.left = g;
        f.right = h;

        System.out.println(maxPathSumDFSRecursive(a));
    }

    public static Double maxPathSumDFS(TNode<Double> root) {
        return 0.;
    }

    public static Double maxPathSumDFSRecursive(TNode<Double> root) {
        if (root == null) return Double.NEGATIVE_INFINITY;
        if (root.left == null && root.right == null) return root.val;

        Double leftSum = maxPathSumDFSRecursive(root.left);
        Double rightSum = maxPathSumDFSRecursive(root.right);
        Double maxChild = Math.max(leftSum, rightSum);

        return maxChild + root.val;
    }

    public static Double maxPathSumBFS(TNode<Double> root) {
        return 0.;
    }

}
