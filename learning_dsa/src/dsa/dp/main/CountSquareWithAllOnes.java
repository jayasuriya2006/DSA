package dsa.dp.main;

public class CountSquareWithAllOnes {
    public static int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int noOfSq = 0;
        int[][] dp = new int[n][m];

        for (int j = 0; j < n; j++) {
            if (matrix[j][0] == 1) noOfSq++;
            dp[j][0] = matrix[j][0];
        }

        for (int j = 1; j < m; j++) {
            if (matrix[0][j] == 1) noOfSq++;
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j],
                            Math.min(
                                    dp[i - 1][j - 1],
                                    dp[i][j - 1]
                            )
                    );
                    noOfSq = noOfSq + dp[i][j];
                }
            }
        }
        return noOfSq;
    }
}
