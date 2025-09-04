package dsa.graphs.main;

import java.util.Arrays;

public class MinCityWithThresholdDis {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        int max = 100000000;
        for (int[] row : dist) {
            Arrays.fill(row, max);
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            dist[u][v] = w;
            dist[v][u] = w;
        }

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

        int ansCity = 0;
        int minCities = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (count <= minCities) {
                minCities = count;
                ansCity = i;
            }
        }
        return ansCity;
    }
}
