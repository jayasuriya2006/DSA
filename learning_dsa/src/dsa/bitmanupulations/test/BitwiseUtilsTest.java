package dsa.bitmanupulations.test;

import dsa.bitmanupulations.main.BitwiseUtils;


public class BitwiseUtilsTest {

    public static void main(String[] args){
        BitwiseUtils.swap(3, 5);  // Expected: a = 5, b = 3

        // isIthBitSet
        System.out.println("Is 2nd bit set in 5? " + BitwiseUtils.isIthBitSet(5, 2)); // true (5 = 101)
        System.out.println("Is 1st bit set in 8? " + BitwiseUtils.isIthBitSet(8, 1)); // false (8 = 1000)

        // setTheIthBit
        System.out.println("Set 1st bit in 8: " + BitwiseUtils.setTheIthBit(8, 1));   // 1000 | 0010 = 1010 → 10

        // clearTheIthBit
        System.out.println("Clear 3rd bit in 15: " + BitwiseUtils.clearTheIthBit(15, 3)); // 1111 & ~(1000) = 0111 → 7

        // toggleTheIthBit
        System.out.println("Toggle 0th bit in 10: " + BitwiseUtils.toggleTheIthBit(10, 0)); // 1010 ^ 0001 = 1011 → 11

        // removeLastSetBit
        System.out.println("Remove last set bit of 12: " + BitwiseUtils.removeLastSetBit(12)); // 1100 & 1011 = 1000 → 8

        // isPowerOfTwo
        System.out.println("Is 16 a power of two? " + BitwiseUtils.isPowerOfTwo(16)); // true
        System.out.println("Is 18 a power of two? " + BitwiseUtils.isPowerOfTwo(18)); // false
        System.out.println("Is 0 a power of two? " + BitwiseUtils.isPowerOfTwo(0));   // false

        // countSetBits
        System.out.println("Set bits in 13: " + BitwiseUtils.countSetBits(13)); // 1101 → 3 set bits
    }
}
