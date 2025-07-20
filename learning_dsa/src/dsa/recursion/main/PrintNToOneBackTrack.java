package dsa.recursion.main;

public class PrintNToOneBackTrack {

    public static void print(int n, int count) {
        //base condition
        if (count > n) {
            return;
        }

        //recursive call
        print(n, count + 1);

        //backtrack
        System.out.println(count);
    }
}
