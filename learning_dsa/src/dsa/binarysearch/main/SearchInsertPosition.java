package dsa.binarysearch.main;

import static dsa.binarysearch.main.UpperBound.getUpperBound;

public class SearchInsertPosition {

    public static int getTheInsertPosition(int[] arr, int num) {
        return getUpperBound(arr, num);
    }
}
