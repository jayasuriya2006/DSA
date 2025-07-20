package dsa.stackqueue.main;

import java.util.Stack;

public class LargestRectangleInHistogram {

    //TC - O(2n) + O(2n) + O(n)
    //SC - O(2n) + O(2n)
    public static int findLargestRectangleArea_Brut(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        int[] pse = findPSE(heights);
        int[] nse = findNSE(heights);

        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, (heights[i] * (nse[i] - pse[i] - 1)));
        }
        return maxArea;
    }

    //TC - O(2n)
    //SC - O(n)
    public static int findLargestRectangleArea_Optimal(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int curIndex = stack.pop();
                int pse = stack.isEmpty() ? -1 : stack.peek();
                int nse = i;
                maxArea = Math.max(maxArea, (heights[curIndex] * (nse - pse - 1)));
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int nse = n;
            int pse = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea, (height * (nse - pse - 1)));
        }
        return maxArea;
    }

    private static int[] findPSE(int[] heights) {
        int n = heights.length;
        int[] pse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pse;
    }

    private static int[] findNSE(int[] heights) {
        int n = heights.length;
        int[] nse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nse;
    }
}
