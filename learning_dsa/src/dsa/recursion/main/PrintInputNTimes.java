package dsa.recursion.main;

public class PrintInputNTimes {

    public static void print(String input, int n, int count) {
        //base condition -> where the function call stops
        if (count == n) {
            return;
        }

        System.out.println(count + 1 + " - " + input);

        //recursive call
        print(input, n, count + 1);   //next call will be returned here
    }
}
