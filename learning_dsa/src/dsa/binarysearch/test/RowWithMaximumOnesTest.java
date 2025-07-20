package dsa.binarysearch.test;

import static dsa.binarysearch.main.RowWithMaximumOnes.rowWithMaxOnes;

public class RowWithMaximumOnesTest {
    public static void main(String[] args) {
        runTest(new int[][]{
                {0, 0, 0, 1},
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0}
        }, 2, "Test 1");

        runTest(new int[][]{
                {0, 0},
                {0, 0},
                {0, 0}
        }, -1, "Test 2 (all zeros)");

        runTest(new int[][]{
                {0, 1, 1},
                {1, 1, 1},
                {0, 0, 1}
        }, 1, "Test 3");

        runTest(new int[][]{
                {1, 1},
                {1, 1},
                {1, 1}
        }, 0, "Test 4 (all rows equal)");

        runTest(new int[][]{}, -1, "Test 5 (empty matrix)");

        runTest(new int[][]{
                {0, 0, 1, 1},
                {0, 0, 0, 1},
                {0, 1, 1, 1},
                {1, 1, 1, 1}
        }, 3, "Test 6");

        runTest(new int[][]{
                {0},
                {1}
        }, 1, "Test 7");
    }

    private static void runTest(int[][] matrix, int expected, String testName) {
        int result = rowWithMaxOnes(matrix);
        if (result == expected) {
            System.out.println(testName + " passed.");
        } else {
            System.out.printf("%s failed: expected %d, got %d\n", testName, expected, result);
        }
    }
}
