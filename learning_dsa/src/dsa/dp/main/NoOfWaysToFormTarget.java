package dsa.dp.main;

import java.util.Arrays;

public class NoOfWaysToFormTarget {

    //TC - O( N ^ 2) not exactly , since standing in the same index
    //SC - O(T)
    public static int noOfWaysToFormATarget_Recursion(int[] coins, int target) {
        return noOfWaysToFormATarget_Recursion(coins, target, coins.length - 1);
    }

    public static int noOfWaysToFormATarget_Recursion(int[] coins, int target, int ind) {
        if (ind == 0) {
            return target % coins[0] == 0 ? 1 : 0;
        }

        int notTake = noOfWaysToFormATarget_Recursion(coins, target, ind - 1);
        int take = 0;
        if (coins[ind] <= target) take = noOfWaysToFormATarget_Recursion(coins, target - coins[ind], ind);
        return notTake + take;
    }

    //TC - O( N * T)
    //SC - O( N * T) + O(T)
    public static int noOfWaysToFormATarget_Memo(int[] coins, int target) {
        int[][] dp = new int[coins.length][target + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return noOfWaysToFormATarget_Memo(coins, target, coins.length - 1, dp);
    }

    public static int noOfWaysToFormATarget_Memo(int[] coins, int target, int ind, int[][] dp) {
        if (ind == 0) {
            return target % coins[0] == 0 ? 1 : 0;
        }
        if (dp[ind][target] != -1) return dp[ind][target];
        int notTake = noOfWaysToFormATarget_Memo(coins, target, ind - 1, dp);
        int take = 0;
        if (coins[ind] <= target) take = noOfWaysToFormATarget_Memo(coins, target - coins[ind], ind, dp);
        dp[ind][target] = notTake + take;
        return dp[ind][target];
    }

    //TC - O( N * T)
    //SC - O( N * T)
    public static int noOfWaysToFormATarget_Tabulation(int[] coins, int target) {
        int[][] dp = new int[coins.length][target + 1];
        for (int i = 0; i <= target; i++) {
            dp[0][i] = i % coins[0] == 0 ? 1 : 0;
        }

        for (int ind = 1; ind < coins.length; ind++) {
            for (int tar = 0; tar <= target; tar++) {
                int notTake = dp[ind - 1][tar];
                int take = 0;
                if (coins[ind] <= tar) take = dp[ind][tar - coins[ind]];
                dp[ind][tar] = notTake + take;
            }
        }
        return dp[coins.length - 1][target];
    }

    //TC - O( N * T)
    //SC - O( T)
    public static int noOfWaysToFormATarget_SpaceOptimized(int[] coins, int target) {
        int[] prev = new int[target + 1];
        for (int i = 0; i <= target; i++) {
            prev[i] = i % coins[0] == 0 ? 1 : 0;
        }

        for (int ind = 1; ind < coins.length; ind++) {
            int[] cur = new int[target + 1];
            for (int tar = 0; tar <= target; tar++) {
                int notTake = prev[tar];
                int take = 0;
                if (coins[ind] <= tar) take = cur[tar - coins[ind]];
                cur[tar] = notTake + take;
            }
            prev = cur;
        }
        return prev[target];
    }
}
