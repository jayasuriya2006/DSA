//7

package dsa.array.test;

public class LeftRotateArrayByDPlacesTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};  // brut
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7}; // better
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7}; // optimal

        int d = 10;
        int[] expected = {4, 5, 6, 7, 1, 2, 3};

        // Test for brut method
        dsa.array.main.LeftRotateArrayByDPlaces.leftRotateArrayByDBrut(arr, d);
        if (java.util.Arrays.equals(arr, expected)) {
            System.out.println(">>>>> TEST PASSED (Brut) <<<<<<<<<");
        } else {
            System.out.println(">>>>> TEST FAILED (Brut) <<<<<<<<<");
            System.out.println("Expected: " + java.util.Arrays.toString(expected));
            System.out.println("Actual: " + java.util.Arrays.toString(arr));
        }

        // Test for better method
        dsa.array.main.LeftRotateArrayByDPlaces.leftRotateArrayByDBetter(arr1, d);
        if (java.util.Arrays.equals(arr1, expected)) {
            System.out.println(">>>>> TEST PASSED (Better) <<<<<<<<<");
        } else {
            System.out.println(">>>>> TEST FAILED (Better) <<<<<<<<<");
            System.out.println("Expected: " + java.util.Arrays.toString(expected));
            System.out.println("Actual: " + java.util.Arrays.toString(arr1));
        }

        // Test for optimal method
        dsa.array.main.LeftRotateArrayByDPlaces.leftRotateArrayByDOptimal(arr2, d);
        if (java.util.Arrays.equals(arr2, expected)) {
            System.out.println(">>>>> TEST PASSED (Optimal) <<<<<<<<<");
        } else {
            System.out.println(">>>>> TEST FAILED (Optimal) <<<<<<<<<");
            System.out.println("Expected: " + java.util.Arrays.toString(expected));
            System.out.println("Actual: " + java.util.Arrays.toString(arr2));
        }
    }
}