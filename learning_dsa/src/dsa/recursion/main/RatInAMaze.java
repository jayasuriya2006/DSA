package dsa.recursion.main;

import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {

    //DLRU
    public static final int[] ROW_MOVEMENT = {1, 0, 0, -1};
    public static final int[] COL_MOVEMENT = {0, -1, 1, 0};
    public static final String MOVEMENT = "DLRU";

    public static List<String> getPaths(int[][] matrix) {
        List<String> result = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        getPaths(matrix, 0, 0, new StringBuilder(), result, n, m, visited);
        return result;
    }

    //TC - O(4 ^ n * m)   each cell trying 4 possible ways
    //SC - O(m * n) max stack space
    private static void getPaths(int[][] matrix, int row, int col, StringBuilder curPath, List<String> result, int n, int m, boolean[][] visited) {
        if (row == n - 1 && col == m - 1) {
            result.add(new String(curPath));
            return;
        }

        for (int i = 0; i < 4; i++) {
            int newRow = row + ROW_MOVEMENT[i];
            int newCol = col + COL_MOVEMENT[i];
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && matrix[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                visited[newRow][newCol] = true;
                curPath = curPath.append(MOVEMENT.charAt(i));
                getPaths(matrix, newRow, newCol, curPath, result, n, m, visited);
                curPath.deleteCharAt(curPath.length() - 1);
                visited[newRow][newCol] = false;
            }
        }
    }
}
