package dsa.dp.test;

import dsa.dp.main.EditDistance;

public class EditDistanceTest {
    public static void main(String[] args) {
        test("horse", "ros", 3);
        test("intention", "execution", 5);
        test("kitten", "sitting", 3);
        test("abc", "abc", 0);
        test("abc", "def", 3);
        test("", "abc", 3);
        test("abc", "", 3);
        test("", "", 0);
    }

    private static void test(String s1, String s2, int expected) {
        int rec = EditDistance.getMinOperation_Recursion(s1, s2);
        int memo = EditDistance.getMinOperation_Memo(s1, s2);
        int tab = EditDistance.getMinOperation_Tabulation(s1, s2);
        int opt = EditDistance.getMinOperation_SpaceOptimized(s1, s2);

        boolean allCorrect = (rec == expected && memo == expected && tab == expected && opt == expected);
        String status = allCorrect ? "✅" : "❌";

        System.out.printf(
                "S1: %-10s | S2: %-10s | Expected: %d | Rec: %d | Memo: %d | Tab: %d | Opt: %d | %s%n",
                s1, s2, expected, rec, memo, tab, opt, status
        );
    }
}
