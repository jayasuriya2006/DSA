package dsa.dp.main;

import java.util.Arrays;

public class GridUniquePathsII {

    //TC - O( N * M)
    //SC - O( (N - 1) + (M -1 )) + O( N * M)
    public static int getUniquePathIICountMemo(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return getUniquePathIICountHelper(n - 1, m - 1, dp, matrix);
    }

    public static int getUniquePathIICountHelper(int row, int col, int[][] dp, int[][] matrix) {
        if (row == 0 && col == 0) {
            if (matrix[0][0] != -1) {
                return 1;
            } else {
                return 0;
            }
        }

        if (row < 0 || col < 0) {
            return 0;
        }

        if (matrix[row][col] == -1) {
            return 0;
        }

        if (dp[row][col] != -1) return dp[row][col];

        int up = getUniquePathIICountHelper(row - 1, col, dp, matrix);
        int left = getUniquePathIICountHelper(row, col - 1, dp, matrix);

        dp[row][col] = up + left;

        return dp[row][col];
    }

    //TC - O( N * M)
    //SC - O( N * M)
    public static int getUniquePathCountTabulation(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (row == 0 && col == 0) {
                    dp[row][col] = 1;
                } else {
                    if (matrix[row][col] == -1) {
                        dp[row][col] = 0;
                    } else {
                        dp[row][col] = (row > 0 ? dp[row - 1][col] : 0) + (col > 0 ? dp[row][col - 1] : 0);
                    }
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    //TC - O( N * M)
    //SC - O(M)
    public static int getUniquePathCountSpaceOptimized(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;
        int[] prev = new int[m];

        for (int row = 0; row < n; row++) {
            int[] temp = new int[m];
            for (int col = 0; col < m; col++) {
                if (row == 0 && col == 0) {
                    if (matrix[0][0] != -1) {
                        temp[col] = 1;
                    } else {
                        temp[col] = 0;
                    }
                } else {
                    if (matrix[row][col] == -1) {
                        temp[col] = 0;
                    } else {
                        temp[col] = (row > 0 ? prev[col] : 0) + (col > 0 ? temp[col - 1] : 0);
                    }
                }
            }
            prev = temp;
        }
        return prev[m - 1];
    }
}
