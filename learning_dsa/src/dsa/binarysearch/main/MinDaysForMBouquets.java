package dsa.binarysearch.main;

public class MinDaysForMBouquets {

    //K - flowers required to make one bouquet
    public static int getMinDaysForMBouquets(int[] bloomDays, int m, int k) {
        if (k * m > bloomDays.length) {
            return -1;
        }

        int ans = -1;
        int[] minMax = findMinMax(bloomDays);

        int low = minMax[0];            //bloom at least 1 flower
        int high = minMax[1];           // bloom all flower

        while (low <= high) {
            int mid = (low + high) / 2;
            int noOfBouquetsForDayMid = findNoOfBouquetsForDayMid(bloomDays, k, mid);
            if (noOfBouquetsForDayMid >= m) {
                ans = mid;
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private static int findNoOfBouquetsForDayMid(int[] bloomDays, int k, int mid) {
        int count = 0;
        int flowers = 0;
        for (int i = 0; i < bloomDays.length; i++) {
            if (bloomDays[i] <= mid) {
                flowers++;
            } else {
                count += (flowers / k);
                flowers = 0;
            }
        }
        count += (flowers / k);
        return count;
    }

    private static int[] findMinMax(int[] bloomDay) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            min = Math.min(day, min);
            max = Math.max(day, max);
        }
        int[] temp = new int[2];
        temp[0] = min;
        temp[1] = max;
        return temp;

    }
}
