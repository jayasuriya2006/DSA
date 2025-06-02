//9

package dsa.array.test;

public class LinearSearchInArrayTest {
    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 5};

        int target = 3;
        int expectedInd = 2;

        int target_negative = 10;

        int actualOutput_P = dsa.array.main.LinearSearchInArray.getTheIndex(arr, target);
        if (actualOutput_P == expectedInd) {
            System.out.println(".... TEST PASSED - POSITIVE CASE......");
        } else {
            System.out.println(".... TEST FAILED - POSITIVE CASE......");
        }

        int actualOutput_N = dsa.array.main.LinearSearchInArray.getTheIndex(arr, target_negative);
        if (actualOutput_N == -1) {
            System.out.println(".... TEST PASSED - NEGATIVE CASE.......");
        } else {
            System.out.println(".... TEST FAILED - NEGATIVE CASE.......");
        }
    }
}
