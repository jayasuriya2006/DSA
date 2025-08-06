package dsa.dp.main;

import java.util.Arrays;

public class FibonacciNumber {

    //TC - O(N)
    //SC - O(N) + O(N)
    public static int getFibonacciMemo(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return getFibonacciMemoHelper(n, dp);

    }

    private static int getFibonacciMemoHelper(int n, int[] dp) {
        if (n <= 1) return n;

        if (dp[n] != -1) return dp[n];

        int prev = getFibonacciMemoHelper(n - 1, dp);
        int secondPrev = getFibonacciMemoHelper(n - 2, dp);

        dp[n] = prev + secondPrev;

        return dp[n];
    }

    //TC - O(N)
    //SC - O(N)
    public static int getFibonacciTabulation(int n) {
        if (n == 0 || n == 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //TC - O(N)
    //SC - O(1)
    public static int getFibonacciSpaceOptimized(int n) {
        if (n == 0 || n == 1) return n;
        int secondPrev = 0;
        int prev = 1;
        for (int i = 2; i <= n; i++) {
            int curFibonacci = prev + secondPrev;
            secondPrev = prev;
            prev = curFibonacci;
        }
        return prev;
    }
}
