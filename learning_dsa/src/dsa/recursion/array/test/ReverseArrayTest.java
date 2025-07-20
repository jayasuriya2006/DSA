//6

package dsa.array.test;

import java.util.Arrays;

public class ReverseArrayTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {5, 4, 3, 2, 1};
        dsa.array.main.ReverseArray.reverseTheArray(arr);
        if (Arrays.equals(arr, expected)) {
            System.out.println(">>>>> TEST PASSED <<<<<<<<<");
        } else {
            System.out.println(">>>>> TEST FAILED <<<<<<<<<");
            System.out.println("Expected: " + Arrays.toString(expected));
            System.out.println("Actual: " + Arrays.toString(arr));
        }

    }
}
