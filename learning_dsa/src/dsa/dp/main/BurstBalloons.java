package dsa.dp.main;

import java.util.Arrays;

public class BurstBalloons {

    //TC - Exponential
    //SC - O(N)
    public static int getMaxPointsByBurstBalloons_Recursion(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        System.arraycopy(nums, 0, newNums, 1, n);
        return getMaxPointsByBurstBalloons_Recursion(1, n, newNums);
    }

    public static int getMaxPointsByBurstBalloons_Recursion(int i, int j, int[] nums) {
        if (i > j) return 0;

        int maxPoints = Integer.MIN_VALUE;
        for (int b = i; b <= j; b++) {
            int points = nums[i - 1] * nums[b] * nums[j + 1]
                    + getMaxPointsByBurstBalloons_Recursion(i, b - 1, nums)
                    + getMaxPointsByBurstBalloons_Recursion(b + 1, j, nums);
            maxPoints = Math.max(maxPoints, points);
        }
        return maxPoints;
    }

    //TC - O( N * N * N)
    //SC - O( N * N ) + O(N)
    public static int getMaxPointsByBurstBalloons_Memorization(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        System.arraycopy(nums, 0, newNums, 1, n);
        int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return getMaxPointsByBurstBalloons_Memorization(1, n, newNums, dp);
    }

    public static int getMaxPointsByBurstBalloons_Memorization(int i, int j, int[] nums, int[][] dp) {
        if (i > j) return 0;

        if (dp[i][j] != -1) return dp[i][j];
        int maxPoints = Integer.MIN_VALUE;
        for (int b = i; b <= j; b++) {
            int points = nums[i - 1] * nums[b] * nums[j + 1]
                    + getMaxPointsByBurstBalloons_Memorization(i, b - 1, nums, dp)
                    + getMaxPointsByBurstBalloons_Memorization(b + 1, j, nums, dp);
            maxPoints = Math.max(maxPoints, points);
        }
        return dp[i][j] = maxPoints;
    }

    //TC - O( N * N * N)
    //SC - O( N * N )
    public static int getMaxPointsByBurstBalloons_Tabulation(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        System.arraycopy(nums, 0, newNums, 1, n);

        int[][] dp = new int[n + 2][n + 2]; // dp[i][j] = max coins from bursting balloons i to j

        // Loop i from n to 1 (bottom-up)
        for (int i = n; i >= 1; i--) {
            for (int j = i; j <= n; j++) {
                if (i > j) continue;

                int maxPoints = Integer.MIN_VALUE;

                for (int b = i; b <= j; b++) {
                    int points = newNums[i - 1] * newNums[b] * newNums[j + 1]
                            + dp[i][b - 1]
                            + dp[b + 1][j];

                    maxPoints = Math.max(maxPoints, points);
                }

                dp[i][j] = maxPoints;
            }
        }
        return dp[1][n];
    }
}
