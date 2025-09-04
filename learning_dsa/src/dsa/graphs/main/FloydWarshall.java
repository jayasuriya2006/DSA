package dsa.graphs.main;

public class FloydWarshall {

    //TC - O(N ^ 3)
    //SC - O(N ^ 2)
    public int[][] floydWarshall(int[][] dist) {
        // Code here
        int n = dist.length;
        int max = 100000000;
        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }
        for (int via = 0; via < n; via++) {
            for (int u = 0; u < n; u++) {
                for (int v = 0; v < n; v++) {
                    if (dist[u][via] != max && dist[via][v] != max &&
                            dist[u][v] > dist[u][via] + dist[via][v]) {
                        dist[u][v] = dist[u][via] + dist[via][v];
                    }
                }
            }
        }

        //detect cycle
        for (int i = 0; i < n; i++) {
            if (dist[i][i] < 0) {
                int[][] ans = new int[1][1];
                ans[0][0] = -1;
                return ans;
            }
        }
        return dist;
    }
}
