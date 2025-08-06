package dsa.dp.test;

import dsa.dp.main.LongestPalindromeSubSequence;

public class LongestPalindromeSubSequenceTest {
    public static void main(String[] args) {
        runTest("bbbab", "bbbb");         // expected: "bbbb"
        runTest("cbbd", "bb");            // expected: "bb"
        runTest("agbdba", "abdba");       // expected: "abdba"
        runTest("a", "a");                // expected: "a"
        runTest("abcd", "a");             // expected: one of "a", "b", "c", or "d"
        runTest("character", "carac");    // expected: "carac" or similar
        runTest("forgeeksskeegfor", "fgeeksskeegf"); // expected: one longest palindromic subsequence
    }

    private static void runTest(String input, String expectedLike) {
        String actual = LongestPalindromeSubSequence.getLCPSubSequence(input);
        boolean passed = isSubsequence(expectedLike, actual) || isSubsequence(actual, expectedLike);
        String check = passed ? "✅" : "❌";
        System.out.printf("%s Input: \"%s\" | Output: \"%s\" | Expected-like: \"%s\"%n",
                check, input, actual, expectedLike);
    }

    // Optional helper: since LCS might differ in actual characters but match in length
    private static boolean isSubsequence(String a, String b) {
        int j = 0;
        for (int i = 0; i < b.length() && j < a.length(); i++) {
            if (a.charAt(j) == b.charAt(i)) j++;
        }
        return j == a.length();
    }
}
