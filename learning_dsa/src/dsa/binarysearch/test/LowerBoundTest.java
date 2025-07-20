package dsa.binarysearch.test;

import static dsa.binarysearch.main.LowerBound.getLowerBound;

public class LowerBoundTest {
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

        printTest("Test 1 - Lower bound of 3", 1, getLowerBound(arr1, 3));
        printTest("Test 2 - Lower bound of 4", 3, getLowerBound(arr1, 4));
        printTest("Test 3 - Lower bound of 0", 0, getLowerBound(arr1, 0));
        printTest("Test 4 - Lower bound of 10", arr1.length, getLowerBound(arr1, 10));
        printTest("Test 5 - Lower bound of 7", 4, getLowerBound(arr1, 7));

        int[] arr2 = {};
        printTest("Test 6 - Empty Array", arr2.length, getLowerBound(arr2, 5));

        int[] arr3 = {5};
        printTest("Test 7 - Single Element Match", 0, getLowerBound(arr3, 5));
        printTest("Test 8 - Single Element Too Small", arr3.length, getLowerBound(arr3, 6));
        printTest("Test 9 - Single Element Too Large", 0, getLowerBound(arr3, 4));

        int[] arr4 = {-10, -5, 0, 2, 4};
        printTest("Test 10 - Lower bound of -6", 1, getLowerBound(arr4, -6));
        printTest("Test 11 - Lower bound of 2", 3, getLowerBound(arr4, 2));
    }
}
