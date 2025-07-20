package dsa.array.main;

public class MaxSumSubArray {

    //TC - O ( n * n * n)
    //SC - O(1)
    public static int getMaxSubArraySum_Brut(int[] arr) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        //consider empty sub array (ask interviewer)
        maxSum = Math.max(maxSum, 0);
        return maxSum;
    }

    //TC - O ( n * n)
    //SC - O(1)
    public static int getMaxSubArraySum_Better(int[] arr) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        //consider empty sub array (ask interviewer)
        maxSum = Math.max(maxSum, 0);
        return maxSum;
    }

    //TC - O (n)
    //SC - O(1)
    public static int getMaxSubArraySum_Optimal(int[] arr) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;

        //require if we return the subArray
        int subArrayStartTemp = 0;
        int subArrayStart = 0;
        int subArrayEnd = 0;

        int cSum = 0;
        for (int i = 0; i < n; i++) {
            if (cSum == 0) {
                subArrayStartTemp = i;
            }

            cSum = cSum + arr[i];
            if (cSum > maxSum) {
                maxSum = cSum;
                subArrayStart = subArrayStartTemp;
                subArrayEnd = i;
            }

            //There is no meaning to carry negative values
            //example cSum -1, and next element is 5. if we carry -1 then cSum will be 4. but 5 is more. (sample applicable for negative values)
            if (cSum < 0) {
                cSum = 0;
            }

        }
        //consider empty sub array (ask interviewer)
        maxSum = Math.max(maxSum, 0);
        return maxSum;
    }
}
