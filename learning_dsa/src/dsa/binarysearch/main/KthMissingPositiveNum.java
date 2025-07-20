package dsa.binarysearch.main;

public class KthMissingPositiveNum {

    //nums = [2,3,4,7,11], k = 5     => 9
    //       [1,2,3,4,5]    -> actual
    //       [1, 1, 1, 3, 6]  -> till missing
    public static int getKthMissingPositiveNum(int[] nums, int k) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int missing = nums[mid] - (mid + 1);
            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if(high < 0) return k;
        return nums[high] + (k - (nums[high] - (high + 1)));
    }
}
