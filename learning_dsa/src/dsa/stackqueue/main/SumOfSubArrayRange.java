package dsa.stackqueue.main;

import java.util.Stack;

import static dsa.stackqueue.main.SumOfSubArrayMin.sumOfSubArraysMin_Optimal;

public class SumOfSubArrayRange {

    //TC - O(N^2)
    //SC - O(1)
    public static int sumOfSubArrayRange_Brut(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int max = arr[i];
            int min = arr[i];
            for (int j = i; j < n; j++) {
                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);
                sum += (max - min);
            }
        }
        return sum;
    }

    public static int sumOfSubArrayRange_Optimal(int[] arr) {
        int n = arr.length;
        int minSum = sumOfSubArraysMin_Optimal(arr);
        int maxSum = sumOfSubArrayMax(arr);
        return maxSum - minSum;
    }

    private static int sumOfSubArrayMax(int[] arr) {
        int sum = 0;
        int[] pgee = findPGEE(arr);
        int[] nge = findNGE(arr);
        for (int i = 0; i < arr.length; i++) {
            sum += (arr[i] * (i - nge[i]) * (pgee[i] - i));
        }
        return sum;
    }

    //Previous greater element or equal - why equal? since we included the same sub-array in nge
    private static int[] findPGEE(int[] arr) {
        int n = arr.length;
        int[] pgee = new int[n];
        java.util.Stack<Integer> stack = new java.util.Stack<>();

        for (int i = 0; i < n; i++) {
            //not equal
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            pgee[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pgee;
    }

    private static int[] findNGE(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        java.util.Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            nge[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nge;
    }

}
