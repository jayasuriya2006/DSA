package dsa.stackqueue.main;

import java.util.Arrays;

import java.util.Stack;

public class PreviousSmallerElement {

    //TC - O(N^2)
    //SC - O(N)
    public static int[] getPSE_Brut(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    res[i] = arr[j];
                    break;
                }
            }
        }
        return res;
    }

    //TC - O(N)
    //SC - O(2N)
    public static int[] getPSE_Optimal(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(arr[i]);
        }
        return res;
    }
}
