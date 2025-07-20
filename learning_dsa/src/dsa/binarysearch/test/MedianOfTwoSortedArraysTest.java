package dsa.binarysearch.test;

import static dsa.binarysearch.main.MedianOfTwoSortedArrays.*;

public class MedianOfTwoSortedArraysTest {
    public static void main(String[] args) {
        runTest(new int[]{1, 3}, new int[]{2}, 2.0, "Test 1");
        runTest(new int[]{1, 2}, new int[]{3, 4}, 2.5, "Test 2");
        runTest(new int[]{0, 0}, new int[]{0, 0}, 0.0, "Test 3");
        runTest(new int[]{}, new int[]{1}, 1.0, "Test 4");
        runTest(new int[]{2}, new int[]{}, 2.0, "Test 5");
        runTest(new int[]{1, 2, 3, 4, 5}, new int[]{6, 7, 8, 9, 10}, 5.5, "Test 6");
        runTest(new int[]{1, 3, 8, 9, 15}, new int[]{7, 11, 18, 19, 21, 25}, 11.0, "Test 7");
    }

    private static void runTest(int[] nums1, int[] nums2, double expected, String testName) {
        double result = getMedian_Optimal(nums1, nums2);   //better and brut also there
        if (Math.abs(result - expected) < 1e-6) {
            System.out.println(testName + " passed.");
        } else {
            System.out.printf("%s failed: expected %.1f, got %.5f\n", testName, expected, result);
        }
    }
}
