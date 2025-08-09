package dsa.dp.main;

import java.util.Arrays;

public class LongestStringChain {

    public static int getLongestStringChainLen(String[] words) {
        int n = words.length;
        if (n == 0) return 0;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int maxLen = 1;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int ind = 1; ind < n; ind++) {
            dp[ind] = 1;
            for (int prevInd = 0; prevInd < ind; prevInd++) {
                if (isWordsAreChain(words[prevInd], words[ind])) {
                    if (dp[ind] < dp[prevInd] + 1) {
                        dp[ind] = dp[prevInd] + 1;
                        maxLen = Math.max(maxLen, dp[ind]);
                    }
                }
            }
        }
        return maxLen;
    }

    private static boolean isWordsAreChain(String w1, String w2) {
        int len1 = w1.length();
        int len2 = w2.length();

        if (len2 != len1 + 1) return false;

        int i = 0;
        int j = 0;
        while (i < len1 && j < len2) {
            if (w1.charAt(i) == w2.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        if (i + 1 == len2) return true;
        return i == len1 && j == len2;
    }
}
