package dsa.bitmanupulations.main;

public class BitwiseOperations {

    /**
     * Performs a bitwise AND operation between two integers.
     *
     * The bitwise AND operator (&) compares each bit of the first operand to the corresponding bit of the second operand.
     * If both bits are 1, the result is 1. Otherwise, the result is 0.
     *
     * Example:
     *     num1 = 12   → Binary: 1100
     *     num2 = 10   → Binary: 1010
     *
     *     Bitwise AND:
     *       1100
     *     & 1010
     *     ------
     *       1000  → Decimal: 8
     *
     * @param num1 The first integer input
     * @param num2 The second integer input
     * @return The result of num1 & num2
     */
    public static int doAnd(int num1, int num2) {
        return num1 & num2;
    }

    /**
     * Performs a bitwise OR operation between two integers.
     *
     * The bitwise OR operator (|) compares each bit of the first operand to the corresponding bit of the second operand.
     * If any of them is 1, the result is 1. If both are 0 , the result is 0.
     *
     * Example:
     *     num1 = 12   → Binary: 1100
     *     num2 = 10   → Binary: 1010
     *
     *     Bitwise OR:
     *       1100
     *     | 1010
     *     ------
     *       1110  → Decimal: 14
     *
     * @param num1 The first integer input
     * @param num2 The second integer input
     * @return The result of num1 | num2
     */
    public static int doOR(int num1, int num2) {
        return num1 | num2;
    }

    /**
     * Performs a bitwise XOR operation between two integers.
     *
     * The bitwise XOR operator (^) compares each bit of the first operand to the corresponding bit of the second operand.
     * If no of 1s is even then result is 0, otherwise result is 1.
     *
     * Example:
     *     num1 = 12   → Binary: 1100
     *     num2 = 10   → Binary: 1010
     *
     *     Bitwise OR:
     *       1100
     *     ^ 1010
     *     ------
     *       0110  → Decimal: 6
     *
     * @param num1 The first integer input
     * @param num2 The second integer input
     * @return The result of num1 ^ num2
     */
    public static int doXOR(int num1, int num2) {
        return num1 ^ num2;
    }


    /**
     * Bitwise NOT (~) flips all bits of the input integer.
     *
     * In Java, integers are 32-bit signed values in two's complement.
     * So ~x is effectively equal to -x - 1.
     *
     * Example:
     *     x =  5  →  00000000 00000000 00000000 00000101
     *    ~x = -6  →  11111111 11111111 11111111 11111010
     *
     * @param num Integer input
     * @return Bitwise NOT of the input
     */
    public static int doNot(int num) {
        return ~num;
    }
}
