package dsa.binarysearch.test;

import static dsa.binarysearch.main.BinarySearchInArray.binarySearch;

public class BinarySearchInArrayTest {

    // Helper method to print test results
    public static void printTest(String testName, int expected, int actual) {
        if (expected == actual) {
            System.out.println(testName + " PASSED ✅");
        } else {
            System.out.println(testName + " FAILED ❌ (Expected: " + expected + ", Got: " + actual + ")");
        }
    }

    // Main method to run test cases
    public static void main(String[] args) {
        // Test case 1: Element in the middle
        int[] arr1 = {1, 3, 5, 7, 9};
        printTest("Test 1 - Middle Element", 2, binarySearch(arr1, 5));

        // Test case 2: Element at start
        printTest("Test 2 - First Element", 0, binarySearch(arr1, 1));

        // Test case 3: Element at end
        printTest("Test 3 - Last Element", 4, binarySearch(arr1, 9));

        // Test case 4: Element not found
        printTest("Test 4 - Element Not Found", -1, binarySearch(arr1, 4));

        // Test case 5: Empty array
        int[] arr2 = {};
        printTest("Test 5 - Empty Array", -1, binarySearch(arr2, 10));

        // Test case 6: Single element found
        int[] arr3 = {5};
        printTest("Test 6 - Single Element Found", 0, binarySearch(arr3, 5));

        // Test case 7: Single element not found
        printTest("Test 7 - Single Element Not Found", -1, binarySearch(arr3, 3));

        // Test case 8: Negative numbers
        int[] arr4 = {-10, -5, 0, 5, 10};
        printTest("Test 8 - Negative Number", 1, binarySearch(arr4, -5));
    }
}

