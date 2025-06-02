//2

package dsa.array.test;

import dsa.array.main.SecondLargestAndSecondSmallest;

public class SecondLargestAndSmallestTest {
    public static void main(String args[]) {
        int[] arr = {1000, 999, 100, 100, 100, 100, 100, 100, 10, 0, 30, -10, -20};
        int expectedSecondLargest = 999;
        int expectedSecondSmallest = -10;

        System.out.println("****** TEST STARTED ON BRUT APPROACH ******");
        int secondLargestBrut = SecondLargestAndSecondSmallest.findSecondLargestBrut(arr);
        if (secondLargestBrut == expectedSecondLargest) {
            System.out.println("BRUT - SECOND LARGEST: ...(^ ^).... TEST PASSED ....(^ ^)...");
        } else {
            System.out.println("BRUT - SECOND LARGEST: ...)^ ^(.... TEST FAILED ....)^ ^(...");
            System.out.println("BRUT - SECOND LARGEST: Expected second largest value: " + expectedSecondLargest + "\n"
                    + "Actual second largest value: " + secondLargestBrut
            );
        }

        int secondSmallestBrut = SecondLargestAndSecondSmallest.findSecondSmallestBrut(arr);
        if (secondSmallestBrut == expectedSecondSmallest) {
            System.out.println("BRUT - SECOND SMALLEST: ...(^ ^).... TEST PASSED ....(^ ^)...");
        } else {
            System.out.println("BRUT - SECOND SMALLEST: ...)^ ^(.... TEST FAILED ....)^ ^(...");
            System.out.println("BRUT - SECOND SMALLEST: Expected second smallest value: " + expectedSecondSmallest + "\n"
                    + "Actual second smallest value: " + secondSmallestBrut
            );
        }

        System.out.println("****** TEST STARTED ON BETTER APPROACH ******");
        int secondLargestBetter = SecondLargestAndSecondSmallest.findSecondLargestBetter(arr);
        if (secondLargestBetter == expectedSecondLargest) {
            System.out.println("BETTER - SECOND LARGEST: ...(^ ^).... TEST PASSED ....(^ ^)...");
        } else {
            System.out.println("BETTER - SECOND LARGEST: ...)^ ^(.... TEST FAILED ....)^ ^(...");
            System.out.println("BETTER - SECOND LARGEST: Expected second largest value: " + expectedSecondLargest + "\n"
                    + "Actual second largest value: " + secondLargestBetter
            );
        }

        int secondSmallestBetter = SecondLargestAndSecondSmallest.findSecondSmallestBetter(arr);
        if (secondSmallestBetter == expectedSecondSmallest) {
            System.out.println("BETTER - SECOND SMALLEST: ...(^ ^).... TEST PASSED ....(^ ^)...");
        } else {
            System.out.println("BETTER - SECOND SMALLEST: ...)^ ^(.... TEST FAILED ....)^ ^(...");
            System.out.println("BETTER - SECOND SMALLEST: Expected second smallest value: " + expectedSecondSmallest + "\n"
                    + "Actual second smallest value: " + secondSmallestBetter
            );
        }

        System.out.println("****** TEST STARTED ON OPTIMAL APPROACH ******");
        int secondLargestOptimal = SecondLargestAndSecondSmallest.findSecondLargestOptimal(arr);
        if (secondLargestOptimal == expectedSecondLargest) {
            System.out.println("OPTIMAL - SECOND LARGEST: ...(^ ^).... TEST PASSED ....(^ ^)...");
        } else {
            System.out.println("OPTIMAL - SECOND LARGEST: ...)^ ^(.... TEST FAILED ....)^ ^(...");
            System.out.println("OPTIMAL - SECOND LARGEST: Expected second largest value: " + expectedSecondLargest + "\n"
                    + "Actual second largest value: " + secondLargestOptimal
            );
        }

        int secondSmallestOptimal = SecondLargestAndSecondSmallest.findSecondSmallestOptimal(arr);
        if (secondSmallestOptimal == expectedSecondSmallest) {
            System.out.println("OPTIMAL - SECOND SMALLEST: ...(^ ^).... TEST PASSED ....(^ ^)...");
        } else {
            System.out.println("OPTIMAL - SECOND SMALLEST: ...)^ ^(.... TEST FAILED ....)^ ^(...");
            System.out.println("OPTIMAL - SECOND SMALLEST: Expected second smallest value: " + expectedSecondSmallest + "\n"
                    + "Actual second smallest value: " + secondSmallestOptimal
            );
        }
    }
}
