package dsa.recursion.test;

import dsa.recursion.main.PrintInputNTimes;

public class PrintInputNTimesTest {
    /* Print the given input N times using recursion   */
    public static void main(String[] args) {
        String input = "Jayaprakash";
        int n = 5;

        //initially count is zero
        PrintInputNTimes.print(input, n, 0);
    }

}
