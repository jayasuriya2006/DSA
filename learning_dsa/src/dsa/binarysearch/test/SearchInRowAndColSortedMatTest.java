package dsa.binarysearch.test;

import static dsa.binarysearch.main.SearchInRowAndColSortedMat.isMatContains;

public class SearchInRowAndColSortedMatTest {
    public static void main(String[] args) {
        runTest(new int[][]{
                {1, 4, 7, 11},
                {2, 5, 8, 12},
                {3, 6, 9, 16},
                {10, 13, 14, 17}
        }, 5, true, "Test 1");

        runTest(new int[][]{
                {1, 4, 7, 11},
                {2, 5, 8, 12},
                {3, 6, 9, 16},
                {10, 13, 14, 17}
        }, 15, false, "Test 2");

        runTest(new int[][]{{1}}, 1, true, "Test 3 (1x1 matrix, present)");
        runTest(new int[][]{{1}}, 2, false, "Test 4 (1x1 matrix, not present)");

        runTest(new int[][]{
                {1, 3, 5},
                {2, 6, 9},
                {3, 6, 12}
        }, 6, true, "Test 5 (multiple occurrences)");

        runTest(new int[][]{}, 1, false, "Test 6 (empty matrix)");

        runTest(new int[][]{{}}, 3, false, "Test 7 (empty row)");

        runTest(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }, 9, true, "Test 8 (last element)");

        runTest(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }, 0, false, "Test 9 (less than min)");

        runTest(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }, 10, false, "Test 10 (greater than max)");
    }

    private static void runTest(int[][] matrix, int target, boolean expected, String testName) {
        boolean result = isMatContains(matrix, target);
        if (result == expected) {
            System.out.println(testName + " passed.");
        } else {
            System.out.printf("%s failed: expected %b, got %b\n", testName, expected, result);
        }
    }
}
