package dsa.dp.test;

import dsa.dp.main.DistinctSubSequence;

public class DistinctSubSequenceTest {
    public static void main(String[] args) {
        test("rabbbit", "rabbit", 3);
        test("babgbag", "bag", 5);
        test("abcde", "ace", 1);
        test("aaaaa", "aa", 10);
        test("abc", "abc", 1);
        test("abc", "axc", 0);
        test("", "", 1);
        test("abc", "", 1);
        test("", "a", 0);
    }

    private static void test(String s1, String s2, int expected) {
        int resRec = DistinctSubSequence.getNoOfDistinctSubSequence_Recursion(s1, s2);
        int resMemo = DistinctSubSequence.getNoOfDistinctSubSequence_Memo(s1, s2);
        int resTab = DistinctSubSequence.getNoOfDistinctSubSequence_Tabulation(s1, s2);
        int resOpt = DistinctSubSequence.getNoOfDistinctSubSequence_SpaceOptimized(s1, s2);

        String status = (resMemo == expected && resTab == expected && resOpt == expected && resRec == expected)
                ? "✅"
                : "❌";

        System.out.printf(
                "S1: %-10s | S2: %-10s | Expected: %-3d | Rec: %-3d | Memo: %-3d | Tab: %-3d | Opt: %-3d | %s\n",
                s1, s2, expected, resRec, resMemo, resTab, resOpt, status
        );
    }
}
