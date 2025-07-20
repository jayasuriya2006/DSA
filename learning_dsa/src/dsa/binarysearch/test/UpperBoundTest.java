package dsa.binarysearch.test;

import static dsa.binarysearch.main.UpperBound.getUpperBound;

public class UpperBoundTest {
    // Helper method to print test results
    public static void printTest(String testName, int expected, int actual) {
        if (expected == actual) {
            System.out.println(testName + " PASSED ✅");
        } else {
            System.out.println(testName + " FAILED ❌ (Expected: " + expected + ", Got: " + actual + ")");
        }
    }

    // Main method with test cases
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 3, 5, 7, 9};

        printTest("Test 1 - Upper bound of 3", 3, getUpperBound(arr1, 3)); // first > 3 is 5
        printTest("Test 2 - Upper bound of 4", 3, getUpperBound(arr1, 4)); // first > 4 is 5
        printTest("Test 3 - Upper bound of 9", arr1.length, getUpperBound(arr1, 9)); // none > 9
        printTest("Test 4 - Upper bound of 0", 0, getUpperBound(arr1, 0)); // first > 0 is 1
        printTest("Test 5 - Upper bound of 7", 5, getUpperBound(arr1, 7)); // first > 7 is 9

        int[] arr2 = {};
        printTest("Test 6 - Empty Array", arr2.length, getUpperBound(arr2, 5));

        int[] arr3 = {5};
        printTest("Test 7 - Single Element Match", arr3.length, getUpperBound(arr3, 5));
        printTest("Test 8 - Single Element Too Small", 0, getUpperBound(arr3, 4));
        printTest("Test 9 - Single Element Too Large", arr3.length, getUpperBound(arr3, 6));

        int[] arr4 = {-10, -5, 0, 2, 4};
        printTest("Test 10 - Upper bound of -6", 1, getUpperBound(arr4, -6));
        printTest("Test 11 - Upper bound of 2", 4, getUpperBound(arr4, 2));
    }
}
