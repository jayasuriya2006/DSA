package dsa.dp.test;

import dsa.dp.main.WildCardMatching;

public class WildCardMatchingTest {
    public static void main(String[] args) {
        test("abc", "a*c", true);
        test("abc", "a*bc", true);
        test("abc", "a*b", false);
        test("abc", "a*", true);
        test("abc", "*", true);
        test("abc", "?*", true);
        test("abc", "???", true);
        test("abc", "????", false);
        test("", "*", true);
        test("", "?", false);
        test("abc", "", false);
        test("", "", true);
    }

    private static void test(String s, String p, boolean expected) {
        boolean resRec = WildCardMatching.isMatch_Recursion(s, p);
        boolean resMemo = WildCardMatching.isMatch_Memo(s, p);
        boolean resTab = WildCardMatching.isMatch_Tabulation(s, p);
        boolean resOpt = WildCardMatching.isMatch_SpaceOptimized(s, p);

        boolean allPass = resRec == expected && resMemo == expected && resTab == expected && resOpt == expected;
        String status = allPass ? "✅" : "❌";

        System.out.printf(
                "S: %-6s | P: %-8s | Expected: %-5s | Rec: %-5s | Memo: %-5s | Tab: %-5s | Opt: %-5s | %s\n",
                s, p, expected, resRec, resMemo, resTab, resOpt, status
        );
    }
}
