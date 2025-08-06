package dsa.dp.main;

import java.util.Arrays;

public class FrogJumpMinCost {

    //TC - O(N)
    //SC - O(N) + O(N)
    public static int getMinCostToReachEndMemo(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp, -1);
        return getMinCostToReachEndMemoHelper(cost, dp, cost.length - 1);
    }

    public static int getMinCostToReachEndMemoHelper(int[] cost, int[] dp, int index) {

        if (index == 0) return 0;
        if (index == 1) return Math.abs(cost[0] - cost[1]);

        if (dp[index] != -1) return dp[index];

        int oneJump = getMinCostToReachEndMemoHelper(cost, dp, index - 1) + Math.abs(cost[index] - cost[index - 1]);
        int twoJump = getMinCostToReachEndMemoHelper(cost, dp, index - 2) + Math.abs(cost[index] - cost[index - 2]);
        dp[index] = Math.min(oneJump, twoJump);

        return dp[index];
    }

    //TC - O(N)
    //SC - O(N)
    public static int getMinCostToReachEndTabulation(int[] cost) {

        int n = cost.length;
        if (n == 1) return 0;
        if (n == 2) return Math.abs(cost[0] - cost[1]);
        int[] dp = new int[n];

        dp[0] = 0;
        dp[1] = Math.abs(cost[0] - cost[1]);
        for (int i = 2; i < n; i++) {
            int oneJump = dp[i - 1] + Math.abs(cost[i] - cost[i - 1]);
            int twoJump = dp[i - 2] + Math.abs(cost[i] - cost[i - 2]);
            dp[i] = Math.min(oneJump, twoJump);
        }
        return dp[n - 1];

    }

    //TC - O(N)
    //SC - O(1)
    public static int getMinCostToReachEndSpaceOptimization(int[] cost) {

        int n = cost.length;
        if (n == 1) return 0;
        if (n == 2) return Math.abs(cost[0] - cost[1]);

        int secondPrev = 0;
        int prev = Math.abs(cost[0] - cost[1]);
        for (int i = 2; i < n; i++) {
            int oneJump = prev + Math.abs(cost[i] - cost[i - 1]);
            int twoJump = secondPrev + Math.abs(cost[i] - cost[i - 2]);
            int curICost = Math.min(oneJump, twoJump);
            secondPrev = prev;
            prev = curICost;
        }
        return prev;

    }


    //TC - O(N * K)
    //SC - O(N)
    public static int getMinCostToReachEndTabulationForKSteps(int[] cost, int k) {

        int n = cost.length;
        if (n == 1) return 0;
        if (n == 2) return Math.abs(cost[0] - cost[1]);
        int[] dp = new int[n];

        dp[0] = 0;
        dp[1] = Math.abs(cost[0] - cost[1]);
        for (int i = 2; i < n; i++) {
            int minCost = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    minCost = Math.min(minCost, dp[i - j] + Math.abs(cost[i] - cost[i - j]));
                }
            }
            dp[i] = minCost;
        }
        return dp[n - 1];

    }
}
