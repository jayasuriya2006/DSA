package dsa.binarysearch.test;

import static dsa.binarysearch.main.ElementInRotatedArrayII.findElementInRotatedArrayII;
import static dsa.binarysearch.test.ElementInRotatedArrayITest.arrayToString;

public class ElementInRotatedArrayIITest {

    public static void main(String[] args) {
        // Original test cases (updated for boolean return)
        test(new int[]{4, 5, 6, 7, 0, 1, 2}, 0, true);
        test(new int[]{4, 5, 6, 7, 0, 1, 2}, 3, false);
        test(new int[]{1, 2, 3, 4, 5, 6}, 4, true);
        test(new int[]{6, 7, 1, 2, 3, 4, 5}, 1, true);
        test(new int[]{}, 1, false);
        test(new int[]{1}, 1, true);
        test(new int[]{1}, 2, false);
        test(new int[]{2, 1}, 1, true);

        // Duplicate test cases
        test(new int[]{2, 2, 2, 3, 4, 2}, 3, true);
        test(new int[]{1, 1, 1, 1, 1, 1}, 1, true);
        test(new int[]{1, 1, 1, 1, 1, 1}, 2, false);
        test(new int[]{1, 1, 3, 1}, 3, true);
        test(new int[]{3, 1, 1}, 3, true);
        test(new int[]{1, 1, 3, 1}, 1, true);
        test(new int[]{2, 2, 2, 2, 2, 3, 2}, 3, true);
    }

    public static void test(int[] nums, int target, boolean expected) {
        boolean result = findElementInRotatedArrayII(nums, target);
        System.out.println("Input: " + arrayToString(nums) + ", Target: " + target);
        System.out.println("Expected: " + expected + ", Got: " + result);
        System.out.println(result == expected ? "✅ PASS\n" : "❌ FAIL\n");
    }
}
