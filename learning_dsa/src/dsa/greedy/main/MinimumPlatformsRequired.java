package dsa.greedy.main;

import java.util.Arrays;

public class MinimumPlatformsRequired {

    //TC - O(2N + 2 NlogN)
    //SC - O(1)
    public static int getMinReqPlatforms(int[] arrival, int[] departure) {
        int reqPlatform = 0;
        int n = arrival.length;
        if (n == 0) {
            return reqPlatform;
        }

        //Observe from outside of railway station based on time, if train arrives increase the count and if departure decrease the count
        Arrays.sort(arrival);
        Arrays.sort(departure);

        //arrival tracker
        int i = 0;
        //departure tracker
        int j = 0;
        //current platform in use count
        int count = 0;
        while (i < n) {
            //arrival
            if (arrival[i] <= departure[j]) {
                count++;
                //since we are observing time based
                i++;
            } else {
                //departure
                count--;
                j++;
            }
            reqPlatform = Math.max(reqPlatform, count);
        }

        return reqPlatform;
    }
}
