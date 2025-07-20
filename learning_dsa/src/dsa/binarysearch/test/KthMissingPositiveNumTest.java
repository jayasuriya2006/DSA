package dsa.binarysearch.test;

import static dsa.binarysearch.main.KthMissingPositiveNum.getKthMissingPositiveNum;

public class KthMissingPositiveNumTest {
    public static void main(String[] args) {
        runTest(new int[]{2, 3, 4, 7, 11}, 5, 9, "Test 1");
        runTest(new int[]{1, 2, 3, 4}, 2, 6, "Test 2");
        runTest(new int[]{5, 6, 7}, 1, 1, "Test 3");
        runTest(new int[]{2}, 1, 1, "Test 4");
        runTest(new int[]{}, 5, 5, "Test 5");
        runTest(new int[]{1, 3, 5, 7, 9}, 4, 8, "Test 6");
        runTest(new int[]{1, 2, 3}, 1000, 1003, "Test 7");
    }

    private static void runTest(int[] nums, int k, int expected, String testName) {
        int result = getKthMissingPositiveNum(nums, k);
        if (result == expected) {
            System.out.println(testName + " passed.");
        } else {
            System.out.printf("%s failed: expected %d, got %d\n", testName, expected, result);
        }
    }
}
