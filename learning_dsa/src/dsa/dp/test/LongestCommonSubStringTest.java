package dsa.dp.test;

import dsa.dp.main.LongestCommonSubString;

public class LongestCommonSubStringTest {
    public static void main(String[] args) {
        runTest("abcde", "abfce", 2, "ab");
        runTest("abcdxyz", "xyzabcd", 4, "abcd");
        runTest("zxabcdezy", "yzabcdezx", 6, "abcdez");
        runTest("abc", "def", 0, "");
        runTest("aaaa", "aa", 2, "aa");
        runTest("", "abc", 0, "");
        runTest("abc", "", 0, "");
        runTest("abcdef", "zabcf", 3, "abc");

        // ✅ Additional test cases
        runTest("abcabc", "abc", 3, "abc");                     // repeated common prefix
        runTest("aabbaabb", "bb", 2, "bb");                     // repeating characters
        runTest("xyabcz", "12abc9", 3, "abc");                  // common substring in the middle
        runTest("abcabcabc", "abc", 3, "abc");                  // multiple max substrings
        runTest("12345", "345", 3, "345");                      // substring at end
        runTest("abcdefg", "xyzabc", 3, "abc");                 // common prefix at end
        runTest("ABAB", "BABA", 3, "ABA");                       // overlapping patterns
        runTest("a", "a", 1, "a");                              // minimal input
        runTest("a", "b", 0, "");                               // minimal no-match input
        runTest("abcXYZdef", "XYZ", 3, "XYZ");                  // full substring match
    }

    private static void runTest(String s1, String s2, int expectedLength, String expectedSubstring) {
        System.out.println("\n=== Testing \"" + s1 + "\" & \"" + s2 + "\" ===");

        int tabLen = LongestCommonSubString.lenOfLCSubString_Tabulation(s1, s2);
        int optLen = LongestCommonSubString.lenOfLCSubString_SpaceOptimized(s1, s2);
        String actualSubStr = LongestCommonSubString.getLCSubString(s1, s2);

        boolean passed = (tabLen == expectedLength) && (actualSubStr.equals(expectedSubstring));
        System.out.println("Tabulation Length:      " + tabLen);
        System.out.println("Space Optimized Length: " + optLen);
        System.out.println("Extracted Substring:    \"" + actualSubStr + "\"");
        System.out.println("Expected Length:        " + expectedLength);
        System.out.println("Expected Substring:     \"" + expectedSubstring + "\"");

        System.out.println(passed ? "✅ Test Passed" : "❌ Test Failed");
    }
}
