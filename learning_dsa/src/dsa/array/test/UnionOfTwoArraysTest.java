//10

package dsa.array.test;


import java.util.Arrays;
import java.util.List;

public class UnionOfTwoArraysTest {
    public static void main(String args[]) {

        //find union of two sorted arrays
        int[] arr1 = {1, 2, 2, 3, 4, 4, 5};
        int[] arr2 = {3, 4, 5, 6, 7};
        List<Integer> expectedUnion = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        List<Integer> actualUnion = dsa.array.main.UnionOfTwoSortedArrays.getUnionBrut(arr1, arr2);
        if (expectedUnion.equals(actualUnion)) {
            System.out.println("....BRUT - TEST PASSED.....");
        } else {
            System.out.println("....BRUT - TEST FAILED.....");
        }

        List<Integer> actualUnionOpt = dsa.array.main.UnionOfTwoSortedArrays.getUnionOptimal(arr1, arr2);
        if (expectedUnion.equals(actualUnionOpt)) {
            System.out.println("....Optimal - TEST PASSED.....");
        } else {
            System.out.println("....Optimal - TEST FAILED.....");
        }

    }
}
