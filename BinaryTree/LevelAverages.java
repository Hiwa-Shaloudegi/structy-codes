package BinaryTree;

import java.util.*;

class LevelAverages {
    public static void main(String[] args) {
        TNode<Integer> a = new TNode<>(3);
        TNode<Integer> b = new TNode<>(11);
        TNode<Integer> c = new TNode<>(4);
        TNode<Integer> d = new TNode<>(4);
        TNode<Integer> e = new TNode<>(25);
        TNode<Integer> f = new TNode<>(1);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        System.out.println(levelAveragesBFS(a));
    }

    public static List<Double> levelAveragesBFS(TNode<Integer> root) {
        if (root == null) return null;

        List<List<TNode<Integer>>> levels = new ArrayList<>();

        Queue<AbstractMap.SimpleEntry<TNode<Integer>, Integer>> queue = new ArrayDeque<>();
        queue.add(new AbstractMap.SimpleEntry<>(root, 0));

        while (!queue.isEmpty()) {
            AbstractMap.SimpleEntry<TNode<Integer>, Integer> currentEntry = queue.remove();
            TNode<Integer> currentNode = currentEntry.getKey();
            Integer currentLevelNum = currentEntry.getValue();

            boolean levelListNotExists = currentLevelNum >= levels.size();
            List<TNode<Integer>> levelNodes;
            if (levelListNotExists) {
                levels.add(new ArrayList<>(List.of(currentNode)));
            } else {
                levelNodes = levels.get(currentLevelNum);
                levelNodes.add(currentNode);
            }
            currentLevelNum++;
            if (currentNode.left != null) queue.add(new AbstractMap.SimpleEntry<>(currentNode.left, currentLevelNum));
            if (currentNode.right != null) queue.add(new AbstractMap.SimpleEntry<>(currentNode.right, currentLevelNum));
        }

        List<Double> avereageList = levels.stream().map(levelNodes -> {
            double sum = 0.;
            for (TNode<Integer> node : levelNodes) {
                sum += node.val;
            }
            return sum / levelNodes.size();
        }).toList();

        return avereageList;
    }
    public static List<Double> levelAveragesDFS(TNode<Integer> root) {
        if (root == null) return null;

        List<List<TNode<Integer>>> levels = new ArrayList<>();

        Stack<AbstractMap.SimpleEntry<TNode<Integer>, Integer>> stack = new Stack<>();
        stack.push(new AbstractMap.SimpleEntry<>(root, 0));

        while (!stack.isEmpty()) {
            AbstractMap.SimpleEntry<TNode<Integer>, Integer> currentEntry = stack.pop();
            TNode<Integer> currentNode = currentEntry.getKey();
            Integer currentLevelNum = currentEntry.getValue();

            boolean levelListNotExists = currentLevelNum >= levels.size();
            List<TNode<Integer>> levelNodes;
            if (levelListNotExists) {
                levels.add(new ArrayList<>(List.of(currentNode)));
            } else {
                levelNodes = levels.get(currentLevelNum);
                levelNodes.add(currentNode);
            }
            currentLevelNum++;
            if (currentNode.right != null) stack.add(new AbstractMap.SimpleEntry<>(currentNode.right, currentLevelNum));
            if (currentNode.left != null) stack.add(new AbstractMap.SimpleEntry<>(currentNode.left, currentLevelNum));
        }

        List<Double> avereageList = levels.stream().map(levelNodes -> {
            double sum = 0.;
            for (TNode<Integer> node : levelNodes) {
                sum += node.val;
            }
            return sum / levelNodes.size();
        }).toList();

        return avereageList;
    }
}
