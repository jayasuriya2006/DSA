package dsa.graphs.main;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    private static final int[] ADJ_ROW = {-1, 0, 1, 0};
    private static final int[] ADJ_COL = {0, 1, 0, -1};

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;

        int freshCount = 0;
        Queue<CellInfoRottenOranges> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new CellInfoRottenOranges(i, j, 0));
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        int minTime = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                CellInfoRottenOranges curCell = queue.poll();
                int curRow = curCell.row;
                int curCol = curCell.col;
                int curTime = curCell.time;
                minTime = curTime;
                for (int l = 0; l < 4; l++) {
                    int newRow = curRow + ADJ_ROW[l];
                    int newColm = curCol + ADJ_COL[l];
                    if (newRow >= 0 && newRow < n
                            && newColm >= 0 && newColm < m
                            && grid[newRow][newColm] == 1) {
                        grid[newRow][newColm] = 2;
                        queue.offer(new CellInfoRottenOranges(newRow, newColm, curTime + 1));
                        freshCount--;

                    }
                }

            }
        }
        if (freshCount != 0) return -1;
        return minTime;
    }
}

class CellInfoRottenOranges {
    int row;
    int col;
    int time;

    public CellInfoRottenOranges(int r, int c, int t) {
        this.row = r;
        this.col = c;
        this.time = t;
    }
}

