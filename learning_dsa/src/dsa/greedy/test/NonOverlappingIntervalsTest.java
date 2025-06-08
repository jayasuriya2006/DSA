package dsa.greedy.test;

import dsa.greedy.main.NonOverlappingIntervals;

public class NonOverlappingIntervalsTest {

    /*
    Given an array of N intervals in the form of (start[i], end[i]), where start[i] is the starting point of the interval and end[i] is the ending point of the interval, return the minimum number of intervals that need to be removed to make the remaining intervals non-overlapping.
    Examples:
    Input : Intervals = [ [1, 2] , [2, 3] , [3, 4] ,[1, 3] ]
    Output : 1
    Explanation : You can remove the interval [1, 3] to make the remaining interval non overlapping.

    Input : Intervals = [ [1, 3] , [1, 4] , [3, 5] , [3, 4] , [4, 5] ]
    Output : 2
    Explanation : You can remove the intervals [1, 4] and [3, 5] and the remaining intervals becomes non overlapping.
     */

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {1, 4}, {3, 5}, {3, 4}, {4, 5}};
        int expectedOutput = 2;

        int actualOutput = NonOverlappingIntervals.getCountOfOverlappingInterval(intervals);

        if (expectedOutput == actualOutput) {
            System.out.println("............TEST PASSED...........");
        } else {
            System.out.println("............TEST FAILED...........");
        }
    }
}
