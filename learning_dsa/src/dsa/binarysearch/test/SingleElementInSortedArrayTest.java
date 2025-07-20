package dsa.binarysearch.test;

import static dsa.binarysearch.main.SingleElementInSortedArray.getSingleElement;

public class SingleElementInSortedArrayTest {
    public static void main(String[] args) {
        int[][] testCases = {
                {1, 1, 2, 2, 3, 3, 4, 4, 5},      // Unique: 5
                {0, 1, 1, 2, 2, 3, 3},            // Unique: 0
                {1, 1, 2, 2, 3, 4, 4, 5, 5},      // Unique: 3
                {1},                              // Unique: 1
                {1, 1, 2},                        // Unique: 2
                {1, 2, 2},                        // Unique: 1
                {1, 1, 2, 2, 3, 3, 4}             // Unique: 4
        };

        int[] expectedResults = {5, 0, 3, 1, 2, 1, 4};

        for (int i = 0; i < testCases.length; i++) {
            int result = getSingleElement(testCases[i]);
            System.out.println("Test Case " + (i + 1) + ": Expected = " + expectedResults[i] +
                    ", Got = " + result +
                    (result == expectedResults[i] ? " ✅" : " ❌"));
        }
    }
}
