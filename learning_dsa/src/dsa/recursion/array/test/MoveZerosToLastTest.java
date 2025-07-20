//8

package dsa.array.test;

import java.util.Arrays;

public class MoveZerosToLastTest {
    public static void main(String args[]) {
        int[] arr_brut = {0, 0, 1, 0, 2, 3, 4, 5, 0, 6};
        int[] arr_optimal = {0, 0, 1, 0, 2, 3, 4, 5, 0, 6};
        int[] expected = {1, 2, 3, 4, 5, 6, 0, 0, 0, 0};

        dsa.array.main.MoveZerosToLast.moveZerosToLastBrut(arr_brut);
        if (Arrays.equals(arr_brut, expected)) {
            System.out.println(".....BRUT - TEST PASSED....");
        } else {
            System.out.println(".....BRUT - TEST FAILED....");
        }

        dsa.array.main.MoveZerosToLast.moveZerosToLastOptimal(arr_optimal);
        if (Arrays.equals(arr_optimal, expected)) {
            System.out.println(".....OPTIMAL - TEST PASSED....");
        } else {
            System.out.println(".....OPTIMAL - TEST FAILED....");
        }
    }
}
