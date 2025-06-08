package dsa.greedy.test;

import dsa.greedy.main.ShortestJobFirst;

public class ShortestJobFirstTest {
    /*
    A software engineer is tasked with using the shortest job first (SJF) policy to calculate the average waiting time for each process. The shortest job first also known as shortest job next (SJN) scheduling policy selects the waiting process with the least execution time to run next.
    Given an array of n integers representing the burst times of processes, determine the average waiting time for all processes and return the closest whole number that is less than or equal to the result.

    Examples:
       Input : bt = [4, 1, 3, 7, 2]   0,0  0,1  1, 3  3,6
       Output : 5
       Explanation : The total waiting time is 20.
             So the average waiting time will be 20/5 => 4.

      Input : bt = [1, 2, 3, 4]
      Output : 2
      Explanation : The total waiting time is 10.
           So the average waiting time will be 10/4 => 2.
     */
    public static void main(String[] args) {

        int[] jobs = {4, 1, 3, 7, 2};

        int expectedAvgWaitTime = 5;

        int actualWaitTime = ShortestJobFirst.getAverageWaitingTime(jobs);
        if (actualWaitTime == expectedAvgWaitTime) {
            System.out.println("..........TEST PASSED.........");
        } else {
            System.out.println("..........TEST FAILED.........");
        }

    }
}
