package dsa.graphs.main;

import java.util.*;

public class FindEventualSafeStates {

    //TC - O(V + E) + O(E)
    //SC - O(E) + O(V) + O(V)
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        List<List<Integer>> adjListRev = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjListRev.add(new ArrayList<>());
        }
        int[] indegree = new int[v];
        for (int i = 0; i < v; i++) {
            for (int adjE : graph[i]) {
                adjListRev.get(adjE).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                que.offer(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!que.isEmpty()) {
            int cur = que.poll();
            res.add(cur);
            for (int adjN : adjListRev.get(cur)) {
                indegree[adjN]--;
                if (indegree[adjN] == 0) {
                    que.offer(adjN);
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}
