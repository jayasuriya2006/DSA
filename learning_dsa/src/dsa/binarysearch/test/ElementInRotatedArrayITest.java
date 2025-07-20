package dsa.binarysearch.test;

import static dsa.binarysearch.main.ElementInRotatedArrayI.findElementInRotatedArray;

public class ElementInRotatedArrayITest {

    public static void main(String[] args) {
        test(new int[]{4, 5, 6, 7, 0, 1, 2}, 0, 4);      // Target present
        test(new int[]{4, 5, 6, 7, 0, 1, 2}, 3, -1);     // Target not present
        test(new int[]{1, 2, 3, 4, 5, 6}, 4, 3);         // No rotation
        test(new int[]{6, 7, 1, 2, 3, 4, 5}, 1, 2);      // Rotated at middle
        test(new int[]{}, 1, -1);                        // Empty array
        test(new int[]{1}, 1, 0);                        // Single element match
        test(new int[]{1}, 2, -1);                       // Single element no match
        test(new int[]{2, 1}, 1, 1);                     // Two elements, rotated
        //test(new int[]{2, 2, 2, 3, 4, 2}, 3, 3);         // With duplicates (if supported)
    }

    public static void test(int[] nums, int target, int expected) {
        int result = findElementInRotatedArray(nums, target);
        System.out.println("Input: " + arrayToString(nums) + ", Target: " + target);
        System.out.println("Expected: " + expected + ", Got: " + result);
        System.out.println(result == expected ? "✅ PASS\n" : "❌ FAIL\n");
    }

    public static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
