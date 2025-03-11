package BinaryTree;

import java.util.AbstractMap.SimpleEntry;
import java.util.*;

class TreeLevels {
    public static void main(String[] args) {
        TNode<String> a = new TNode<>("3");
        TNode<String> b = new TNode<>("11");
        TNode<String> c = new TNode<>("4");
        TNode<String> d = new TNode<>("4");
        TNode<String> e = new TNode<>("10");
        TNode<String> f = new TNode<>("1");
        TNode<String> x = new TNode<>("99");

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        f.right = x;

        System.out.println(treeLevelsDFSRecursive(a));
    }


    public static <T> List<List<TNode<T>>> treeLevelsBFS(TNode<T> root) {
        if (root == null) return List.of();

        List<List<TNode<T>>> levels = new ArrayList<>();

        Queue<SimpleEntry<TNode<T>, Integer>> queue = new ArrayDeque<>();
        queue.add(new SimpleEntry<>(root, 0));

        while (!queue.isEmpty()) {
            SimpleEntry<TNode<T>, Integer> currentEntry = queue.remove();
            TNode<T> currentNode = currentEntry.getKey();
            Integer currentLevelNum = currentEntry.getValue();

            boolean levelListNotExists = currentLevelNum >= levels.size();
            List<TNode<T>> levelNodes;
            if (levelListNotExists) {
                levels.add(new ArrayList<>(List.of(currentNode)));
            } else {
                levelNodes = levels.get(currentLevelNum);
                levelNodes.add(currentNode);
            }
            currentLevelNum++;
            if (currentNode.left != null) queue.add(new SimpleEntry<>(currentNode.left, currentLevelNum));
            if (currentNode.right != null) queue.add(new SimpleEntry<>(currentNode.right, currentLevelNum));
        }

        return levels;
    }


    public static <T> List<List<TNode<T>>> treeLevelsDFS(TNode<T> root) {
        if (root == null) return List.of();

        List<List<TNode<T>>> levels = new ArrayList<>();

        Stack<SimpleEntry<TNode<T>, Integer>> stack = new Stack<>();
        stack.push(new SimpleEntry<>(root, 0));

        while (!stack.isEmpty()) {
            SimpleEntry<TNode<T>, Integer> currentEntry = stack.pop();
            TNode<T> currentNode = currentEntry.getKey();
            Integer currentLevelNum = currentEntry.getValue();

            boolean levelListNotExists = currentLevelNum >= levels.size();
            List<TNode<T>> levelNodes;
            if (levelListNotExists) {
                levels.add(new ArrayList<>(List.of(currentNode)));
            } else {
                levelNodes = levels.get(currentLevelNum);
                levelNodes.add(currentNode);
            }
            currentLevelNum++;
            if (currentNode.right != null) stack.add(new SimpleEntry<>(currentNode.right, currentLevelNum));
            if (currentNode.left != null) stack.add(new SimpleEntry<>(currentNode.left, currentLevelNum));
        }

        return levels;
    }


    public static <T> List<List<TNode<T>>> treeLevelsDFSRecursive(TNode<T> root) {
        if (root == null) return List.of();
        if (root.left == null && root.right == null) return new ArrayList<>(List.of(List.of(root)));

        List<List<TNode<T>>> leftLevels = treeLevelsDFSRecursive(root.left);
        List<List<TNode<T>>> rightLevels = treeLevelsDFSRecursive(root.right);

        List<List<TNode<T>>> result = new ArrayList<>();
        result.add(List.of(root));

        // Combine levels from left and right subtrees
        int maxLevels = Math.max(leftLevels.size(), rightLevels.size());

        for (int i = 0; i < maxLevels; i++) {
            List<TNode<T>> level = new ArrayList<>();
            if (i < leftLevels.size()) {
                level.addAll(leftLevels.get(i));
            }
            if (i < rightLevels.size()) {
                level.addAll(rightLevels.get(i));
            }
            if (!level.isEmpty()) {
                result.add(level);
            }
        }
        return result;
    }

}
