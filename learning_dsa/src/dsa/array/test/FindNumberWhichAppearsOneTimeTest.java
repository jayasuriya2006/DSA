//14

package dsa.array.test;

import dsa.array.main.FindNumberWhichAppearsOneTime;

public class FindNumberWhichAppearsOneTimeTest {
    public static void main(String args[]) {
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 4, 5, 6, 6, 7, 7};
        int expected = 5;

        int resultBrut = FindNumberWhichAppearsOneTime.getNUmberWhichAppearsOneTimeBrut(arr);
        int resultBetter = FindNumberWhichAppearsOneTime.getNUmberWhichAppearsOneTimeBetter(arr);
        int resultOptimal = FindNumberWhichAppearsOneTime.getNUmberWhichAppearsOneTimeOptimal(arr);

        if (resultBrut == expected) {
            System.out.println("....BRUT - TEST PASSED....");
        } else {
            System.out.println("....BRUT - TEST PASSED....");
        }

        if (resultBetter == expected) {
            System.out.println("....BETTER - TEST PASSED....");
        } else {
            System.out.println("....BETTER - TEST PASSED....");
        }

        if (resultOptimal == expected) {
            System.out.println("....OPTIMAL - TEST PASSED....");
        } else {
            System.out.println("....OPTIMAL - TEST PASSED....");
        }
    }
}
