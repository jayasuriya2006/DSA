package dsa.graphs.main;

public class SurroundedRegionsReplaceZeroWithX {
    private static final int[] AD_ROW = {-1, 0, 1, 0};
    private static final int[] AD_COL = {0, 1, 0, -1};

    //TC - O(N + M) + O( N * M * 4)
    //SC - O(N * M) + O(N * M)
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                markNonSurroundsDFS(i, 0, vis, n, m, board);
            }
            if (board[i][m - 1] == 'O') {
                markNonSurroundsDFS(i, m - 1, vis, n, m, board);
            }
        }

        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O') {
                markNonSurroundsDFS(0, i, vis, n, m, board);
            }
            if (board[n - 1][i] == 'O') {
                markNonSurroundsDFS(n - 1, i, vis, n, m, board);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void markNonSurroundsDFS(int i, int j, boolean[][] vis, int n, int m, char[][] board) {
        vis[i][j] = true;
        for (int in = 0; in < 4; in++) {
            int nr = i + AD_ROW[in];
            int nc = j + AD_COL[in];
            if (nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc] && board[nr][nc] == 'O') {
                markNonSurroundsDFS(nr, nc, vis, n, m, board);
            }
        }
    }
}
