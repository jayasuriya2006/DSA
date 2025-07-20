package dsa.recursion.test;

public class FibonacciTest {
    /* Get Fibonacci of a number N */
    public static void main(String[] args) {
        int n = 10;
        long expectedAns = 55; // Fibonacci sequence: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...

        long actualAns = dsa.recursion.main.Fibonacci.getFibonacci(n);

        if (actualAns == expectedAns) {
            System.out.println("..........TEST PASSED.............");
        } else {
            System.out.println("..........TEST FAILED.............");
        }
    }
}
