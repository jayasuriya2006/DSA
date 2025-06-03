package dsa.twopointer.main;

public class NumberofSubstringsContainingAllThreeChar {
    // Brute-force approach 1: count all substrings and check if 'a', 'b', and 'c' are present
    public static int brute(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int has[] = {0, 0, 0};// track presence of 'a', 'b', and 'c'
            for (int j = i; j < s.length(); j++) {
                has[s.charAt(j) - 'a']++; // increment corresponding character
                if (has[0] != 0 && has[1] != 0 && has[2] != 0) {
                    count++; // substring has all 3 characters
                }
            }
        }
        return count;
    }

    // Brute-force approach 2: smarter break after finding all 3 characters
    public static int better_1(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int[] tem = new int[3];// to track presence of a, b, c
            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                if (ch == 'a') tem[0] = 1;
                if (ch == 'b') tem[1] = 1;
                if (ch == 'c') tem[2] = 1;

                // if all three are found, all substrings from j to end are valid

                if (tem[0] + tem[1] + tem[2] == 3) {
                    count = count + (n - j);// add number of substrings from j to end
                    break;// break to avoid unnecessary checking
                }
            }
        }
        return count;
    }

    // Better: same as brute_2 but using array index trick instead of char check
    public static int better_2(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int has[] = {0, 0, 0};// track 'a', 'b', 'c'
            for (int j = i; j < s.length(); j++) {
                has[s.charAt(j) - 'a']++;
                if (has[0] != 0 && has[1] != 0 && has[2] != 0) {
                    count = count + (s.length() - j);// all suffixes from j to end are valid
                    break;
                }
            }
        }
        return count;
    }

    // Optimal solution using last-seen positions
    public static int optimal(String s) {
        int[] last = {-1, -1, -1}; // last seen indices of 'a', 'b', and 'c'
        int count = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            last[ch - 'a'] = i; // update last seen index for current char

            // if all three characters are seen at least once
            if (last[0] != -1 && last[1] != -1 && last[2] != -1) {
                // smallest index among the last seen -> minimum start of valid substring
                count += 1 + Math.min(last[0], Math.min(last[1], last[2]));
            }
        }
        return count;
    }
}
