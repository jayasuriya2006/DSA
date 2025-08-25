package dsa.graphs.main;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleInDirectedGraphDFS {

    //TC - O(V + E)
    //SC - (V + V + V)
    public static boolean isDirectedGraphHasCycleDFS(int v, int[][] adj) {
        boolean[] vis = new boolean[v];
        boolean[] pathVis = new boolean[v];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] adjElements : adj) {
            adjList.get(adjElements[0]).add(adjElements[1]);
        }
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                if (isDirectedGraphHasCycleDFS_H(i, adjList, vis, pathVis)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isDirectedGraphHasCycleDFS_H(int node, List<List<Integer>> adjList, boolean[] vis, boolean[] pathVis) {
        vis[node] = true;
        pathVis[node] = true;
        for (int adjNode : adjList.get(node)) {
            if (!vis[adjNode]) {
                if (isDirectedGraphHasCycleDFS_H(adjNode, adjList, vis, pathVis)) {
                    return true;
                }
            } else if (pathVis[adjNode]) {
                return true;
            }
        }
        pathVis[node] = false;
        return false;
    }
}
