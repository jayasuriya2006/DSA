package dsa.twopointer.main;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
    public static int brute(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int maxlen = 0;
        while (r < fruits.length) {
            // Add the current fruit to the map and increase its count
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);

            // If more than 2 types of fruits, shrink window from the left
            while (map.size() > 2) {
                map.put(fruits[l], map.get(fruits[l]) - 1); // Decrease count of fruit at left pointer
                if (map.get(fruits[l]) == 0) {
                    map.remove(fruits[l]);   // Remove fruit type if count becomes 0
                }
                l++;
            }

            // Update the maximum length of valid subarray (with at most 2 fruit types)
            maxlen = Math.max(maxlen, r - l + 1);
            r++;
        }
        return maxlen;
    }


    public static int optimal(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int maxlen = 0;
        while (r < fruits.length) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);

            // If there are more than 2 types of fruits, shrink the window from the left
            // ** maintain the large windo size**
            if (map.size() > 2) {
                map.put(fruits[l], map.get(fruits[l]) - 1);

                if (map.get(fruits[l]) == 0) {
                    map.remove(fruits[l]);
                }
                l++;
            }
            if (map.size() <= 2) maxlen = Math.max(maxlen, r - l + 1);

            r++;
        }
        return maxlen;
    }
}



