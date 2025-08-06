package dsa.dp.main;

import java.util.Arrays;

public class Triangle {

    //TC - O( N * N)
    //SC - O( N * N) + O(N)
    public static int maxSumPathInTriangleMemo(int[][] triangle) {
        int n = triangle.length;
        if (n == 0) return 0;
        if (n == 1) return triangle[0][0];

        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return maxSumPathInTriangleHelper(triangle, 0, 0, dp);
    }

    public static int maxSumPathInTriangleHelper(int[][] triangle, int row, int col, int[][] dp) {
        if (row == triangle.length - 1) {
            return triangle[row][col];
        }

        if (dp[row][col] != -1) return dp[row][col];

        int down = triangle[row][col] + maxSumPathInTriangleHelper(triangle, row + 1, col, dp);
        int diag = triangle[row][col] + maxSumPathInTriangleHelper(triangle, row + 1, col + 1, dp);

        dp[row][col] =  Math.max(down, diag);

        return dp[row][col];
    }

    //TC - O( N * N)
    //SC - O( N * N)
    public static int maxSumPathInTriangleTabulation(int[][] triangle) {
        int n = triangle.length;
        if (n == 0) return 0;
        if (n == 1) return triangle[0][0];

        int[][] dp = new int[n][n];
        dp[n - 1] = triangle[n - 1];

        for (int row = n - 2; row >= 0; row--) {
            for (int col = row ; col >= 0; col--) {
                dp[row][col] = triangle[row][col] + Math.max(dp[row + 1][col], dp[row + 1][col + 1]);
            }
        }
        return dp[0][0];
    }

    //TC - O( N * N)
    //SC - O( N )
    public static int maxSumPathInTriangleSpaceOptimized(int[][] triangle) {
        int n = triangle.length;
        if (n == 0) return 0;
        if (n == 1) return triangle[0][0];

        int[] pre = new int[n];
        pre = triangle[n - 1];

        for (int row = n - 2; row >= 0; row--) {
            int[] temp = new int[n];
            for (int col = 0; col <= row; col++) {
                temp[col] = triangle[row][col] + Math.max(pre[col], pre[col + 1]);
            }
            pre = temp;
        }
        return pre[0];
    }
}
