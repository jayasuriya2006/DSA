package dsa.greedy.main;

import java.util.Arrays;

public class NonOverlappingIntervals {

      /*This is exactly inversion problem of NMeetingsInOneRoom
      There we found non overlapping count, here we need to get overlapping count (n - meetingsCount)
       */

    //TC - O(NlogN + N)
    //SC - O(1)
    public static int getCountOfOverlappingInterval(int[][] intervals) {

        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int nonOverlap = 1;
        int lastIntervalEnd = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= lastIntervalEnd) {
                nonOverlap++;
                lastIntervalEnd = intervals[i][1];
            }
        }

        return n - nonOverlap;
    }
}
