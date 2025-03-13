package Graph;

import java.util.*;

class LargestComponent {
    public static void main(String[] args) {

        System.out.println(
                largestComponentDFSRecursive(Map.of(0, List.of(8, 1, 5), 1, List.of(0), 5, List.of(0, 8), 8, List.of(0, 5), 2, List.of(3, 4), 3, List.of(2, 4), 4, List.of(3, 2)))
        );

    }


    public static int largestComponentDFS(Map<Integer, List<Integer>> graph) {
        if (graph.isEmpty()) return 0;

        int maxComponent = (int) Double.NEGATIVE_INFINITY;
        Set<Integer> visited = new HashSet<>();

        for (int node : graph.keySet()) {
            Stack<Integer> stack = new Stack<>();

            if (visited.contains(node)) continue;
            else stack.push(node);

            Set<Integer> componentVisited = new HashSet<>();
            while (!stack.isEmpty()) {
                Integer current = stack.pop();
                visited.add(current);
                componentVisited.add(current);

                for (int n : graph.get(current))
                    if (!visited.contains(n)) stack.push(n);
            }
            if (componentVisited.size() > maxComponent) maxComponent = componentVisited.size();
        }
        return maxComponent;
    }


    public static int largestComponentDFSRecursive(Map<Integer, List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();

        int maxSize = 0;
        for (int node : graph.keySet()) {
            int componentSize = getComponentSizeRecursive(graph, node, visited);
            if (componentSize > maxSize) maxSize = componentSize;
        }
        return maxSize;
    }

    public static int getComponentSizeRecursive(Map<Integer, List<Integer>> graph, int src, Set<Integer> visited) {
        if (visited.contains(src)) return 0;

        visited.add(src);

        int count = 1;
        for (int n : graph.get(src)) {
            count += getComponentSizeRecursive(graph, n, visited);
        }
        return count;
    }

}