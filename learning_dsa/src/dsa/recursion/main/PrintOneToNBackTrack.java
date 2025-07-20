package dsa.recursion.main;

public class PrintOneToNBackTrack {

    public static void print(int count) {
        //base condition
        if (count == 0) {
            return;
        }

        //recursive call
        print(count - 1);

        //backtrack
        System.out.println(count);
    }
}
