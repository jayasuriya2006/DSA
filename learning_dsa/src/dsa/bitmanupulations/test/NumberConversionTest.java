package dsa.bitmanupulations.test;

import static dsa.bitmanupulations.main.NumberConversion.convertBinaryToDecimal;
import static dsa.bitmanupulations.main.NumberConversion.convertDecimalToBinary;

public class NumberConversionTest {

    public static void main(String[] args) {
        System.out.println("********************************");
        System.out.println(convertDecimalToBinary(0));    // Expected: "0"
        System.out.println(convertDecimalToBinary(1));    // Expected: "1"
        System.out.println(convertDecimalToBinary(2));    // Expected: "10"
        System.out.println(convertDecimalToBinary(5));    // Expected: "101"
        System.out.println(convertDecimalToBinary(10));   // Expected: "1010"
        System.out.println(convertDecimalToBinary(15));   // Expected: "1111"
        System.out.println(convertDecimalToBinary(32));   // Expected: "100000"
        System.out.println(convertDecimalToBinary(255));  // Expected: "11111111"

        System.out.println("********************************");

        System.out.println(convertBinaryToDecimal("0"));         // Expected: 0
        System.out.println(convertBinaryToDecimal("1"));         // Expected: 1
        System.out.println(convertBinaryToDecimal("10"));        // Expected: 2
        System.out.println(convertBinaryToDecimal("101"));       // Expected: 5
        System.out.println(convertBinaryToDecimal("1010"));      // Expected: 10
        System.out.println(convertBinaryToDecimal("1111"));      // Expected: 15
        System.out.println(convertBinaryToDecimal("100000"));    // Expected: 32
        System.out.println(convertBinaryToDecimal("11111111"));  // Expected: 255

        System.out.println("********************************");
    }
}
