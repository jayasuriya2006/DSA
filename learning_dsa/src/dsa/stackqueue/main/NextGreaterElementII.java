package dsa.stackqueue.main;

import java.util.Stack;

public class NextGreaterElementII {

    //TC - O(2n) + O(n)
    //SC - O(n)
    public static int[] getNGE_Circular(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];

        Stack<Integer> stack = new Stack<>();

        //since circular array 2*n
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i % n] >= stack.peek()) {
                stack.pop();
            }

            if (i <= n - 1) {
                res[i] = stack.isEmpty() ? -1 : stack.peek();
            }

            stack.push(arr[i % n]);
        }
        return res;
    }
}
