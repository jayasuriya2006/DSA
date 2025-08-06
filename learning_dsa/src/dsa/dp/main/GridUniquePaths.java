package dsa.dp.main;

import java.util.Arrays;

public class GridUniquePaths {

    //TC - O( N * M)
    //SC - O( (N - 1) + (M -1 )) + O( N * M)
    public static int getUniquePathCountMemo(int n, int m) {
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return getUniquePathCountHelper(n - 1, m - 1, dp);
    }

    public static int getUniquePathCountHelper(int row, int col, int[][] dp) {
        if (row == 0 && col == 0) {
            return 1;
        }

        if (row < 0 || col < 0) {
            return 0;
        }

        if (dp[row][col] != -1) return dp[row][col];

        int up = getUniquePathCountHelper(row - 1, col, dp);
        int left = getUniquePathCountHelper(row, col - 1, dp);

        dp[row][col] = up + left;

        return dp[row][col];
    }

    //TC - O( N * M)
    //SC - O( N * M)
    public static int getUniquePathCountTabulation(int n, int m) {
        int[][] dp = new int[n][m];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (row == 0 && col == 0) {
                    dp[row][col] = 1;
                } else {
                    dp[row][col] = (row > 0 ? dp[row - 1][col] : 0) + (col > 0 ? dp[row][col - 1] : 0);
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    //TC - O( N * M)
    //SC - O(M)
    public static int getUniquePathCountSpaceOptimized(int n, int m) {
        int[] prev = new int[m];

        for (int row = 0; row < n; row++) {
            int[] temp = new int[m];
            for (int col = 0; col < m; col++) {
                if (row == 0 && col == 0) {
                    temp[col] = 1;
                } else {
                    temp[col] = (row > 0 ? prev[col] : 0) + (col > 0 ? temp[col - 1] : 0);
                }
            }
            prev = temp;
        }
        return prev[m - 1];
    }
}
