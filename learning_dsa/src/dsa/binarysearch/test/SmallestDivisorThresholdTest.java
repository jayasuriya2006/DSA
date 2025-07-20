package dsa.binarysearch.test;

import java.util.Arrays;

import static dsa.binarysearch.main.SmallestDivisorThreshold.getSmallestDivisorWithThreshold;

public class SmallestDivisorThresholdTest {
    public static void main(String[] args) {

        runTest(new int[]{1, 2, 5, 9}, 6, 5, "Test 1");
        runTest(new int[]{2, 3, 5, 7, 11}, 11, 3, "Test 2");
        runTest(new int[]{19}, 5, 4, "Test 3");
        runTest(new int[]{10, 10, 10, 10}, 5, 10, "Test 4");
        runTest(new int[]{100, 200, 300}, 3, 300, "Test 5");
        runTest(fillArray(10, 1_000_000), 10, 1_000_000, "Test 6");
        runTest(new int[]{1, 1, 1, 1}, 4, 1, "Test 7");
        runTest(new int[]{10, 20, 30, 40}, 4, 40, "Test 8");
    }

    private static void runTest(int[] nums, int threshold, int expected, String testName) {
        int result = getSmallestDivisorWithThreshold(nums, threshold);
        if (result == expected) {
            System.out.println(testName + " passed.");
        } else {
            System.out.println(testName + " failed: expected " + expected + ", got " + result);
        }
    }

    private static int[] fillArray(int size, int value) {
        int[] arr = new int[size];
        Arrays.fill(arr, value);
        return arr;
    }
}
