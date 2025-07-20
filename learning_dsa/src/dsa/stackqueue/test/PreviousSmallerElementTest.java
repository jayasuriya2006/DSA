package dsa.stackqueue.test;

import java.util.Arrays;

import static dsa.stackqueue.main.PreviousSmallerElement.getPSE_Brut;
import static dsa.stackqueue.main.PreviousSmallerElement.getPSE_Optimal;

public class PreviousSmallerElementTest {
    public static void main(String[] args) {
        test(new int[]{4, 5, 2, 10, 8}, new int[]{-1, 4, -1, 2, 2});
        test(new int[]{1, 3, 0, 2, 5}, new int[]{-1, 1, -1, 0, 2});
        test(new int[]{4, 3, 2, 1}, new int[]{-1, -1, -1, -1});
        test(new int[]{1, 2, 3, 4}, new int[]{-1, 1, 2, 3});
        test(new int[]{3, 2, 5, 1, 7}, new int[]{-1, -1, 2, -1, 1});
    }

    private static void test(int[] input, int[] expected) {
        int[] actual = getPSE_Optimal(input);
        boolean passed = Arrays.equals(actual, expected);

        System.out.println("Input:    " + Arrays.toString(input));
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("Actual:   " + Arrays.toString(actual));
        System.out.println(passed ? "✅ Test Passed\n" : "❌ Test Failed\n");
    }
}
