package dsa.dp.main;

import static dsa.dp.main.LengthOfLongestCommonSubsequence.lenOfLCS_SpaceOptimized;

public class SCSuperSequence {

    public static int getSCSuperSequenceLen(String s1, String s2) {
        int lcs = lenOfLCS_SpaceOptimized(s1, s2);
        return (s1.length() - lcs) + (s2.length() - lcs) + lcs;
    }

    public static String getSCSuperSequenceString(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][ n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        StringBuilder scs = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                scs.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                scs.append(s1.charAt(i - 1));
                i--;
            } else {
                scs.append(s2.charAt(j - 1));
                j--;
            }
        }

        while (i > 0) scs.append(s1.charAt(i-- - 1));
        while (j > 0) scs.append(s2.charAt(j-- - 1));

        return scs.reverse().toString(); // reverse at the end
    }
}
