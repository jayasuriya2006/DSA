//5

package dsa.array.test;

import java.util.Arrays;

public class LeftRotateArrayByOnePlaceTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int[] expected = {2, 3, 4, 5, 6, 7, 1};
        dsa.array.main.LeftRotateArrayByOnePlace.leftRotateArrayByOne(arr);

        if (Arrays.equals(arr, expected)) {
            System.out.println(">>>>> TEST PASSED <<<<<<<<<");
        } else {
            System.out.println(">>>>> TEST FAILED <<<<<<<<<");
            System.out.println("Expected: " + Arrays.toString(expected));
            System.out.println("Actual: " + Arrays.toString(arr));
        }
    }
}