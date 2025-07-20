package dsa.binarysearch.test;

import static dsa.binarysearch.main.KthElementOfTwoSortedArrays.findKthElement;

public class KthElementOfTwoSortedArraysTest {
    public static void main(String[] args) {
        runTest(new int[]{2, 3, 6, 7, 9}, new int[]{1, 4, 8, 10}, 5, 6, "Test 1");
        runTest(new int[]{1, 3, 5}, new int[]{2, 4, 6}, 4, 4, "Test 2");
        runTest(new int[]{1, 2}, new int[]{3, 4, 5, 6}, 6, 6, "Test 3");
        runTest(new int[]{100, 112, 256}, new int[]{50, 75, 150, 175}, 5, 150, "Test 4");
        runTest(new int[]{}, new int[]{1, 2, 3, 4}, 3, 3, "Test 5 (empty arr1)");
        runTest(new int[]{1, 2, 3}, new int[]{}, 2, 2, "Test 6 (empty arr2)");
        runTest(new int[]{1}, new int[]{2}, 2, 2, "Test 7 (small arrays)");
    }

    private static void runTest(int[] arr1, int[] arr2, int k, int expected, String testName) {
        int result = findKthElement(arr1, arr2, k);
        if (result == expected) {
            System.out.println(testName + " passed.");
        } else {
            System.out.printf("%s failed: expected %d, got %d\n", testName, expected, result);
        }
    }
}
