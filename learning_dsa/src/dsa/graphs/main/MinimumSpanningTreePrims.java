package dsa.graphs.main;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumSpanningTreePrims {

    //TC - O(E * Log V)
    //SC - O(E + V)
    public int spanningTree(int V, int[][] edges) {
        List<List<List<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(List.of(v, w));
            adj.get(v).add(List.of(u, w));
        }
        // code here
        PriorityQueue<EdgeInfo> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        int sum = 0;
        boolean[] vis = new boolean[V];
        pq.offer(new EdgeInfo(0, 0));
        //vis[0] = true;
        while (!pq.isEmpty()) {
            EdgeInfo curEdge = pq.poll();
            int curNode = curEdge.adjNode;
            int weight = curEdge.w;
            if (vis[curNode]) continue;
            vis[curNode] = true;
            sum += weight;
            for (List<Integer> adjInfo : adj.get(curNode)) {
                int adN = adjInfo.get(0);
                int adW = adjInfo.get(1);
                if (!vis[adN]) {
                    pq.offer(new EdgeInfo(adN, adW));
                }
            }

        }
        return sum;
    }
}

class EdgeInfo {
    int adjNode;
    int w;

    public EdgeInfo(int adjNode, int w) {
        this.adjNode = adjNode;
        this.w = w;
    }
}
