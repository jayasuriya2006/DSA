package dsa.bitmanupulations.test;

import static dsa.bitmanupulations.main.BitwiseShiftOperations.leftShift;
import static dsa.bitmanupulations.main.BitwiseShiftOperations.rightShift;

public class BitwiseShiftOperationsTest {
    public static void main(String[] args) {
        // LEFT SHIFT TESTS
        System.out.println("5 << 1 = " + leftShift(5, 1));     // 5 * 2 = 10
        System.out.println("3 << 2 = " + leftShift(3, 2));     // 3 * 4 = 12
        System.out.println("1 << 5 = " + leftShift(1, 5));     // 1 * 32 = 32
        System.out.println("-2 << 2 = " + leftShift(-2, 2));   // -2 * 4 = -8

        // RIGHT SHIFT TESTS
        System.out.println("8 >> 1 = " + rightShift(8, 1));    // 8 / 2 = 4
        System.out.println("19 >> 2 = " + rightShift(19, 2));  // 19 / 4 = 4 (integer division)
        System.out.println("1 >> 1 = " + rightShift(1, 1));    // 1 / 2 = 0
        System.out.println("-16 >> 2 = " + rightShift(-16, 2)); // -16 / 4 = -4 (sign preserved)

        // Edge Case: MAX/MIN values
        System.out.println("Integer.MAX_VALUE << 1 = " + leftShift(Integer.MAX_VALUE, 1));
        System.out.println("Integer.MIN_VALUE >> 1 = " + rightShift(Integer.MIN_VALUE, 1));
    }
}
