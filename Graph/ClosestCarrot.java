package Graph;

import java.util.*;

record Triplet<K, V, T>(K row, V col, T distance) {}
record Pair<K, V>(K row, V col) {}

class ClosestCarrot {

    public static void main(String[] args) {
        List<List<String>> grid = List.of(
                List.of("O", "O", "O", "O", "O"),
                List.of("O", "X", "O", "O", "O"),
                List.of("O", "X", "X", "O","O"),
                List.of("O", "X", "C", "O", "O"),
                List.of("C", "O", "O", "O", "O")
        );

        System.out.println(closestCarrot(grid, 1, 2));
    }


    public static int closestCarrot(List<List<String>> grid, int startRow, int startCol) {
        Set<Pair<Integer, Integer>> visited = new HashSet<>();

        Queue<Triplet<Integer, Integer, Integer>> queue = new ArrayDeque<>();
        queue.add(new Triplet<>(startRow, startCol, 0));
        while (!queue.isEmpty()) {
            Triplet<Integer, Integer, Integer> current = queue.remove();
            Integer row = current.row();
            Integer col = current.col();
            Integer distance = current.distance();

            visited.add(new Pair<>(row, col));
            if (grid.get(row).get(col).equals("C"))
                return distance;

            int newDistance = distance + 1;
            List<Triplet<Integer, Integer, Integer>> neighbors = List.of(
                    new Triplet<>(row - 1, col, newDistance),
                    new Triplet<>(row, col + 1, newDistance),
                    new Triplet<>(row + 1, col, newDistance),
                    new Triplet<>(row, col - 1, newDistance)
            );
            for (Triplet<Integer, Integer, Integer> n : neighbors) {
                boolean isRowInBound = 0 <= n.row() && n.row() < grid.size();
                boolean isColInBound = 0 <= n.col() && n.col() < grid.getFirst().size();
                if (!visited.contains(new Pair<>(n.row(), n.col())) && isRowInBound && isColInBound && !grid.get(n.row()).get(n.col()).equals("X")) queue.add(n);
            }
        }
        return -1;
    }

}
