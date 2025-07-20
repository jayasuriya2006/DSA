package dsa.recursion.main;

public class Factorial {

    public static int getFactorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * getFactorial(n - 1);
    }
}
