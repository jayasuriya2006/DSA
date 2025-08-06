package dsa.dp.main;

import java.util.Arrays;

public class ZeroOrOneKnapsack {

    //TC - O(2 ^ N)
    //SC - O(N)
    public static int getMaxProfit_Recursion(int[] weight, int[] values, int capacity) {
        return getMaxProfit_Recursion(weight, values, weight.length - 1, capacity);
    }

    public static int getMaxProfit_Recursion(int[] weight, int[] values, int index, int capacity) {
        if (index == 0) {
            if (weight[0] <= capacity) {
                return values[0];
            } else {
                return 0;
            }
        }

        int notPick = getMaxProfit_Recursion(weight, values, index - 1, capacity);
        int pick = Integer.MIN_VALUE;
        if (capacity >= weight[index])
            pick = values[index] + getMaxProfit_Recursion(weight, values, index - 1, capacity - weight[index]);

        return Math.max(notPick, pick);
    }

    //TC - O(N * C)
    //SC -  O(N * C) + O(N)
    public static int getMaxProfit_Memo(int[] weight, int[] values, int capacity) {
        int n = weight.length;
        int[][] dp = new int[n][capacity + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return getMaxProfit_Memo(weight, values, weight.length - 1, capacity, dp);
    }

    public static int getMaxProfit_Memo(int[] weight, int[] values, int index, int capacity, int[][] dp) {
        if (index == 0) {
            if (weight[0] <= capacity) {
                return values[0];
            } else {
                return 0;
            }
        }

        if (dp[index][capacity] != -1) return dp[index][capacity];
        int notPick = getMaxProfit_Memo(weight, values, index - 1, capacity, dp);
        int pick = Integer.MIN_VALUE;
        if (capacity >= weight[index])
            pick = values[index] + getMaxProfit_Memo(weight, values, index - 1, capacity - weight[index], dp);


        dp[index][capacity] = Math.max(notPick, pick);
        return dp[index][capacity];
    }

    //TC - O(N * C)
    //SC - O(N)
    public static int getMaxProfit_Tabulation(int[] weight, int[] values, int capacity) {
        int n = weight.length;
        int[][] dp = new int[n][capacity + 1];

        for (int i = 0; i <= capacity; i++) {
            if (weight[0] <= i) {
                dp[0][i] = values[0];
            }
        }

        for (int ind = 1; ind < n; ind++) {
            for (int wei = 0; wei <= capacity; wei++) {
                int notPick = dp[ind - 1][wei];
                int pick = Integer.MIN_VALUE;
                if (wei >= weight[ind])
                    pick = values[ind] + dp[ind - 1][wei - weight[ind]];

                dp[ind][wei] = Math.max(notPick, pick);
            }
        }
        return dp[n - 1][capacity];
    }

    //TC - O(N * C)
    //SC - O(C)
    public static int getMaxProfit_SpaceOptimized(int[] weight, int[] values, int capacity) {
        int n = weight.length;
        int[] prev = new int[capacity + 1];

        for (int i = 0; i <= capacity; i++) {
            if (weight[0] <= i) {
                prev[i] = values[0];
            }
        }

        for (int ind = 1; ind < n; ind++) {
            int[] cur = new int[capacity + 1];
            for (int wei = 0; wei <= capacity; wei++) {
                int notPick = prev[wei];
                int pick = Integer.MIN_VALUE;
                if (wei >= weight[ind])
                    pick = values[ind] + prev[wei - weight[ind]];

                cur[wei] = Math.max(notPick, pick);
            }
            prev = cur;
        }
        return prev[capacity];
    }

}
