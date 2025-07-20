package dsa.binarysearch.main;

import java.util.Arrays;

public class AggressiveCows {

    //Aggressive cows
    //place cows, such that distance between two cows maximum
    //get the min distance between two cows
    //return the max(min)
    public static int getMaxMinDistance(int[] arr, int cows) {
        Arrays.sort(arr);

        int low = 1;
        int high = arr[arr.length - 1];

        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int placedCows = countCowsForMid(arr, mid);
            if (placedCows >= cows) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private static int countCowsForMid(int[] arr, int mid) {
        int count = 1;
        int lastPlaced = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - lastPlaced < mid) {
                continue;
            } else {
                count++;
                lastPlaced = arr[i];
            }
        }
        return count;
    }
}
