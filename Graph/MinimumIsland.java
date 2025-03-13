package Graph;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class MinimumIsland {
    public static void main(String[] args) {
        List<List<String>> grid = List.of(
                List.of("W", "L", "W", "W", "W"),
                List.of("W", "L", "W", "W", "W"),
                List.of("W", "W", "W", "L", "W"),
                List.of("W", "W", "L", "L", "W"),
                List.of("L", "W", "W", "L", "L"),
                List.of("L", "L", "W", "W", "W")
        );

        System.out.println(minimumIslandRecursive(grid));

    }

    // Recursive
    public static int minimumIslandRecursive(List<List<String>> grid) {
        Set<AbstractMap.SimpleEntry<Integer, Integer>> visited = new HashSet<>();

        int minCount = (int) Double.POSITIVE_INFINITY;
        for (int r = 0; r < grid.size(); r++) {
            for (int c = 0; c < grid.getFirst().size(); c++) {
                if (grid.get(r).get(c).equals("L") && !visited.contains(new AbstractMap.SimpleEntry<>(r, c))) {
                    int numOfLandSquares = 0;
                    numOfLandSquares += explore(r, c, grid, visited);
                    if (numOfLandSquares < minCount) minCount = numOfLandSquares;
                }
            }
        }
        return minCount;
    }

    private static int explore(int r, int c, List<List<String>> grid, Set<AbstractMap.SimpleEntry<Integer, Integer>> visited) {
        if (visited.contains(new AbstractMap.SimpleEntry<>(r, c)) || grid.get(r).get(c).equals("W")) return 0;

        visited.add(new AbstractMap.SimpleEntry<>(r, c));

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

    private static boolean isInBound(int r, int c, List<List<String>> grid) {
        boolean isRowInBound = 0 <= r && r < grid.size();
        boolean isColumnInBound = 0 <= c && c < grid.getFirst().size();
        return isRowInBound && isColumnInBound;
    }
}
