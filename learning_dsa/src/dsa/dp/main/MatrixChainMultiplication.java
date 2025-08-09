package dsa.dp.main;

import java.util.Arrays;

public class MatrixChainMultiplication {

    //TC - Exponential
    //SC - O(N)
    public static int getMinNoOfOperationForMCM_Recursion(int[] dimensions) {
        return getMinNoOfOperationForMCM_Recursion(1, dimensions.length - 1, dimensions);
    }

    private static int getMinNoOfOperationForMCM_Recursion(int i, int j, int[] dimensions) {
        if (j <= i) return 0;

        int minOperation = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int operations = dimensions[i - 1] * dimensions[k] * dimensions[j]
                    + getMinNoOfOperationForMCM_Recursion(i, k, dimensions)
                    + getMinNoOfOperationForMCM_Recursion(k + 1, j, dimensions);
            minOperation = Math.min(minOperation, operations);
        }
        return minOperation;
    }


    //TC - O(N * N * N)
    //SC - O(N * N) + O(N)
    public static int getMinNoOfOperationForMCM_Memo(int[] dimensions) {
        int n = dimensions.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return getMinNoOfOperationForMCM_Memo(1, dimensions.length - 1, dimensions, dp);
    }

    private static int getMinNoOfOperationForMCM_Memo(int i, int j, int[] dimensions, int[][] dp) {
        if (j <= i) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int minOperation = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int operations = dimensions[i - 1] * dimensions[k] * dimensions[j]
                    + getMinNoOfOperationForMCM_Memo(i, k, dimensions, dp)
                    + getMinNoOfOperationForMCM_Memo(k + 1, j, dimensions, dp);
            minOperation = Math.min(minOperation, operations);
        }
        dp[i][j] = minOperation;
        return dp[i][j];
    }

    //TC - O(N * N * N)
    //SC - O(N * N)
    public static int getMinNoOfOperationForMCM_Tabulation(int[] dimensions) {
        int n = dimensions.length;
        int[][] dp = new int[n][n];

        for(int i = n - 1; i >= 1; i--){
            for(int j = i + 1; j < n; j++){
                int minOperation = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int operations = dimensions[i - 1] * dimensions[k] * dimensions[j]
                            + dp[i][k]
                            + dp[k + 1][j];
                    minOperation = Math.min(minOperation, operations);
                }
                dp[i][j] = minOperation;
            }
        }
        return dp[1][n - 1];
    }
}
