package dsa.dp.test;

import dsa.dp.main.NoOfLIS;

import java.util.Arrays;

import static dsa.dp.main.NoOfLIS.getNoOfLis;

public class NoOfLISTest {
    private static void runTest(int[] input, int expected, int testNum) {
        int result = NoOfLIS.getNoOfLis(input);
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
        // Test 1: Example case with multiple LIS
        runTest(new int[]{1, 3, 5, 4, 7}, 2, 1); // Two LIS: [1,3,4,7] and [1,3,5,7]

        // Test 2: Strictly increasing sequence
        runTest(new int[]{1, 2, 3, 4, 5}, 1, 2); // Only one LIS

        // Test 3: All elements same
        runTest(new int[]{2, 2, 2, 2, 2}, 5, 3); // Each single element is a LIS of length 1

        // Test 4: Decreasing sequence
        runTest(new int[]{5, 4, 3, 2, 1}, 5, 4); // Each single element is LIS of length 1

        // Test 5: Multiple LIS with same length
        runTest(new int[]{1, 2, 4, 3, 5, 4, 7, 2}, 3, 5);

        // Test 6: Empty array
        runTest(new int[]{}, 0, 6);

        // Test 7: One element
        runTest(new int[]{10}, 1, 7);

        // Test 8: Two increasing
        runTest(new int[]{2, 3}, 1, 8);

        // Test 9: Two decreasing
        runTest(new int[]{5, 2}, 2, 9); // Two LIS of length 1

        // Test 10: Complex mix
        runTest(new int[]{1, 2, 3, 1, 2, 3}, 4, 10); // [1,2,3] and [1,2,3] (different indices)
    }
}
