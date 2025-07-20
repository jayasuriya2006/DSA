package dsa.binarysearch.test;

import static dsa.binarysearch.main.MinShipCapacityWithDDays.getMinCapacityWithDDays;

public class MinShipCapacityWithDDaysTest {
    public static void main(String[] args) {

        runTest(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5, 15, "Test 1");
        runTest(new int[]{3, 2, 2, 4, 1, 4}, 3, 6, "Test 2");
        runTest(new int[]{1, 2, 3, 1, 1}, 4, 3, "Test 3");
        runTest(new int[]{10, 50, 50, 50}, 2, 100, "Test 4");
        runTest(new int[]{5, 5, 5, 5, 5}, 1, 25, "Test 5");
        runTest(new int[]{5, 5, 5, 5, 5}, 5, 5, "Test 6");
    }

    private static void runTest(int[] weights, int days, int expected, String testName) {
        int result = getMinCapacityWithDDays(weights, days);
        if (result == expected) {
            System.out.println(testName + " passed.");
        } else {
            System.out.println(testName + " failed: expected " + expected + ", got " + result);
        }
    }
}
