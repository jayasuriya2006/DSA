package dsa.graphs.main;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] effort = new int[n][m];

        for (int[] row : effort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        effort[0][0] = 0;
        PriorityQueue<CellInfoEffort> pq = new PriorityQueue<>((a, b) -> a.effort - b.effort);
        pq.offer(new CellInfoEffort(0, 0, 0));

        int[] adr = {-1, 0, 1, 0};
        int[] adc = {0, 1, 0, -1};
        while (!pq.isEmpty()) {
            CellInfoEffort curCel = pq.poll();
            int cr = curCel.row;
            int cc = curCel.col;
            int ce = curCel.effort;
            if (cr == n - 1 && cc == m - 1) return ce;
            for (int i = 0; i < 4; i++) {
                int nr = cr + adr[i];
                int nc = cc + adc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    int ef = Math.max(ce, Math.abs(heights[cr][cc] - heights[nr][nc]));
                    if (ef < effort[nr][nc]) {

                        effort[nr][nc] = ef;
                        pq.offer(new CellInfoEffort(nr, nc, ef));
                    }
                }

            }


        }
        return -1;
    }

}

class CellInfoEffort {
    int effort;
    int row;
    int col;

    public CellInfoEffort(int r, int c, int d) {
        row = r;
        col = c;
        effort = d;
    }
}
