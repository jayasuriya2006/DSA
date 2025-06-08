package dsa.greedy.test;

import dsa.greedy.main.InsertInterval;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervalTest {

    /*
    Given a 2D array Intervals, where Intervals[i] = [start[i], end[i]] represents the start and end of the ith interval, the array represents non-overlapping intervals sorted in ascending order by start[i].
    Given another array newInterval, where newInterval = [start, end] represents the start and end of another interval, insert newInterval into Intervals such that Intervals remain non-overlapping and sorted in ascending order by start[i].
    Return Intervals after the insertion of newInterval.

    Examples:
       Input : Intervals = [ [1, 3] , [6, 9] ] , newInterval = [2, 5]
       Output : [ [1, 5] , [6, 9] ]
       Explanation : After inserting the newInterval the Intervals array becomes [ [1, 3] , [2, 5] , [6, 9] ].
       So to make them non overlapping we can merge the intervals [1, 3] and [2, 5].
       So the Intervals array is [ [1, 5] , [6, 9] ].

       Input : Intervals = [ [1, 2] , [3, 5] , [6, 7] , [8,10] ] , newInterval = [4, 8]
       Output : [ [1, 2] , [3, 10] ]
       Explanation : The Intervals array after inserting newInterval is [ [1, 2] , [3, 5] , [4, 8] , [6, 7] , [8, 10] ].
       We merge the required intervals to make it non overlapping.
       So final array is [ [1, 2] , [3, 10] ].
     */

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}};
        int[] newInterval = {8, 10};

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(1, 2));
        expected.add(List.of(3, 5));
        expected.add(List.of(6, 7));
        expected.add(List.of(8, 10));


        List<List<Integer>> actual = InsertInterval.insertInterval(intervals, newInterval);
        boolean isPassed = true;
        if (actual.size() == expected.size()) {
            for (List<Integer> items : actual) {
                if (!expected.contains(items)) {
                    isPassed = false;
                    break;
                }
            }
        } else {
            isPassed = false;
        }

        if (isPassed) {
            System.out.println("...........TEST PASSED.........");
        } else {
            System.out.println("...........TEST FAILED.........");
        }
    }
}
