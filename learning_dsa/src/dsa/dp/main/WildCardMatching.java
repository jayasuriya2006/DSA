package dsa.dp.main;

import java.util.Arrays;

public class WildCardMatching {

    //TC - Exponential
    //SC - O(N + M)
    public static boolean isMatch_Recursion(String s, String p) {
        return isMatch_Recursion(s.length(), p.length(), s, p);
    }

    public static boolean isMatch_Recursion(int i, int j, String s, String p) {
        if (i == 0 && j == 0) {
            return true;
        }
        if (j == 0 && i > 0) {
            return false;
        }

        if (i == 0 && j > 0) {
            return isAllStar(p, j);
        }

        if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
            return isMatch_Recursion(i - 1, j - 1, s, p);
        } else if (p.charAt(j - 1) == '*') {
            return isMatch_Recursion(i, j - 1, s, p) || isMatch_Recursion(i - 1, j, s, p);
        }
        return false;
    }

    //TC - O( N * M)
    //SC - O( N * M) + O(N + M)
    public static boolean isMatch_Memo(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return isMatch_Memo(s.length(), p.length(), s, p, dp);
    }

    public static boolean isMatch_Memo(int i, int j, String s, String p, int[][] dp) {
        if (i == 0 && j == 0) {
            return true;
        }
        if (j == 0 && i > 0) {
            return false;
        }

        if (i == 0 && j > 0) {
            return isAllStar(p, j);
        }
        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }
        if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
            dp[i][j] = isMatch_Memo(i - 1, j - 1, s, p, dp) ? 1 : 0;
            return dp[i][j] == 1;
        } else if (p.charAt(j - 1) == '*') {
            dp[i][j] = (isMatch_Memo(i, j - 1, s, p, dp) || isMatch_Memo(i - 1, j, s, p, dp)) ? 1 : 0;
            return dp[i][j] == 1;
        }
        return false;
    }

    //TC - O( N * M)
    //SC - O( N * M)
    public static boolean isMatch_Tabulation(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][0] = true;
        int prefixStar = 0;
        for (int i = 0; i < m; i++) {
            if (p.charAt(i) == '*') {
                prefixStar = i + 1;
            } else {
                break;
            }
        }

        for (int i = 0; i <= prefixStar; i++) {
            dp[0][i] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }

    //TC - O( N * M)
    //SC - O( M)
    public static boolean isMatch_SpaceOptimized(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[] prev = new boolean[m + 1];

        prev[0] = true;
        int prefixStar = 0;
        for (int i = 0; i < m; i++) {
            if (p.charAt(i) == '*') {
                prefixStar = i + 1;
            } else {
                break;
            }
        }

        for (int i = 0; i <= prefixStar; i++) {
            prev[i] = true;
        }

        for (int i = 1; i <= n; i++) {
            boolean[] cur = new boolean[m + 1];
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    cur[j] = prev[j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    cur[j] = cur[j - 1] || prev[j];
                } else {
                    cur[j] = false;
                }
            }
            prev = cur;
        }
        return prev[m];
    }

    private static boolean isAllStar(String p, int ind) {
        for (int i = 1; i <= ind; i++) {
            if (p.charAt(i - 1) != '*') {
                return false;
            }
        }
        return true;
    }


}
