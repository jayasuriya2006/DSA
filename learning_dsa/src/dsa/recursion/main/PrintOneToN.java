package dsa.recursion.main;

public class PrintOneToN {

    public static void print(int n, int count) {
        //base condition
        if (count > n) {
            return;
        }

        System.out.println(count);

        //recursive call
        print(n, count + 1);
    }
}
