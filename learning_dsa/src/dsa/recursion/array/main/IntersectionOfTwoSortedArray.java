package dsa.array.main;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoSortedArray {
    public static List<Integer> getIntersectionBrut(int[] arr1, int[] arr2) {
        return getIntersectionBrut(arr1, arr1.length, arr2, arr2.length);
    }

    //TC - O( n1 * n2)
    private static List<Integer> getIntersectionBrut(int[] arr1, int n1, int[] arr2, int n2) {
        //iterate one array and check for the element in second array
        //keep visited array for added element tracking - since duplicate may possible
        boolean[] visited = new boolean[n2];
        List<Integer> intersection = new ArrayList<>();
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if ((arr1[i] == arr2[j]) && !visited[j]) {
                    intersection.add(arr1[i]);
                    visited[j] = true;
                    break;
                }
                if (arr2[j] > arr1[i]) break;
            }
        }
        return intersection;
    }

    public static List<Integer> getIntersectionOptimal(int[] arr1, int[] arr2) {
        return getIntersectionOptimal(arr1, arr1.length, arr2, arr2.length);
    }


    //TC - O(n1 + n2)
    //SC - O(1)   but O(M) for storing the answer, where M is the matching nof of elements
    private static List<Integer> getIntersectionOptimal(int[] arr1, int n1, int[] arr2, int n2) {

        List<Integer> intersection = new ArrayList<>();
        //use two pointer   i for first array j for second array
        int i = 0;
        int j = 0;

        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                //match found , add it intersection and move both pointers
                intersection.add(arr1[i]);
                i++;
                j++;
            }
        }
        return intersection;
    }

}
