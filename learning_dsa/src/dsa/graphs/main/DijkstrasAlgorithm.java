package dsa.graphs.main;

import java.util.*;

public class DijkstrasAlgorithm {

    //TC - O((V + E) * Log V)
    //SC - O(V + E)
    public static int[] getMinDistance(int v, int src, int[][] edges) {
        List<List<List<Integer>>> adjWithWeight = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjWithWeight.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int wei = edge[2];
            adjWithWeight.get(from).add(List.of(to, wei));
        }

        PriorityQueue<NodeInfo> que = new PriorityQueue<>((a, b) -> a.dis - b.dis);
        int[] dis = new int[v];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;
        que.offer(new NodeInfo(src, 0));
        while (!que.isEmpty()) {
            NodeInfo curNode = que.poll();
            for (List<Integer> adj : adjWithWeight.get(curNode.node)) {
                int to = adj.get(0);
                int wei = adj.get(1);
                if ((dis[curNode.node] + wei) < dis[to]) {
                    dis[to] = dis[curNode.node] + wei;
                    que.offer(new NodeInfo(to, dis[curNode.node] + wei));
                }
            }

        }
        return dis;
    }
}

class NodeInfo {
    int node;
    int dis;

    public NodeInfo(int node, int dis) {
        this.node = node;
        this.dis = dis;
    }
}
