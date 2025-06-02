package dsa.array.main;

import java.util.HashMap;
import java.util.Map;

public class FindNumberWhichAppearsOneTime {

    //TC - O (n * n)
    //SC - O (1)
    public static int getNUmberWhichAppearsOneTimeBrut(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count == 1) {
                return arr[i];
            }
        }
        return 0;
    }

    public static int getNUmberWhichAppearsOneTimeBetter(int[] arr) {
        //use frequency map
        int n = arr.length;
        Map<Integer, Integer> countMap = new HashMap<>();

        //O(n)
        for (int item : arr) {
            countMap.put(item, countMap.getOrDefault(item, 0) + 1);
        }

        //O(n/2) since all the numbers appearing twice
        for (int key : countMap.keySet()) {
            if (countMap.get(key) == 1) {
                return key;
            }
        }
        return 0;
    }

    //TC - O(n)
    //SC - O(1)
    public static int getNUmberWhichAppearsOneTimeOptimal(int[] arr) {
        //xor of two same numbers will give 0
        //xor of 0 and number will be the number itself
        int xor = 0;
        for (int item : arr) {
            xor = xor ^ item;
        }
        return xor;
    }
}
