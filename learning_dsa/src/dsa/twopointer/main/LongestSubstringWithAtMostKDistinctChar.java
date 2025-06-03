package dsa.twopointer.main;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctChar {


    // Brute-force method: checks all substrings starting from each character
    public static int brute(String s, int k) {
        int maxlen = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.clear();// Clear the map for a new starting index i

            for (int j = i; j < s.length(); j++) {
                // Add or update the count of current character
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                // If we have more than k distinct characters, stop expanding

                if (map.size() > k) break;
                maxlen = Math.max(maxlen, j - i + 1);
            }
        }
        return maxlen;
    }


    // Better approach: sliding window with shrinking when distinct char count > k
    public static int better(String s, int k) {
        int l = 0;
        int r = 0;
        int maxlen = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (r < s.length()) {

            // Expand window by adding current character
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);

            // Shrink window from left until we have at most k distinct characters
            while (map.size() > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                if (map.get(s.charAt(l)) == 0) map.remove(s.charAt(l));
                l++;

            }
            maxlen = Math.max(maxlen, r - l + 1);
            r++;
        }
        return maxlen;
    }


    // Optimal approach: same as 'better' but checks map.size > k only once per r
    public static int optimal(String s, int k) {
        int l = 0;
        int r = 0;
        int maxlen = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (r < s.length()) {
            // Add the rightmost character to the map
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            // If distinct character count exceeds k, shrink window from left
            if (map.size() > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                if (map.get(s.charAt(l)) == 0) map.remove(s.charAt(l));
                l++;

            }
            maxlen = Math.max(maxlen, r - l + 1);
            r++;
        }
        return maxlen;
    }
}
