package dsa.bitmanupulations.main;

/**
 * This class contains a method to find the element that appears only once in an array
 * where every other element appears exactly twice.
 *
 * Concept:
 * - XOR of a number with itself is 0: (a ^ a = 0)
 * - XOR of a number with 0 is the number itself: (a ^ 0 = a)
 * - XOR is both associative and commutative
 * Thus, all elements that appear twice will cancel out, leaving the single element.
 */
public class SingleNumberI {

    /**
     * Finds the element that appears only once in the array.
     * All other elements appear exactly twice.
     *
     * @param arr The input array
     * @return The single number that appears only once
     *
     * Example:
     * Input: [2, 3, 2, 4, 4]
     * Steps:
     * xor = 0 ^ 2 = 2
     * xor = 2 ^ 3 = 1
     * xor = 1 ^ 2 = 3
     * xor = 3 ^ 4 = 7
     * xor = 7 ^ 4 = 3
     * Output: 3 (only number that appears once)
     */
    public static int getTheSingleNumber(int[] arr) {
        int xor = 0;

        for (int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i];  // XOR accumulates and cancels out duplicate elements
        }

        return xor;
    }
}
