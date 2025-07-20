//1

package dsa.array.test;

import dsa.array.main.LargestElementInAnArray;

public class LargestElementInAnArrayTest {

    public static void main(String args[]) {

        int[] arr = {999, 10, 50, 120, 0, -5, 20};
        int expectedLargest = 999;

        System.out.println("... TEST STARTED ON BRUT APPROACH ....");
        int largestElementInAnArrayBrut = LargestElementInAnArray.findLargestElementInAnArrayBrut(arr);
        if (largestElementInAnArrayBrut == expectedLargest) {
            System.out.println("BRUT: ...(^ ^).... TEST PASSED ....(^ ^)...");
        } else {
            System.out.println("BRUT: ...)^ ^(.... TEST FAILED ....)^ ^(...");
            System.out.println("BRUT: Expected largest value: " + expectedLargest + "\n"
                    + "Actual largest value: " + largestElementInAnArrayBrut
            );
        }

        System.out.println("... TEST STARTED ON OPTIMAL APPROACH ....");
        int largestElementInAnArrayOptimal = LargestElementInAnArray.findLargestElementInAnArrayOptimal(arr);
        if (largestElementInAnArrayOptimal == expectedLargest) {
            System.out.println("OPTIMAL: ...(^ ^).... TEST PASSED ....(^ ^)...");
        } else {
            System.out.println("OPTIMAL: ...)^ ^(.... TEST FAILED ....)^ ^(...");
            System.out.println("OPTIMAL: Expected largest value: " + expectedLargest + "\n"
                    + "Actual largest value: " + largestElementInAnArrayOptimal
            );
        }
    }
}
