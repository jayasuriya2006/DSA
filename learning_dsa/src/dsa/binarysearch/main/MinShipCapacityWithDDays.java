package dsa.binarysearch.main;

public class MinShipCapacityWithDDays {

    public static int getMinCapacityWithDDays(int[] weights, int d) {
        int minCap = -1;
        int[] maxAndSum = findMaxAndSum(weights);
        int low = maxAndSum[0];           // one item per day
        int high = maxAndSum[1];          // all item in one day
        while (low <= high) {
            int mid = (low + high) / 2;
            int requiredDaysForMid = getRequiredDaysForMid(weights, mid);

            if (requiredDaysForMid <= d) {
                minCap = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return minCap;
    }

    private static int getRequiredDaysForMid(int[] weights, int capacity) {
        int days = 1;
        int currentDayWeight = weights[0];
        for (int i = 1; i < weights.length; i++) {
            if (weights[i] + currentDayWeight <= capacity) {
                currentDayWeight = currentDayWeight + weights[i];
            } else {
                days++;
                currentDayWeight = weights[i];
            }
        }
        return days;
    }

    private static int[] findMaxAndSum(int[] weights) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int weight : weights) {
            max = Math.max(max, weight);
            sum = sum + weight;
        }

        int[] temp = {max, sum};
        return temp;
    }
}
