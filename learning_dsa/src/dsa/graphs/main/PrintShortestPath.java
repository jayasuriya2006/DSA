package dsa.graphs.main;

import java.util.*;

public class PrintShortestPath {
    //TC - O((V + E) * Log V)
    //SC - O(2V + E)
    public static String getShortest(int v, int src, int des, int[][] edges) {
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
        int[] par = new int[v];
        for (int i = 0; i < v; i++) {
            par[i] = i;
        }
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
                    par[to] = curNode.node;
                    que.offer(new NodeInfo(to, dis[curNode.node] + wei));
                }
            }

        }
        if (dis[des] == Integer.MAX_VALUE) return "No path";
        List<Integer> path = new ArrayList<>();
        int cur = des;
        while (par[cur] != cur) {
            path.add(cur);
            cur = par[cur];
        }
        path.add(src);
        Collections.reverse(path);

        // Convert to string with arrows or spaces
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            str.append(path.get(i));
            if (i != path.size() - 1) str.append(" -> ");
        }

        return str.toString();
    }
}