package dsa.stackqueue.main;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMaximum {

    //TC - O((n - k) * k)
    //SC - O(1)
    public static List<Integer> getSlidingWindowMax_Brut(int[] arr, int k) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i <= arr.length - k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, arr[j]);
            }
            answer.add(max);
        }
        return answer;
    }

    //TC - O(2n)
    //SC - O(n)
    public static List<Integer> getSlidingWindowMax_Optimal(int[] arr, int k) {
        List<Integer> answer = new ArrayList<>();

        Deque<Integer> dequeue = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {

            while (!dequeue.isEmpty() && dequeue.peekFirst() <= i - k) {
                dequeue.removeFirst();
            }

            while (!dequeue.isEmpty() && arr[dequeue.peekLast()] < arr[i]) {
                dequeue.removeLast();
            }

            dequeue.offerLast(i);
            if (i >= k - 1) {
                answer.add(arr[dequeue.peekFirst()]);
            }

        }
        return answer;
    }
}

