package dsa.stackqueue.test;

import java.util.Arrays;

import static dsa.stackqueue.main.TrappingRainwater.*;

public class TrappingRainwaterTest {
    public static void main(String[] args) {
        test(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}, 6);
        test(new int[]{4, 2, 0, 3, 2, 5}, 9);
        test(new int[]{1, 0, 2, 1, 0, 1, 3}, 5);
        test(new int[]{2, 1, 0, 2}, 3);
        test(new int[]{2, 0, 2}, 2);
        test(new int[]{3, 0, 0, 2, 0, 4}, 10);
    }

    private static void test(int[] height, int expected) {
        int actual = getTotalRainWaterStore_Optimal(height);
        boolean passed = actual == expected;

        System.out.println("Input:    " + Arrays.toString(height));
        System.out.println("Expected: " + expected);
        System.out.println("Actual:   " + actual);
        System.out.println(passed ? "✅ Test Passed\n" : "❌ Test Failed\n");
    }
}
