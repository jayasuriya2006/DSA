package dsa.twopointer.main;

public class MinimumWindowSubstring {

    // Brute-force approach: Time Complexity -> O(n^2)
    public static String brute(String s, String t) {
        int n = s.length();
        int minLength = Integer.MAX_VALUE; // Track the minimum length found
        int startIndex = -1; // Track the starting index of the minimum window

        // Try every possible starting point
        for (int i = 0; i < n; i++) {
            int[] hash = new int[256]; // Frequency of required characters (ASCII size)
            int count = 0; // Number of matched characters

            // Fill the hash with characters in t
            for (int j = 0; j < t.length(); j++) {
                hash[t.charAt(j)]++;
            }

            // Try every possible ending point starting from i
            for (int j = i; j < n; j++) {
                // If s[j] is a needed character
                if (hash[s.charAt(j)] > 0) {
                    count++; // One required character found
                }

                // Use the character
                hash[s.charAt(j)]--;

                // If all characters from t are found
                if (count == t.length()) {
                    // Update minimum length window
                    if ((j - i + 1) < minLength) {
                        minLength = j - i + 1;
                        startIndex = i;
                    }
                    break; // Move to next i (no need to check longer window)
                }
            }
        }

        // If no window found
        if (startIndex == -1) return "";
        return s.substring(startIndex, startIndex + minLength); // Return the substring
    }

    // Optimized sliding window approach: Time Complexity -> O(n)
    public static String optimal(String s, String t) {
        int[] hash = new int[256]; // Track needed characters from t

        // Count frequency of characters in t
        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i)]++;
        }

        int start = 0; // Left pointer of window
        int count = 0; // Number of matched characters
        int minLen = Integer.MAX_VALUE; // Minimum length of window
        int startInd = -1; // Starting index of best window

        // Right pointer of window
        for (int r = 0; r < s.length(); r++) {
            // If current character is required
            if (hash[s.charAt(r)] > 0) {
                count++; // One required character matched
            }

            // Reduce character count (whether it's needed or not)
            hash[s.charAt(r)]--;

            // If window contains all characters of t
            while (count == t.length()) {
                // Update smallest window
                if (r - start + 1 < minLen) {
                    minLen = r - start + 1;
                    startInd = start;
                }

                // Shrink window from the left
                hash[s.charAt(start)]++;
                if (hash[s.charAt(start)] > 0) {
                    count--; // We lost a required character
                }

                start++; // Move left pointer
            }
        }

        // If no valid window found
        return startInd == -1 ? "" : s.substring(startInd, startInd + minLen);
    }

}


