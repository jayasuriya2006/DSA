package dsa.dp.main;

import java.util.Arrays;

public class RodCutting {

    // index is the length
    //TC - O(2 ^ N) - not exactly, since we are standing in the same index
    //SC - O(N)
    public static int getMaxProfitFromRod_Recursion(int[] prices) {
        return getMaxProfitFromRod_Recursion(prices.length - 1, prices.length, prices);
    }

    public static int getMaxProfitFromRod_Recursion(int ind, int len, int[] prices) {
        if (ind == 0) {
            return prices[0] * len;
        }

        int notCut = getMaxProfitFromRod_Recursion(ind - 1, len, prices);
        int cut = Integer.MIN_VALUE;
        if (len >= (ind + 1)) cut = prices[ind] + getMaxProfitFromRod_Recursion(ind, len - (ind + 1), prices);
        return Math.max(cut, notCut);
    }

    // index is the length
    //TC - O(N * N)
    //SC - O(N * N) + O(N)
    public static int getMaxProfitFromRod_Memo(int[] prices) {
        int[][] dp = new int[prices.length][prices.length + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return getMaxProfitFromRod_Memo(prices.length - 1, prices.length, prices, dp);
    }

    public static int getMaxProfitFromRod_Memo(int ind, int len, int[] prices, int[][] dp) {
        if (ind == 0) {
            return prices[0] * len;
        }
        if (dp[ind][len] != -1) return dp[ind][len];
        int notCut = getMaxProfitFromRod_Memo(ind - 1, len, prices, dp);
        int cut = Integer.MIN_VALUE;
        if (len >= (ind + 1)) cut = prices[ind] + getMaxProfitFromRod_Memo(ind, len - (ind + 1), prices, dp);
        dp[ind][len] = Math.max(cut, notCut);
        return dp[ind][len];
    }

    //TC - O(N * N)
    //SC - O(N * N)
    public static int getMaxProfitFromRod_Tabulation(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][n + 1]; // dp[ind][length]

        // Base case: if only length-1 pieces are allowed
        for (int length = 0; length <= n; length++) {
            dp[0][length] = length * prices[0];  // only 1-length cuts allowed
        }

        for (int ind = 1; ind < n; ind++) {
            for (int length = 0; length <= n; length++) {
                int notCut = dp[ind - 1][length]; // don't take piece of length (ind + 1)
                int cut = Integer.MIN_VALUE;
                if (length >= (ind + 1)) {
                    cut = prices[ind] + dp[ind][length - (ind + 1)];
                }
                dp[ind][length] = Math.max(notCut, cut);
            }
        }

        return dp[n - 1][n]; // Full rod of length n
    }

    //TC - O(N * N)
    //SC - O(N)
    public static int getMaxProfitFromRod_SpaceOptimized(int[] prices) {
        int n = prices.length;
        int[] prev = new int[n + 1]; // dp[ind][length]

        // Base case: if only length-1 pieces are allowed
        for (int length = 0; length <= n; length++) {
            prev[length] = length * prices[0];  // only 1-length cuts allowed
        }

        for (int ind = 1; ind < n; ind++) {
            int[] cur = new int[n + 1];
            for (int length = 0; length <= n; length++) {
                int notCut = prev[length]; // don't take piece of length (ind + 1)
                int cut = Integer.MIN_VALUE;
                if (length >= (ind + 1)) {
                    cut = prices[ind] + cur[length - (ind + 1)];
                }
                cur[length] = Math.max(notCut, cut);
            }
            prev = cur;
        }

        return prev[n]; // Full rod of length n
    }
}
