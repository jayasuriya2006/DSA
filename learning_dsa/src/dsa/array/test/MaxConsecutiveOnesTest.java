//13
package dsa.array.test;

import dsa.array.main.MaxConsecutiveOnes;

public class MaxConsecutiveOnesTest {
    public static void main(String args[]) {
        int[] arr = {1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1};
        int expectedMaxConsecutiveOnes = 4;

        int actualResult = MaxConsecutiveOnes.findMaxConsecutiveOnes(arr);
        if (actualResult == expectedMaxConsecutiveOnes) {
            System.out.println(".....TEST PASSED......");
        } else {
            System.out.println(".....TEST FAILED......");
        }

    }
}
