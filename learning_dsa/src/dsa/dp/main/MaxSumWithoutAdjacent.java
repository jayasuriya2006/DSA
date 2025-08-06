package dsa.dp.main;

import java.util.Arrays;

public class MaxSumWithoutAdjacent {

    //TC - O(N)
    //SC - O(N) + O(N)
    public static int getMaxSumWithoutAdjacentMemo(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return getMaxSumWithoutAdjacentMemoHelper(arr, dp, n - 1);
    }

    public static int getMaxSumWithoutAdjacentMemoHelper(int[] arr, int[] dp, int index) {
        if (index == 0) return arr[0];
        if (index < 0) return 0;

        if (dp[index] != -1) return dp[index];

        int include = arr[index] + getMaxSumWithoutAdjacentMemoHelper(arr, dp, index - 2);
        int notInclude = getMaxSumWithoutAdjacentMemoHelper(arr, dp, index - 1);

        dp[index] = Math.max(include, notInclude);
        return dp[index];
    }

    //TC - O(N)
    //SC - O(N)
    public static int getMaxSumWithoutAdjacentTabulation(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            int notInclude = dp[i - 1];
            int include = Integer.MIN_VALUE;
            if (i > 1) {
                include = dp[i - 2] + arr[i];
            }
            dp[i] = Math.max(include, notInclude);
        }
        return dp[n - 1];
    }

    //TC - O(N)
    //SC - O(1)
    public static int getMaxSumWithoutAdjacentSpaceOptimization(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        if (n == 1) return arr[0];
        int prev = arr[0];
        int secondPrev = 0;
        for (int i = 1; i < n; i++) {
            int curIMax = Math.max(arr[i] + secondPrev, prev);
            secondPrev = prev;
            prev = curIMax;
        }
        return prev;
    }

    public static int getMaxSumWithoutAdjacentCircular(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        if (n == 1) return arr[0];

        // Exclude last element (take from 0 to n-2)
        int[] excludeLast = Arrays.copyOfRange(arr, 0, n - 1);
        // Exclude first element (take from 1 to n-1)
        int[] excludeFirst = Arrays.copyOfRange(arr, 1, n);

        int withoutLast = getMaxSumWithoutAdjacentSpaceOptimization(excludeLast);
        int withoutFirst = getMaxSumWithoutAdjacentSpaceOptimization(excludeFirst);

        return Math.max(withoutLast, withoutFirst);
    }

}
