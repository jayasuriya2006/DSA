package dsa.dp.main;

import static dsa.dp.main.LengthOfLongestCommonSubsequence.lenOfLCS_SpaceOptimized;

public class MinInsertionOrDeletionForAToB {

    public static int getMinInsertionOrDeletionToMakeAToB(String a, String b) {
        int lcs = lenOfLCS_SpaceOptimized(a, b);
        return (a.length() - lcs) + (b.length() - lcs);       //removed + inserted
    }
}
