package dsa.binarysearch.test;

import static dsa.binarysearch.main.AggressiveCows.getMaxMinDistance;

public class AggressiveCowsTest {
    public static void main(String[] args) {
        runTest(new int[]{1, 2, 4, 8, 9}, 3, 3, "Test 1");
        runTest(new int[]{10, 1, 2, 7, 5}, 2, 9, "Test 2");
        runTest(new int[]{1, 2, 3, 4, 5, 6}, 3, 2, "Test 3");
        runTest(new int[]{1, 3, 7, 9, 13, 15}, 4, 2, "Test 4");
        runTest(new int[]{5, 17, 100, 11}, 2, 95, "Test 5");
        runTest(new int[]{1, 1000000000}, 2, 999999999, "Test 6");
    }

    private static void runTest(int[] positions, int cows, int expected, String testName) {
        int result = getMaxMinDistance(positions, cows);
        if (result == expected) {
            System.out.println(testName + " passed.");
        } else {
            System.out.printf("%s failed: expected %d, got %d\n", testName, expected, result);
        }
    }
}
