package dsa.dp.main;

public class CherryPickupII {

    //TC - O( 3 ^ N  *  3 ^ N)  -recursion
    //TC - O( N  * M) * 9
    //SC - O( N * M * M)  + O(N)
    public int cherryPickupMemo(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return cherryPickup(grid, 0, 0, m - 1, n, m, dp);
    }

    private int cherryPickup(int[][] grid, int i, int j1, int j2, int n, int m, int[][][] dp) {
        if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) return 0;
        if (i == n - 1) {
            if (j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }

        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];

        int max = 0;
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int cherrys = 0;
                if (j1 == j2) {
                    cherrys = grid[i][j1];
                } else {
                    cherrys = grid[i][j1] + grid[i][j2];
                }

                cherrys += cherryPickup(grid, i + 1, j1 + dj1, j2 + dj2, n, m, dp);
                max = Math.max(max, cherrys);
            }
        }
        dp[i][j1][j2] = max;
        return max;
    }

    //TC - O( N * M * M)
    //SC - O( N * M * M)
    public int cherryPickupTabulation(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j) {
                    dp[n - 1][i][j] = grid[n - 1][j];
                } else {
                    dp[n - 1][i][j] = grid[n - 1][j] + grid[n - 1][i];
                }
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int max = Integer.MIN_VALUE;
                    for (int dj1 = -1; dj1 <= 1; dj1++) {
                        for (int dj2 = -1; dj2 <= 1; dj2++) {
                            int nj1 = j1 + dj1;
                            int nj2 = j2 + dj2;

                            if (nj1 >= 0 && nj1 < m && nj2 >= 0 && nj2 < m) {
                                int cherries = (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];
                                cherries += dp[i + 1][nj1][nj2];
                                max = Math.max(max, cherries);
                            }
                        }
                    }
                    dp[i][j1][j2] = max;
                }
            }
        }

        // Return the result from the top-left and top-right corners
        return dp[0][0][m - 1];
    }

}
