package dsa.dp.test;

import dsa.dp.main.LongestBitonicSubsequence;

import java.util.Arrays;

public class LongestBitonicSubsequenceTest {
    private static void runTest(int[] input, int expected, int testNum) {
        int result = LongestBitonicSubsequence.longestBitonicSubSequence(input);
        if (result == expected) {
            System.out.println("Test " + testNum + " ✅ Passed: " + result);
        } else {
            System.out.println("Test " + testNum + " ❌ Failed");
            System.out.println("  Input:     " + Arrays.toString(input));
            System.out.println("  Expected:  " + expected);
            System.out.println("  Got:       " + result);
        }
    }

    public static void main(String[] args) {
        // Test 1: Normal bitonic
        runTest(new int[]{1, 3, 5, 4, 2}, 5, 1); // Whole array is bitonic

        // Test 2: Increasing only
        runTest(new int[]{1, 2, 3, 4, 5}, 5, 2); // No decreasing part, so LBS = LIS

        // Test 3: Decreasing only
        runTest(new int[]{5, 4, 3, 2, 1}, 5, 3); // No increasing part after peak, still valid

        // Test 4: Bitonic in middle
        runTest(new int[]{1, 11, 2, 10, 4, 5, 2, 1}, 6, 4); // LBS = [1, 2, 10, 4, 2, 1]

        // Test 5: Random order
        runTest(new int[]{12, 11, 40, 5, 3, 1}, 5, 5); // LBS = [11, 40, 5, 3, 1]

        // Test 6: Empty array
        runTest(new int[]{}, 0, 6);

        // Test 7: One element
        runTest(new int[]{10}, 1, 7);

        // Test 8: Two increasing
        runTest(new int[]{2, 3}, 2, 8);

        // Test 9: Two decreasing
        runTest(new int[]{5, 1}, 2, 9);

        // Test 10: Plateau in the middle (should not count flat parts)
        runTest(new int[]{1, 2, 2, 2, 1}, 3, 10); // LBS = [1, 2, 1]
    }
}
