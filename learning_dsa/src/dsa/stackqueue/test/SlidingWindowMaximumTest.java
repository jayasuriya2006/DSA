package dsa.stackqueue.test;

import java.util.Arrays;
import java.util.List;

import static dsa.stackqueue.main.SlidingWindowMaximum.getSlidingWindowMax_Brut;
import static dsa.stackqueue.main.SlidingWindowMaximum.getSlidingWindowMax_Optimal;

public class SlidingWindowMaximumTest {
    public static void main(String[] args) {

        int[][] inputs = {
                {1, 3, -1, -3, 5, 3, 6, 7},
                {9, 11},
                {4, -2},
                {1},
                {1, 2, 3, 4, 5},
                {5, 4, 3, 2, 1},
                {1, 3, 1, 2, 0, 5}
        };

        int[] ks = {3, 2, 2, 1, 3, 3, 3};

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(3, 3, 5, 5, 6, 7),
                Arrays.asList(11),
                Arrays.asList(4),
                Arrays.asList(1),
                Arrays.asList(3, 4, 5),
                Arrays.asList(5, 4, 3),
                Arrays.asList(3, 3, 2, 5)
        );

        for (int i = 0; i < inputs.length; i++) {
            List<Integer> result = getSlidingWindowMax_Optimal(inputs[i], ks[i]);

            System.out.println("Test case " + (i + 1));
            System.out.print("Input:    ");
            printArray(inputs[i]);
            System.out.println("Window k: " + ks[i]);
            System.out.print("Expected: ");
            System.out.println(expected.get(i));
            System.out.print("Actual:   ");
            System.out.println(result);
            System.out.println(result.equals(expected.get(i)) ? "✅ Passed" : "❌ Failed");
            System.out.println("-----------");
        }
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
