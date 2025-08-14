package dsa.graphs.main;

public class DetectCyclesInTwoDGrid {
    private static final int[] DR = {-1, 0, 1, 0}; // up, right, down, left
    private static final int[] DC = {0, 1, 0, -1};

    //TC - O( N * M)
    //SC - O( N * M)
    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    if (dfs(grid, visited, i, j, -1, -1, grid[i][j])) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] grid, boolean[][] visited, int r, int c, int pr, int pc, char target) {
        visited[r][c] = true;

        for (int d = 0; d < 4; d++) {
            int nr = r + DR[d];
            int nc = c + DC[d];

            if (nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length) continue;
            if (grid[nr][nc] != target) continue;

            if (nr == pr && nc == pc) continue; // Don't go back to parent

            if (visited[nr][nc]) {
                // Found a back edge → cycle detected
                return true;
            }

            if (dfs(grid, visited, nr, nc, r, c, target)) {
                return true;
            }
        }

        return false;
    }
}
