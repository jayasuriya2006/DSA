package dsa.twopointer.main;

import java.util.HashMap;
import java.util.Map;

public class LongSubstringWithoutRepeatingChar {
    public static int brute(String s) {
        int maxlen = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int[] letter = new int[26]; // Tracks if a letter has appeared in the current substring
            for (int j = i; j < n; j++) {
                int index = s.charAt(j) - 'a'; // Map character to index (0 for 'a', 1 for 'b', ..., 25 for 'z')
                if (letter[index] == 1) break;   // If character already exists in current substring, break
                maxlen = Math.max(maxlen, j - i + 1);
                letter[index]++;    // Mark the character as seen
            }
        }
        return maxlen;
    }

    public static int optimal(String s) {
        // Map to store the last index of each character
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int l = 0;
        int r = 0;
        int maxlen = 0;
        while (r < n) {
            // If the current character is already in the map and its last seen index is within the current window
            if (map.containsKey(s.charAt(r))) {
                if (map.get(s.charAt(r)) >= l) {
                    // Move the left pointer to one position right of the last occurrence
                    l = map.get(s.charAt(r)) + 1;
                }
            }
            // Update the last seen index of the current character
            map.put(s.charAt(r), r);
            maxlen = Math.max(maxlen, r - l + 1);
            r++;
        }
        return maxlen;
    }
}


