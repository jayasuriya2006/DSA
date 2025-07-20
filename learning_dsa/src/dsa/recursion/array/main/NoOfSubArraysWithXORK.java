package dsa.array.main;

import java.util.HashMap;
import java.util.Map;

public class NoOfSubArraysWithXORK {

    //TC - O (N^3)
    //SC - O(1)
    public static int getNoOfSubArraysWithXOR_K_Brut(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int xor = 0;
                for (int l = i; l <= j; l++) {
                    xor = xor ^ arr[l];
                }
                if (xor == k) {
                    count++;
                }
            }
        }
        return count;
    }

    //TC - O (N^2)
    //SC - O(1)
    public static int getNoOfSubArraysWithXOR_K_Better(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int xor = 0;
            for (int j = i; j < arr.length; j++) {
                xor = xor ^ arr[j];
                if (xor == k) {
                    count++;
                }
            }
        }
        return count;
    }

    //TC - O(n)
    //SC - O(n)
    public static int getNoOfSubArraysWithXOR_K_Optimal(int[] arr, int k) {
        int count = 0;
        //xor -> count
        int curXOR = 0;
        Map<Integer, Integer> freqXOR = new HashMap<>();
        freqXOR.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            // xorNeeded = k ^ curXOR
            curXOR = curXOR ^ arr[i];
            int neededXor = curXOR ^ k;
            if (freqXOR.containsKey(neededXor)) {
                count = count + freqXOR.get(neededXor);
            }
            freqXOR.put(curXOR, freqXOR.getOrDefault(curXOR, 0) + 1);
        }
        return count;
    }
}
