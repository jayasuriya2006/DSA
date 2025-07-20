package dsa.array.main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumProblem {

    //TC - O( n * n)
    //SC- O(1)
    //Take one element and compare with all remaining elements
    public static int[] getTwoIndexesSumAsTar_Brut(int[] arr, int target) {
        int[] result = {-1, -1};
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            //no need to check from zero index, since they are already compared
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }

        }
        //if not found return as -1, -1
        return result;
    }

    //HashMap approach... search for the extra value in map
    //TC - O(N)
    //SC - O(N)
    public static int[] getTwoIndexesSumAsTar_Better(int[] arr, int target) {
        int[] result = {-1, -1};
        int n = arr.length;
        Map<Integer, Integer> indexMapping = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int extraValue = target - arr[i];
            if (indexMapping.containsKey(extraValue)) {
                result[0] = indexMapping.get(extraValue);
                result[1] = i;
                return result;
            }
            indexMapping.put(arr[i], i);
        }
        return result;
    }


    //Two pointer approach... s
    //TC - O(N)
    //SC - O(1)
    //This is not suitable for when we are returning indexes, since we are sorting the given array
    //Still we can achieve by storing the indexes in another data structure before sorting, but previous approach is good compare to this
    public static String getTwoIndexesSumAsTar_Optimal(int[] arr, int target) {

        int n = arr.length;
        Arrays.sort(arr);
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (arr[left] + arr[right] < target) {
                //increase the sum
                left++;
            } else if (arr[left] + arr[right] > target) {
                //decrease the sum
                right--;
            } else {
                return "YES";
            }

        }
        return "NO";
    }

}
