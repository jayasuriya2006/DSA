package dsa.binarysearch.main;

public class SmallestDivisorThreshold {

    public static int getSmallestDivisorWithThreshold(int[] nums, int threshold) {
        int low = 1;
        int high = getMax(nums);
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int sumValue = getSumValue(nums, mid);
            if (sumValue <= threshold) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;

    }

    private static int getSumValue(int[] nums, int mid) {
        int count = 0;
        for (int num : nums) {
            if (num % mid == 0) count = count + (num / mid);
            else count = count + (num / mid) + 1;
        }
        return count;
    }

    private static int getMax(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }
}
