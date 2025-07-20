package dsa.stackqueue.main;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    //TC - O(n^2)
    //SC - O(N) - answer
    public static int[] getNGE_Brut(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    res[i] = arr[j];
                    break;
                }
            }
        }

        return res;
    }

    //TC - O(2N)
    //SC - O(2N)
    public static int[] getNGE_Optimal(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] >= stack.peek()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }

            stack.push(arr[i]);
        }

        return res;
    }
}
