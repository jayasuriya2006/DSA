package dsa.graphs.main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {

    //TC - O(V + E)
    //SC - O(V + V + V)
    public static List<Integer> getTopologicalSort(int[][] adj, int v) {
        List<Integer> topoSort = new ArrayList<>();
        int[] indegree = new int[v];

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] adjE : adj) {
            adjList.get(adjE[0]).add(adjE[1]);
            indegree[adjE[1]]++;
        }

        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                que.offer(i);
            }
        }
        while (!que.isEmpty()) {
            int curNode = que.poll();
            topoSort.add(curNode);
            for (int adjNode : adjList.get(curNode)) {
                indegree[adjNode]--;
                if (indegree[adjNode] == 0) {
                    que.offer(adjNode);
                }
            }
        }
        return topoSort;
    }
}
