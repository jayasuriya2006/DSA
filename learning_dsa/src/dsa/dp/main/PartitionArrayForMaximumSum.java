package dsa.dp.main;

import java.util.Arrays;

public class PartitionArrayForMaximumSum {
    //TC - O(N * N)
    //SC - O(N) + O(N)
    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return maxSumAfterPartitioning(0, arr, k, dp);
    }

    public static int maxSumAfterPartitioning(int i, int[] arr, int k, int[] dp) {
        if (i == arr.length) return 0;
        if (dp[i] != -1) return dp[i];
        int maxi = 0;
        int len = 0;
        int maxNum = Integer.MIN_VALUE;
        for (int ind = i; ind < Math.min(arr.length, i + k); ind++) {
            len++;
            maxNum = Math.max(arr[ind], maxNum);
            maxi = Math.max(maxi,
                    len * maxNum + maxSumAfterPartitioning(ind + 1, arr, k, dp));
        }
        return dp[i] = maxi;
    }

    //TC - O(N * N)
    //SC - O(N)
    public static int maxSumAfterPartitioning_Tabulation(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int maxi = 0;
            int len = 0;
            int maxNum = Integer.MIN_VALUE;
            for (int ind = i; ind < Math.min(arr.length, i + k); ind++) {
                len++;
                maxNum = Math.max(arr[ind], maxNum);
                maxi = Math.max(maxi,
                        len * maxNum + dp[ind + 1]);
            }
            dp[i] = maxi;
        }

        return dp[0];
    }
}
