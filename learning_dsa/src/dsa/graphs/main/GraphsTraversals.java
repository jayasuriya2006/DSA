package dsa.graphs.main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphsTraversals {

    //TC - O(N) + O(2E)
    //SC - O(N) + O(N)
    public static List<List<Integer>> bfsFromAdjList(int vertices, List<List<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[vertices];
        queue.offer(0);   //if it's one based, then put one
        visited[0] = true;
        List<List<Integer>> bfsRes = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int curNode = queue.poll();
                curLevel.add(curNode);
                for (int adjNode : adj.get(curNode)) {
                    if (!visited[adjNode]) {
                        visited[adjNode] = true;
                        queue.offer(adjNode);
                    }
                }
            }
            bfsRes.add(curLevel);
        }
        return bfsRes;
    }

    public static List<List<Integer>> bfsFromAdjMatrix(int vertices, int[][] adjMatrix) {
        List<List<Integer>> adjList = getAdjListFromAdjMatrix(vertices, adjMatrix);
        return bfsFromAdjList(vertices, adjList);
    }

    public static List<List<Integer>> getAdjListFromAdjMatrix(int vertices, int[][] adjMatrix) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
            for (int j = 0; j < vertices; j++) {
                if (adjMatrix[i][j] == 1) {
                    adjList.get(i).add(j);
                }
            }

        }
        return adjList;
    }

    //TC - O(N) + O(2E)
    //SC - O(N) + O(N)
    public static List<Integer> dfsFromAdjList(int vertices, List<List<Integer>> adj) {
        boolean[] visited = new boolean[vertices];
        List<Integer> dfsRes = new ArrayList<>();
        dfs(0, adj, dfsRes, visited);
        return dfsRes;
    }

    private static void dfs(int curNode, List<List<Integer>> adj, List<Integer> dfsRes, boolean[] visited) {
        visited[curNode] = true;
        dfsRes.add(curNode);
        for (int adjNode : adj.get(curNode)) {
            if (!visited[adjNode]) {
                dfs(adjNode, adj, dfsRes, visited);
            }
        }
    }

    public static List<Integer> dfsFromAdjMatrix(int vertices, int[][] adjMatrix) {
        List<List<Integer>> adjList = getAdjListFromAdjMatrix(vertices, adjMatrix);
        return dfsFromAdjList(vertices, adjList);
    }

}
