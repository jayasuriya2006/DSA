package dsa.dp.test;

import dsa.dp.main.PalindromePartitioningII;

public class PalindromePartitioningIITest {
    public static void main(String[] args) {
        runTest("aab", 1);
        runTest("a", 0);
        runTest("ab", 1);
        runTest("racecar", 0);
        runTest("banana", 1);
        runTest("cddpd", 2);
        runTest("abccbc", 2);
        runTest("abcdef", 5); // All single characters
        runTest("aabbc", 2);  // Cut between "aa", "bb", "c"
        runTest("abccba", 0); // Already palindrome
    }

    private static void runTest(String s, int expected) {
        PalindromePartitioningII solver = new PalindromePartitioningII();
        int result = solver.minCut(s);

        System.out.println("Input String        : " + s);
        System.out.println("Minimum Cuts Result : " + result);
        System.out.println("Expected            : " + expected);
        System.out.println(result == expected ? "✅ Test Passed" : "❌ Test Failed");
        System.out.println("--------------------------------------------------");
    }
}
