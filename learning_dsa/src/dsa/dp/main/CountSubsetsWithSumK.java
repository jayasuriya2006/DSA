package dsa.dp.main;

import java.util.Arrays;

public class CountSubsetsWithSumK {

    //TC - O(2 ^ N)
    //SC - O(N)
    public int countSubsetWithSumAsK_Recursion(int[] arr, int k) {
        return countSubsetWithSumAsK_Recursion(arr, k, arr.length - 1);
    }

    public int countSubsetWithSumAsK_Recursion(int[] arr, int k, int ind) {
        if (ind == 0) {
            if (arr[ind] == 0 && k == 0) {
                return 2;
            }
            if (arr[ind] == k || k == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        int nonTake = countSubsetWithSumAsK_Recursion(arr, k, ind - 1);
        int take = 0;
        if (k >= arr[ind]) take = countSubsetWithSumAsK_Recursion(arr, k - arr[ind], ind - 1);
        return nonTake + take;
    }

    //TC - O( N * K)
    //SC - O( N * K) + O(N)
    public int countSubsetWithSumAsK_Memo(int[] arr, int k) {
        int n = arr.length;
        int[][] dp = new int[n][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return countSubsetWithSumAsK_Memo(arr, k, arr.length - 1, dp);
    }

    public int countSubsetWithSumAsK_Memo(int[] arr, int k, int ind, int[][] dp) {
        if (ind == 0) {
            if (arr[ind] == 0 && k == 0) {
                return 2;
            }
            if (arr[ind] == k || k == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        if (dp[ind][k] != -1) return dp[ind][k];
        int nonTake = countSubsetWithSumAsK_Memo(arr, k, ind - 1, dp);
        int take = 0;
        if (k >= arr[ind]) take = countSubsetWithSumAsK_Memo(arr, k - arr[ind], ind - 1, dp);
        dp[ind][k] = nonTake + take;
        return dp[ind][k];
    }

    //TC - O( N * K)
    //SC - O( N * K)
    public int countSubsetWithSumAsK_Tabulation(int[] arr, int k) {
        int n = arr.length;
        int[][] dp = new int[n][k + 1];

        dp[0][0] = (arr[0] == 0) ? 2 : 1;
        if (arr[0] != 0 && arr[0] <= k)
            dp[0][arr[0]] = 1;

        for (int ind = 1; ind < n; ind++) {
            for (int tar = 0; tar <= k; tar++) {
                int nonTake = dp[ind - 1][tar];
                int take = 0;
                if (tar >= arr[ind]) take = dp[ind - 1][tar - arr[ind]];
                dp[ind][tar] = nonTake + take;
            }
        }
        return dp[n - 1][k];
    }

    //TC - O( N * K)
    //SC - O(K)
    public int countSubsetWithSumAsK_SpaceOptimized(int[] arr, int k) {
        int n = arr.length;
        int[] prev = new int[k + 1];

        if (arr[0] == 0) {
            prev[0] = 2;
        } else {
            prev[0] = 1;
        }
        if (arr[0] != 0 && arr[0] <= k) prev[arr[0]] = 1;

        for (int ind = 1; ind < n; ind++) {
            int[] cur = new int[k + 1];
            for (int tar = 0; tar <= k; tar++) {
                int nonTake = prev[tar];
                int take = 0;
                if (tar >= arr[ind]) take = prev[tar - arr[ind]];
                cur[tar] = nonTake + take;
            }
            prev = cur;
        }
        return prev[k];
    }
}
