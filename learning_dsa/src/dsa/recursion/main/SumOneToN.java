package dsa.recursion.main;

public class SumOneToN {

    public static int getSumOfFirstNNumbers(int n) {
        if (n <= 0) {
            return 0;
        }
        return n + getSumOfFirstNNumbers(n - 1);
    }
}
