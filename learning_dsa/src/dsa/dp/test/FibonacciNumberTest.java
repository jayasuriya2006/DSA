package dsa.dp.test;

import static dsa.dp.main.FibonacciNumber.*;

public class FibonacciNumberTest {
    public static void main(String[] args) {
        int[] testCases = {0, 1, 2, 5, 10, 20, 30};

        for (int n : testCases) {
            int memo = getFibonacciMemo(n);
            int tab = getFibonacciTabulation(n);
            int opt = getFibonacciSpaceOptimized(n);

            System.out.println("n = " + n);
            System.out.println("  Memoization: " + memo);
            System.out.println("  Tabulation : " + tab);
            System.out.println("  Optimized  : " + opt);
            System.out.println("  Match: " + (memo == tab && tab == opt));
            System.out.println("-------------------------------------");
        }
    }
}
