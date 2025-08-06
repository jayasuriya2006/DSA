package dsa.dp.main;

import java.util.Arrays;

public class LongestCommonSubString {

    //TC - O(N * M)
    //SC - O(N * M)
    public static int lenOfLCSubString_Tabulation(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int maxLen = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    maxLen = Math.max(maxLen, 1 + dp[i - 1][j - 1]);
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return maxLen;
    }

    //TC - O(N * M)
    //SC - O(M)
    public static int lenOfLCSubString_SpaceOptimized(String s1, String s2) {

        int[] prev = new int[s2.length() + 1];
        int maxLen = 0;
        for (int i = 1; i <= s1.length(); i++) {
            int[] cur = new int[s2.length() + 1];
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    maxLen = Math.max(maxLen, 1 + prev[j - 1]);
                    cur[j] = 1 + prev[j - 1];
                } else {
                    cur[j] = 0;
                }
            }
            prev = cur;
        }
        return maxLen;
    }

    //TC - O(N * M) + O( N + M)
    //SC - O(N * M)
    public static String getLCSubString(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int endIdx = 0;
        int maxLen = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        endIdx = i;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return s1.substring(endIdx - maxLen, endIdx);
    }
}
