package dsa.array.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LeadersInAnArray {

    //TC - O(N * N)
    //SC - O(N) but for returning answer
    //checking each element with all the right elements
    public static List<Integer> getLeaders_Brut(int[] arr) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.add(arr[i]);
            }
        }
        return res;
    }

    public static List<Integer> getLeaders_Optimal(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int n = arr.length;
        int rightMax = arr[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            //if element is greater than which is maximum of it's right,  it means that it's greater than all the right elements
            if (arr[i] >= rightMax) {
                rightMax = arr[i];
                res.add(arr[i]);
            }
        }
        Collections.reverse(res);
        return res;
    }
}
