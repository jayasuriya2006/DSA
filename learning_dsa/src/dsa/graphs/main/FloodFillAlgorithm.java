package dsa.graphs.main;

public class FloodFillAlgorithm {

    private static final int[] ADJ_ROW = {-1, 0, 1, 0};
    private static final int[] ADJ_COL = {0, 1, 0, -1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldCol = image[sr][sc];
        if (oldCol == color) return image;
        int n = image.length;
        int m = image[0].length;

        int[][] result = new int[n][m];

        for (int i = 0; i < n; i++) {
            System.arraycopy(image[i], 0, result[i], 0, m);
        }
        dfsFloodFill(sr, sc, oldCol, color, result);
        return result;
    }

    private static void dfsFloodFill(int i, int j, int oldCol, int newCol, int[][] result) {
        result[i][j] = newCol;
        for (int l = 0; l < 4; l++) {
            int newRow = i + ADJ_ROW[l];
            int newColm = j + ADJ_COL[l];
            if (newRow >= 0 && newRow < result.length
                    && newColm >= 0 && newColm < result[0].length
                    && result[newRow][newColm] == oldCol) {
                dfsFloodFill(newRow, newColm, oldCol, newCol, result);
            }
        }
    }
}
