package dsa.array.main;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysSumEqualsK {

    //brut
    //TC - O( N^3)
    //SC - O(1)
    public static int getTheSubArrayCountWithSumAsK_Brut(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int l = i; l <= j; l++) {
                    sum += arr[l];
                }
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    //better
    //TC - O( N^2)
    //SC - O(1)
    public static int getTheSubArrayCountWithSumAsK_Better(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    //Optimal
    //TC - O(N)
    //SC - O(N)
    public static int getTheSubArrayCountWithSumAsK_Optimal(int[] arr, int k) {
        int count = 0;
        int prefixSum = 0;

        //prefixSum -> key
        //how many time occurred -> value
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1);


        for (int i = 0; i < arr.length; i++) {
            prefixSum = prefixSum + arr[i];
            int needsToRemove = prefixSum - k;
            if (prefixSumMap.containsKey(needsToRemove)) {
                count += prefixSumMap.get(needsToRemove);
            }
            prefixSumMap.put(prefixSum, prefixSumMap.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
