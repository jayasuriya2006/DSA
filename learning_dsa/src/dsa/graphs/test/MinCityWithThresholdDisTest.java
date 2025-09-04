package dsa.graphs.test;

import dsa.graphs.main.MinCityWithThresholdDis;

public class MinCityWithThresholdDisTest {
    public static void main(String[] args) {
        MinCityWithThresholdDis fc = new MinCityWithThresholdDis(); // Rename your class accordingly

        int test = 1;

        runTest(fc, 4, new int[][]{
                {0, 1, 3}, {1, 2, 1}, {2, 3, 4}, {0, 3, 7}
        }, 4, 3, test++); // Expected: 3

        runTest(fc, 5, new int[][]{
                {0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}
        }, 2, 0, test++); // Expected: 0

        runTest(fc, 2, new int[][]{
                {0, 1, 3}
        }, 2, 1, test++); // Both can reach 1 city, return higher index (1)

        runTest(fc, 3, new int[][]{
                {0, 1, 1}, {1, 2, 1}, {0, 2, 2}
        }, 1, 2, test++); // Expected: 2

        runTest(fc, 3, new int[][]{
                {0, 1, 1}, {1, 2, 1}
        }, 1, 2, test++); // Expected: 2

        runTest(fc, 4, new int[][]{
                {0, 1, 1}, {0, 2, 1}, {1, 2, 1}, {1, 3, 1}, {2, 3, 1}
        }, 1, 3, test++); // All can reach 2 cities, return highest index

        runTest(fc, 1, new int[][]{}, 0, 0, test++); // Only one node

        runTest(fc, 3, new int[][]{
                {0, 1, 10}, {1, 2, 10}, {0, 2, 30}
        }, 20, 2, test++); // Expected: 2

        runTest(fc, 4, new int[][]{
                {0, 1, 2}, {1, 2, 2}, {2, 3, 2}
        }, 2, 3, test++); // Expected: 0

        runTest(fc, 4, new int[][]{
                {0, 1, 1}, {1, 2, 1}, {2, 3, 1}, {3, 0, 1}
        }, 1, 3, test++); // All can reach 2 cities, return 3
    }

    private static void runTest(MinCityWithThresholdDis fc, int n, int[][] edges, int threshold, int expected, int testNum) {
        int result = fc.findTheCity(n, edges, threshold);
        if (result == expected) {
            System.out.println("Test " + testNum + " ✅ Passed");
        } else {
            System.out.println("Test " + testNum + " ❌ Failed");
            System.out.println("Expected: " + expected + ", Got: " + result);
        }
    }
}
