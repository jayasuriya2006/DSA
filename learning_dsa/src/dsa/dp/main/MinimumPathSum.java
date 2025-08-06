package dsa.dp.main;

import java.util.Arrays;

public class MinimumPathSum {

    //TC - O(N * N)
    //SC - O((N - 1) + (M - 1)) + O( N * M)
    public static int minimumPathSumMemo(int[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;

        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return minimumPathSumMemoHelper(grid, n - 1, m - 1, dp);

    }

    private static int minimumPathSumMemoHelper(int[][] grid, int row, int col, int[][] dp) {
        if (row == 0 && col == 0) {
            return grid[0][0];
        }

        if (row < 0 || col < 0) {
            return 1000000000;
        }

        if (dp[row][col] != -1) return dp[row][col];

        int up = grid[row][col] + minimumPathSumMemoHelper(grid, row - 1, col, dp);
        int right = grid[row][col] + minimumPathSumMemoHelper(grid, row, col - 1, dp);

        dp[row][col] = Math.min(up, right);
        return dp[row][col];
    }

    //TC - O(N * N)
    //SC - O( N * M)
    public static int minimumPathSumTabulation(int[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;

        int[][] dp = new int[n][m];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (row == 0 && col == 0) {
                    dp[row][col] = grid[row][col];
                } else {
                    int left = 1000000000;
                    if (col > 0) left = grid[row][col] + dp[row][col - 1];
                    int up = 1000000000;
                    if (row > 0) up = grid[row][col] + dp[row - 1][col];

                    dp[row][col] = Math.min(up, left);
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    //TC - O(N * N)
    //SC - O( N )
    public static int minimumPathSumTSpaceOptimized(int[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;

        int[] prev = new int[m];
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum = sum + grid[0][i];
            prev[i] = sum;
        }

        for (int row = 1; row < n; row++) {
            int[] temp = new int[m];
            for (int col = 0; col < m; col++) {
                int left = 1000000000;
                if (col > 0) left = grid[row][col] + temp[col - 1];
                int up = grid[row][col] + prev[col];
                temp[col] = Math.min(up, left);
            }
            prev = temp;
        }
        return prev[m - 1];
    }
}
