package dsa.greedy.main;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    //TC - O(N)
    //SC - O(N) - ans
    public static List<List<Integer>> insertInterval(int[][] interval, int[] newInterval) {
        List<List<Integer>> inserted = new ArrayList<>();
        int n = interval.length;
        //left - non overlap
        int i = 0;
        while (i < n && interval[i][1] < newInterval[0]) {
            inserted.add(List.of(interval[i][0], interval[i][1]));
            i++;
        }

        //merge the overlap part
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        while (i < n && newInterval[1] >= interval[i][0]) {
            newStart = Math.min(newStart, interval[i][0]);
            newEnd = Math.max(newEnd, interval[i][1]);
            i++;
        }
        inserted.add(List.of(newStart, newEnd));

        //right non overlap part
        while (i < n) {
            inserted.add(List.of(interval[i][0], interval[i][1]));
            i++;
        }
        return inserted;
    }
}
