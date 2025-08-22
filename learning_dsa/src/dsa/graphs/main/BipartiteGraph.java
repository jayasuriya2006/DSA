package dsa.graphs.main;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BipartiteGraph {

    //TC - O(V) + O(2E)
    //SC - O(2V)
    public static boolean isBipartiteGraphBFS(List<List<Integer>> adj) {
        int v = adj.size();
        //boolean[] vis = new boolean[v];
        int[] colors = new int[v];
        Arrays.fill(colors, -1);
        for (int i = 0; i < v; i++) {
            if (colors[i] == -1) {
                if (!bipartiteGraphCheckBFS(i, adj, colors)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean bipartiteGraphCheckBFS(int node, List<List<Integer>> adj, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        //visited[node] = true;
        colors[node] = 0;
        while (!queue.isEmpty()) {
            int curNode = queue.poll();
            int curColor = colors[curNode];
            for (int adjNode : adj.get(curNode)) {
                if (colors[adjNode] == -1) {
                    colors[adjNode] = curColor ^ 1;
                    queue.offer(adjNode);
                } else if (colors[adjNode] == curColor) {
                    return false;
                }
            }

        }
        return true;
    }

    public boolean isBipartiteBFS(int[][] graph) {
        int v = graph.length;
        int[] colors = new int[v];
        Arrays.fill(colors, -1);

        for (int i = 0; i < v; i++) {
            if (colors[i] == -1 && !bipartiteGraphCheckBFS(i, graph, colors)) {
                return false;
            }
        }
        return true;
    }

    private boolean bipartiteGraphCheckBFS(int start, int[][] graph, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        colors[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                if (colors[neighbor] == -1) {
                    colors[neighbor] = colors[node] ^ 1; // flip color
                    queue.offer(neighbor);
                } else if (colors[neighbor] == colors[node]) {
                    return false; // same color on both ends of an edge
                }
            }
        }
        return true;
    }

    public static boolean isBipartiteDFS(List<List<Integer>> adj) {
        int v = adj.size();
        int[] colors = new int[v];
        Arrays.fill(colors, -1);
        for (int i = 0; i < v; i++) {
            if (colors[i] == -1) {
                if (!bipartiteGraphCheckDFS(i, adj, colors)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean bipartiteGraphCheckDFS(int node, List<List<Integer>> adj, int[] colors) {
        for (int adjNode : adj.get(node)) {
            if (colors[adjNode] == -1) {
                colors[adjNode] = colors[node] ^ 1;
                if (!bipartiteGraphCheckDFS(adjNode, adj, colors)) {
                    return false;
                }
            } else if (colors[adjNode] == colors[node]) {
                return false;
            }
        }
        return true;
    }


}
