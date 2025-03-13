package Graph;

import java.util.*;

class ConnectedComponentsCount {
    public static void main(String[] args) {
        System.out.println(connectedComponentsCount(Map.of(1, List.of(2), 2, List.of(1, 8), 6, List.of(7), 9, List.of(8), 7, List.of(6, 8), 8, List.of(9, 7, 2))));
    }

    public static int connectedComponentsCount(Map<Integer, List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();

        int count = 0;
        for (Integer node : graph.keySet()) {
            // DFS Traversal
            Stack<Integer> stack = new Stack<>();
            if (!visited.contains(node)) stack.push(node);
            else continue;
            stack.push(node);
            while (!stack.isEmpty()) {
                Integer current = stack.pop();
                visited.add(current);

                for (Integer n : graph.get(current))
                    if (!visited.contains(n)) stack.push(n);
            }
            count++;
        }
        return count;
    }
}
