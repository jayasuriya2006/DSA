package dsa.binarysearch.main;

public class KoKoEatingBananas {

    public static int minEatingSpeedPerHour(int[] bananas, int minHour) {
        int low = 1;
        int high = findMax(bananas);          // each element can take 1 hour

        int ans = high;
        while (low <= high) {
            int mid = (low + high) / 2;
            int totalHoursForMid = getTotalHoursRequired(bananas, mid);
            if (totalHoursForMid <= minHour) {        // can eat with in minHour or less, so decrease the perHour and check
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static int getTotalHoursRequired(int[] bananas, int perHour) {
        int totalHours = 0;
        for (int i = 0; i < bananas.length; i++) {
            if (bananas[i] % perHour == 0) {
                totalHours = totalHours + (bananas[i] / perHour);
            } else {
                totalHours = totalHours + (bananas[i] / perHour) + 1;
            }
        }
        return totalHours;
    }

    private static int findMax(int[] bananas) {
        int max = bananas[0];
        for (int i = 1; i < bananas.length; i++) {
            max = Math.max(max, bananas[i]);
        }
        return max;
    }
}
