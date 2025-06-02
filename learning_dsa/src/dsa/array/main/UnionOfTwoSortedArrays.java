package dsa.array.main;

import java.util.*;

public class UnionOfTwoSortedArrays {
    public static List<Integer> getUnionBrut(int[] arr1, int[] arr2) {
        return getUnionBrut(arr1, arr1.length, arr2, arr2.length);
    }

    //TC - O(2n1 + 2n2)
    //SC - O(n1 + n2)  returned list
    private static List<Integer> getUnionBrut(int[] arr1, int n1, int[] arr2, int n2) {
        Set<Integer> uniqueSet = new HashSet<>();

        //O(n1)
        for (int i = 0; i < n1; i++) {
            uniqueSet.add(arr1[i]);
        }

        //O(n2)
        for (int i = 0; i < n2; i++) {
            uniqueSet.add(arr2[i]);
        }

        List<Integer> union = new ArrayList<>();

        //This also can be done - performance is good. but for learning purpose commented and used iteration
        // union.addAll(uniqueSet);

        //O(n1 + n2) - if all elements are unique
        for (int item : uniqueSet) {
            union.add(item);
        }

        return union;
    }

    public static List<Integer> getUnionOptimal(int[] arr1, int[] arr2) {
        return getUnionOptimal(arr1, arr1.length, arr2, arr2.length);
    }

    //TC - O(n1 + n2)
    //SC - O(n1 + n2)
    private static List<Integer> getUnionOptimal(int[] arr1, int n1, int[] arr2, int n2) {

        List<Integer> union = new ArrayList<>();

        //use two pointers i for arr1 and j for arr2
        int i = 0;
        int j = 0;
        while (i < n1 && j < n2) {
            //proceed with small element
            if (arr1[i] <= arr2[j]) {
                //if last added element is not current then add
                if (union.isEmpty() || union.getLast() != arr1[i]) {
                    union.add(arr1[i]);
                }
                //increase the pointer
                i++;
            } else {
                if (union.isEmpty() || union.getLast() != arr2[j]) {
                    union.add(arr2[j]);
                }
                j++;
            }
        }

        //if any one array completed continue processing next array
        while (i < n1) {
            if (union.isEmpty() || union.getLast() != arr1[i]) {
                union.add(arr1[i]);
            }
            i++;
        }

        while (j < n2) {
            if (union.isEmpty() || union.getLast() != arr2[j]) {
                union.add(arr2[j]);
            }
            j++;
        }

        return union;
    }

}
