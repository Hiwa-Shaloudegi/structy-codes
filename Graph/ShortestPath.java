package Graph;

import java.util.AbstractMap.SimpleEntry;
import java.util.*;

class ShortestPath {
    public static void main(String[] args) {
        List<List<String>> edges = List.of(
                List.of("w", "x"),
                List.of("x", "y"),
                List.of("z", "y"),
                List.of("z", "v"),
                List.of("w", "v")
        );
        System.out.println(shortestPath(edges, "w", "z"));
    }

    public static int shortestPath(List<List<String>> edges, String nodeA, String nodeB) {
        // Convert to graph
        Map<String, List<String>> graph = toGraph(edges);

        // BFS
        Set<String> visited = new HashSet<>();
        Queue<SimpleEntry<String, Integer>> queue = new ArrayDeque<>();
        queue.add(new SimpleEntry<>(nodeA, 0));
        while (!queue.isEmpty()) {
            SimpleEntry<String, Integer> currentEntry = queue.remove();
            String currentNode = currentEntry.getKey();
            Integer distance = currentEntry.getValue();
            visited.add(currentNode);

            if (currentNode.equals(nodeB)) return distance;
            for (String neighbor : graph.get(currentNode)) {
                if (!visited.contains(neighbor)) queue.add(new SimpleEntry<>(neighbor, distance + 1));
            }

        }
        return -1;
    }

    public static Map<String, List<String>> toGraph(List<List<String>> edges) {
        Map<String, List<String>> graph = new HashMap<>();

        for (List<String> edge : edges) {
            String first = edge.getFirst();
            String last = edge.getLast();

            if (graph.containsKey(first)) graph.get(first).add(last);
            else graph.put(first, new ArrayList<>(List.of(last)));

            if (graph.containsKey(last)) graph.get(last).add(first);
            else graph.put(last, new ArrayList<>(List.of(first)));
        }
        return graph;
    }
}
