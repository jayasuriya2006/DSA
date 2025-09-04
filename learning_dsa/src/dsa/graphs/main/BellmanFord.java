package dsa.graphs.main;

import java.util.Arrays;

public class BellmanFord {
    //TC - O(V * E)
    //SC - O(V)
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int[] dis = new int[V];
        int max = 100000000;
        Arrays.fill(dis, max);
        dis[src] = 0;
        for(int i = 0; i < V-1; i++){
            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                if(dis[u] != max && dis[v] > dis[u] + w){
                    dis[v] = dis[u] + w;
                }

            }
        }

        //detecting negative cycle
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if(dis[u] != max && dis[v] > dis[u] + w){
                int[] ans = {-1};
                return ans;
            }
        }

        return dis;
    }
}
