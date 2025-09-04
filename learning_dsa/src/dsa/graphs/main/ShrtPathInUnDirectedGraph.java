package dsa.graphs.main;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShrtPathInUnDirectedGraph {

    //TC - O(V²)
    //SC - O(V + V)
    public static int[] getMinDistance(int[][] graph, int startNode){
        int v = graph.length;
        int[] dis = new int[v];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[startNode] = 0;
        Queue<Integer> que = new LinkedList<>();
        que.offer(startNode);

        while(!que.isEmpty()){
            int curNode = que.poll();
            int cDis = dis[curNode];
            for(int i = 0; i < v; i++){
                if(graph[curNode][i] == 1){
                    if(cDis + 1 < dis[i]){
                        dis[i] = cDis + 1;
                        que.offer(i);
                    }
                }
            }

        }
        for(int i = 0 ; i < v; i++){
            if(dis[i] == Integer.MAX_VALUE){
                dis[i] = -1;
            }
        }
        return dis;
    }
}

