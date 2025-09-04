package dsa.graphs.main;

import java.util.*;

public class NoOfWaysToDestination {
    public int countPaths(int n, int[][] roads) {
        int mod = 1_000_000_007;
        long[] dis = new long[n];
        int[] ways = new int[n];

        // Build graph using custom Edge class
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] edge : roads) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new Edge(v, w));
            adj.get(v).add(new Edge(u, w));
        }

        Arrays.fill(dis, Long.MAX_VALUE);
        dis[0] = 0;
        ways[0] = 1;

        PriorityQueue<NodeInfoD> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.dis));
        pq.offer(new NodeInfoD(0, 0));

        while (!pq.isEmpty()) {
            NodeInfoD current = pq.poll();
            int u = current.node;
            long currDist = current.dis;

            //if (currDist > dis[u]) continue;

            for (Edge e : adj.get(u)) {
                int v = e.to;
                long newDist = currDist + e.weight;

                if (newDist < dis[v]) {
                    dis[v] = newDist;
                    ways[v] = ways[u];
                    pq.offer(new NodeInfoD(v, newDist));
                } else if (newDist == dis[v]) {
                    ways[v] = (ways[v] + ways[u]) % mod;
                }
            }
        }

        return ways[n - 1];
    }
}

class Edge {
    int to, weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}
class NodeInfoD {
    int node;
    long dis;
    public NodeInfoD(int node, long dis) {
        this.node = node;
        this.dis = dis;
    }
}
