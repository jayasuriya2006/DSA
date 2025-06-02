package dsa.array.main;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithKSum {

    //TC - O( n * n * n) commented.... O(n * n)
    //SC - O(1)
    public static int getLongestLengthWithSumK_Brut(int[] arr, int k) {
        int maxLength = 0;
        int n = arr.length;

        // n ^ 3 solution
        //O(n * n * n)
//        for(int i = 0; i < n; i++){
//            for(int j = i ; j < n; j++){
//                int sum = 0;
//                for(int l = i; l <= j; l++){
//                    sum += arr[l];
//                }
//                if(sum == k){
//                   maxLength = Math.max(maxLength,  j - i + 1);
//                }
//            }
//        }

        //improved to n ^ 2
        //O(n * n)
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }

    //If Array contains positives, negatives and zeros this is the optimal solution
    // Pre-sum approach
    //TC - O(n)
    //SC - O(n)
    public static int getLongestLengthWithSumK_Better(int arr[], int k) {
        int maxLen = 0;
        int n = arr.length;

        Map<Integer, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0, -1);
        int preSum = 0;
        for (int i = 0; i < n; i++) {

            preSum = preSum + arr[i];
            if (preSum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }
            int needsToRemove = preSum - k;
            if (preSumMap.containsKey(needsToRemove)) {
                int indexToRemove = preSumMap.get(needsToRemove);
                int curSubArrayLen = i - indexToRemove;
                maxLen = Math.max(maxLen, curSubArrayLen);
            }

            if (!preSumMap.containsKey(preSum)) {
                preSumMap.put(preSum, i);
            }
        }
        return maxLen;
    }

    //if array contains only positive we can still improve the solution with two pointer approach
    //TC - O(2n)
    public static int getLongestLengthWithSumK_Optimal(int[] arr, int k) {
        int n = arr.length;
        int maxLen = 0;

        int left = 0;
        int right = 0;
        int curSum = arr[0];
        while (right < n) {
            //if curSum is greater then decrease the sub array (remove from left)
            while (curSum > k && left <= right) {
                curSum = curSum - arr[left];
                left++;
            }
            //check for the target value
            if (curSum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            // increase the right and add it to curSum
            right++;
            if (right < n) {
                curSum = curSum + arr[right];
            }

        }
        return maxLen;
    }

}
