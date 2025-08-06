package dsa.dp.main;

import java.util.Arrays;

public class DistinctSubSequence {

    //TC - Exponential
    //SC - O( N + M)
    public static int getNoOfDistinctSubSequence_Recursion(String s1, String s2) {
        return getNoOfDistinctSubSequence_Recursion(s1.length(), s2.length(), s1, s2);
    }

    public static int getNoOfDistinctSubSequence_Recursion(int i, int j, String s1, String s2) {
        if (j == 0) {
            return 1;
        }
        if (i == 0) {
            return 0;
        }

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            return getNoOfDistinctSubSequence_Recursion(i - 1, j - 1, s1, s2) + getNoOfDistinctSubSequence_Recursion(i - 1, j, s1, s2);
        } else {
            return getNoOfDistinctSubSequence_Recursion(i - 1, j, s1, s2);
        }
    }

    //TC - O( N * M)
    //SC - O( N * M) + O( N + M)
    public static int getNoOfDistinctSubSequence_Memo(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return getNoOfDistinctSubSequence_Memo(s1.length(), s2.length(), s1, s2, dp);
    }

    public static int getNoOfDistinctSubSequence_Memo(int i, int j, String s1, String s2, int[][] dp) {
        if (j == 0) {
            return 1;
        }
        if (i == 0) {
            return 0;
        }
        if (dp[i][j] != -1) return dp[i][j];
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            dp[i][j] = getNoOfDistinctSubSequence_Memo(i - 1, j - 1, s1, s2, dp) + getNoOfDistinctSubSequence_Memo(i - 1, j, s1, s2, dp);
            return dp[i][j];
        } else {
            dp[i][j] = getNoOfDistinctSubSequence_Memo(i - 1, j, s1, s2, dp);
            return dp[i][j];
        }
    }

    //TC - O( N * M)
    //SC - O( N * M)
    public static int getNoOfDistinctSubSequence_Tabulation(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }

    //TC - O( N * M)
    //SC - O( M)
    public static int getNoOfDistinctSubSequence_SpaceOptimized(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[] prev = new int[m + 1];


        prev[0] = 1;

        for (int i = 1; i <= n; i++) {
            int[] cur = new int[m + 1];
            cur[0] = 1;
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    cur[j] = prev[j - 1] + prev[j];
                } else {
                    cur[j] = prev[j];
                }
            }
            prev = cur;
        }
        return prev[m];
    }


}
