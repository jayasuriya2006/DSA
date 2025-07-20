package dsa.stackqueue.main;

public class TrappingRainwater {

    //TC - O(3N)
    //SC - O(2N)
    public static int getTotalRainWaterStore_Brut(int[] heights) {
        // sum( min(leftMax , rightMax) - height[i])

        int[] leftMax = findLeftMax(heights);
        int[] rightMax = findRightMax(heights);

        int total = 0;
        for (int i = 0; i < heights.length; i++) {
            if (leftMax[i] > heights[i] && rightMax[i] > heights[i]) {
                total += Math.min(leftMax[i], rightMax[i]) - heights[i];
            }
        }
        return total;
    }

    //TC - O(2N)
    //SC - O(N)
    public static int getTotalRainWaterStore_Better(int[] heights) {
        // sum( min(leftMax , rightMax) - height[i])

        //int[] leftMax = findLeftMax(heights);    update the left max during iteration
        int[] rightMax = findRightMax(heights);
        int leftMax = heights[0];

        int total = 0;
        for (int i = 0; i < heights.length; i++) {
            if (leftMax > heights[i] && rightMax[i] > heights[i]) {
                total += Math.min(leftMax, rightMax[i]) - heights[i];
            }
            leftMax = Math.max(leftMax, heights[i]);
        }
        return total;
    }

    //TC - O(N)
    //SC - O(1)
    public static int getTotalRainWaterStore_Optimal(int[] heights) {

        int n = heights.length;
        int total = 0;
        int left = 0;
        int right = n - 1;
        int rightMax = 0;
        int leftMax = 0;

        while (left < right) {
            if (heights[left] <= heights[right]) {
                //since we are processing small height, in opposite side there is a large building
                if (heights[left] < leftMax) {
                    total = total + (leftMax - heights[left]);
                } else {
                    leftMax = heights[left];
                }
                left++;
            } else {
                if (heights[right] < rightMax) {
                    total = total + (rightMax - heights[right]);
                } else {
                    rightMax = heights[right];
                }
                right--;
            }
        }

        return total;
    }


    private static int[] findLeftMax(int[] arr) {
        int[] leftMax = new int[arr.length];
        leftMax[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }
        return leftMax;
    }

    private static int[] findRightMax(int[] arr) {
        int n = arr.length;
        int[] rightMax = new int[n];
        rightMax[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }
        return rightMax;

    }
}
