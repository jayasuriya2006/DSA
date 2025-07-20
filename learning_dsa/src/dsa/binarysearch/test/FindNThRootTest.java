package dsa.binarysearch.test;

import static dsa.binarysearch.main.FindNThRoot.findNthRoot;

public class FindNThRootTest {
    public static void main(String[] args) {
        int[][] testCases = {
                {2, 4},     // 2^2 = 4 → return 2
                {3, 27},    // 3^3 = 27 → return 3
                {2, 10},    // not exact → return -1
                {3, 9},     // not exact → return -1
                {4, 16},    // 2^4 = 16 → return 2
                {5, 243},   // 3^5 = 243 → return 3
                {2, 1},     // 1^2 = 1 → return 1
                {3, 1},     // 1^3 = 1 → return 1
                {2, 0},     // 0^2 = 0 → return 0
                {3, 125},   // 5^3 = 125 → return 5
                {6, 64},    // 2^6 = 64 → return 2
                {3, 30},    // not exact → return -1
                {4, 10000}, // not exact (10^4 = 10000, exact) → return 10
                {2, 14},    // not exact → return -1
                {2, 49},    // 7^2 = 49 → return 7
        };

        int[] expected = {
                2, 3, -1, -1, 2, 3, 1, 1, 0, 5, 2, -1, 10, -1, 7
        };

        for (int i = 0; i < testCases.length; i++) {
            int n = testCases[i][0];
            int A = testCases[i][1];
            int result = findNthRoot(n, A);
            boolean passed = result == expected[i];
            System.out.println("Test " + (i + 1) + ": " +
                    n + "th root of " + A + " → " + result +
                    (passed ? " ✅" : " ❌ Expected: " + expected[i]));
        }
    }
}
