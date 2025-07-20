package dsa.bitmanupulations.main;

public class BitwiseUtils {

    /**
     * Swaps two integers using XOR without a temporary variable.
     * XOR property: a ^ b ^ b = a and a ^ b ^ a = b
     */
    public static void swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;   // (a ^ b) ^ b → a
        a = a ^ b;   // (a ^ b) ^ a → b

        System.out.println("Values after swap: a = " + a + ", b = " + b);
    }

    /**
     * Checks if the ith bit is set (1) in the number.
     * Right shift num by i, then AND with 1.
     */
    public static boolean isIthBitSet(int num, int i) {
        return (num >> i & 1) == 1;
    }

    /**
     * Sets (turns on) the ith bit of the number.
     * OR the number with (1 << i)
     */
    public static int setTheIthBit(int num, int i) {
        return num | (1 << i);
    }

    /**
     * Clears (turns off) the ith bit of the number.
     * AND with the complement of (1 << i)
     */
    public static int clearTheIthBit(int num, int i) {
        return num & (~(1 << i));
    }

    /**
     * Toggles the ith bit (flips 0↔1) of the number.
     * XOR with (1 << i)
     */
    public static int toggleTheIthBit(int num, int i) {
        return num ^ (1 << i);
    }

    /**
     * Removes the rightmost (last) set bit of the number.
     * num & (num - 1) turns off the last set bit.
     */
    public static int removeLastSetBit(int num) {
        return num & (num - 1);
    }

    /**
     * Checks if the number is a power of two.
     * Powers of two have only one set bit.
     */
    public static boolean isPowerOfTwo(int num) {
        if (num <= 0) return false; // Important edge case
        return (num & (num - 1)) == 0;
    }

    /**
     * Counts the number of set bits (1s) in the number using Brian Kernighan's algorithm.
     */
    public static int countSetBits(int num) {
        int count = 0;
        while (num != 0) {
            num = num & (num - 1);
            count++;
        }
        return count;
    }
}
