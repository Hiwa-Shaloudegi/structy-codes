package Graph;

import java.util.*;

class HasPath {
    public static void main(String[] args) {
        Map<String, List<String>> graph = Map.of("f", List.of("g", "i"), "g", List.of("h"), "h", List.of(), "i", List.of("g", "k"), "j", List.of("i"), "k", List.of());
        System.out.println(hasPathDFSRecursive(graph, "f", "k")); // true

    }

    public static boolean hasPathBFS(Map<String, List<String>> graph, String src, String dst) {
        Queue<String> queue = new ArrayDeque<>();
        queue.add(src);
        while (!queue.isEmpty()) {
            String current = queue.remove();

            if (current.equals(dst)) return true;

            queue.addAll(graph.get(current));
        }

        return false;
    }

    public static boolean hasPathDFS(Map<String, List<String>> graph, String src, String dst) {
        Stack<String> stack = new Stack<>();
        stack.push(src);
        while (!stack.isEmpty()) {
            String current = stack.pop();

            if (current.equals(dst)) return true;

            stack.addAll(graph.get(current));
        }
        return false;
    }

    public static boolean hasPathDFSRecursive(Map<String, List<String>> graph, String src, String dst) {
        if (src.equals(dst)) return true;
        for (String n : graph.get(src)) {
            if (hasPathDFSRecursive(graph, n, dst)) return true;
        }
        return false;
    }


}
