package dsa.stackqueue.test;

import java.util.Arrays;

import static dsa.stackqueue.main.NextGreaterElement.getNGE_Brut;
import static dsa.stackqueue.main.NextGreaterElement.getNGE_Optimal;

public class NextGreaterElementTest {
    public static void main(String[] args) {
        test(new int[]{4, 5, 2, 25}, new int[]{5, 25, 25, -1});
        test(new int[]{9, 7, 5, 3}, new int[]{-1, -1, -1, -1});
        test(new int[]{3, 3, 3}, new int[]{-1, -1, -1});
        test(new int[]{10}, new int[]{-1});
        test(new int[]{1, 3, 2, 4}, new int[]{3, 4, 4, -1});
    }

    private static void test(int[] input, int[] expected) {
        int[] actual = getNGE_Optimal(input);
        boolean passed = Arrays.equals(actual, expected);

        System.out.println("Input:    " + Arrays.toString(input));
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("Actual:   " + Arrays.toString(actual));
        System.out.println(passed ? "✅ Test Passed\n" : "❌ Test Failed\n");
    }
}
