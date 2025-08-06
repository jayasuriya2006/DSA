package dsa.dp.main;

import java.util.Arrays;

public class MinCoinsInfiniteSupply {

    //TC - O( N ^ 2) not exactly, since we are standing on the same index. So it's exponential
    //SC - O(T)
    public static int minCoinsRequired_recursion(int[] coins, int target) {
        int ans = minCoinsRequired_recursion(coins, target, coins.length - 1);
        return (ans == Integer.MAX_VALUE / 2) ? -1 : ans;
    }

    public static int minCoinsRequired_recursion(int[] coins, int target, int ind) {
        if (ind == 0) {
            if (target % coins[0] == 0) {
                return target / coins[0];
            } else {
                return Integer.MAX_VALUE / 2;
            }
        }

        int notTake = minCoinsRequired_recursion(coins, target, ind - 1);
        int take = Integer.MAX_VALUE;
        if (target >= coins[ind])
            take = 1 + minCoinsRequired_recursion(coins, target - coins[ind], ind); // stand on the same index
        return Math.min(notTake, take);
    }

    //TC - O( N * T)
    //SC - O( N * T) + O(T)
    public static int minCoinsRequired_memo(int[] coins, int target) {
        int[][] dp = new int[coins.length][target + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = minCoinsRequired_memo(coins, target, coins.length - 1, dp);
        return (ans == Integer.MAX_VALUE / 2) ? -1 : ans;
    }

    public static int minCoinsRequired_memo(int[] coins, int target, int ind, int[][] dp) {
        if (ind == 0) {
            if (target % coins[0] == 0) {
                return target / coins[0];
            } else {
                return Integer.MAX_VALUE / 2;
            }
        }

        if (dp[ind][target] != -1) {
            return dp[ind][target];
        }

        int notTake = minCoinsRequired_memo(coins, target, ind - 1, dp);
        int take = Integer.MAX_VALUE;
        if (target >= coins[ind])
            take = 1 + minCoinsRequired_memo(coins, target - coins[ind], ind, dp); // stand on the same index
        dp[ind][target] = Math.min(notTake, take);
        return dp[ind][target];
    }

    //TC - O( N * T)
    //SC - O( N * T)
    public static int minCoinsRequired_tabulation(int[] coins, int target) {
        int[][] dp = new int[coins.length][target + 1];

        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        }

        for (int i = 0; i <= target; i++) {
            if (i % coins[0] == 0) {
                dp[0][i] = i / coins[0];
            }
        }

        for (int coin = 1; coin < coins.length; coin++) {
            for (int tar = 0; tar <= target; tar++) {
                int notTake = dp[coin - 1][tar];
                int take = Integer.MAX_VALUE / 2;
                if (tar >= coins[coin])
                    take = 1 + dp[coin][tar - coins[coin]]; // stand on the same index
                dp[coin][tar] = Math.min(notTake, take);
            }
        }
        return dp[coins.length - 1][target] == Integer.MAX_VALUE / 2 ? -1 : dp[coins.length - 1][target];
    }

    //TC - O( N * T)
    //SC - O(T)
    public static int minCoinsRequired_spaceOptimized(int[] coins, int target) {
        int[] prev = new int[target + 1];
        Arrays.fill(prev, Integer.MAX_VALUE / 2);
        for (int i = 0; i <= target; i++) {
            if (i % coins[0] == 0) {
                prev[i] = i / coins[0];
            }
        }

        for (int coin = 1; coin < coins.length; coin++) {
            int[] cur = new int[target + 1];
            Arrays.fill(cur, Integer.MAX_VALUE / 2);
            for (int tar = 0; tar <= target; tar++) {
                int notTake = prev[tar];
                int take = Integer.MAX_VALUE / 2;
                if (tar >= coins[coin])
                    take = 1 + cur[tar - coins[coin]]; // stand on the same index
                cur[tar] = Math.min(notTake, take);
            }
            prev = cur;
        }
        return prev[target] == Integer.MAX_VALUE / 2 ? -1 : prev[target];
    }
}
