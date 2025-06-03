package dsa.twopointer.main;

public class MaxConsecutiveOnes {
    public static int brute(int[] nums, int k) {
        int maxlen = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int zero = 0;    // Counter to count number of zeros in the current subarray
            for (int j = i; j < n; j++) {
                if (nums[j] == 0) zero++;     // If current element is 0, increase the zero count
                if (zero > k) break;  // If zero count exceeds k, break the inner loop
                maxlen = Math.max(maxlen, j - i + 1);
            }
        }
        return maxlen;
    }


    public static int optimal(int nums[], int k) {
        int left = 0;    // Left pointer of the sliding window
        int right = 0;   // Right pointer of the sliding window
        int zero = 0;    // To count the number of zeros in the current window
        int maxlen = 0;  // To store the maximum length of valid subarray
        while (right < nums.length) {
            // If the current element is 0, increment the zero counter
            if (nums[right] == 0) {
                zero++;
            }
            // If the number of zeros exceeds k, move the left pointer to reduce zeros
            if (zero > k) {
                if (nums[left] == 0) zero--;
                left++;  // Shrink the window from the left
            }
            // Update the maximum length if current window is valid
            if (zero <= k) {
                maxlen = Math.max(maxlen, right - left + 1);
            }
            right++;
        }
        return maxlen;
    }
}

