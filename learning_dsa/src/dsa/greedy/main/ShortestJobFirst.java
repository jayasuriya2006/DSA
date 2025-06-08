package dsa.greedy.main;

import java.util.Arrays;

public class ShortestJobFirst {

    //TC - O(N + NlogN)
    //SC - O(1)
    public static int getAverageWaitingTime(int[] jobs) {
        int waitingTime = 0;
        int n = jobs.length;
        int totalTime = 0;
        Arrays.sort(jobs);
        for (int job : jobs) {
            waitingTime = waitingTime + totalTime;
            totalTime = waitingTime + job;
        }
        return waitingTime / n;
    }
}
