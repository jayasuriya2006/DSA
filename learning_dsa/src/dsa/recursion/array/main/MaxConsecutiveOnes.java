package dsa.array.main;

public class MaxConsecutiveOnes {

    //TC - O(n)
    //SC - O(1)
    public static int findMaxConsecutiveOnes(int arr[]) {
        int maxOnes = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
                maxOnes = Math.max(count, maxOnes);
            } else {
                count = 0;
            }
        }

        return maxOnes;
    }
}
