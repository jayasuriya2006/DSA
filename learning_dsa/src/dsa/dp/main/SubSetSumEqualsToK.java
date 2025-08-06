package dsa.dp.main;

import java.util.Arrays;

public class SubSetSumEqualsToK {

    //TC - O(2 ^ N)
    //SC - O(N)
    public static boolean isArrayHasSubSetWhichSumIsK_Recursion(int[] arr, int k) {
        return isArrayHasSubSetWhichSumIsK_Recursion(arr, k, arr.length - 1);
    }

    public static boolean isArrayHasSubSetWhichSumIsK_Recursion(int[] arr, int k, int ind) {
        if (k == 0) {
            return true;
        }

        if (ind == 0) {
            return arr[0] == k;
        }

        boolean nonTake = isArrayHasSubSetWhichSumIsK_Recursion(arr, k, ind - 1);
        boolean take = false;
        if (k >= arr[ind]) take = isArrayHasSubSetWhichSumIsK_Recursion(arr, k - arr[ind], ind - 1);
        return nonTake || take;

    }

    //TC - O( N * K)
    //SC - O( N * K) + O(N)
    public static boolean isArrayHasSubSetWhichSumIsK_Memo(int[] arr, int k) {
        int[][] dp = new int[arr.length][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return isArrayHasSubSetWhichSumIsK_Memo(arr, k, arr.length - 1, dp);
    }

    public static boolean isArrayHasSubSetWhichSumIsK_Memo(int[] arr, int k, int ind, int[][] dp) {
        if (k == 0) {
            return true;
        }

        if (ind == 0) {
            return arr[0] == k;
        }

        if (dp[ind][k] != -1) {
            return dp[ind][k] == 1;
        }

        boolean nonTake = isArrayHasSubSetWhichSumIsK_Memo(arr, k, ind - 1, dp);
        boolean take = false;
        if (k >= arr[ind]) take = isArrayHasSubSetWhichSumIsK_Memo(arr, k - arr[ind], ind - 1, dp);
        if (nonTake || take) {
            dp[ind][k] = 1;
        } else {
            dp[ind][k] = 0;
        }
        return nonTake || take;

    }

    //TC - O( N * K)
    //SC - O( N * K)
    public static boolean isArrayHasSubSetWhichSumIsK_Tabulation(int[] arr, int k) {
        int n = arr.length;
        boolean[][] dp = new boolean[arr.length][k + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (arr[0] <= k) dp[0][arr[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            for (int tar = 1; tar <= k; tar++) {
                boolean nonTake = dp[ind - 1][tar];
                boolean take = false;
                if (tar >= arr[ind]) take = dp[ind - 1][tar - arr[ind]];
                dp[ind][tar] = nonTake || take;
            }
        }
        return dp[n - 1][k];
    }

    //TC - O( N * K)
    //SC - O(K)
    public static boolean isArrayHasSubSetWhichSumIsK_SpaceOptimized(int[] arr, int k) {
        int n = arr.length;
        boolean[] prev = new boolean[k + 1];

        prev[0] = true;
        if (arr[0] <= k) prev[arr[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            boolean[] cur = new boolean[k + 1];
            cur[0] = true;
            for (int tar = 1; tar <= k; tar++) {
                boolean nonTake = prev[tar];
                boolean take = false;
                if (tar >= arr[ind]) take = prev[tar - arr[ind]];
                cur[tar] = nonTake || take;
            }
            prev = cur;
        }
        return prev[k];
    }

    public static boolean canSplitIntoTwoSubSetsWithEqualSum(int[] arr) {
        int sum = 0;
        for (int ele : arr) {
            sum += ele;
        }

        if ((sum % 2) != 0) {
            return false;
        }

        int target = sum / 2;
        return isArrayHasSubSetWhichSumIsK_SpaceOptimized(arr, target);
    }

    public static int getMinAbsDiffBetweenTwoSubSets(int[] arr) {
        int sum = 0;
        for (int ele : arr) {
            sum += ele;
        }

        int k = sum;
        int n = arr.length;
        boolean[] prev = new boolean[k + 1];

        prev[0] = true;
        if (arr[0] <= k) prev[arr[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            boolean[] cur = new boolean[k + 1];
            cur[0] = true;
            for (int tar = 1; tar <= k; tar++) {
                boolean nonTake = prev[tar];
                boolean take = false;
                if (tar >= arr[ind]) take = prev[tar - arr[ind]];
                cur[tar] = nonTake || take;
            }
            prev = cur;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= sum; i++) {
            if (prev[i]) {
                int firstSubsetSum = i;
                int secondSubsetSum = sum - i;
                min = Math.min(min, Math.abs(firstSubsetSum - secondSubsetSum));
            }
        }
        return min;
    }

}
