package dsa.dp.main;

import java.util.Arrays;

public class MinimumCostToCutTheStick {

    //TC - Exponential
    //SC - O(N)
    public static int getMinCostToCutTheStick_Recursion(int n, int[] cuts) {
        int cutsLen = cuts.length;
        int[] newCuts = new int[cutsLen + 2];
        newCuts[0] = 0;
        newCuts[cutsLen + 1] = n;
        System.arraycopy(cuts, 0, newCuts, 1, cutsLen);
        Arrays.sort(newCuts);
        return getMinCostToCutTheStick_Recursion(1, cutsLen, newCuts);
    }

    private static int getMinCostToCutTheStick_Recursion(int i, int j, int[] cuts) {
        if (i > j) return 0;

        int minCost = Integer.MAX_VALUE;
        for (int cut = i; cut <= j; cut++) {
            int cost = cuts[j + 1] - cuts[i - 1]
                    + getMinCostToCutTheStick_Recursion(i, cut - 1, cuts)
                    + getMinCostToCutTheStick_Recursion(cut + 1, j, cuts);
            minCost = Math.min(minCost, cost);
        }
        return minCost;
    }

    //TC - O(N * N * N)
    //SC - O(N * N) + O(N)
    public static int getMinCostToCutTheStick_Memorization(int n, int[] cuts) {
        int cutsLen = cuts.length;
        int[] newCuts = new int[cutsLen + 2];
        newCuts[0] = 0;
        newCuts[cutsLen + 1] = n;
        System.arraycopy(cuts, 0, newCuts, 1, cutsLen);
        Arrays.sort(newCuts);

        int[][] dp = new int[cutsLen + 1][cutsLen + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return getMinCostToCutTheStick_Memorization(1, cutsLen, newCuts, dp);
    }

    private static int getMinCostToCutTheStick_Memorization(int i, int j, int[] cuts, int[][] dp) {
        if (i > j) return 0;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int minCost = Integer.MAX_VALUE;
        for (int cut = i; cut <= j; cut++) {
            int cost = cuts[j + 1] - cuts[i - 1]
                    + getMinCostToCutTheStick_Memorization(i, cut - 1, cuts, dp)
                    + getMinCostToCutTheStick_Memorization(cut + 1, j, cuts, dp);
            minCost = Math.min(minCost, cost);
        }
        return dp[i][j] = minCost;
    }

    //TC - O(N * N * N)
    //SC - O(N * N)
    public static int getMinCostToCutTheStick_Tabulation(int n, int[] cuts) {
        int cutsLen = cuts.length;
        int[] newCuts = new int[cutsLen + 2];
        newCuts[0] = 0;
        newCuts[cutsLen + 1] = n;
        System.arraycopy(cuts, 0, newCuts, 1, cutsLen);
        Arrays.sort(newCuts);

        int[][] dp = new int[cutsLen + 2][cutsLen + 2];
        for (int i = cutsLen; i >= 1; i--) {
            for (int j = 0; j <= cutsLen; j++) {
                if(i > j) continue;
                int minCost = Integer.MAX_VALUE;
                for (int cut = i; cut <= j; cut++) {
                    int cost = newCuts[j + 1] - newCuts[i - 1]
                            + dp[i][cut - 1]
                            + dp[cut + 1][j];
                    minCost = Math.min(minCost, cost);
                }
                dp[i][j] = minCost;
            }
        }
        return dp[1][cutsLen];
    }
}
