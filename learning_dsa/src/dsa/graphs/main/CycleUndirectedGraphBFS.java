package dsa.graphs.main;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleUndirectedGraphBFS {

    //TC - O(N) + O(2E)
    //SC - O(N) + O(N)
    public static boolean isCycleUndirectedGraphBFS(int v, List<List<Integer>> adj) {
        int n = adj.size();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (bfsForDetectCycleUndirectedGraph(i, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean bfsForDetectCycleUndirectedGraph(int node, List<List<Integer>> adj, boolean[] visited) {
        Queue<NodeParentInfo> queue = new LinkedList<>();
        queue.offer(new NodeParentInfo(node, -1));
        visited[node] = true;
        while (!queue.isEmpty()) {
            NodeParentInfo curNodeInfo = queue.poll();
            int curNode = curNodeInfo.node;
            int curNodeParent = curNodeInfo.parent;
            for (int adjNode : adj.get(curNode)) {
                if (!visited[adjNode]) {
                    visited[adjNode] = true;
                    queue.offer(new NodeParentInfo(adjNode, curNode));
                } else if (adjNode != curNodeParent) {
                    return true;
                }
            }
        }
        return false;
    }
}

class NodeParentInfo {
    int node;
    int parent;

    public NodeParentInfo(int n, int p) {
        this.node = n;
        this.parent = p;
    }
}
