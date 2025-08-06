package dsa.dp.main;

import java.util.Arrays;

public class MaximumPathInGrid {

    //TC - O( N * M)
    //SC - O(N) + O(N * M)
    public static int minFallingPathSumMemo(int[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int min = Integer.MIN_VALUE;
        for (int col = 0; col < n; col++) {
            min = Math.max(min, getMinPathSumMemoHelper(grid, n - 1, col, dp));
        }

        return min;
    }

    public static int getMinPathSumMemoHelper(int[][] grid, int row, int col, int[][] dp) {
        int n = grid.length;

        if (col < 0 || col >= n) {
            return Integer.MIN_VALUE;
        }

        if (row == 0) {
            return grid[0][col];
        }

        if (dp[row][col] != -1) return dp[row][col];

        int up = getMinPathSumMemoHelper(grid, row - 1, col, dp);
        int leftDiag = getMinPathSumMemoHelper(grid, row - 1, col - 1, dp);
        int rightDiag = getMinPathSumMemoHelper(grid, row - 1, col + 1, dp);

        dp[row][col] = grid[row][col] + Math.max(up, Math.max(leftDiag, rightDiag));

        return dp[row][col];
    }

    //TC - O( N * M)
    //SC - O(N * M)
    public static int minFallingPathTabulation(int[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        int[][] dp = new int[n][n];
        dp[0] = grid[0];
        for (int row = 1; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int up = dp[row - 1][col];
                int leftDiag = Integer.MIN_VALUE;
                if (col > 0) leftDiag = dp[row - 1][col - 1];
                int rightDiag = Integer.MIN_VALUE;
                if (col <= n - 2) rightDiag = dp[row - 1][col + 1];
                dp[row][col] = grid[row][col] + Math.max(up, Math.max(leftDiag, rightDiag));
            }
        }

        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, dp[n - 1][i]);
        }
        return maxi;
    }

    //TC - O( N * M)
    //SC - O(N * M)
    public static int minFallingPathSpaceOptimized(int[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        int[] prev = new int[n];
        prev = grid[0];
        for (int row = 1; row < n; row++) {
            int[] temp = new int[n];
            for (int col = 0; col < n; col++) {
                int up = prev[col];
                int leftDiag = Integer.MIN_VALUE;
                if (col > 0) leftDiag = prev[col - 1];
                int rightDiag = Integer.MIN_VALUE;
                if (col <= n - 2) rightDiag = prev[col + 1];
                temp[col] = grid[row][col] + Math.max(up, Math.max(leftDiag, rightDiag));
            }
            prev = temp;
        }

        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, prev[i]);
        }
        return maxi;
    }
}

