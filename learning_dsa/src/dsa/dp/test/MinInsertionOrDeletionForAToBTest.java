package dsa.dp.test;

import dsa.dp.main.MinInsertionOrDeletionForAToB;

public class MinInsertionOrDeletionForAToBTest {
    public static void main(String[] args) {
        test("heap", "pea", 3);        // delete 'h', 'p' → insert 'p', 'a'
        test("geeksforgeeks", "geeks", 8);
        test("abcdef", "fbdamn", 8);
        test("abc", "abc", 0);         // already same
        test("abc", "def", 6);         // no common chars
        test("", "abc", 3);            // 3 insertions
        test("abc", "", 3);            // 3 deletions
        test("", "", 0);               // nothing to do
        test("a", "a", 0);             // already same
        test("a", "b", 2);             // 1 deletion, 1 insertion
    }

    private static void test(String a, String b, int expected) {
        int result = MinInsertionOrDeletionForAToB.getMinInsertionOrDeletionToMakeAToB(a, b);
        String status = result == expected ? "✅" : "❌";
        System.out.printf("A: %-10s | B: %-10s | Expected: %-2d | Result: %-2d | %s\n",
                a, b, expected, result, status);
    }
}
