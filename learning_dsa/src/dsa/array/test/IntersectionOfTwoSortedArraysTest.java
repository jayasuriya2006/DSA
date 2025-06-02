//11
package dsa.array.test;

import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoSortedArraysTest {
    public static void main(String args[]) {
        //find union of two sorted arrays
        int[] arr1 = {1, 2, 2, 3, 4, 4, 5, 8, 8};
        int[] arr2 = {2, 2, 3, 3, 4, 5, 6, 7, 8, 8};
        List<Integer> expectedIntersection = Arrays.asList(2, 2, 3, 4, 5, 8, 8);

        List<Integer> actualIntersection = dsa.array.main.IntersectionOfTwoSortedArray.getIntersectionBrut(arr1, arr2);
        if (expectedIntersection.equals(actualIntersection)) {
            System.out.println("....BRUT - TEST PASSED.....");
        } else {
            System.out.println("....BRUT - TEST FAILED.....");
        }

        List<Integer> actualIntersectionOptimal = dsa.array.main.IntersectionOfTwoSortedArray.getIntersectionOptimal(arr1, arr2);
        if (expectedIntersection.equals(actualIntersectionOptimal)) {
            System.out.println("....OPTIMAL - TEST PASSED.....");
        } else {
            System.out.println("....OPTIMAL - TEST FAILED.....");
        }
    }


}
