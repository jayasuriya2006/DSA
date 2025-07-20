package dsa.array.main;

import java.util.ArrayList;
import java.util.List;

public class RearrangeArrayElementsBySign {

    //equal number of positives and negatives
    //brut force
    //TC - O (2n)
    //SC - O(n)
    public static int[] reArrangeBySign_Brut(int[] arr) {
        int n = arr.length;

        //since we know number of positive and negative are equal
        int[] positives = new int[n / 2];
        int[] negative = new int[n / 2];

        int posInd = 0;
        int negInd = 0;
        for (int item : arr) {
            if (item >= 0) {
                positives[posInd] = item;
                posInd++;
            } else {
                negative[negInd] = item;
                negInd++;
            }
        }

        for (int i = 0; i < n / 2; i++) {
            arr[2 * i] = positives[i];
            arr[2 * i + 1] = negative[i];
        }
        return arr;
    }

    //equal number of positives and negatives
    //brut force
    //TC - O (2n)
    //SC - O(n) - but for returning the result
    public static int[] reArrangeBySign_Better(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        int posInd = 0;
        int negInd = 1;
        for (int item : arr) {
            if (item >= 0) {
                result[posInd] = item;
                posInd = posInd + 2;
            } else {
                result[negInd] = item;
                negInd = negInd + 2;
            }
        }

        return result;
    }


    //not equal number of positives and negatives
    //brut force is the only solution
    //TC - O (2n)
    //SC - O(n)
    public static int[] reArrangeBySign_2_Brut(int[] arr) {
        int n = arr.length;

        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();

        for (int item : arr) {
            if (item < 0) {
                negatives.add(item);
            } else {
                positives.add(item);
            }
        }

        //if positives less, then remaining places should filled with negatives [1,-1,2,-2,3,-5,-8,-9,-5]
        if (positives.size() < negatives.size()) {
            for (int i = 0; i < positives.size(); i++) {
                arr[i * 2] = positives.get(i);
                arr[i * 2 + 1] = negatives.get(i);
            }
            int negInd = 2 * positives.size();
            for (int i = positives.size(); i < negatives.size(); i++) {
                arr[negInd] = negatives.get(i);
                negInd++;
            }

        } else {
            //if negative less, then remaining places should filled with positives
            for (int i = 0; i < negatives.size(); i++) {
                arr[i * 2] = positives.get(i);
                arr[i * 2 + 1] = negatives.get(i);
            }
            int posInd = 2 * negatives.size();
            for (int i = negatives.size(); i < positives.size(); i++) {
                arr[posInd] = positives.get(i);
                posInd++;
            }

        }
        return arr;
    }
}
