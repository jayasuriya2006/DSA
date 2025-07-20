package dsa.binarysearch.test;

import static dsa.binarysearch.main.SearchInsertPosition.getTheInsertPosition;

public class SearchInsertPositionTest {
    // Helper to print results
    public static void printTest(String testName, int expected, int actual) {
        if (expected == actual) {
            System.out.println(testName + " PASSED ✅");
        } else {
            System.out.println(testName + " FAILED ❌ (Expected: " + expected + ", Got: " + actual + ")");
        }
    }

    // Main method with tests
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 6};

        printTest("Test 1 - Insert 5 (after existing)", 3, getTheInsertPosition(arr1, 5));
        printTest("Test 2 - Insert 2", 1, getTheInsertPosition(arr1, 2));
        printTest("Test 3 - Insert 7", 4, getTheInsertPosition(arr1, 7));
        printTest("Test 4 - Insert 0", 0, getTheInsertPosition(arr1, 0));
        printTest("Test 5 - Insert 6 (after existing)", 4, getTheInsertPosition(arr1, 6));

        int[] arr2 = {};
        printTest("Test 6 - Insert into empty array", 0, getTheInsertPosition(arr2, 10));

        int[] arr3 = {10};
        printTest("Test 7 - Insert equal to element", 1, getTheInsertPosition(arr3, 10));
        printTest("Test 8 - Insert less than element", 0, getTheInsertPosition(arr3, 5));
        printTest("Test 9 - Insert greater than element", 1, getTheInsertPosition(arr3, 20));

        int[] arr4 = {1, 2, 2, 2, 3};
        printTest("Test 10 - Insert duplicate (after all)", 4, getTheInsertPosition(arr4, 2));
        printTest("Test 11 - Insert new value 4", 5, getTheInsertPosition(arr4, 4));
        printTest("Test 12 - Insert 0", 0, getTheInsertPosition(arr4, 0));
        printTest("Test 13 - Insert 4", 5, getTheInsertPosition(arr4, 4));
    }
}
