package dsa.binarysearch.test;

import static dsa.binarysearch.main.FirstAndLastOccurrences.getFirstAndLastOccurrence;

public class FirstAndLastOccurrencesTest {
    // Test result printer
    public static void printTest(String testName, int[] expected, int[] actual) {
        if (expected[0] == actual[0] && expected[1] == actual[1]) {
            System.out.println(testName + " PASSED ✅");
        } else {
            System.out.println(testName + " FAILED ❌ (Expected: [" + expected[0] + ", " + expected[1] +
                    "], Got: [" + actual[0] + ", " + actual[1] + "])");
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 2, 3, 4, 4, 5};

        printTest("Test 1 - Target 2", new int[]{1, 3}, getFirstAndLastOccurrence(arr1, 2));
        printTest("Test 2 - Target 4", new int[]{5, 6}, getFirstAndLastOccurrence(arr1, 4));
        printTest("Test 3 - Target 1", new int[]{0, 0}, getFirstAndLastOccurrence(arr1, 1));
        printTest("Test 4 - Target 5", new int[]{7, 7}, getFirstAndLastOccurrence(arr1, 5));
        printTest("Test 5 - Target not found", new int[]{-1, -1}, getFirstAndLastOccurrence(arr1, 10));

        int[] arr2 = {};
        printTest("Test 6 - Empty array", new int[]{-1, -1}, getFirstAndLastOccurrence(arr2, 3));

        int[] arr3 = {5};
        printTest("Test 7 - Single match", new int[]{0, 0}, getFirstAndLastOccurrence(arr3, 5));
        printTest("Test 8 - Single no match", new int[]{-1, -1}, getFirstAndLastOccurrence(arr3, 3));

        int[] arr4 = {2, 2, 2, 2, 2};
        printTest("Test 9 - All elements match", new int[]{0, 4}, getFirstAndLastOccurrence(arr4, 2));
        printTest("Test 10 - All elements no match", new int[]{-1, -1}, getFirstAndLastOccurrence(arr4, 3));
    }
}
