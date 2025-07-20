package dsa.binarysearch.test;
import dsa.binarysearch.main.SearchInATwoDMatrix;

import static dsa.binarysearch.main.SearchInATwoDMatrix.searchMatrix;
import static dsa.binarysearch.main.SearchInATwoDMatrix.searchMatrix_matrixTrans;

public class SearchInATwoDMatrixTest {

    public static void main(String[] args) {
        runTest(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        }, 3, true, "Test 1");

        runTest(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        }, 13, false, "Test 2");

        runTest(new int[][]{{1}}, 1, true, "Test 3 (single element, present)");

        runTest(new int[][]{{1}}, 0, false, "Test 4 (single element, not present)");

        runTest(new int[][]{}, 1, false, "Test 5 (empty matrix)");

        runTest(new int[][]{{}}, 1, false, "Test 6 (empty row)");

        runTest(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }, 9, true, "Test 7 (last element)");

        runTest(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }, 0, false, "Test 8 (less than min)");

        runTest(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }, 10, false, "Test 9 (greater than max)");
    }

    private static void runTest(int[][] matrix, int target, boolean expected, String testName) {
        boolean result = searchMatrix_matrixTrans(matrix, target);
        if (result == expected) {
            System.out.println(testName + " passed.");
        } else {
            System.out.printf("%s failed: expected %b, got %b\n", testName, expected, result);
        }
    }
}


