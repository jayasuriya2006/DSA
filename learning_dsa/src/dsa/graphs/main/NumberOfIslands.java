package dsa.graphs.main;


import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    private static final int[] ADJ_ROW = {-1, 0, 1, 0};
    private static final int[] ADJ_COL = {0, 1, 0, -1};

    public static int numIslands(char[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    dfsForNoOfIsland(i, j, visited, grid);
                }
            }
        }
        return count;
    }

    private static void dfsForNoOfIsland(int i, int j, boolean[][] visited, char[][] grid) {
        visited[i][j] = true;

        for (int l = 0; l < 4; l++) {
            int newRow = i + ADJ_ROW[l];
            int newCol = j + ADJ_COL[l];
            if (newRow >= 0 && newRow < grid.length
                    && newCol >= 0 && newCol < grid[0].length
                    && grid[newRow][newCol] == '1'
                    && !visited[newRow][newCol]) {
                dfsForNoOfIsland(newRow, newCol, visited, grid);         //BFS also implemented
            }
        }

    }

    private static void bfsForNoOfIsland(int i, int j, boolean[][] visited, char[][] grid) {
        Queue<CellInfo> queue = new LinkedList<>();
        visited[i][j] = true;
        queue.offer(new CellInfo(i, j));
        while (!queue.isEmpty()) {
            CellInfo curCell = queue.poll();
            int curRow = curCell.row;
            int curCol = curCell.col;
            for (int l = 0; l < 4; l++) {
                int newRow = curRow + ADJ_ROW[l];
                int newCol = curCol + ADJ_COL[l];
                if (newRow >= 0 && newRow < grid.length
                        && newCol >= 0 && newCol < grid[0].length
                        && grid[newRow][newCol] == '1'
                        && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    queue.offer(new CellInfo(newRow, newCol));
                }
            }

        }
    }
}


class CellInfo {
    int row;
    int col;

    public CellInfo(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
