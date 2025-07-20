package dsa.recursion.test;

public class FactorialTest {

    /* Get Factorial of a number N */
    public static void main(String[] args) {
        int n = 5;
        int expectedAns = 120; // 5! = 5 * 4 * 3 * 2 * 1

        int actualAns = dsa.recursion.main.Factorial.getFactorial(n);

        if (actualAns == expectedAns) {
            System.out.println("..........TEST PASSED.............");
        } else {
            System.out.println("..........TEST FAILED.............");
        }
    }
}
