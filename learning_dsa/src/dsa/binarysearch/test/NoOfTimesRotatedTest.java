package dsa.binarysearch.test;

import static dsa.binarysearch.main.NoOfTimesRotated.findRotationCount;

public class NoOfTimesRotatedTest {
    public static void main(String[] args) {
        // Test cases
        int[][] testCases = {
                {15, 18, 2, 3, 6, 12},         // Rotated 2 times
                {7, 9, 11, 12, 5},             // Rotated 4 times
                {1, 2, 3, 4, 5},               // Not rotated
                {3, 4, 5, 1, 2},               // Rotated 3 times
                {2, 1},                        // Rotated 1 time
                {1},                           // Not rotated
                {4, 5, 6, 7, 0, 1, 2},         // Rotated 4 times
        };

        int[] expected = {2, 4, 0, 3, 1, 0, 4};

        boolean allPassed = true;

        for (int i = 0; i < testCases.length; i++) {
            try {
                int result = findRotationCount(testCases[i]);
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
