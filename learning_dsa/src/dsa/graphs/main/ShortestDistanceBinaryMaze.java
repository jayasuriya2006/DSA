package dsa.graphs.main;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceBinaryMaze {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
            return -1;
        }
        if (n == 1 && m == 1) return 1;
        int[][] dist = new int[n][m];
        for (
                int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Queue<CellInfoBM> q = new LinkedList<>();
        q.offer(new CellInfoBM(0, 0, 1));
        int[] adr = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] adc = {0, 1, 1, 1, 0, -1, -1, -1};
        while (!q.isEmpty()) {
            CellInfoBM curCel = q.poll();
            int cr = curCel.row;
            int cc = curCel.col;
            int cd = curCel.dis;
            for (int i = 0; i < 8; i++) {
                int nr = cr + adr[i];
                int nc = cc + adc[i];
                if (nr == n - 1 && nc == m - 1) return cd + 1;
                if (nr >= 0 && nr < n && nc >= 0 && nc < m
                        && grid[nr][nc] == 0 && dist[nr][nc] > cd + 1) {
                    dist[nr][nc] = cd + 1;
                    q.offer(new CellInfoBM(nr, nc, cd + 1));
                }
            }
        }

        return -1;
    }
}

class CellInfoBM {
    int dis;
    int row;
    int col;

    public CellInfoBM(int r, int c, int d) {
        row = r;
        col = c;
        dis = d;
    }
}
