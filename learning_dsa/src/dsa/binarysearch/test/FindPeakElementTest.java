package dsa.binarysearch.test;

import static dsa.binarysearch.main.FindPeakElement.findPeakElement;

public class FindPeakElementTest {

    private static boolean isValidPeak(int[] nums, int index) {
        int left = index > 0 ? nums[index - 1] : Integer.MIN_VALUE;
        int right = index < nums.length - 1 ? nums[index + 1] : Integer.MIN_VALUE;
        return nums[index] > left && nums[index] > right;
    }

    public static void main(String[] args) {
        int[][] testCases = {
                {1, 2, 3, 1},               // Example 1: peak at index 2 (3)
                {1, 2, 1, 3, 5, 6, 4},      // Example 2: peak at index 1 (2) or 5 (6)
                {1},                        // Single element, peak at index 0
                {2, 1},                     // Peak at index 0
                {1, 2},                     // Peak at index 1
                {3, 4, 3, 2, 1},            // Peak at index 1 (4)
                {1, 2, 3, 4, 5},            // Peak at index 4 (5)
                {5, 4, 3, 2, 1},            // Peak at index 0 (5)
                {1, 3, 20, 4, 1, 0},        // Peak at index 2 (20)
                {10, 20, 15, 2, 23, 90, 67} // Multiple peaks: 1 (20), 5 (90)
        };

        for (int i = 0; i < testCases.length; i++) {
            int resultIndex = findPeakElement(testCases[i]);
            int resultValue = testCases[i][resultIndex];
            boolean valid = isValidPeak(testCases[i], resultIndex);

            System.out.println("Test Case " + (i + 1) +
                    ": Peak at index " + resultIndex +
                    " with value " + resultValue +
                    (valid ? " ✅" : " ❌ INVALID PEAK"));
        }
    }
}
