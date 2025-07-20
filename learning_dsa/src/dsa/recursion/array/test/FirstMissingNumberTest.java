//12
package dsa.array.test;

import dsa.array.main.FirstMissingNumber;

public class FirstMissingNumberTest {

    public static void main(String args[]) {

        //find the missing number in 1 to n
        int[] arr = {1, 2, 3, 5, 4, 6, 7, 8};
        int n = 9;
        int missingNumber = 9;


        int resBrut = FirstMissingNumber.findFirstMissingNumberBrut(arr, n);
        if (missingNumber == resBrut) {
            System.out.println(".....BRUT - TEST PASSED.....");
        } else {
            System.out.println(".....BRUT - TEST FAILED.....");
        }

        int resBetter = FirstMissingNumber.findFirstMissingNumberBetter(arr, n);
        if (missingNumber == resBetter) {
            System.out.println(".....BETTER - TEST PASSED.....");
        } else {
            System.out.println(".....BETTER - TEST FAILED.....");
        }

        int resOpt = FirstMissingNumber.findFirstMissingNumberOptimal(arr, n);
        if (missingNumber == resOpt) {
            System.out.println(".....OPTIMAL - TEST PASSED.....");
        } else {
            System.out.println(".....OPTIMAL - TEST FAILED.....");
        }

        int resOpt_XOR = FirstMissingNumber.findFirstMissingNumberOptimal_XOR(arr, n);
        if (missingNumber == resOpt_XOR) {
            System.out.println(".....OPTIMAL_XOR - TEST PASSED.....");
        } else {
            System.out.println(".....OPTIMAL_XOR - TEST FAILED.....");
        }
    }
}
