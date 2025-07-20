package dsa.stackqueue.test;

import java.util.Arrays;

import static dsa.stackqueue.main.NextGreaterElementII.getNGE_Circular;

public class NextGreaterElementIITest {
    public static void main(String[] args) {
        test(new int[]{1, 2, 1}, new int[]{2, -1, 2});
        test(new int[]{5, 4, 3, 2, 1}, new int[]{-1, 5, 5, 5, 5});
        test(new int[]{2, 2, 2}, new int[]{-1, -1, -1});
        test(new int[]{3, 8, 4, 1, 2}, new int[]{8, -1, 8, 2, 3});
        test(new int[]{6, 1, 2, 3, 4, 5}, new int[]{-1, 2, 3, 4, 5, 6});
    }

    private static void test(int[] input, int[] expected) {
        int[] actual = getNGE_Circular(input);
        boolean passed = Arrays.equals(actual, expected);

        System.out.println("Input:    " + Arrays.toString(input));
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("Actual:   " + Arrays.toString(actual));
        System.out.println(passed ? "✅ Test Passed\n" : "❌ Test Failed\n");
    }
}
