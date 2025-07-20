package dsa.binarysearch.test;

import static dsa.binarysearch.main.FindPeekInTwoDMatrix.findPeekElementInMatrix;

public class FindPeekInTwoDMatrixTest {
    public static void main(String[] args) {
        runTest(new int[][]{
                {1, 4},
                {3, 2}
        }, "Test 1");

        runTest(new int[][]{
                {10, 8, 10, 10},
                {14, 13, 12, 11},
                {15, 9, 11, 21},
                {16, 17, 19, 20}
        }, "Test 2");

        runTest(new int[][]{
                {1, 2, 3, 6, 5}
        }, "Test 3 (single row)");

        runTest(new int[][]{
                {1},
                {2},
                {3},
                {4}
        }, "Test 4 (single column)");

        runTest(new int[][]{
                {5}
        }, "Test 5 (1x1 matrix)");

        runTest(new int[][]{
                {10, 20, 15},
                {21, 30, 14},
                {7, 16, 32}
        }, "Test 6");
    }

    private static void runTest(int[][] mat, String testName) {
        int[] peak = findPeekElementInMatrix(mat);
        if (isValidPeak(mat, peak[0], peak[1])) {
            System.out.println(testName + " passed. Peak at: " + "[" + peak[0] + "," + peak[1] + "] = " + mat[peak[0]][peak[1]]);
        } else {
            System.out.println(testName + " failed. Invalid peak at: " + "[" + peak[0] + "," + peak[1] + "]");
        }
    }

    private static boolean isValidPeak(int[][] mat, int i, int j) {
        int rows = mat.length;
        int cols = mat[0].length;
        int val = mat[i][j];

        // Check up
        if (i - 1 >= 0 && mat[i - 1][j] >= val) return false;
        // Check down
        if (i + 1 < rows && mat[i + 1][j] >= val) return false;
        // Check left
        if (j - 1 >= 0 && mat[i][j - 1] >= val) return false;
        // Check right
        if (j + 1 < cols && mat[i][j + 1] >= val) return false;

        return true;
    }
}
