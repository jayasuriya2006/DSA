package dsa.graphs.main;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultiplicationsReachEnd {
    public int minimumMultiplications(int[] arr, int start, int end) {
        if (start == end) return 0;
        // Your code here
        int[] levels = new int[100000];
        Arrays.fill(levels, -1);
        Queue<Info> q = new LinkedList<>();
        levels[start] = 0;
        q.offer(new Info(start, 0));
        while (!q.isEmpty()) {
            Info cuNumInfo = q.poll();
            int cn = cuNumInfo.num;
            int cs = cuNumInfo.steps;
            for (int e : arr) {
                int nNum = (e * cn) % 100000;
                if (nNum == end) return cs + 1;
                if (levels[nNum] == -1) {
                    levels[nNum] = cs + 1;
                    q.offer(new Info(nNum, cs + 1));

                }
            }
        }
        return -1;
    }
}

class Info {
    int num;
    int steps;

    public Info(int n, int s) {
        num = n;
        steps = s;
    }
}
