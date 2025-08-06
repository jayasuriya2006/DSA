package dsa.dp.test;

import dsa.dp.main.MinInsertionToMakePalindrome;

public class MinInsertionToMakePalindromeTest {
    public static void main(String[] args) {
        test("abcda", 2);
        test("aebcbda", 2);
        test("race", 3);
        test("abcd", 3);
        test("aa", 0);
        test("a", 0);
        test("", 0);
        test("abcba", 0); // already a palindrome
        test("ab", 1);
        test("abc", 2);
        test("abca", 1);
        test("palindrome", 9);
        test("noon", 0); // already a palindrome
        test("civic", 0); // already a palindrome
        test("level", 0); // already a palindrome
        test("deified", 0); // already a palindrome
        test("reviver", 0); // already a palindrome
        test("rotator", 0); // already a palindrome
    }

    private static void test(String input, int expected) {
        int result = MinInsertionToMakePalindrome.getMinInsertionForPalindrome(input);
        String status = result == expected ? "✅" : "❌";
        System.out.printf("Input: %-12s | Expected: %-2d | Result: %-2d | %s\n",
                input, expected, result, status);
    }
}
