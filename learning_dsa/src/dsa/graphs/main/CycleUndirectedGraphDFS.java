package dsa.graphs.main;

import java.util.List;

public class CycleUndirectedGraphDFS {

    //TC - O(N) + O(2E)
    //SC - O(N) + O(N)
    public static boolean isCycleUndirectedGraphBFS(int v, List<List<Integer>> adj) {
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (dfsForDetectCycleUndirectedGraph(i, adj, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfsForDetectCycleUndirectedGraph(int node, List<List<Integer>> adj, boolean[] vis, int parent) {
        vis[node] = true;
        for (int adjNode : adj.get(node)) {
            if (!vis[adjNode]) {
                if (dfsForDetectCycleUndirectedGraph(adjNode, adj, vis, node)) {
                    return true;
                }
            } else if (vis[adjNode] && adjNode != parent) {
                return true;
            }
        }
        return false;
    }
}
