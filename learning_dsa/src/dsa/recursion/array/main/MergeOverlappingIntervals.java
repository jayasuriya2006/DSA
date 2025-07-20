package dsa.array.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals {

    public static List<List<Integer>> mergeIntervals(int[][] intervals) {
        List<List<Integer>> mergedIntervals = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            if (!mergedIntervals.isEmpty() && mergedIntervals.getLast().getLast() >= start) {
                end = Math.max(end, mergedIntervals.getLast().get(1));
                start = Math.min(start, mergedIntervals.getLast().get(0));
                mergedIntervals.removeLast();
            }
            mergedIntervals.add(List.of(start, end));
        }
        return mergedIntervals;
    }

}
