package dsa.dp.main;

import java.util.Arrays;

public class EditDistance {

    //TC - Exponential
    //SC - O(N + M)
    public static int getMinOperation_Recursion(String s1, String s2) {
        return getMinOperation_Recursion(s1.length(), s2.length(), s1, s2);
    }

    public static int getMinOperation_Recursion(int i, int j, String s1, String s2) {
        if (i == 0) {
            return j;
        }

        if (j == 0) {
            return i;
        }

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            return getMinOperation_Recursion(i - 1, j - 1, s1, s2);
        } else {
            int delete = getMinOperation_Recursion(i - 1, j, s1, s2);
            int insertion = getMinOperation_Recursion(i, j - 1, s1, s2);
            int replace = getMinOperation_Recursion(i - 1, j - 1, s1, s2);

            return 1 + Math.min(delete, Math.min(insertion, replace));
        }
    }

    //TC -O(N * M)
    //SC - O(N * M) + O(N + M)
    public static int getMinOperation_Memo(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return getMinOperation_Memo(s1.length(), s2.length(), s1, s2, dp);
    }

    public static int getMinOperation_Memo(int i, int j, String s1, String s2, int[][] dp) {
        if (i == 0) {
            return j;
        }

        if (j == 0) {
            return i;
        }

        if (dp[i][j] != -1) return dp[i][j];
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            dp[i][j] = getMinOperation_Memo(i - 1, j - 1, s1, s2, dp);
            return dp[i][j];
        } else {
            int delete = getMinOperation_Memo(i - 1, j, s1, s2, dp);
            int insertion = getMinOperation_Memo(i, j - 1, s1, s2, dp);
            int replace = getMinOperation_Memo(i - 1, j - 1, s1, s2, dp);

            dp[i][j] = 1 + Math.min(delete, Math.min(insertion, replace));
            return dp[i][j];
        }
    }

    //TC -O(N * M)
    //SC - O(N * M)
    public static int getMinOperation_Tabulation(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int delete = dp[i - 1][j];
                    int insertion = dp[i][j - 1];
                    int replace = dp[i - 1][j - 1];

                    dp[i][j] = 1 + Math.min(delete, Math.min(insertion, replace));
                }
            }
        }
        return dp[n][m];
    }

    //TC -O(N * M)
    //SC - O(M)
    public static int getMinOperation_SpaceOptimized(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[] prev = new int[m + 1];
        for (int j = 0; j <= m; j++) {
            prev[j] = j;
        }

        for (int i = 1; i <= n; i++) {
            int[] cur = new int[m + 1];
            cur[0] = i;
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    cur[j] = prev[j - 1];
                } else {
                    int delete = prev[j];
                    int insertion = cur[j - 1];
                    int replace = prev[j - 1];

                    cur[j] = 1 + Math.min(delete, Math.min(insertion, replace));
                }
            }
            prev = cur;
        }
        return prev[m];
    }

}
