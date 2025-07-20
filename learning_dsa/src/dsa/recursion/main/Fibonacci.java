package dsa.recursion.main;

public class Fibonacci {

    public static long getFibonacci(int n) {
        //base condition
        if (n <= 1) {
            return n;
        }

        //multiple recursive call
        return getFibonacci(n - 1) + getFibonacci(n - 2);
    }
}
