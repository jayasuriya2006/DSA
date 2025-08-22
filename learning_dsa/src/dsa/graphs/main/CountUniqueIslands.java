package dsa.graphs.main;

import java.util.HashSet;
import java.util.Set;

public class CountUniqueIslands {

    private static final int[] AD_ROW = {-1, 0, 1, 0};
    private static final int[] AD_COL = {0, 1, 0, -1};
    private static final String MOVES = "URDL";

    //TC - O(N * M) + O(N * M * 4)
    //SC - O(N * M) + O(N * M)
    public static int countNoOfUniqueIslands(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] vis = new boolean[n][m];
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1 && !vis[i][j]) {
                    StringBuilder curMoves = new StringBuilder("C");
                    dfsForDirections(i, j, vis, matrix, curMoves, n, m);
                    set.add(curMoves.toString());
                }
            }
        }
        return set.size();
    }

    private static void dfsForDirections(int i, int j, boolean[][] vis, int[][] matrix,
                                         StringBuilder curMoves, int n, int m) {
        vis[i][j] = true;
        for (int in = 0; in < 4; in++) {
            int nr = i + AD_ROW[in];
            int nc = j + AD_COL[in];
            if (nr >= 0 && nr < n && nc >= 0 && nc < m && matrix[nr][nc] == 1 && !vis[nr][nc]) {
                curMoves.append(MOVES.charAt(in));
                dfsForDirections(nr, nc, vis, matrix, curMoves, n, m);
            }
        }
    }
}
