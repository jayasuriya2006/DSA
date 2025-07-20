package dsa.binarysearch.test;

import static dsa.binarysearch.main.MinDaysForMBouquets.getMinDaysForMBouquets;

public class MinDaysForMBouquetsTest {
    public static void main(String[] args) {
        int[][] testBloomDays = {
                {1, 10, 3, 10, 2},      // Example 1
                {1, 10, 3, 10, 2},      // Example 2 (impossible)
                {7, 7, 7, 7, 12, 7, 7}, // Example 3
                {1000000000, 1000000000}, // Impossible case
                {1, 10, 2, 9, 3, 8},    // Custom case
                {1, 2, 3, 4, 5, 6},     // Exact fit
                {1, 2, 3, 4, 5},     // Not enough flowers
        };

        int[] mVals = {3, 3, 2, 1, 2, 2, 3};
        int[] kVals = {1, 2, 3, 1, 2, 3, 2};
        int[] expected = {3, -1, 12, 1000000000, 9, 6, -1};

        for (int i = 0; i < testBloomDays.length; i++) {
            int result = getMinDaysForMBouquets(testBloomDays[i], mVals[i], kVals[i]);
            boolean passed = result == expected[i];
            System.out.println("Test " + (i + 1) +
                    ": Expected = " + expected[i] +
                    ", Got = " + result +
                    (passed ? " ✅" : " ❌"));
        }
    }
}
