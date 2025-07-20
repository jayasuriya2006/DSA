package dsa.stackqueue.main;

import static dsa.stackqueue.main.LargestRectangleInHistogram.findLargestRectangleArea_Optimal;

public class MaxRectangleAreaInMatrix {

    public static int maxRectangleAreaInMatrix(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;

        int[][] heights = new int[n][m];
        heights[0] = matrix[0];
        for (int col = 0; col < m; col++) {
            for (int row = 1; row < n; row++) {
                heights[row][col] = matrix[row][col] == 0 ? 0 : heights[row - 1][col] + 1;
            }
        }

        int maxArea = 0;
        for (int row = 0; row < n; row++) {
            maxArea = Math.max(maxArea, findLargestRectangleArea_Optimal(heights[row]));
        }
        return maxArea;
    }
}
