//3

package dsa.array.test;

import dsa.array.main.IsArraySorted;

public class IsArraySortedTest {

    public static void main(String args[]) {
        int[] arr = {1, 3, 3, 3, 3, 3, 3, 20};
        boolean expectedResult = true;

        boolean actualResult = IsArraySorted.isArraySortedCheck(arr);

        if (expectedResult == actualResult) {
            System.out.println(".....(^ ^)... TEST PASSED ...(^ ^).....");
        } else {
            System.out.println(".....(^ ^)... TEST FAILED ...(^ ^).....");
        }
    }
}
