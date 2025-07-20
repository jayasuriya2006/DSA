package dsa.binarysearch.main;

public class FindPeekInTwoDMatrix {

    public static int[] findPeekElementInMatrix(int[][] matrix) {
        int[] peekPos = {-1, -1};
        if (matrix.length == 0) return peekPos;
        int low = 0;
        int high = matrix[0].length - 1;
        int m = matrix[0].length;
        while (low <= high) {
            int mid = (low + high) / 2;
            int maxRow = findMaxRow(matrix, mid);
            if (checkForPeek(maxRow, mid, matrix)) {
                peekPos[0] = maxRow;
                peekPos[1] = mid;
                return peekPos;
            } else if (mid < m - 1 && matrix[maxRow][mid + 1] > matrix[maxRow][mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return peekPos;
    }

    private static boolean checkForPeek(int row, int col, int[][] m) {
        boolean peek = true;

        if (row > 0) {
            peek = peek && (m[row][col] > m[row - 1][col]);
        }
        if (peek && row < m.length - 1) {
            peek = peek && (m[row][col] > m[row + 1][col]);
        }
        if (peek && col > 0) {
            peek = peek && (m[row][col] > m[row][col - 1]);
        }
        if (peek && col < m[row].length - 1) {
            peek = peek && (m[row][col] > m[row][col + 1]);
        }
        return peek;
    }

    private static int findMaxRow(int[][] matrix, int col) {
        int n = matrix.length;
        int maxRow = 0;
        for (int i = 0; i < n; i++) {
            if (matrix[i][col] > matrix[maxRow][col]) {
                maxRow = i;
            }
        }
        return maxRow;
    }
}
