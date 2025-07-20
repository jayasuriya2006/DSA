package dsa.bitmanupulations.test;

import static dsa.bitmanupulations.main.BitwiseOperations.*;

public class BitwiseOperationsTest {
    public static void main(String[] args) {
        System.out.println("**************** AND ****************");
        System.out.println("12 & 10 = " + doAnd(12, 10));   // 1100 & 1010 = 1000 → 8
        System.out.println("7 & 3 = " + doAnd(7, 3));       // 0111 & 0011 = 0011 → 3
        System.out.println("0 & 0 = " + doAnd(0, 0));       // 0000 & 0000 = 0000 → 0
        System.out.println("15 & 1 = " + doAnd(15, 1));     // 1111 & 0001 = 0001 → 1
        System.out.println("5 & 2 = " + doAnd(5, 2));       // 0101 & 0010 = 0000 → 0
        System.out.println("255 & 170 = " + doAnd(255, 170)); // 11111111 & 10101010 = 10101010 → 170
        System.out.println("1023 & 511 = " + doAnd(1023, 511)); // 1111111111 & 0111111111 = 0111111111 → 511
        System.out.println("Integer.MAX_VALUE & Integer.MAX_VALUE = " + doAnd(Integer.MAX_VALUE, Integer.MAX_VALUE)); // should return Integer.MAX_VALUE
        System.out.println("Integer.MAX_VALUE & 0 = " + doAnd(Integer.MAX_VALUE, 0)); // should return 0

        /*
          Two’s Complement Rules:
             Positive numbers are the same as usual binary.
             To represent a negative number, you:
                  Write the binary of its positive version.
                  Invert the bits (flip 0 ↔ 1).
                  Add 1 to the result.

           11111111 11111111 11111111 11111111   (-1)
        &  00000000 00000000 00000000 00000001   (1)
           ---------------------------------------
           00000000 00000000 00000000 00000001   (1)

         */
        System.out.println("-1 & 1 = " + doAnd(-1, 1));     // Bitwise: all 1s & 0001 → 0001 → 1 (two's complement)
        System.out.println("********************************");

        System.out.println("************** OR ******************");

        System.out.println("0 | 0 = " + doOR(0, 0));           // 0000 | 0000 = 0000 → 0
        System.out.println("0 | 1 = " + doOR(0, 1));           // 0000 | 0001 = 0001 → 1
        System.out.println("1 | 1 = " + doOR(1, 1));           // 0001 | 0001 = 0001 → 1
        System.out.println("2 | 4 = " + doOR(2, 4));           // 0010 | 0100 = 0110 → 6
        System.out.println("5 | 3 = " + doOR(5, 3));           // 0101 | 0011 = 0111 → 7
        System.out.println("10 | 12 = " + doOR(10, 12));       // 1010 | 1100 = 1110 → 14
        System.out.println("255 | 1 = " + doOR(255, 1));       // 11111111 | 00000001 = 11111111 → 255
        System.out.println("-1 | 0 = " + doOR(-1, 0));         // All 1s | 0000 = All 1s → -1
        System.out.println("-1 | 1 = " + doOR(-1, 1));         // All 1s | 0001 = All 1s → -1
        System.out.println("1023 | 511 = " + doOR(1023, 511)); // 11 bits all 1s → 1023
        System.out.println("Integer.MAX_VALUE | 0 = " + doOR(Integer.MAX_VALUE, 0)); // returns Integer.MAX_VALUE

        System.out.println("********************************");

        System.out.println("*************** XOR *****************");
        System.out.println("0 ^ 0 = " + doXOR(0, 0));           // 0000 ^ 0000 = 0000 → 0
        System.out.println("0 ^ 1 = " + doXOR(0, 1));           // 0000 ^ 0001 = 0001 → 1
        System.out.println("1 ^ 1 = " + doXOR(1, 1));           // 0001 ^ 0001 = 0000 → 0
        System.out.println("2 ^ 4 = " + doXOR(2, 4));           // 0010 ^ 0100 = 0110 → 6
        System.out.println("5 ^ 3 = " + doXOR(5, 3));           // 0101 ^ 0011 = 0110 → 6
        System.out.println("10 ^ 12 = " + doXOR(10, 12));       // 1010 ^ 1100 = 0110 → 6
        System.out.println("255 ^ 1 = " + doXOR(255, 1));       // 11111111 ^ 00000001 = 11111110 → 254
        System.out.println("-1 ^ 0 = " + doXOR(-1, 0));         // All 1s ^ 0000 = All 1s → -1
        System.out.println("-1 ^ 1 = " + doXOR(-1, 1));         // All 1s ^ 0001 = All 1s except last bit → -2
        System.out.println("1023 ^ 511 = " + doXOR(1023, 511)); // 1111111111 ^ 0111111111 = 1000000000 → 512
        System.out.println("Integer.MAX_VALUE ^ 0 = " + doXOR(Integer.MAX_VALUE, 0)); // MAX_VALUE ^ 0 = MAX_VALUE
        System.out.println("********************************");

        System.out.println("**************** NOT ****************");
        /*
         ~5: 5 in binary: 00000000 00000000 00000000 00000101
              ~5 flips every bit → 11111111 11111111 11111111 11111010
              This is -6 in two’s complement.
        ~(-1):
-           1 in binary (two’s complement): all bits 1
            Flipping gives all bits 0 → value is 0
         */
        System.out.println("~0 = " + doNot(0));      //  0 → ~0 = -1
        System.out.println("~1 = " + doNot(1));      //  1 → ~1 = -2
        System.out.println("~5 = " + doNot(5));      //  5 → ~5 = -6
        System.out.println("~-1 = " + doNot(-1));    // -1 → ~(-1) = 0
        System.out.println("~10 = " + doNot(10));    // 10 → ~10 = -11
        System.out.println("~(-128) = " + doNot(-128)); // ~(-128) = 127
        System.out.println("~Integer.MAX_VALUE = " + doNot(Integer.MAX_VALUE)); // ~2147483647 = -2147483648
        System.out.println("~Integer.MIN_VALUE = " + doNot(Integer.MIN_VALUE)); // ~-2147483648 = 2147483647
        System.out.println("********************************");
    }
}
