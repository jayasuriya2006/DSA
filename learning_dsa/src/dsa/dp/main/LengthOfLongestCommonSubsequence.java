package dsa.dp.main;

import java.util.Arrays;

public class LengthOfLongestCommonSubsequence {

    //TC - O(2 ^ N) - Exponential
    //SC - O(N + M)
    public static int lenOfLCS_Recursion(String s1, String s2) {
        return lenOfLCS_Recursion(s1.length(), s2.length(), s1, s2);
    }

    public static int lenOfLCS_Recursion(int i, int j, String s1, String s2) {
        if (i == 0 || j == 0) {
            return 0;
        }

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            return 1 + lenOfLCS_Recursion(i - 1, j - 1, s1, s2);
        } else {
            return Math.max(lenOfLCS_Recursion(i, j - 1, s1, s2), lenOfLCS_Recursion(i - 1, j, s1, s2));
        }
    }

    //TC - O(N * M)
    //SC - O(N * M)  + O(N + M)
    public static int lenOfLCS_Memo(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return lenOfLCS_Memo(s1.length(), s2.length(), s1, s2, dp);
    }

    public static int lenOfLCS_Memo(int i, int j, String s1, String s2, int[][] dp) {
        if (i == 0 || j == 0) {
            return 0;
        }
        if (dp[i][j] != -1) return dp[i][j];
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            dp[i][j] = 1 + lenOfLCS_Memo(i - 1, j - 1, s1, s2, dp);
            return dp[i][j];
        } else {
            dp[i][j] = Math.max(lenOfLCS_Memo(i, j - 1, s1, s2, dp), lenOfLCS_Memo(i - 1, j, s1, s2, dp));
            return dp[i][j];
        }
    }

    //TC - O(N * M)
    //SC - O(N * M)
    public static int lenOfLCS_Tabulation(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    //TC - O(N * M)
    //SC - O(M)
    public static int lenOfLCS_SpaceOptimized(String s1, String s2) {
        int[] prev = new int[s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            int[] cur = new int[s2.length() + 1];
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    cur[j] = 1 + prev[j - 1];
                } else {
                    cur[j] = Math.max(cur[j - 1], prev[j]);
                }
            }
            prev = cur;
        }
        return prev[s2.length()];
    }

    //TC - O(N * M) + O( N + M)
    //SC - O(N * M)
    public static String getLCS(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        StringBuilder lcs = new StringBuilder();
        int i = s1.length();
        int j = s2.length();
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.insert(0, s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i][j - 1] > dp[i - 1][j]) {
                j--;
            } else {
                i--;
            }
        }
        return lcs.toString();
    }

}
