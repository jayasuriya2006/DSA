package dsa.graphs.main;

import java.util.LinkedList;
import java.util.Queue;

public class DisOfNearestZeroCell {
    private static final int[] AD_ROW = {-1, 0, 1, 0};
    private static final int[] AD_COL = {0, 1, 0, -1};

    //TC - O(N*M) + O(N*M*4)
    //SC - O(N*M) + O(N*M)
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][] disM = new int[n][m];
        Queue<NodeWithDis> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    que.add(new NodeWithDis(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }

        while (!que.isEmpty()) {
            NodeWithDis curNode = que.remove();
            int cr = curNode.row;
            int cc = curNode.col;
            int cd = curNode.dis;
            disM[cr][cc] = cd;
            for (int i = 0; i < 4; i++) {
                int nr = cr + AD_ROW[i];
                int nc = cc + AD_COL[i];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc]) {
                    que.add(new NodeWithDis(nr, nc, cd + 1));
                    vis[nr][nc] = true;
                }
            }

        }

        return disM;
    }
}

class NodeWithDis {
    int row;
    int col;
    int dis;

    public NodeWithDis(int r, int c, int d) {
        this.row = r;
        this.col = c;
        this.dis = d;
    }
}

