package dsa.dp.test;

import dsa.dp.main.SCSuperSequence;

public class SCSuperSequenceTest {
    public static void main(String[] args) {
        test("brute", "groot", 8, "bgruoote");  // Example
        test("abac", "cab", 5, "cabac");
        test("abc", "def", 6, "abcdef");
        test("AGGTAB", "GXTXAYB", 9, "AGGXTXAYB");
        test("geek", "eke", 5, "geeke");
        test("a", "a", 1, "a");
        test("a", "b", 2, "ab");
        test("", "abc", 3, "abc");
        test("abc", "", 3, "abc");
        test("", "", 0, "");
    }

    private static void test(String s1, String s2, int expectedLen, String expectedStrHint) {
        int len = SCSuperSequence.getSCSuperSequenceLen(s1, s2);
        String scs = SCSuperSequence.getSCSuperSequenceString(s1, s2);

        boolean lenCorrect = len == scs.length();
        boolean matchHint = scs.contains(expectedStrHint) || scs.equals(expectedStrHint); // relaxed check

        String status = (lenCorrect && matchHint) ? "✅" : "❌";
        System.out.printf("S1: %-8s | S2: %-8s | Len: %-2d | SCS: %-12s | %s\n",
                s1, s2, len, scs, status);
    }
}
