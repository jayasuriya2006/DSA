package dsa.recursion.test;

import dsa.recursion.main.SumOneToN;

public class SumOneToNTest {

    /*Functional way */
    /* Get the sum of first N natural Numbers */

    public static void main(String[] args) {
        int n = 10;
        int expectedAns = n * (n + 1) / 2;

        int actualAns = SumOneToN.getSumOfFirstNNumbers(n);

        if (actualAns == expectedAns) {
            System.out.println("..........TEST PASSED.............");
        } else {
            System.out.println("..........TEST PASSED.............");
        }
    }
}
