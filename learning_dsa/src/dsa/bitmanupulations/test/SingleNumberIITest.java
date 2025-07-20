package dsa.bitmanupulations.test;

import dsa.bitmanupulations.main.SingleNumberII;

public class SingleNumberIITest {

        /*
    find the number which appears one time, (remaining elements appears three times)

    1. brut - use map and count
    2. better - sort and compare
    2. optimal - needs to think
     */

    public static void main(String[] args) {
        // Test case 1
        int[] input1 = {5, 5, 5, 2, 3, 3, 3};
        int expected1 = 2;
        runTest(input1, expected1);

        // Test case 2
        int[] input2 = {7, 7, 8, 7};
        int expected2 = 8;
        runTest(input2, expected2);

        // Test case 3
        int[] input3 = {1, 1, 1, 9, 2, 2, 2};
        int expected3 = 9;
        runTest(input3, expected3);

        // Test case 4
        int[] input4 = {0, 0, 0, 11};
        int expected4 = 11;
        runTest(input4, expected4);
    }

    private static void runTest(int[] input, int expected) {
        int result = SingleNumberII.getSingleNumber(input);
        if (result == expected) {
            System.out.println("✅ Test passed! Single number: " + result);
        } else {
            System.out.println("❌ Test failed! Expected: " + expected + ", but got: " + result);
        }
    }
}
