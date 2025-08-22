package dsa.graphs.main;

public class NumberOfEnclaves {
    private static final int[] AD_ROW = {-1, 0, 1, 0};
    private static final int[] AD_COL = {0, 1, 0, -1};

    //TC - O(N + M) + O( N * M * 4)
    //SC - O(N * M) + O(N * M)
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) {
                markNonEnclavesDFS(i, 0, vis, n, m, grid);
            }
            if (grid[i][m - 1] == 1) {
                markNonEnclavesDFS(i, m - 1, vis, n, m, grid);
            }
        }

        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 1) {
                markNonEnclavesDFS(0, i, vis, n, m, grid);
            }
            if (grid[n - 1][i] == 1) {
                markNonEnclavesDFS(n - 1, i, vis, n, m, grid);
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private void markNonEnclavesDFS(int i, int j, boolean[][] vis, int n, int m, int[][] board) {
        vis[i][j] = true;
        for (int in = 0; in < 4; in++) {
            int nr = i + AD_ROW[in];
            int nc = j + AD_COL[in];
            if (nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc] && board[nr][nc] == 1) {
                markNonEnclavesDFS(nr, nc, vis, n, m, board);
            }
        }
    }
}
