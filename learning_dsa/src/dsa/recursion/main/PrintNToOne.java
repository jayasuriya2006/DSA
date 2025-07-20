package dsa.recursion.main;

public class PrintNToOne {

    public static void print(int count) {
        //base condition
        if (count == 0) {
            return;
        }

        System.out.println(count);

        //recursive call
        print(count - 1);
    }
}
