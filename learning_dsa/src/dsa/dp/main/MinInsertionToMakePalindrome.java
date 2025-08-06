package dsa.dp.main;

import static dsa.dp.main.LengthOfLongestCommonSubsequence.lenOfLCS_SpaceOptimized;

public class MinInsertionToMakePalindrome {

    public static int getMinInsertionForPalindrome(String s1) {
        String s2 = new StringBuilder(s1).reverse().toString();
        int lcs = lenOfLCS_SpaceOptimized(s1, s2);
        return s2.length() - lcs;
    }
}
