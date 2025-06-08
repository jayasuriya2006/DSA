package dsa.greedy.main;

import java.util.Arrays;

public class JobSequencingProblem {


    //TC - O( NLogN + (N * max(deadLine)))
    //SC - O(maxDeadLine)
    public static int[] getMaxProfit(int[][] jobs) {
        int[] res = new int[2];

        //sort the array based on profit
        Arrays.sort(jobs, (a, b) -> b[2] - a[2]);

        //find the max deadline -> for creating a day tracker array
        int maxDeadLine = Integer.MIN_VALUE;
        for (int[] job : jobs) {
            maxDeadLine = Math.max(maxDeadLine, job[1]);
        }
        int[] tracker = new int[maxDeadLine + 1];
        Arrays.fill(tracker, -1);

        int totalProfit = 0;
        int totalJob = 0;
        //iterate jobs
        for (int[] job : jobs) {
            //delay the job as much possible, so that early days can be free
            //find the max day on which this job can perform
            for (int i = job[1]; i > 0; i--) {
                if (tracker[i] == -1) {
                    tracker[i] = job[0];
                    totalProfit = totalProfit + job[2];
                    totalJob = totalJob + 1;
                    break;
                }
            }
        }
        res[0] = totalJob;
        res[1] = totalProfit;
        return res;
    }
}

