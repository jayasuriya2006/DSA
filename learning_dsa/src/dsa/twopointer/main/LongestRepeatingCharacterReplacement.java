package dsa.twopointer.main;

public class LongestRepeatingCharacterReplacement {

    // ✅ Brute-force approach: O(n^2) time
    public static int brute(String s, int k) {
        int maxlen = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] has = new int[26]; // Frequency of each character from A-Z
            int maxfreq = 0;         // Most frequent character count in current window
            for (int j = i; j < s.length(); j++) {
                has[s.charAt(j) - 'A']++;
                maxfreq = Math.max(maxfreq, has[s.charAt(j) - 'A']);

                int check = (j - i + 1) - maxfreq; // Number of characters to change
                if (check <= k) {
                    maxlen = Math.max(maxlen, j - i + 1); // Valid window, update max
                } else
                    break; // If more than k changes needed, stop expanding
            }
        }
        return maxlen;
    }

    // ✅ Better approach using sliding window, but recalculates max frequency inside loop
    public static int better(String s, int k) {
        int r = 0, l = 0;
        int maxlen = 0;
        int maxfre = 0;
        int[] has = new int[26];

        while (r < s.length()) {
            has[s.charAt(r) - 'A']++; // Update frequency of current character
            maxfre = Math.max(maxfre, has[s.charAt(r) - 'A']); // Track highest freq char

            // Check if we need more than k changes
            while ((r - l + 1) - maxfre > k) {
                has[s.charAt(l) - 'A']--; // Shrink window from left
                maxfre = 0;               // Recalculate max frequency
                for (int i = 0; i < 26; i++) {
                    maxfre = Math.max(maxfre, has[i]);
                }
                l++;
            }

            maxlen = Math.max(maxlen, r - l + 1); // Update max length
            r++;
        }
        return maxlen;
    }

    // ✅ Optimal approach using sliding window without recalculating max frequency
    public static int optimal(String s, int k) {
        int r = 0, l = 0;
        int maxlen = 0;
        int maxfre = 0;
        int[] has = new int[26];

        while (r < s.length()) {
            has[s.charAt(r) - 'A']++; // Count current character
            maxfre = Math.max(maxfre, has[s.charAt(r) - 'A']); // Track max freq

            // If changes needed exceed k, shrink window from left
            if ((r - l + 1) - maxfre > k) {
                has[s.charAt(l) - 'A']--;
                l++;
                // ❌ No need to recalculate maxfre — it’s okay to use stale value
            }

            maxlen = Math.max(maxlen, r - l + 1); // Update result
            r++;
        }
        return maxlen;
    }
}

