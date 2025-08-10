package dsa.graphs.main;

import java.util.List;

import static dsa.graphs.main.GraphsTraversals.getAdjListFromAdjMatrix;

public class NumberOfProvinces {

    public static int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;
        //List<List<Integer>> adjList = getAdjListFromAdjMatrix(v, isConnected);

        boolean[] visited = new boolean[v];
        int count = 0;
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                count++;
                dfs_countProvinces(i, isConnected, visited);
            }
        }
        return count;
    }

    private static void dfs_countProvinces(int curNode, int[][] adj, boolean[] visited) {
        visited[curNode] = true;
        for (int i = 0; i < adj[curNode].length; i++) {
            if (adj[curNode][i] == 1 && !visited[i]) {
                dfs_countProvinces(i, adj, visited);
            }
        }
    }
}
