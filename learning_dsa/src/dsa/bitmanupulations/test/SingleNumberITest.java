package dsa.bitmanupulations.test;

import dsa.bitmanupulations.main.SingleNumberI;

public class SingleNumberITest {

    /*
    find the number which appears one time, (remaining elements appears two times)

    1. brut - use map and count
    2. optimal - use XOR (XOR with same number will result as 0)
     */

    public static void main(String[] args) {
        // Test case 1
        int[] input1 = {2, 3, 2, 4, 4};
        int expected1 = 3;
        runTest(input1, expected1);

        // Test case 2
        int[] input2 = {5, 1, 5, 1, 7};
        int expected2 = 7;
        runTest(input2, expected2);

        // Test case 3
        int[] input3 = {10};
        int expected3 = 10;
        runTest(input3, expected3);

        // Test case 4
        int[] input4 = {9, 9, 11, 13, 13};
        int expected4 = 11;
        runTest(input4, expected4);
    }

    private static void runTest(int[] input, int expected) {
        int result = SingleNumberI.getTheSingleNumber(input);
        if (result == expected) {
            System.out.println("✅ Test passed! Single number: " + result);
        } else {
            System.out.println("❌ Test failed! Expected: " + expected + ", but got: " + result);
        }
    }
}
