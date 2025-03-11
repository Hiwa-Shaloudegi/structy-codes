package Graph;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> graph = Map.of("a", List.of("c", "b"), "b", List.of("d"), "c", List.of("e"), "d", List.of(), "e", List.of());

        printDFSRecursive(graph, "a");
    }

    public static void printBFS(Map<String, List<String>> graph, String src) {
        Queue<String> queue = new ArrayDeque<>();
        queue.add(src);
        while (!queue.isEmpty()) {
            String current = queue.remove();

            System.out.println(current);

            queue.addAll(graph.get(current));
        }
    }

    public static void printDFS(Map<String, List<String>> graph, String src) {
        Stack<String> stack = new Stack<>();
        stack.push(src);
        while (!stack.isEmpty()) {
            String current = stack.pop();

            System.out.println(current);

            stack.addAll(graph.get(current));
        }
    }

    public static void printDFSRecursive(Map<String, List<String>> graph, String src) {
        System.out.println(src);

        for (String n : graph.get(src)) {
            printDFSRecursive(graph, n);
        }


    }

}