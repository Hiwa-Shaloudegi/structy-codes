package Graph;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;


class IslandCount {
    public static void main(String[] args) {
        List<List<String>> grid = List.of(
                List.of("W", "L", "W", "W", "W"),
                List.of("W", "L", "W", "W", "W"),
                List.of("W", "W", "W", "L", "W"),
                List.of("W", "W", "L", "L", "W"),
                List.of("L", "W", "W", "L", "L"),
                List.of("L", "L", "W", "W", "W")
        );

        System.out.println(islandCountRecursive(grid));
    }

    // Iterative
    public static int islandCount(List<List<String>> grid) {
        Set<SimpleEntry<Integer, Integer>> visited = new HashSet<>();

        int count = 0;
        for (int r = 0; r < grid.size(); r++) {
            for (int c = 0; c < grid.getFirst().size(); c++) {
                if (grid.get(r).get(c).equals("L") && !visited.contains(new SimpleEntry<>(r, c))) {

                    // Travers
                    Stack<SimpleEntry<Integer, Integer>> stack = new Stack<>();
                    if (!visited.contains(new SimpleEntry<>(r, c))) stack.push(new SimpleEntry<>(r, c));
                    while (!stack.isEmpty()) {
                        SimpleEntry<Integer, Integer> current = stack.pop();
                        visited.add(current);
                        Integer newRow = current.getKey();
                        Integer newValue = current.getValue();

                        if (isInBound(newRow - 1, newValue, grid) && grid.get(newRow - 1).get(newValue).equals("L")) {
                            SimpleEntry<Integer, Integer> neighborUp = new SimpleEntry<>(newRow - 1, newValue);
                            if (!visited.contains(neighborUp)) {
                                stack.push(neighborUp);
                                visited.add(neighborUp);
                            }
                        }
                        if (isInBound(newRow + 1, newValue, grid) && grid.get(newRow + 1).get(newValue).equals("L")) {
                            SimpleEntry<Integer, Integer> neighborDown = new SimpleEntry<>(newRow + 1, newValue);
                            if (!visited.contains(neighborDown)) {
                                stack.push(neighborDown);
                                visited.add(neighborDown);
                            }
                        }
                        if (isInBound(newRow, newValue + 1, grid) && grid.get(newRow).get(newValue + 1).equals("L")) {
                            SimpleEntry<Integer, Integer> neighborRight = new SimpleEntry<>(newRow, newValue + 1);
                            if (!visited.contains(neighborRight)) {
                                stack.push(neighborRight);
                                visited.add(neighborRight);
                            }
                        }
                        if (isInBound(newRow, newValue - 1, grid) && grid.get(newRow).get(newValue - 1).equals("L")) {
                            SimpleEntry<Integer, Integer> neighborLeft = new SimpleEntry<>(newRow, newValue - 1);
                            if (!visited.contains(neighborLeft)) {
                                stack.push(neighborLeft);
                                visited.add(neighborLeft);
                            }
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isInBound(int r, int c, List<List<String>> grid) {
        boolean isRowInBound = 0 <= r && r < grid.size();
        boolean isColumnInBound = 0 <= c && c < grid.getFirst().size();
        return isRowInBound && isColumnInBound;
    }

    // Recursive
    public static int islandCountRecursive(List<List<String>> grid) {
        Set<SimpleEntry<Integer, Integer>> visited = new HashSet<>();

        int componentCount = 0;
        for (int r = 0; r < grid.size(); r++) {
            for (int c = 0; c < grid.getFirst().size(); c++) {
                if (grid.get(r).get(c).equals("L") && !visited.contains(new SimpleEntry<>(r, c))) {
                    int numOfLandSquares = 0;
                    numOfLandSquares += explore(r, c, grid, visited);
                    if (numOfLandSquares > 0) componentCount++;
                }
            }
        }
        return componentCount;
    }

    private static int explore(int r, int c, List<List<String>> grid, Set<SimpleEntry<Integer, Integer>> visited) {
        if (visited.contains(new SimpleEntry<>(r, c)) || grid.get(r).get(c).equals("W")) return 0;

        visited.add(new SimpleEntry<>(r, c));

        int upCount = 0;
        int downCount = 0;
        int rightCount = 0;
        int leftCount = 0;

        if (isInBound(r - 1, c, grid)) upCount = explore(r - 1, c, grid, visited);
        if (isInBound(r + 1, c, grid)) downCount = explore(r + 1, c, grid, visited);
        if (isInBound(r , c - 1, grid)) leftCount = explore(r , c - 1, grid, visited);
        if (isInBound(r, c + 1, grid)) rightCount = explore(r, c + 1, grid, visited);

        return 1 + upCount + downCount + leftCount + rightCount;
    }
}
