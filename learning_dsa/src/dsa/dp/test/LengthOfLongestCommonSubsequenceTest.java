package dsa.dp.test;

import dsa.dp.main.LengthOfLongestCommonSubsequence;

public class LengthOfLongestCommonSubsequenceTest {
    public static void main(String[] args) {
        runTest("abcde", "ace", 3, "ace");
        runTest("abc", "abc", 3, "abc");
        runTest("abc", "def", 0, "");
        runTest("aggtab", "gxtxayb", 4, "gtab");
        runTest("aaa", "aa", 2, "aa");
        runTest("", "", 0, "");
        runTest("a", "a", 1, "a");
        runTest("a", "", 0, "");
        runTest("abac", "cab", 2, "ab"); // Note: "ac" is also a valid LCS
    }

    private static void runTest(String s1, String s2, int expectedLen, String expectedLCS) {
        System.out.println("\n=== Testing: \"" + s1 + "\" & \"" + s2 + "\" ===");

        int lenRec = LengthOfLongestCommonSubsequence.lenOfLCS_Recursion(s1, s2);
        int lenMemo = LengthOfLongestCommonSubsequence.lenOfLCS_Memo(s1, s2);
        int lenTab = LengthOfLongestCommonSubsequence.lenOfLCS_Tabulation(s1, s2);
        int lenOpt = LengthOfLongestCommonSubsequence.lenOfLCS_SpaceOptimized(s1, s2);
        String actualLCS = LengthOfLongestCommonSubsequence.getLCS(s1, s2);

        boolean passed = lenTab == expectedLen && actualLCS.length() == expectedLen;

        System.out.println("Recursion:         " + lenRec);
        System.out.println("Memoization:       " + lenMemo);
        System.out.println("Tabulation:        " + lenTab);
        System.out.println("Space Optimized:   " + lenOpt);
        System.out.println("LCS String:        \"" + actualLCS + "\"");
        System.out.println("Expected Length:   " + expectedLen);
        System.out.println("Expected LCS:      \"" + expectedLCS + "\"");

        System.out.println(passed ? "✅ Test Passed" : "❌ Test Failed");
    }
}
