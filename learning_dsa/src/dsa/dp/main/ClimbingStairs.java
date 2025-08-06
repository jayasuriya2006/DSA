package dsa.dp.main;

import java.util.Arrays;

public class ClimbingStairs {

    //TC - O(N)
    //SC - O(N) + O(N)
    public static int getTotalWaysClimMemo(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return getTotalWaysClimMemoHelper(n, dp);
    }

    public static int getTotalWaysClimMemoHelper(int n, int[] dp) {
        if (n <= 2) return n;

        if (dp[n] != -1) return dp[n];

        dp[n] = getTotalWaysClimMemoHelper(n - 1, dp) + getTotalWaysClimMemoHelper(n - 2, dp);
        return dp[n];
    }

    //TC - O(N)
    //SC - O(N)
    public static int getTotalWaysClimTabulation(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2]  = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //TC - O(N)
    //SC - O(1)
    public static int getTotalWaysClimSpaceOptimized(int n) {
        if (n <= 2) return n;
        int secondPrev = 1;
        int prev  = 2;
        for(int i = 3; i <= n; i++){
            int curIWays = secondPrev + prev;
            secondPrev = prev;
            prev = curIWays;
        }
        return prev;
    }
}
