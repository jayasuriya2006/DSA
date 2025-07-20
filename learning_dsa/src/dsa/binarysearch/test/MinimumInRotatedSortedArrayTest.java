package dsa.binarysearch.test;

import static dsa.binarysearch.main.MinimumInRotatedSortedArray.getMinimum;

public class MinimumInRotatedSortedArrayTest {

    public static void main(String[] args) {
        // Test cases
        int[][] testCases = {
                {4, 5, 6, 7, 0, 1, 2},         // Normal rotated
                {3, 4, 5, 1, 2},               // Rotated small
                {11, 13, 15, 17},              // Not rotated
                {2, 1},                        // Two elements, rotated
                {1},                           // Single element
                {1, 2, 3, 4, 5},               // Sorted, not rotated
                {2, 2, 2, 0, 1}               // With duplicates
        };

        int[] expected = {0, 1, 11, 1, 1, 1, 0};

        boolean allPassed = true;

        for (int i = 0; i < testCases.length; i++) {
            try {
                int result = getMinimum(testCases[i]);
                if (result == expected[i]) {
                    System.out.println("Test case " + (i + 1) + " passed.");
                } else {
                    System.out.println("Test case " + (i + 1) + " failed. Expected: " + expected[i] + ", Got: " + result);
                    allPassed = false;
                }
            } catch (Exception e) {
                System.out.println("Test case " + (i + 1) + " threw exception: " + e.getMessage());
                allPassed = false;
            }
        }

        if (allPassed) {
            System.out.println("✅ All test cases passed!");
        } else {
            System.out.println("❌ Some test cases failed.");
        }
    }
}
