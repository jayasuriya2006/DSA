package dsa.array.test;

import dsa.array.main.MergeOverlappingIntervals;

import java.util.ArrayList;
import java.util.List;

public class MergeOverlappingIntervalsTest {
    public static void main(String[] args) {
//        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        List<List<Integer>> expected = new ArrayList<>();
//        expected.add(List.of(1, 6));
//        expected.add(List.of(8, 10));
//        expected.add(List.of(15, 18));
        int[][] intervals1 = {{1, 10}, {2, 3}, {4, 8}};
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(1, 10));

        boolean resPassed = true;
        List<List<Integer>> actual = MergeOverlappingIntervals.mergeIntervals(intervals1);
        if (actual.size() == expected.size()) {
            for (List<Integer> interval : actual) {
                if (!expected.contains(interval)) {
                    resPassed = false;
                }
            }
        } else {
            resPassed = false;
        }

        if (resPassed) {
            System.out.println("....... TEST PASSED.........");
        } else {
            System.out.println("....... TEST FAILED.........");
        }

    }
}
