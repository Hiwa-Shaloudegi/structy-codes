package Graph;

import java.util.*;

class UndirectedPath {
    public static void main(String[] args) {
        List<List<String>> edges = List.of(List.of("i", "j"), List.of("k", "i"), List.of("m", "k"), List.of("k", "l"), List.of("o", "n"));

        System.out.println(undirectedPathDFS(edges, "j", "m"));
    }

    public static boolean undirectedPathDFS(List<List<String>> edges, String nodeA, String nodeB) {
        Map<String, List<String>> graph = new HashMap<>();

        // Convert to adjacency list
        for (List<String> e : edges) {
            String first = e.getFirst();
            String last = e.getLast();

            if (graph.containsKey(first)) graph.get(first).add(last);
            else graph.put(first, new ArrayList<>(List.of(last)));

            if (graph.containsKey(last)) graph.get(last).add(first);
            else graph.put(last, new ArrayList<>(List.of(first)));
        }
        // Graph traversal (BFS, DFS, Recursive DFS)
        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();
        stack.push(nodeA);
        while (!stack.isEmpty()) {
            String current = stack.pop();
            visited.add(current);
            if (current.equals(nodeB)) return true;
            for (String n : graph.get(current)) {
                if (!visited.contains(n)) stack.push(n);
            }
        }
        return false;
    }
}
