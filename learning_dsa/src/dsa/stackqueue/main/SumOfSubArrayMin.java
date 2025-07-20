package dsa.stackqueue.main;

import java.util.Stack;

public class SumOfSubArrayMin {

    //TC - O(N^2)
    //SC - O(1)
    public static int sumOfSubArraysMin_Brut(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            for (int j = i; j < arr.length; j++) {
                min = Math.min(min, arr[j]);
                sum += min;
            }
        }
        return sum;
    }

    //TC - O(2n) + O(2n) + O(n)
    //SC - O(2n) + O(2n)
    public static int sumOfSubArraysMin_Optimal(int[] arr) {
        int sum = 0;
        int[] psee = findPSEE(arr);
        int[] nse = findNSE(arr);
        for (int i = 0; i < arr.length; i++) {
            sum += (arr[i] * (i - nse[i]) * (psee[i] - i));
        }
        return sum;
    }

    //Previous smaller element or equal - why equal? since we included the same sub-array in nse
    private static int[] findPSEE(int[] arr) {
        int n = arr.length;
        int[] psee = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            //not equal
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            psee[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return psee;
    }

    private static int[] findNSE(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nse;
    }
}
