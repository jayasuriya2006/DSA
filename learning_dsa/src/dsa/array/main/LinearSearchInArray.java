package dsa.array.main;

public class LinearSearchInArray {
    //TC - O(N)
    public static int getTheIndex(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            //found - return the index
            if (arr[i] == target) return i;
        }
        //if not found return -1
        return -1;
    }
}
