//4

package dsa.array.test;

public class RemoveDuplicatesInArrayTest {
    public static void main(String[] arg) {
        int[] arr = {1, 1, 1, 2, 3, 3, 3, 4, 5};
        // int nonDupLen = 5;

        dsa.array.main.RemoveDuplicatesInSortedArray.removeDupFromArrayBrut(arr);
        System.out.println(".... BRUT OUTPUT....");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        int[] arr1 = {1, 1, 1, 2, 3, 3, 3, 4, 5};
        dsa.array.main.RemoveDuplicatesInSortedArray.removeDupFromArrayOptimal(arr1);
        System.out.println(".... OPTIMAL OUTPUT....");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
    }
}
